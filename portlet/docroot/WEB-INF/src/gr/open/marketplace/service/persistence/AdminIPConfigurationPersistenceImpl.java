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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import gr.open.marketplace.NoSuchAdminIPConfigurationException;
import gr.open.marketplace.model.AdminIPConfiguration;
import gr.open.marketplace.model.impl.AdminIPConfigurationImpl;
import gr.open.marketplace.model.impl.AdminIPConfigurationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the admin i p configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author cotria
 * @see AdminIPConfigurationPersistence
 * @see AdminIPConfigurationUtil
 * @generated
 */
public class AdminIPConfigurationPersistenceImpl extends BasePersistenceImpl<AdminIPConfiguration>
	implements AdminIPConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdminIPConfigurationUtil} to access the admin i p configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdminIPConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPConfigurationModelImpl.FINDER_CACHE_ENABLED,
			AdminIPConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPConfigurationModelImpl.FINDER_CACHE_ENABLED,
			AdminIPConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the admin i p configuration in the entity cache if it is enabled.
	 *
	 * @param adminIPConfiguration the admin i p configuration
	 */
	public void cacheResult(AdminIPConfiguration adminIPConfiguration) {
		EntityCacheUtil.putResult(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPConfigurationImpl.class,
			adminIPConfiguration.getPrimaryKey(), adminIPConfiguration);

		adminIPConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the admin i p configurations in the entity cache if it is enabled.
	 *
	 * @param adminIPConfigurations the admin i p configurations
	 */
	public void cacheResult(List<AdminIPConfiguration> adminIPConfigurations) {
		for (AdminIPConfiguration adminIPConfiguration : adminIPConfigurations) {
			if (EntityCacheUtil.getResult(
						AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						AdminIPConfigurationImpl.class,
						adminIPConfiguration.getPrimaryKey()) == null) {
				cacheResult(adminIPConfiguration);
			}
			else {
				adminIPConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all admin i p configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdminIPConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdminIPConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the admin i p configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdminIPConfiguration adminIPConfiguration) {
		EntityCacheUtil.removeResult(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPConfigurationImpl.class, adminIPConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdminIPConfiguration> adminIPConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdminIPConfiguration adminIPConfiguration : adminIPConfigurations) {
			EntityCacheUtil.removeResult(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				AdminIPConfigurationImpl.class,
				adminIPConfiguration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new admin i p configuration with the primary key. Does not add the admin i p configuration to the database.
	 *
	 * @param id the primary key for the new admin i p configuration
	 * @return the new admin i p configuration
	 */
	public AdminIPConfiguration create(long id) {
		AdminIPConfiguration adminIPConfiguration = new AdminIPConfigurationImpl();

		adminIPConfiguration.setNew(true);
		adminIPConfiguration.setPrimaryKey(id);

		return adminIPConfiguration;
	}

	/**
	 * Removes the admin i p configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the admin i p configuration
	 * @return the admin i p configuration that was removed
	 * @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPConfiguration remove(long id)
		throws NoSuchAdminIPConfigurationException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the admin i p configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the admin i p configuration
	 * @return the admin i p configuration that was removed
	 * @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdminIPConfiguration remove(Serializable primaryKey)
		throws NoSuchAdminIPConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdminIPConfiguration adminIPConfiguration = (AdminIPConfiguration)session.get(AdminIPConfigurationImpl.class,
					primaryKey);

			if (adminIPConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdminIPConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adminIPConfiguration);
		}
		catch (NoSuchAdminIPConfigurationException nsee) {
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
	protected AdminIPConfiguration removeImpl(
		AdminIPConfiguration adminIPConfiguration) throws SystemException {
		adminIPConfiguration = toUnwrappedModel(adminIPConfiguration);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, adminIPConfiguration);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(adminIPConfiguration);

		return adminIPConfiguration;
	}

	@Override
	public AdminIPConfiguration updateImpl(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration,
		boolean merge) throws SystemException {
		adminIPConfiguration = toUnwrappedModel(adminIPConfiguration);

		boolean isNew = adminIPConfiguration.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, adminIPConfiguration, merge);

			adminIPConfiguration.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			AdminIPConfigurationImpl.class,
			adminIPConfiguration.getPrimaryKey(), adminIPConfiguration);

		return adminIPConfiguration;
	}

	protected AdminIPConfiguration toUnwrappedModel(
		AdminIPConfiguration adminIPConfiguration) {
		if (adminIPConfiguration instanceof AdminIPConfigurationImpl) {
			return adminIPConfiguration;
		}

		AdminIPConfigurationImpl adminIPConfigurationImpl = new AdminIPConfigurationImpl();

		adminIPConfigurationImpl.setNew(adminIPConfiguration.isNew());
		adminIPConfigurationImpl.setPrimaryKey(adminIPConfiguration.getPrimaryKey());

		adminIPConfigurationImpl.setId(adminIPConfiguration.getId());
		adminIPConfigurationImpl.setRedirectUrl(adminIPConfiguration.getRedirectUrl());
		adminIPConfigurationImpl.setDebug(adminIPConfiguration.isDebug());
		adminIPConfigurationImpl.setMode(adminIPConfiguration.getMode());

		return adminIPConfigurationImpl;
	}

	/**
	 * Returns the admin i p configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin i p configuration
	 * @return the admin i p configuration
	 * @throws com.liferay.portal.NoSuchModelException if a admin i p configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdminIPConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the admin i p configuration with the primary key or throws a {@link gr.open.marketplace.NoSuchAdminIPConfigurationException} if it could not be found.
	 *
	 * @param id the primary key of the admin i p configuration
	 * @return the admin i p configuration
	 * @throws gr.open.marketplace.NoSuchAdminIPConfigurationException if a admin i p configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPConfiguration findByPrimaryKey(long id)
		throws NoSuchAdminIPConfigurationException, SystemException {
		AdminIPConfiguration adminIPConfiguration = fetchByPrimaryKey(id);

		if (adminIPConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchAdminIPConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return adminIPConfiguration;
	}

	/**
	 * Returns the admin i p configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin i p configuration
	 * @return the admin i p configuration, or <code>null</code> if a admin i p configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdminIPConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the admin i p configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the admin i p configuration
	 * @return the admin i p configuration, or <code>null</code> if a admin i p configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdminIPConfiguration fetchByPrimaryKey(long id)
		throws SystemException {
		AdminIPConfiguration adminIPConfiguration = (AdminIPConfiguration)EntityCacheUtil.getResult(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				AdminIPConfigurationImpl.class, id);

		if (adminIPConfiguration == _nullAdminIPConfiguration) {
			return null;
		}

		if (adminIPConfiguration == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				adminIPConfiguration = (AdminIPConfiguration)session.get(AdminIPConfigurationImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (adminIPConfiguration != null) {
					cacheResult(adminIPConfiguration);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AdminIPConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						AdminIPConfigurationImpl.class, id,
						_nullAdminIPConfiguration);
				}

				closeSession(session);
			}
		}

		return adminIPConfiguration;
	}

	/**
	 * Returns all the admin i p configurations.
	 *
	 * @return the admin i p configurations
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdminIPConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<AdminIPConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<AdminIPConfiguration> findAll(int start, int end,
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

		List<AdminIPConfiguration> list = (List<AdminIPConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADMINIPCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADMINIPCONFIGURATION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AdminIPConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AdminIPConfiguration>)QueryUtil.list(q,
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
	 * Removes all the admin i p configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AdminIPConfiguration adminIPConfiguration : findAll()) {
			remove(adminIPConfiguration);
		}
	}

	/**
	 * Returns the number of admin i p configurations.
	 *
	 * @return the number of admin i p configurations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADMINIPCONFIGURATION);

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
	 * Initializes the admin i p configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.gr.open.marketplace.model.AdminIPConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdminIPConfiguration>> listenersList = new ArrayList<ModelListener<AdminIPConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdminIPConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdminIPConfigurationImpl.class.getName());
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
	private static final String _SQL_SELECT_ADMINIPCONFIGURATION = "SELECT adminIPConfiguration FROM AdminIPConfiguration adminIPConfiguration";
	private static final String _SQL_COUNT_ADMINIPCONFIGURATION = "SELECT COUNT(adminIPConfiguration) FROM AdminIPConfiguration adminIPConfiguration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adminIPConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdminIPConfiguration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdminIPConfigurationPersistenceImpl.class);
	private static AdminIPConfiguration _nullAdminIPConfiguration = new AdminIPConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdminIPConfiguration> toCacheModel() {
				return _nullAdminIPConfigurationCacheModel;
			}
		};

	private static CacheModel<AdminIPConfiguration> _nullAdminIPConfigurationCacheModel =
		new CacheModel<AdminIPConfiguration>() {
			public AdminIPConfiguration toEntityModel() {
				return _nullAdminIPConfiguration;
			}
		};
}