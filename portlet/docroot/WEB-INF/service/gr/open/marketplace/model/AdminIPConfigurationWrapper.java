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

package gr.open.marketplace.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdminIPConfiguration}.
 * </p>
 *
 * @author    cotria
 * @see       AdminIPConfiguration
 * @generated
 */
public class AdminIPConfigurationWrapper implements AdminIPConfiguration,
	ModelWrapper<AdminIPConfiguration> {
	public AdminIPConfigurationWrapper(
		AdminIPConfiguration adminIPConfiguration) {
		_adminIPConfiguration = adminIPConfiguration;
	}

	public Class<?> getModelClass() {
		return AdminIPConfiguration.class;
	}

	public String getModelClassName() {
		return AdminIPConfiguration.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("redirectUrl", getRedirectUrl());
		attributes.put("debug", getDebug());
		attributes.put("mode", getMode());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String redirectUrl = (String)attributes.get("redirectUrl");

		if (redirectUrl != null) {
			setRedirectUrl(redirectUrl);
		}

		Boolean debug = (Boolean)attributes.get("debug");

		if (debug != null) {
			setDebug(debug);
		}

		Integer mode = (Integer)attributes.get("mode");

		if (mode != null) {
			setMode(mode);
		}
	}

	/**
	* Returns the primary key of this admin i p configuration.
	*
	* @return the primary key of this admin i p configuration
	*/
	public long getPrimaryKey() {
		return _adminIPConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this admin i p configuration.
	*
	* @param primaryKey the primary key of this admin i p configuration
	*/
	public void setPrimaryKey(long primaryKey) {
		_adminIPConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this admin i p configuration.
	*
	* @return the ID of this admin i p configuration
	*/
	public long getId() {
		return _adminIPConfiguration.getId();
	}

	/**
	* Sets the ID of this admin i p configuration.
	*
	* @param id the ID of this admin i p configuration
	*/
	public void setId(long id) {
		_adminIPConfiguration.setId(id);
	}

	/**
	* Returns the redirect url of this admin i p configuration.
	*
	* @return the redirect url of this admin i p configuration
	*/
	public java.lang.String getRedirectUrl() {
		return _adminIPConfiguration.getRedirectUrl();
	}

	/**
	* Sets the redirect url of this admin i p configuration.
	*
	* @param redirectUrl the redirect url of this admin i p configuration
	*/
	public void setRedirectUrl(java.lang.String redirectUrl) {
		_adminIPConfiguration.setRedirectUrl(redirectUrl);
	}

	/**
	* Returns the debug of this admin i p configuration.
	*
	* @return the debug of this admin i p configuration
	*/
	public boolean getDebug() {
		return _adminIPConfiguration.getDebug();
	}

	/**
	* Returns <code>true</code> if this admin i p configuration is debug.
	*
	* @return <code>true</code> if this admin i p configuration is debug; <code>false</code> otherwise
	*/
	public boolean isDebug() {
		return _adminIPConfiguration.isDebug();
	}

	/**
	* Sets whether this admin i p configuration is debug.
	*
	* @param debug the debug of this admin i p configuration
	*/
	public void setDebug(boolean debug) {
		_adminIPConfiguration.setDebug(debug);
	}

	/**
	* Returns the mode of this admin i p configuration.
	*
	* @return the mode of this admin i p configuration
	*/
	public int getMode() {
		return _adminIPConfiguration.getMode();
	}

	/**
	* Sets the mode of this admin i p configuration.
	*
	* @param mode the mode of this admin i p configuration
	*/
	public void setMode(int mode) {
		_adminIPConfiguration.setMode(mode);
	}

	public boolean isNew() {
		return _adminIPConfiguration.isNew();
	}

	public void setNew(boolean n) {
		_adminIPConfiguration.setNew(n);
	}

	public boolean isCachedModel() {
		return _adminIPConfiguration.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_adminIPConfiguration.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _adminIPConfiguration.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _adminIPConfiguration.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adminIPConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adminIPConfiguration.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adminIPConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdminIPConfigurationWrapper((AdminIPConfiguration)_adminIPConfiguration.clone());
	}

	public int compareTo(
		gr.open.marketplace.model.AdminIPConfiguration adminIPConfiguration) {
		return _adminIPConfiguration.compareTo(adminIPConfiguration);
	}

	@Override
	public int hashCode() {
		return _adminIPConfiguration.hashCode();
	}

	public com.liferay.portal.model.CacheModel<gr.open.marketplace.model.AdminIPConfiguration> toCacheModel() {
		return _adminIPConfiguration.toCacheModel();
	}

	public gr.open.marketplace.model.AdminIPConfiguration toEscapedModel() {
		return new AdminIPConfigurationWrapper(_adminIPConfiguration.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adminIPConfiguration.toString();
	}

	public java.lang.String toXmlString() {
		return _adminIPConfiguration.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adminIPConfiguration.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AdminIPConfiguration getWrappedAdminIPConfiguration() {
		return _adminIPConfiguration;
	}

	public AdminIPConfiguration getWrappedModel() {
		return _adminIPConfiguration;
	}

	public void resetOriginalValues() {
		_adminIPConfiguration.resetOriginalValues();
	}

	private AdminIPConfiguration _adminIPConfiguration;
}