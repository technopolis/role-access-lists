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

package gr.open.marketplace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import gr.open.marketplace.model.AdminIPConfiguration;

import java.util.List;

/**
 * The persistence utility for the admin i p configuration service. This utility wraps {@link AdminIPConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cotria
 * @see AdminIPConfigurationPersistence
 * @see AdminIPConfigurationPersistenceImpl
 * @generated
 */
public class AdminIPConfigurationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AdminIPConfiguration adminIPConfiguration) {
		getPersistence().clearCache(adminIPConfiguration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AdminIPConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdminIPConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdminIPConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AdminIPConfiguration update(
		AdminIPConfiguration adminIPConfiguration, boolean merge)
		throws SystemException {
		return getPersistence().update(adminIPConfiguration, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AdminIPConfiguration update(
		AdminIPConfiguration adminIPConfiguration, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(adminIPConfiguration, merge, serviceContext);
	}

	/**
	* Caches the admin i p configuration in the entity cache if it is enabled.
	*
	* @param adminIPConfiguration the admin i p configuration
	*/
	public static void cacheResult(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration) {
		getPersistence().cacheResult(adminIPConfiguration);
	}

	/**
	* Caches the admin i p configurations in the entity cache if it is enabled.
	*
	* @param adminIPConfigurations the admin i p configurations
	*/
	public static void cacheResult(
		java.util.List<gr.open.marketplace.model.AdminIPConfiguration> adminIPConfigurations) {
		getPersistence().cacheResult(adminIPConfigurations);
	}

	/**
	* Creates a new admin i p configuration with the primary key. Does not add the admin i p configuration to the database.
	*
	* @param id the primary key for the new admin i p configuration
	* @return the new admin i p configuration
	*/
	public static gr.open.marketplace.model.AdminIPConfiguration create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the admin i p configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration that was removed
	* @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPConfiguration remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPConfigurationException {
		return getPersistence().remove(id);
	}

	public static gr.open.marketplace.model.AdminIPConfiguration updateImpl(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adminIPConfiguration, merge);
	}

	/**
	* Returns the admin i p configuration with the primary key or throws a {@link gr.open.marketplace.NoSuchAdminIPConfigurationException} if it could not be found.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration
	* @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPConfiguration findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPConfigurationException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the admin i p configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration, or <code>null</code> if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPConfiguration fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the admin i p configurations.
	*
	* @return the admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<gr.open.marketplace.model.AdminIPConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the admin i p configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of admin i p configurations
	* @param end the upper bound of the range of admin i p configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the admin i p configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of admin i p configurations.
	*
	* @return the number of admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdminIPConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdminIPConfigurationPersistence)PortletBeanLocatorUtil.locate(gr.open.marketplace.service.ClpSerializer.getServletContextName(),
					AdminIPConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(AdminIPConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AdminIPConfigurationPersistence persistence) {
	}

	private static AdminIPConfigurationPersistence _persistence;
}