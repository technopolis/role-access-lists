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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the admin i p validation data local service. This utility wraps {@link gr.open.marketplace.service.impl.AdminIPValidationDataLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author cotria
 * @see AdminIPValidationDataLocalService
 * @see gr.open.marketplace.service.base.AdminIPValidationDataLocalServiceBaseImpl
 * @see gr.open.marketplace.service.impl.AdminIPValidationDataLocalServiceImpl
 * @generated
 */
public class AdminIPValidationDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link gr.open.marketplace.service.impl.AdminIPValidationDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the admin i p validation data to the database. Also notifies the appropriate model listeners.
	*
	* @param adminIPValidationData the admin i p validation data
	* @return the admin i p validation data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData addAdminIPValidationData(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAdminIPValidationData(adminIPValidationData);
	}

	/**
	* Creates a new admin i p validation data with the primary key. Does not add the admin i p validation data to the database.
	*
	* @param id the primary key for the new admin i p validation data
	* @return the new admin i p validation data
	*/
	public static gr.open.marketplace.model.AdminIPValidationData createAdminIPValidationData(
		long id) {
		return getService().createAdminIPValidationData(id);
	}

	/**
	* Deletes the admin i p validation data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data that was removed
	* @throws PortalException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData deleteAdminIPValidationData(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdminIPValidationData(id);
	}

	/**
	* Deletes the admin i p validation data from the database. Also notifies the appropriate model listeners.
	*
	* @param adminIPValidationData the admin i p validation data
	* @return the admin i p validation data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData deleteAdminIPValidationData(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdminIPValidationData(adminIPValidationData);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static gr.open.marketplace.model.AdminIPValidationData fetchAdminIPValidationData(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAdminIPValidationData(id);
	}

	/**
	* Returns the admin i p validation data with the primary key.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data
	* @throws PortalException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData getAdminIPValidationData(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdminIPValidationData(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the admin i p validation datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of admin i p validation datas
	* @param end the upper bound of the range of admin i p validation datas (not inclusive)
	* @return the range of admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> getAdminIPValidationDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdminIPValidationDatas(start, end);
	}

	/**
	* Returns the number of admin i p validation datas.
	*
	* @return the number of admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getAdminIPValidationDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdminIPValidationDatasCount();
	}

	/**
	* Updates the admin i p validation data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminIPValidationData the admin i p validation data
	* @return the admin i p validation data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData updateAdminIPValidationData(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAdminIPValidationData(adminIPValidationData);
	}

	/**
	* Updates the admin i p validation data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminIPValidationData the admin i p validation data
	* @param merge whether to merge the admin i p validation data with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the admin i p validation data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData updateAdminIPValidationData(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAdminIPValidationData(adminIPValidationData, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.liferay.portal.model.Role> getAvailableRoles(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAvailableRoles(companyId);
	}

	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> getByCopmanyAndRole(
		long companyId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCopmanyAndRole(companyId, roleId);
	}

	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> getAdminIPValidationData(
		long companyId, java.lang.String ip, int active, long roleId,
		int start, int end) {
		return getService()
				   .getAdminIPValidationData(companyId, ip, active, roleId,
			start, end);
	}

	public static int getAdminIPValidationDataCount(long companyId,
		java.lang.String ip, int active, long roleId) {
		return getService()
				   .getAdminIPValidationDataCount(companyId, ip, active, roleId);
	}

	public static java.util.List<java.lang.String> getAllowedAddressesList() {
		return getService().getAllowedAddressesList();
	}

	public static void clearService() {
		_service = null;
	}

	public static AdminIPValidationDataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdminIPValidationDataLocalService.class.getName());

			if (invokableLocalService instanceof AdminIPValidationDataLocalService) {
				_service = (AdminIPValidationDataLocalService)invokableLocalService;
			}
			else {
				_service = new AdminIPValidationDataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AdminIPValidationDataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AdminIPValidationDataLocalService service) {
	}

	private static AdminIPValidationDataLocalService _service;
}