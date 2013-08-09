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

import gr.open.marketplace.model.AdminIPValidationData;

/**
 * The persistence interface for the admin i p validation data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cotria
 * @see AdminIPValidationDataPersistenceImpl
 * @see AdminIPValidationDataUtil
 * @generated
 */
public interface AdminIPValidationDataPersistence extends BasePersistence<AdminIPValidationData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdminIPValidationDataUtil} to access the admin i p validation data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the admin i p validation data in the entity cache if it is enabled.
	*
	* @param adminIPValidationData the admin i p validation data
	*/
	public void cacheResult(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData);

	/**
	* Caches the admin i p validation datas in the entity cache if it is enabled.
	*
	* @param adminIPValidationDatas the admin i p validation datas
	*/
	public void cacheResult(
		java.util.List<gr.open.marketplace.model.AdminIPValidationData> adminIPValidationDatas);

	/**
	* Creates a new admin i p validation data with the primary key. Does not add the admin i p validation data to the database.
	*
	* @param id the primary key for the new admin i p validation data
	* @return the new admin i p validation data
	*/
	public gr.open.marketplace.model.AdminIPValidationData create(long id);

	/**
	* Removes the admin i p validation data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data that was removed
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	public gr.open.marketplace.model.AdminIPValidationData updateImpl(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the admin i p validation data with the primary key or throws a {@link gr.open.marketplace.NoSuchAdminIPValidationDataException} if it could not be found.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns the admin i p validation data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the admin i p validation data
	* @return the admin i p validation data, or <code>null</code> if a admin i p validation data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the admin i p validation data where id = &#63; or throws a {@link gr.open.marketplace.NoSuchAdminIPValidationDataException} if it could not be found.
	*
	* @param id the ID
	* @return the matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns the admin i p validation data where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the admin i p validation data where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchById(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the admin i p validation datas where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @return the matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByActiveAndCompany(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByActiveAndCompany(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByActiveAndCompany(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.marketplace.model.AdminIPValidationData findByActiveAndCompany_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchByActiveAndCompany_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.marketplace.model.AdminIPValidationData findByActiveAndCompany_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchByActiveAndCompany_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.marketplace.model.AdminIPValidationData[] findByActiveAndCompany_PrevAndNext(
		long id, long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns all the admin i p validation datas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns the first admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data
	* @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns the last admin i p validation data in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.marketplace.model.AdminIPValidationData[] findByCompany_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Returns all the admin i p validation datas.
	*
	* @return the admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.marketplace.model.AdminIPValidationData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the admin i p validation data where id = &#63; from the database.
	*
	* @param id the ID
	* @return the admin i p validation data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.marketplace.model.AdminIPValidationData removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.marketplace.NoSuchAdminIPValidationDataException;

	/**
	* Removes all the admin i p validation datas where companyId = &#63; and active = &#63; from the database.
	*
	* @param companyId the company ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActiveAndCompany(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the admin i p validation datas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the admin i p validation datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of admin i p validation datas where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of admin i p validation datas where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company ID
	* @param active the active
	* @return the number of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByActiveAndCompany(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of admin i p validation datas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of admin i p validation datas.
	*
	* @return the number of admin i p validation datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}