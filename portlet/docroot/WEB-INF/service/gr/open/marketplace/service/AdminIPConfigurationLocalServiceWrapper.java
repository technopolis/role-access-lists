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
 * This class is a wrapper for {@link AdminIPConfigurationLocalService}.
 * </p>
 *
 * @author    cotria
 * @see       AdminIPConfigurationLocalService
 * @generated
 */
public class AdminIPConfigurationLocalServiceWrapper
	implements AdminIPConfigurationLocalService,
		ServiceWrapper<AdminIPConfigurationLocalService> {
	public AdminIPConfigurationLocalServiceWrapper(
		AdminIPConfigurationLocalService adminIPConfigurationLocalService) {
		_adminIPConfigurationLocalService = adminIPConfigurationLocalService;
	}

	/**
	* Adds the admin i p configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param adminIPConfiguration the admin i p configuration
	* @return the admin i p configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration addAdminIPConfiguration(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.addAdminIPConfiguration(adminIPConfiguration);
	}

	/**
	* Creates a new admin i p configuration with the primary key. Does not add the admin i p configuration to the database.
	*
	* @param id the primary key for the new admin i p configuration
	* @return the new admin i p configuration
	*/
	public gr.open.marketplace.model.AdminIPConfiguration createAdminIPConfiguration(
		long id) {
		return _adminIPConfigurationLocalService.createAdminIPConfiguration(id);
	}

	/**
	* Deletes the admin i p configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration that was removed
	* @throws PortalException if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration deleteAdminIPConfiguration(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.deleteAdminIPConfiguration(id);
	}

	/**
	* Deletes the admin i p configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param adminIPConfiguration the admin i p configuration
	* @return the admin i p configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration deleteAdminIPConfiguration(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.deleteAdminIPConfiguration(adminIPConfiguration);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adminIPConfigurationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.dynamicQueryCount(dynamicQuery);
	}

	public gr.open.marketplace.model.AdminIPConfiguration fetchAdminIPConfiguration(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.fetchAdminIPConfiguration(id);
	}

	/**
	* Returns the admin i p configuration with the primary key.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration
	* @throws PortalException if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration getAdminIPConfiguration(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.getAdminIPConfiguration(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the admin i p configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of admin i p configurations
	* @param end the upper bound of the range of admin i p configurations (not inclusive)
	* @return the range of admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.marketplace.model.AdminIPConfiguration> getAdminIPConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.getAdminIPConfigurations(start,
			end);
	}

	/**
	* Returns the number of admin i p configurations.
	*
	* @return the number of admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public int getAdminIPConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.getAdminIPConfigurationsCount();
	}

	/**
	* Updates the admin i p configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminIPConfiguration the admin i p configuration
	* @return the admin i p configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration updateAdminIPConfiguration(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.updateAdminIPConfiguration(adminIPConfiguration);
	}

	/**
	* Updates the admin i p configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminIPConfiguration the admin i p configuration
	* @param merge whether to merge the admin i p configuration with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the admin i p configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration updateAdminIPConfiguration(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.updateAdminIPConfiguration(adminIPConfiguration,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _adminIPConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adminIPConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adminIPConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public gr.open.marketplace.model.AdminIPConfiguration getAdminIPConfiguration()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPConfigurationLocalService.getAdminIPConfiguration();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdminIPConfigurationLocalService getWrappedAdminIPConfigurationLocalService() {
		return _adminIPConfigurationLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdminIPConfigurationLocalService(
		AdminIPConfigurationLocalService adminIPConfigurationLocalService) {
		_adminIPConfigurationLocalService = adminIPConfigurationLocalService;
	}

	public AdminIPConfigurationLocalService getWrappedService() {
		return _adminIPConfigurationLocalService;
	}

	public void setWrappedService(
		AdminIPConfigurationLocalService adminIPConfigurationLocalService) {
		_adminIPConfigurationLocalService = adminIPConfigurationLocalService;
	}

	private AdminIPConfigurationLocalService _adminIPConfigurationLocalService;
}