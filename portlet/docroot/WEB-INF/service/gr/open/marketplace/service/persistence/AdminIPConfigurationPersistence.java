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

import com.liferay.portal.service.persistence.BasePersistence;

import gr.open.marketplace.model.AdminIPConfiguration;

/**
 * The persistence interface for the admin i p configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cotria
 * @see AdminIPConfigurationPersistenceImpl
 * @see AdminIPConfigurationUtil
 * @generated
 */
public interface AdminIPConfigurationPersistence extends BasePersistence<AdminIPConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdminIPConfigurationUtil} to access the admin i p configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the admin i p configuration in the entity cache if it is enabled.
	*
	* @param adminIPConfiguration the admin i p configuration
	*/
	public void cacheResult(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration);

	/**
	* Caches the admin i p configurations in the entity cache if it is enabled.
	*
	* @param adminIPConfigurations the admin i p configurations
	*/
	public void cacheResult(
		java.util.List<gr.open.marketplace.model.AdminIPConfiguration> adminIPConfigurations);

	/**
	* Creates a new admin i p configuration with the primary key. Does not add the admin i p configuration to the database.
	*
	* @param id the primary key for the new admin i p configuration
	* @return the new admin i p configuration
	*/
	public gr.open.marketplace.model.AdminIPConfiguration create(long id);

	/**
	* Removes the admin i p configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration that was removed
	* @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPConfigurationException;

	public gr.open.marketplace.model.AdminIPConfiguration updateImpl(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the admin i p configuration with the primary key or throws a {@link gr.open.marketplace.NoSuchAdminIPConfigurationException} if it could not be found.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration
	* @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPConfigurationException;

	/**
	* Returns the admin i p configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the admin i p configuration
	* @return the admin i p configuration, or <code>null</code> if a admin i p configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPConfiguration fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the admin i p configurations.
	*
	* @return the admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.marketplace.model.AdminIPConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the admin i p configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of admin i p configurations.
	*
	* @return the number of admin i p configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}