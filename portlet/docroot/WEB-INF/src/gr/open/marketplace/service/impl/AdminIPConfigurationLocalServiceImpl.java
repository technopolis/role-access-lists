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
import com.liferay.portal.kernel.exception.SystemException;

import gr.open.marketplace.model.AdminIPConfiguration;
import gr.open.marketplace.service.base.AdminIPConfigurationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the admin i p configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link gr.open.marketplace.service.AdminIPConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cotria
 * @see gr.open.marketplace.service.base.AdminIPConfigurationLocalServiceBaseImpl
 * @see gr.open.marketplace.service.AdminIPConfigurationLocalServiceUtil
 */
public class AdminIPConfigurationLocalServiceImpl
	extends AdminIPConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link gr.open.marketplace.service.AdminIPConfigurationLocalServiceUtil} to access the admin i p configuration local service.
	 */
	public AdminIPConfiguration getAdminIPConfiguration() throws SystemException {
		List<AdminIPConfiguration> all = adminIPConfigurationPersistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if (all.isEmpty()) {
			return null;
		}
		else {
			return all.get(0);
		}
		
	}
}