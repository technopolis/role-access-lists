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

package gr.open.marketplace.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;

import gr.open.marketplace.Constants;
import gr.open.marketplace.model.AdminIPValidationData;
import gr.open.marketplace.service.base.AdminIPValidationDataLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The implementation of the admin i p validation data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link gr.open.marketplace.service.AdminIPValidationDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cotria
 * @see gr.open.marketplace.service.base.AdminIPValidationDataLocalServiceBaseImpl
 * @see gr.open.marketplace.service.AdminIPValidationDataLocalServiceUtil
 */
public class AdminIPValidationDataLocalServiceImpl
	extends AdminIPValidationDataLocalServiceBaseImpl implements Constants {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link gr.open.marketplace.service.AdminIPValidationDataLocalServiceUtil} to access the admin i p validation data local service.
	 */
	
	private static final Log logger = LogFactoryUtil.getLog(AdminIPValidationDataLocalServiceImpl.class);
	
	public List<Role> getAvailableRoles(long companyId) throws SystemException, PortalException {
		List<Role> results = new ArrayList<Role>();
		
		for (AdminIPValidationData data : adminIPValidationDataPersistence.findByCompany(companyId)) {
			Long[] roleIds = data.getRolesAsArray();
			for (Long roleId : roleIds) {
				if (roleId != null) {
					Role role = RoleLocalServiceUtil.getRole(roleId);
					if (!results.contains(role)) {
						results.add(role);
					}
				}
			}
		}
		
		return results;
	}
	
	public List<AdminIPValidationData> getByCopmanyAndRole(long companyId, long roleId) throws SystemException {
		List<AdminIPValidationData> results = new ArrayList<AdminIPValidationData>();
		
		for (AdminIPValidationData data : adminIPValidationDataPersistence.findByActiveAndCompany(companyId, true)) {
			Long[] roleIds = data.getRolesAsArray();
			for (Long id : roleIds) {
				if (id == roleId) {
					results.add(data);
				}
			}
		}
		
		return results;
	}
	
	public List<AdminIPValidationData> getAdminIPValidationData(long companyId, String ip, int active, long roleId, int start, int end) {
						
		List<AdminIPValidationData> results = new ArrayList<AdminIPValidationData>();
		try {
			List<AdminIPValidationData> tempResults = null;

			if (active == ACTIVE_ALL) {
				tempResults = adminIPValidationDataPersistence.findByCompany(companyId, start, end);
			}
			else {
				tempResults = adminIPValidationDataPersistence.findByActiveAndCompany(companyId, active==ACTIVE_ONLY_ACTIVE?true:false, start, end);
			}
			
			if (Validator.isNotNull(ip) || roleId > 0) {
				for (AdminIPValidationData tempResult : tempResults) {
					boolean toBeAddedByRole = true;
					if (roleId > 0) {
						toBeAddedByRole = false;
						if (tempResult.getRoles().contains(String.valueOf(roleId))) {
							toBeAddedByRole = true;
						}
					}
					boolean toBeAddedByIP = true;
					if (Validator.isNotNull(ip)) {
						toBeAddedByIP = false;
						if (tempResult.getIpAddresses().contains(ip)) {
							toBeAddedByIP = true;
						}
					}
					if (toBeAddedByRole && toBeAddedByIP) {
						results.add(tempResult);
					}
				}
			}
			else {
				results.addAll(tempResults);
			}
		}
		catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}
		return results;
	}
	
	public int getAdminIPValidationDataCount(long companyId, String ip, int active, long roleId) {
		return getAdminIPValidationData(companyId, ip, active, roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}
	
	public List<String> getAllowedAddressesList() {

		List<String> ipAddresses = null;

		try {

			AdminIPValidationData validationData = fetchAdminIPValidationData(1);

			if (validationData != null) {
				ipAddresses = Arrays.asList(validationData.getIpAddresses()
						.split(","));
			}

		} catch (SystemException e) {

			e.printStackTrace();
		}

		return ipAddresses;
	}

	
	

}