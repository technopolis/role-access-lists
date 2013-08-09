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

package gr.open.marketplace.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AdminIPValidationDataService}.
 * </p>
 *
 * @author    cotria
 * @see       AdminIPValidationDataService
 * @generated
 */
public class AdminIPValidationDataServiceWrapper
	implements AdminIPValidationDataService,
		ServiceWrapper<AdminIPValidationDataService> {
	public AdminIPValidationDataServiceWrapper(
		AdminIPValidationDataService adminIPValidationDataService) {
		_adminIPValidationDataService = adminIPValidationDataService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _adminIPValidationDataService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adminIPValidationDataService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adminIPValidationDataService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<java.lang.String> getAllowedAddressesList() {
		return _adminIPValidationDataService.getAllowedAddressesList();
	}

	public java.lang.String getRedirectUrl() {
		return _adminIPValidationDataService.getRedirectUrl();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdminIPValidationDataService getWrappedAdminIPValidationDataService() {
		return _adminIPValidationDataService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdminIPValidationDataService(
		AdminIPValidationDataService adminIPValidationDataService) {
		_adminIPValidationDataService = adminIPValidationDataService;
	}

	public AdminIPValidationDataService getWrappedService() {
		return _adminIPValidationDataService;
	}

	public void setWrappedService(
		AdminIPValidationDataService adminIPValidationDataService) {
		_adminIPValidationDataService = adminIPValidationDataService;
	}

	private AdminIPValidationDataService _adminIPValidationDataService;
}