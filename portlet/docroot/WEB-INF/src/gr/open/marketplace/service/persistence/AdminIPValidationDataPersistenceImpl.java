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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import gr.open.marketplace.NoSuchAdminIPValidationDataException;
import gr.open.marketplace.model.AdminIPValidationData;
import gr.open.marketplace.model.impl.AdminIPValidationDataImpl;
import gr.open.marketplace.model.impl.AdminIPValidationDataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the admin i p validation data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cotria
 * @see AdminIPValidationDataPersistence
 * @see AdminIPValidationDataUtil
 * @generated
 */
public class AdminIPValidationDataPersistenceImpl extends BasePersistenceImpl<AdminIPValidationData>
	implements AdminIPValidationDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdminIPValidationDataUtil} to access the admin i p validation data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdminIPValidationDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchById", new String[] { Long.class.getName() },
			AdminIPValidationDataModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVEANDCOMPANY =
		new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActiveAndCompany",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEANDCOMPANY =
		new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByActiveAndCompany",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			AdminIPValidationDataModelImpl.COMPANYID_COLUMN_BITMASK |
			AdminIPValidationDataModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVEANDCOMPANY = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActiveAndCompany",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			AdminIPValidationDataModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the admin i p validation data in the entity cache if it is enabled.
	 *
	 * @param adminIPValidationData the admin i p validation data
	 */
	public void cacheResult(AdminIPValidationData adminIPValidationData) {
		EntityCacheUtil.putResult(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			adminIPValidationData.getPrimaryKey(), adminIPValidationData);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(adminIPValidationData.getId()) },
			adminIPValidationData);

		adminIPValidationData.resetOriginalValues();
	}

	/**
	 * Caches the admin i p validation datas in the entity cache if it is enabled.
	 *
	 * @param adminIPValidationDatas the admin i p validation datas
	 */
	public void cacheResult(List<AdminIPValidationData> adminIPValidationDatas) {
		for (AdminIPValidationData adminIPValidationData : adminIPValidationDatas) {
			if (EntityCacheUtil.getResult(
						AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
						AdminIPValidationDataImpl.class,
						adminIPValidationData.getPrimaryKey()) == null) {
				cacheResult(adminIPValidationData);
			}
			else {
				adminIPValidationData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all admin i p validation datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdminIPValidationDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdminIPValidationDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the admin i p validation data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdminIPValidationData adminIPValidationData) {
		EntityCacheUtil.removeResult(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			adminIPValidationData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(adminIPValidationData);
	}

	@Override
	public void clearCache(List<AdminIPValidationData> adminIPValidationDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdminIPValidationData adminIPValidationData : adminIPValidationDatas) {
			EntityCacheUtil.removeResult(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
				AdminIPValidationDataImpl.class,
				adminIPValidationData.getPrimaryKey());

			clearUniqueFindersCache(adminIPValidationData);
		}
	}

	protected void clearUniqueFindersCache(
		AdminIPValidationData adminIPValidationData) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(adminIPValidationData.getId()) });
	}

	/**
	 * Creates a new admin i p validation data with the primary key. Does not add the admin i p validation data to the database.
	 *
	 * @param id the primary key for the new admin i p validation data
	 * @return the new admin i p validation data
	 */
	public AdminIPValidationData create(long id) {
		AdminIPValidationData adminIPValidationData = new AdminIPValidationDataImpl();

		adminIPValidationData.setNew(true);
		adminIPValidationData.setPrimaryKey(id);

		return adminIPValidationData;
	}

	/**
	 * Removes the admin i p validation data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the admin i p validation data
	 * @return the admin i p validation data that was removed
	 * @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData remove(long id)
		throws NoSuchAdminIPValidationDataException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the admin i p validation data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the admin i p validation data
	 * @return the admin i p validation data that was removed
	 * @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdminIPValidationData remove(Serializable primaryKey)
		throws NoSuchAdminIPValidationDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdminIPValidationData adminIPValidationData = (AdminIPValidationData)session.get(AdminIPValidationDataImpl.class,
					primaryKey);

			if (adminIPValidationData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdminIPValidationDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adminIPValidationData);
		}
		catch (NoSuchAdminIPValidationDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AdminIPValidationData removeImpl(
		AdminIPValidationData adminIPValidationData) throws SystemException {
		adminIPValidationData = toUnwrappedModel(adminIPValidationData);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, adminIPValidationData);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(adminIPValidationData);

		return adminIPValidationData;
	}

	@Override
	public AdminIPValidationData updateImpl(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData,
		boolean merge) throws SystemException {
		adminIPValidationData = toUnwrappedModel(adminIPValidationData);

		boolean isNew = adminIPValidationData.isNew();

		AdminIPValidationDataModelImpl adminIPValidationDataModelImpl = (AdminIPValidationDataModelImpl)adminIPValidationData;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, adminIPValidationData, merge);

			adminIPValidationData.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdminIPValidationDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adminIPValidationDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(adminIPValidationDataModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(adminIPValidationDataModelImpl.getOriginalActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(adminIPValidationDataModelImpl.getCompanyId()),
						Boolean.valueOf(adminIPValidationDataModelImpl.getActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEANDCOMPANY,
					args);
			}

			if ((adminIPValidationDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(adminIPValidationDataModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(adminIPValidationDataModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}
		}

		EntityCacheUtil.putResult(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPValidationDataImpl.class,
			adminIPValidationData.getPrimaryKey(), adminIPValidationData);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
				new Object[] { Long.valueOf(adminIPValidationData.getId()) },
				adminIPValidationData);
		}
		else {
			if ((adminIPValidationDataModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(adminIPValidationDataModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
					new Object[] { Long.valueOf(adminIPValidationData.getId()) },
					adminIPValidationData);
			}
		}

		return adminIPValidationData;
	}

	protected AdminIPValidationData toUnwrappedModel(
		AdminIPValidationData adminIPValidationData) {
		if (adminIPValidationData instanceof AdminIPValidationDataImpl) {
			return adminIPValidationData;
		}

		AdminIPValidationDataImpl adminIPValidationDataImpl = new AdminIPValidationDataImpl();

		adminIPValidationDataImpl.setNew(adminIPValidationData.isNew());
		adminIPValidationDataImpl.setPrimaryKey(adminIPValidationData.getPrimaryKey());

		adminIPValidationDataImpl.setId(adminIPValidationData.getId());
		adminIPValidationDataImpl.setIpAddresses(adminIPValidationData.getIpAddresses());
		adminIPValidationDataImpl.setRoles(adminIPValidationData.getRoles());
		adminIPValidationDataImpl.setCompanyId(adminIPValidationData.getCompanyId());
		adminIPValidationDataImpl.setUserId(adminIPValidationData.getUserId());
		adminIPValidationDataImpl.setUserName(adminIPValidationData.getUserName());
		adminIPValidationDataImpl.setCreateDate(adminIPValidationData.getCreateDate());
		adminIPValidationDataImpl.setModifiedDate(adminIPValidationData.getModifiedDate());
		adminIPValidationDataImpl.setNotes(adminIPValidationData.getNotes());
		adminIPValidationDataImpl.setActive(adminIPValidationData.isActive());

		return adminIPValidationDataImpl;
	}

	/**
	 * Returns the admin i p validation data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin i p validation data
	 * @return the admin i p validation data
	 * @throws com.liferay.portal.NoSuchModelException if a admin i p validation data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdminIPValidationData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the admin i p validation data with the primary key or throws a {@link gr.open.marketplace.NoSuchAdminIPValidationDataException} if it could not be found.
	 *
	 * @param id the primary key of the admin i p validation data
	 * @return the admin i p validation data
	 * @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a admin i p validation data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData findByPrimaryKey(long id)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = fetchByPrimaryKey(id);

		if (adminIPValidationData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchAdminIPValidationDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return adminIPValidationData;
	}

	/**
	 * Returns the admin i p validation data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin i p validation data
	 * @return the admin i p validation data, or <code>null</code> if a admin i p validation data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdminIPValidationData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the admin i p validation data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the admin i p validation data
	 * @return the admin i p validation data, or <code>null</code> if a admin i p validation data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData fetchByPrimaryKey(long id)
		throws SystemException {
		AdminIPValidationData adminIPValidationData = (AdminIPValidationData)EntityCacheUtil.getResult(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
				AdminIPValidationDataImpl.class, id);

		if (adminIPValidationData == _nullAdminIPValidationData) {
			return null;
		}

		if (adminIPValidationData == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				adminIPValidationData = (AdminIPValidationData)session.get(AdminIPValidationDataImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (adminIPValidationData != null) {
					cacheResult(adminIPValidationData);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AdminIPValidationDataModelImpl.ENTITY_CACHE_ENABLED,
						AdminIPValidationDataImpl.class, id,
						_nullAdminIPValidationData);
				}

				closeSession(session);
			}
		}

		return adminIPValidationData;
	}

	/**
	 * Returns the admin i p validation data where id = &#63; or throws a {@link gr.open.marketplace.NoSuchAdminIPValidationDataException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching admin i p validation data
	 * @throws gr.open.marketplace.NoSuchAdminIPValidationDataException if a matching admin i p validation data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData findById(long id)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = fetchById(id);

		if (adminIPValidationData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAdminIPValidationDataException(msg.toString());
		}

		return adminIPValidationData;
	}

	/**
	 * Returns the admin i p validation data where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData fetchById(long id) throws SystemException {
		return fetchById(id, true);
	}

	/**
	 * Returns the admin i p validation data where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData fetchById(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result instanceof AdminIPValidationData) {
			AdminIPValidationData adminIPValidationData = (AdminIPValidationData)result;

			if ((id != adminIPValidationData.getId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ADMINIPVALIDATIONDATA_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			query.append(AdminIPValidationDataModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<AdminIPValidationData> list = q.list();

				result = list;

				AdminIPValidationData adminIPValidationData = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					adminIPValidationData = list.get(0);

					cacheResult(adminIPValidationData);

					if ((adminIPValidationData.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, adminIPValidationData);
					}
				}

				return adminIPValidationData;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (AdminIPValidationData)result;
			}
		}
	}

	/**
	 * Returns all the admin i p validation datas where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdminIPValidationData> findByActiveAndCompany(long companyId,
		boolean active) throws SystemException {
		return findByActiveAndCompany(companyId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<AdminIPValidationData> findByActiveAndCompany(long companyId,
		boolean active, int start, int end) throws SystemException {
		return findByActiveAndCompany(companyId, active, start, end, null);
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
	public List<AdminIPValidationData> findByActiveAndCompany(long companyId,
		boolean active, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEANDCOMPANY;
			finderArgs = new Object[] { companyId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVEANDCOMPANY;
			finderArgs = new Object[] {
					companyId, active,
					
					start, end, orderByComparator
				};
		}

		List<AdminIPValidationData> list = (List<AdminIPValidationData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdminIPValidationData adminIPValidationData : list) {
				if ((companyId != adminIPValidationData.getCompanyId()) ||
						(active != adminIPValidationData.getActive())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ADMINIPVALIDATIONDATA_WHERE);

			query.append(_FINDER_COLUMN_ACTIVEANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_ACTIVEANDCOMPANY_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AdminIPValidationDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(active);

				list = (List<AdminIPValidationData>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public AdminIPValidationData findByActiveAndCompany_First(long companyId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = fetchByActiveAndCompany_First(companyId,
				active, orderByComparator);

		if (adminIPValidationData != null) {
			return adminIPValidationData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminIPValidationDataException(msg.toString());
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
	public AdminIPValidationData fetchByActiveAndCompany_First(long companyId,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		List<AdminIPValidationData> list = findByActiveAndCompany(companyId,
				active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public AdminIPValidationData findByActiveAndCompany_Last(long companyId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = fetchByActiveAndCompany_Last(companyId,
				active, orderByComparator);

		if (adminIPValidationData != null) {
			return adminIPValidationData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminIPValidationDataException(msg.toString());
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
	public AdminIPValidationData fetchByActiveAndCompany_Last(long companyId,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByActiveAndCompany(companyId, active);

		List<AdminIPValidationData> list = findByActiveAndCompany(companyId,
				active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public AdminIPValidationData[] findByActiveAndCompany_PrevAndNext(long id,
		long companyId, boolean active, OrderByComparator orderByComparator)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AdminIPValidationData[] array = new AdminIPValidationDataImpl[3];

			array[0] = getByActiveAndCompany_PrevAndNext(session,
					adminIPValidationData, companyId, active,
					orderByComparator, true);

			array[1] = adminIPValidationData;

			array[2] = getByActiveAndCompany_PrevAndNext(session,
					adminIPValidationData, companyId, active,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdminIPValidationData getByActiveAndCompany_PrevAndNext(
		Session session, AdminIPValidationData adminIPValidationData,
		long companyId, boolean active, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADMINIPVALIDATIONDATA_WHERE);

		query.append(_FINDER_COLUMN_ACTIVEANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_ACTIVEANDCOMPANY_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AdminIPValidationDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adminIPValidationData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdminIPValidationData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the admin i p validation datas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdminIPValidationData> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<AdminIPValidationData> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
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
	public List<AdminIPValidationData> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<AdminIPValidationData> list = (List<AdminIPValidationData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdminIPValidationData adminIPValidationData : list) {
				if ((companyId != adminIPValidationData.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADMINIPVALIDATIONDATA_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AdminIPValidationDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<AdminIPValidationData>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public AdminIPValidationData findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = fetchByCompany_First(companyId,
				orderByComparator);

		if (adminIPValidationData != null) {
			return adminIPValidationData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminIPValidationDataException(msg.toString());
	}

	/**
	 * Returns the first admin i p validation data in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdminIPValidationData> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public AdminIPValidationData findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = fetchByCompany_Last(companyId,
				orderByComparator);

		if (adminIPValidationData != null) {
			return adminIPValidationData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminIPValidationDataException(msg.toString());
	}

	/**
	 * Returns the last admin i p validation data in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin i p validation data, or <code>null</code> if a matching admin i p validation data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<AdminIPValidationData> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public AdminIPValidationData[] findByCompany_PrevAndNext(long id,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AdminIPValidationData[] array = new AdminIPValidationDataImpl[3];

			array[0] = getByCompany_PrevAndNext(session, adminIPValidationData,
					companyId, orderByComparator, true);

			array[1] = adminIPValidationData;

			array[2] = getByCompany_PrevAndNext(session, adminIPValidationData,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdminIPValidationData getByCompany_PrevAndNext(Session session,
		AdminIPValidationData adminIPValidationData, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADMINIPVALIDATIONDATA_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AdminIPValidationDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adminIPValidationData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdminIPValidationData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the admin i p validation datas.
	 *
	 * @return the admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdminIPValidationData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<AdminIPValidationData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<AdminIPValidationData> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AdminIPValidationData> list = (List<AdminIPValidationData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADMINIPVALIDATIONDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADMINIPVALIDATIONDATA.concat(AdminIPValidationDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AdminIPValidationData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AdminIPValidationData>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the admin i p validation data where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the admin i p validation data that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPValidationData removeById(long id)
		throws NoSuchAdminIPValidationDataException, SystemException {
		AdminIPValidationData adminIPValidationData = findById(id);

		return remove(adminIPValidationData);
	}

	/**
	 * Removes all the admin i p validation datas where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByActiveAndCompany(long companyId, boolean active)
		throws SystemException {
		for (AdminIPValidationData adminIPValidationData : findByActiveAndCompany(
				companyId, active)) {
			remove(adminIPValidationData);
		}
	}

	/**
	 * Removes all the admin i p validation datas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (AdminIPValidationData adminIPValidationData : findByCompany(
				companyId)) {
			remove(adminIPValidationData);
		}
	}

	/**
	 * Removes all the admin i p validation datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AdminIPValidationData adminIPValidationData : findAll()) {
			remove(adminIPValidationData);
		}
	}

	/**
	 * Returns the number of admin i p validation datas where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countById(long id) throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADMINIPVALIDATIONDATA_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of admin i p validation datas where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByActiveAndCompany(long companyId, boolean active)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADMINIPVALIDATIONDATA_WHERE);

			query.append(_FINDER_COLUMN_ACTIVEANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_ACTIVEANDCOMPANY_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVEANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of admin i p validation datas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADMINIPVALIDATIONDATA_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of admin i p validation datas.
	 *
	 * @return the number of admin i p validation datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADMINIPVALIDATIONDATA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the admin i p validation data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.gr.open.marketplace.model.AdminIPValidationData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdminIPValidationData>> listenersList = new ArrayList<ModelListener<AdminIPValidationData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdminIPValidationData>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AdminIPValidationDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AdminIPConfigurationPersistence.class)
	protected AdminIPConfigurationPersistence adminIPConfigurationPersistence;
	@BeanReference(type = AdminIPValidationDataPersistence.class)
	protected AdminIPValidationDataPersistence adminIPValidationDataPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ADMINIPVALIDATIONDATA = "SELECT adminIPValidationData FROM AdminIPValidationData adminIPValidationData";
	private static final String _SQL_SELECT_ADMINIPVALIDATIONDATA_WHERE = "SELECT adminIPValidationData FROM AdminIPValidationData adminIPValidationData WHERE ";
	private static final String _SQL_COUNT_ADMINIPVALIDATIONDATA = "SELECT COUNT(adminIPValidationData) FROM AdminIPValidationData adminIPValidationData";
	private static final String _SQL_COUNT_ADMINIPVALIDATIONDATA_WHERE = "SELECT COUNT(adminIPValidationData) FROM AdminIPValidationData adminIPValidationData WHERE ";
	private static final String _FINDER_COLUMN_ID_ID_2 = "adminIPValidationData.id = ?";
	private static final String _FINDER_COLUMN_ACTIVEANDCOMPANY_COMPANYID_2 = "adminIPValidationData.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ACTIVEANDCOMPANY_ACTIVE_2 = "adminIPValidationData.active = ?";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "adminIPValidationData.companyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adminIPValidationData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdminIPValidationData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdminIPValidationData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdminIPValidationDataPersistenceImpl.class);
	private static AdminIPValidationData _nullAdminIPValidationData = new AdminIPValidationDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdminIPValidationData> toCacheModel() {
				return _nullAdminIPValidationDataCacheModel;
			}
		};

	private static CacheModel<AdminIPValidationData> _nullAdminIPValidationDataCacheModel =
		new CacheModel<AdminIPValidationData>() {
			public AdminIPValidationData toEntityModel() {
				return _nullAdminIPValidationData;
			}
		};
}