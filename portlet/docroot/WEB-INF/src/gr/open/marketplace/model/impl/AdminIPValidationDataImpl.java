/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gr.open.marketplace.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import gr.open.marketplace.Constants;

/**
 * The extended model implementation for the AdminIPValidationData service. Represents a row in the &quot;opengr_AdminIPValidationData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link gr.open.marketplace.model.AdminIPValidationData} interface.
 * </p>
 *
 * @author cotria
 */
public class AdminIPValidationDataImpl extends AdminIPValidationDataBaseImpl implements Constants{
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a admin i p validation data model instance should use the {@link gr.open.marketplace.model.AdminIPValidationData} interface instead.
	 */
	private static final Log logger = LogFactoryUtil.getLog(AdminIPValidationDataImpl.class);
	
	public AdminIPValidationDataImpl() {
		
	}
	
	public Long[] getRolesAsArray() {
		String[] roles = getRoles().split(",");
		
		Long[] result = new Long[roles.length];

		for(int i = 0; i < roles.length; i++){
			try {
				result[i] = Long.parseLong(roles[i]);
			}
			catch (Exception e) {
				// do nothing
			}
		}
		return result;
	}
	
	public String[] getIpsAsArray() {
		return getIpAddresses().split(",");
	}
	
	public String getIpsForTable() {
		String[] ips = getIpAddresses().split(",");
		String result = "";
		boolean isFirst = true;
		for (String ip : ips) {
			if (isFirst) {
				isFirst = false;
			}
			else {
				result += "<br>";
			}
			result += ip;
		}
		return result;
	}
	
	public String getCreateDateForView() {
		return DD_MM_YYYY_HH_MM_SS.format(getCreateDate());
	}
	
	public String getModifiedDateForView() {
		return DD_MM_YYYY_HH_MM_SS.format(getModifiedDate());
	}
	
	public String getUserEmailForView() {
		String result = "";
		
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(getUserId());
		}
		catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}
		
		if (user != null) {
			String title = user.getFullName() + "<br>";
			title += user.getLoginIP() + "<br>";
			title += user.getScreenName();
			result = "<a href='#' class='hasTooltip' onclick='return false;' title='" + title + "'>" + getUserName() + "";
		}
		else {
			result = getUserName();
		}
		
		return result;
	}
	
	public String getRolesForView()  {
		String result = "";
		boolean isFirst = true;
		for (Long roleId : getRolesAsArray()) {
			try {
				Role role = RoleLocalServiceUtil.getRole(roleId);
				if (isFirst) {
					isFirst = false;
				}
				else {
					result += ", ";
				}
				if (Validator.isNotNull(role.getDescription())) {
					result += "<a href='#' class='hasTooltip' onclick='return false;' title='" + role.getDescriptionCurrentValue() + "'>" + role.getName() + "</a>";
				}
				else {
					result += role.getName();
				}
			}
			catch (PortalException e) {
				logger.error(e.getMessage(), e);
			}
			catch (SystemException e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		return result;
	}
}