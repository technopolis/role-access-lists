package gr.open.marketplace.hook.actions;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import gr.open.marketplace.hook.Constants;
import gr.open.marketplace.hook.HookHelper;
import gr.open.marketplace.model.AdminIPConfiguration;
import gr.open.marketplace.model.AdminIPValidationData;
import gr.open.marketplace.service.AdminIPConfigurationLocalServiceUtil;
import gr.open.marketplace.service.AdminIPValidationDataLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateAdminAddressAction extends Action implements Constants{
	
	private static Log logger = LogFactoryUtil.getLog(ValidateAdminAddressAction.class);
	private static final String LOGOUT = "LOGOUT";

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		AdminIPConfiguration conf = null;
		try {
			conf = AdminIPConfigurationLocalServiceUtil.getAdminIPConfiguration();
			if (conf.getMode() == MODE_CONTROL_PANEL) {
				return ;
			}
		}
		catch (SystemException e3) {
			logger.error(e3.getMessage(), e3);
		}
		
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		long userId = PortalUtil.getUserId(request);
		long companyId = PortalUtil.getCompanyId(request);
		
		AdminIPConfiguration config = null;
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			config = AdminIPConfigurationLocalServiceUtil.getAdminIPConfiguration();
			if (config.isDebug()) {
				logger.info("CHECKING");
				logger.info("  USER: " + user);
				logger.info("  USER ROLES: ");
				for (Role role : user.getRoles()) {
					logger.info("    - " + role.getName());
				}
				logger.info("  REMOTE ADDRESS: " + remoteAddr);
				logger.info("  REMOTE HOST: " + remoteHost);
			}

			try {
				for (Role role : AdminIPValidationDataLocalServiceUtil.getAvailableRoles(companyId)) {
					if (HookHelper.hasUserRole(user, role.getName())) {
						List<AdminIPValidationData> allowedIps = AdminIPValidationDataLocalServiceUtil.getByCopmanyAndRole(companyId, role.getRoleId());
						RULES : for (AdminIPValidationData data : allowedIps) {
							
							for (String ip : data.getIpAddresses().split(",")) {
								if (config.isDebug()) logger.info("  CHECKING IP:" + ip);
								if (HookHelper.isValidAdminSession(ip, remoteAddr, remoteHost)) {
									for (String dataRoleIdAsString : data.getRoles().split(",")) {
										long dataLongId = Long.parseLong(dataRoleIdAsString);
										if (role.getRoleId() == dataLongId) {
											if (config.isDebug()) {
												logger.info("THIS USER HAS PASSED THE VALIDATION");
												if (data.isDebugMode()) {
													logger.info("THIS RULE IS IN DEBUG MODE. ");
												}
											}
											else {
												if (data.isDebugMode()) {
													logger.info("THIS RULE IS IN DEBUG MODE. THE USER WOULD HAVE PASSED THE CHECKS...");
													continue RULES;
												}
											}
											return ;
										}
									}
								}
							}
						}
					}
				}
			}
			catch (PortalException e2) {
				logger.error(e2.getMessage(), e2);
			}
			
			if (config.isDebug()) logger.info("THIS USER SHOULD BE REDIRECTED TO " + config.getRedirectUrl());
			
			if (!config.isDebug()) {
				HttpSession session = request.getSession();
				request.setAttribute(LOGOUT, true);
				session.invalidate();
				try {
					response.sendRedirect(config.getRedirectUrl());
				} catch (IOException e) {
					logger.error(e.toString(), e);
				}
			}
		}
		catch (SystemException e1) {
			logger.error(e1.toString(), e1);
		}
		catch (PortalException e) {
			logger.error(e.toString(), e);
		}
	}


	

}

