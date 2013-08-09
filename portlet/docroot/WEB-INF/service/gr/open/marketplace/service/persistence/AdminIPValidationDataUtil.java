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

import gr.open.marketplace.model.AdminIPValidationData;

import java.util.List;

/**
 * The persistence utility for the admin i p validation data service. This utility wraps {@link AdminIPValidationDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cotria
 * @see AdminIPValidationDataPersistence
 * @see AdminIPValidationDataPersistenceImpl
 * @generated
 */
public class AdminIPValidationDataUtil {
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
	public static void clearCache(AdminIPValidationData adminIPValidationData) {
		getPersistence().clearCache(adminIPValidationData);
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
	public static List<AdminIPValidationData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdminIPValidationData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdminIPValidationData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AdminIPValidationData update(
		AdminIPValidationData adminIPValidationData, boolean merge)
		throws SystemException {
		return getPersistence().update(adminIPValidationData, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AdminIPValidationData update(
		AdminIPValidationData adminIPValidationData, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(adminIPValidationData, merge, serviceContext);
	}

	/**
	* Caches the admin i p validation data in the entity cache if it is enabled.
	*
	* @param adminIPValidationData the admin i p validation data
	*/
	public static void cacheResult(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData) {
		getPersistence().cacheResult(adminIPValidationData);
	}

	/**
	* Caches the admin i p validation datas in the entity cache if it is enabled.
	*
	* @param adminIPValidationDatas the admin i p validation datas
	*/
	public static void cacheResult(
		java.util.List<gr.open.marketplace.model.AdminIPValidationData> adminIPValidationDatas) {
		getPersistence().cacheResult(adminIPValidationDatas);
	}

	/**
	* Creates a new admin i p validation data with the primary key. Does not add the admin i p validation data to the database.
	*
	* @param id the primary key for the new admin i p validation data
	* @return the new admin i p validation data
	*/
	public static gr.open.marketplace.model.AdminIPValidationData create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the admin i p validation data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data that was removed
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence().remove(id);
	}

	public static gr.open.marketplace.model.AdminIPValidationData updateImpl(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adminIPValidationData, merge);
	}

	/**
	* Returns the admin i p validation data with the primary key or throws a {@link gr.open.marketplace.NoSuchAdminIPValidationDataException} if it could not be found.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the admin i p validation data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data, or <code>null</code> if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the admin i p validation data where id = &#63; or throws a {@link gr.open.marketplace.NoSuchAdminIPValidationDataException} if it could not be found.
	*
	* @param id the ID
	* @return the matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData findById(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence().findById(id);
	}

	/**
	* Returns the admin i p validation data where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchById(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id);
	}

	/**
	* Returns the admin i p validation data where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchById(
		long id, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id, retrieveFromCache);
	}

	/**
	* Returns all the admin i p validation datas where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @return the matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByActiveAndCompany(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveAndCompany(companyId, active);
	}

	/**
	* Returns a range of all the admin i p validation datas where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param active the active
	* @param start the lower bound of the range of admin i p validation datas
	* @param end the upper bound of the range of admin i p validation datas (not inclusive)
	* @return the range of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByActiveAndCompany(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveAndCompany(companyId, active, start, end);
	}

	/**
	* Returns an ordered range of all the admin i p validation datas where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param active the active
	* @param start the lower bound of the range of admin i p validation datas
	* @param end the upper bound of the range of admin i p validation datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByActiveAndCompany(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveAndCompany(companyId, active, start, end,
			orderByComparator);
	}

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData findByActiveAndCompany_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence()
				   .findByActiveAndCompany_First(companyId, active,
			orderByComparator);
	}

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchByActiveAndCompany_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveAndCompany_First(companyId, active,
			orderByComparator);
	}

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData findByActiveAndCompany_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence()
				   .findByActiveAndCompany_Last(companyId, active,
			orderByComparator);
	}

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchByActiveAndCompany_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveAndCompany_Last(companyId, active,
			orderByComparator);
	}

	/**
	* Returns the admin i p validation datas before and after the current admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param id the primary key of the current admin i p validation data
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData[] findByActiveAndCompany_PrevAndNext(
		long id, long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence()
				   .findByActiveAndCompany_PrevAndNext(id, companyId, active,
			orderByComparator);
	}

	/**
	* Returns all the admin i p validation datas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the admin i p validation datas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of admin i p validation datas
	* @param end the upper bound of the range of admin i p validation datas (not inclusive)
	* @return the range of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the admin i p validation datas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of admin i p validation datas
	* @param end the upper bound of the range of admin i p validation datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the admin i p validation datas before and after the current admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param id the primary key of the current admin i p validation data
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData[] findByCompany_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence()
				   .findByCompany_PrevAndNext(id, companyId, orderByComparator);
	}

	/**
	* Returns all the admin i p validation datas.
	*
	* @return the admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the admin i p validation datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of admin i p validation datas
	* @param end the upper bound of the range of admin i p validation datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.marketplace.model.AdminIPValidationData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the admin i p validation data where id = &#63; from the database.
	*
	* @param id the ID
	* @return the admin i p validation data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.marketplace.model.AdminIPValidationData removeById(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException {
		return getPersistence().removeById(id);
	}

	/**
	* Removes all the admin i p validation datas where companyId = &#63; and active = &#63; from the database.
	*
	* @param companyId the company ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActiveAndCompany(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActiveAndCompany(companyId, active);
	}

	/**
	* Removes all the admin i p validation datas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the admin i p validation datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of admin i p validation datas where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countById(id);
	}

	/**
	* Returns the number of admin i p validation datas where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @return the number of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActiveAndCompany(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActiveAndCompany(companyId, active);
	}

	/**
	* Returns the number of admin i p validation datas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of admin i p validation datas.
	*
	* @return the number of admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdminIPValidationDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdminIPValidationDataPersistence)PortletBeanLocatorUtil.locate(gr.open.marketplace.service.ClpSerializer.getServletContextName(),
					AdminIPValidationDataPersistence.class.getName());

			ReferenceRegistry.registerReference(AdminIPValidationDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AdminIPValidationDataPersistence persistence) {
	}

	private static AdminIPValidationDataPersistence _persistence;
}