package gr.open.marketplace.portlets;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import gr.open.marketplace.Constants;
import gr.open.marketplace.model.AdminIPConfiguration;
import gr.open.marketplace.model.AdminIPValidationData;
import gr.open.marketplace.service.AdminIPConfigurationLocalServiceUtil;
import gr.open.marketplace.service.AdminIPValidationDataLocalServiceUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Portlet implementation class AdminAllowedIPsPortlet
 */
public class AdminAllowedIPsPortlet extends MVCPortlet implements Constants {
	
	private static Log logger = LogFactoryUtil.getLog(AdminAllowedIPsPortlet.class);
	private String defaultRedirectUrl =  PortletProps.get("redirectUrl.default");
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Role> roles;
		try {
			roles = AdminIPValidationDataLocalServiceUtil.getAvailableRoles(themeDisplay.getCompanyId());
			renderRequest.setAttribute("roles", roles);
		}
		catch (PortalException e) {
			logger.error(e.getMessage());
		}
		catch (SystemException e) {
			logger.error(e.getMessage());
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void init()
		throws PortletException {
	
		try {
			AdminIPConfiguration config = AdminIPConfigurationLocalServiceUtil.getAdminIPConfiguration();
			if (config == null) {
				long configId = CounterLocalServiceUtil.increment(AdminIPConfiguration.class.getName());
				config = AdminIPConfigurationLocalServiceUtil.createAdminIPConfiguration(configId);
				config.setDebug(false);
				config.setMode(MODE_BOTH);
				config.setRedirectUrl(defaultRedirectUrl);
				AdminIPConfigurationLocalServiceUtil.addAdminIPConfiguration(config);
			}
		}
		catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}
		
		super.init();
	}
	
	@ProcessAction(name = "delete")
	public void delete(ActionRequest request, ActionResponse response){
		
		long id = ParamUtil.getLong(request, "id", 0);
		if (id > 0) {
			try {
				AdminIPValidationDataLocalServiceUtil.deleteAdminIPValidationData(id);
			}
			catch (PortalException e) {
				logger.error(e.getMessage(), e);
			}
			catch (SystemException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
	
	@ProcessAction(name = "saveEntry")
	public void saveEntry(ActionRequest request, ActionResponse response) throws PortletException, IOException{
		if (logger.isDebugEnabled()) logger.debug("SAVING DATA!");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long id = ParamUtil.getLong(request, "id", 0);
		String[] ipAddresses = ParamUtil.getParameterValues(request, "ipAddresses");
		String[] roles = ParamUtil.getParameterValues(request, "roles");
		String notes = ParamUtil.getString(request, "notes", "");
		boolean active = ParamUtil.getBoolean(request, "active", true);
		boolean debugMode = ParamUtil.getBoolean(request, "debugMode", true);
		
		AdminIPValidationData tableEntry = null;

		try {
			tableEntry = AdminIPValidationDataLocalServiceUtil.fetchAdminIPValidationData(id);
			boolean updating = true;
			if (tableEntry == null){
				long adminIPValidationDataId = CounterLocalServiceUtil.increment(AdminIPValidationData.class.getName());
				tableEntry = AdminIPValidationDataLocalServiceUtil.createAdminIPValidationData(adminIPValidationDataId);
				updating = false;
			}
			
			tableEntry.setIpAddresses(StringUtils.join(ipAddresses, ","));
			tableEntry.setRoles(StringUtils.join(roles, ","));
			tableEntry.setNotes(notes);
			tableEntry.setActive(active);
			tableEntry.setDebugMode(debugMode);
			tableEntry.setCompanyId(themeDisplay.getCompanyId());
			tableEntry.setUserName(themeDisplay.getUser().getEmailAddress());
			tableEntry.setUserId(themeDisplay.getUserId());
			tableEntry.setModifiedDate(new Date());
			AdminIPValidationData newData = null;
			if (updating) {
				if (logger.isDebugEnabled()) logger.debug("UPDATING " + tableEntry);
				newData = AdminIPValidationDataLocalServiceUtil.updateAdminIPValidationData(tableEntry);
			}
			else {
				if (logger.isDebugEnabled()) logger.debug("CREATING " + tableEntry);
				tableEntry.setCreateDate(new Date());
				newData = AdminIPValidationDataLocalServiceUtil.addAdminIPValidationData(tableEntry);
			}
			
			if (logger.isDebugEnabled()) logger.debug("NEW DATA IS:" + newData);
		} catch (SystemException e) {
			logger.error(e.getMessage(), e);
			SessionErrors.add(request, "error-in-saving-data");
		}
	}
	
	
	private boolean validateRedirectUrl(ActionRequest request, String redirectUrl) {
		return Validator.isNotNull(redirectUrl);
	}
	
	@ProcessAction(name = "saveIpsConfiguration")
	public void saveIpsConfiguration(ActionRequest request, ActionResponse response) throws PortletException, IOException{
		if (logger.isDebugEnabled()) logger.debug("SAVING CONFIGURATION DATA!");
		
		long id = ParamUtil.getLong(request, "id", 0);
		String redirectUrl = ParamUtil.getString(request, "redirectUrl", defaultRedirectUrl);
		boolean debug = ParamUtil.getBoolean(request, "debug", false);
		int mode = ParamUtil.getInteger(request, "mode");
		
		if (!validateRedirectUrl(request, redirectUrl)) {
			SessionErrors.add(request, "error-in-redirect-url");
			if (logger.isDebugEnabled()) logger.debug("redirect URL is invalid");
			response.setRenderParameter("jspPage", "/adminallowedips/ipsConfiguration.jsp");
			response.setRenderParameter("id", String.valueOf(id));
		}
		else {
			AdminIPConfiguration config = null;
	
			try {
				config = AdminIPConfigurationLocalServiceUtil.getAdminIPConfiguration();
				boolean updating = true;
				if (config == null){
					long configId = CounterLocalServiceUtil.increment(AdminIPConfiguration.class.getName());
					config = AdminIPConfigurationLocalServiceUtil.createAdminIPConfiguration(configId);
					updating = false;
				}
				
				config.setRedirectUrl(redirectUrl);
				config.setDebug(debug);
				config.setMode(mode);
				
				AdminIPConfiguration newConfig = null;
				if (updating) {
					if (logger.isDebugEnabled()) logger.debug("UPDATING " + config);
					newConfig = AdminIPConfigurationLocalServiceUtil.updateAdminIPConfiguration(config, true);
				}
				else {
					if (logger.isDebugEnabled()) logger.debug("CREATING " + config);
					newConfig = AdminIPConfigurationLocalServiceUtil.addAdminIPConfiguration(config);
				}
				
				if (logger.isDebugEnabled()) logger.debug("NEW DATA IS:" + newConfig);
			} catch (SystemException e) {
				logger.error(e.getMessage(), e);
				SessionErrors.add(request, "error-in-saving-data");
			}
		}
	}
	
}
