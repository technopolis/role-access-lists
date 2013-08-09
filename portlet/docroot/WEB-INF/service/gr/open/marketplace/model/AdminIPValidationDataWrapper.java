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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdminIPValidationData}.
 * </p>
 *
 * @author    cotria
 * @see       AdminIPValidationData
 * @generated
 */
public class AdminIPValidationDataWrapper implements AdminIPValidationData,
	ModelWrapper<AdminIPValidationData> {
	public AdminIPValidationDataWrapper(
		AdminIPValidationData adminIPValidationData) {
		_adminIPValidationData = adminIPValidationData;
	}

	public Class<?> getModelClass() {
		return AdminIPValidationData.class;
	}

	public String getModelClassName() {
		return AdminIPValidationData.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ipAddresses", getIpAddresses());
		attributes.put("roles", getRoles());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("notes", getNotes());
		attributes.put("active", getActive());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ipAddresses = (String)attributes.get("ipAddresses");

		if (ipAddresses != null) {
			setIpAddresses(ipAddresses);
		}

		String roles = (String)attributes.get("roles");

		if (roles != null) {
			setRoles(roles);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this admin i p validation data.
	*
	* @return the primary key of this admin i p validation data
	*/
	public long getPrimaryKey() {
		return _adminIPValidationData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this admin i p validation data.
	*
	* @param primaryKey the primary key of this admin i p validation data
	*/
	public void setPrimaryKey(long primaryKey) {
		_adminIPValidationData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this admin i p validation data.
	*
	* @return the ID of this admin i p validation data
	*/
	public long getId() {
		return _adminIPValidationData.getId();
	}

	/**
	* Sets the ID of this admin i p validation data.
	*
	* @param id the ID of this admin i p validation data
	*/
	public void setId(long id) {
		_adminIPValidationData.setId(id);
	}

	/**
	* Returns the ip addresses of this admin i p validation data.
	*
	* @return the ip addresses of this admin i p validation data
	*/
	public java.lang.String getIpAddresses() {
		return _adminIPValidationData.getIpAddresses();
	}

	/**
	* Sets the ip addresses of this admin i p validation data.
	*
	* @param ipAddresses the ip addresses of this admin i p validation data
	*/
	public void setIpAddresses(java.lang.String ipAddresses) {
		_adminIPValidationData.setIpAddresses(ipAddresses);
	}

	/**
	* Returns the roles of this admin i p validation data.
	*
	* @return the roles of this admin i p validation data
	*/
	public java.lang.String getRoles() {
		return _adminIPValidationData.getRoles();
	}

	/**
	* Sets the roles of this admin i p validation data.
	*
	* @param roles the roles of this admin i p validation data
	*/
	public void setRoles(java.lang.String roles) {
		_adminIPValidationData.setRoles(roles);
	}

	/**
	* Returns the company ID of this admin i p validation data.
	*
	* @return the company ID of this admin i p validation data
	*/
	public long getCompanyId() {
		return _adminIPValidationData.getCompanyId();
	}

	/**
	* Sets the company ID of this admin i p validation data.
	*
	* @param companyId the company ID of this admin i p validation data
	*/
	public void setCompanyId(long companyId) {
		_adminIPValidationData.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this admin i p validation data.
	*
	* @return the user ID of this admin i p validation data
	*/
	public long getUserId() {
		return _adminIPValidationData.getUserId();
	}

	/**
	* Sets the user ID of this admin i p validation data.
	*
	* @param userId the user ID of this admin i p validation data
	*/
	public void setUserId(long userId) {
		_adminIPValidationData.setUserId(userId);
	}

	/**
	* Returns the user uuid of this admin i p validation data.
	*
	* @return the user uuid of this admin i p validation data
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adminIPValidationData.getUserUuid();
	}

	/**
	* Sets the user uuid of this admin i p validation data.
	*
	* @param userUuid the user uuid of this admin i p validation data
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_adminIPValidationData.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this admin i p validation data.
	*
	* @return the user name of this admin i p validation data
	*/
	public java.lang.String getUserName() {
		return _adminIPValidationData.getUserName();
	}

	/**
	* Sets the user name of this admin i p validation data.
	*
	* @param userName the user name of this admin i p validation data
	*/
	public void setUserName(java.lang.String userName) {
		_adminIPValidationData.setUserName(userName);
	}

	/**
	* Returns the create date of this admin i p validation data.
	*
	* @return the create date of this admin i p validation data
	*/
	public java.util.Date getCreateDate() {
		return _adminIPValidationData.getCreateDate();
	}

	/**
	* Sets the create date of this admin i p validation data.
	*
	* @param createDate the create date of this admin i p validation data
	*/
	public void setCreateDate(java.util.Date createDate) {
		_adminIPValidationData.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this admin i p validation data.
	*
	* @return the modified date of this admin i p validation data
	*/
	public java.util.Date getModifiedDate() {
		return _adminIPValidationData.getModifiedDate();
	}

	/**
	* Sets the modified date of this admin i p validation data.
	*
	* @param modifiedDate the modified date of this admin i p validation data
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_adminIPValidationData.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the notes of this admin i p validation data.
	*
	* @return the notes of this admin i p validation data
	*/
	public java.lang.String getNotes() {
		return _adminIPValidationData.getNotes();
	}

	/**
	* Sets the notes of this admin i p validation data.
	*
	* @param notes the notes of this admin i p validation data
	*/
	public void setNotes(java.lang.String notes) {
		_adminIPValidationData.setNotes(notes);
	}

	/**
	* Returns the active of this admin i p validation data.
	*
	* @return the active of this admin i p validation data
	*/
	public boolean getActive() {
		return _adminIPValidationData.getActive();
	}

	/**
	* Returns <code>true</code> if this admin i p validation data is active.
	*
	* @return <code>true</code> if this admin i p validation data is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _adminIPValidationData.isActive();
	}

	/**
	* Sets whether this admin i p validation data is active.
	*
	* @param active the active of this admin i p validation data
	*/
	public void setActive(boolean active) {
		_adminIPValidationData.setActive(active);
	}

	public boolean isNew() {
		return _adminIPValidationData.isNew();
	}

	public void setNew(boolean n) {
		_adminIPValidationData.setNew(n);
	}

	public boolean isCachedModel() {
		return _adminIPValidationData.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_adminIPValidationData.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _adminIPValidationData.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _adminIPValidationData.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adminIPValidationData.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adminIPValidationData.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adminIPValidationData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdminIPValidationDataWrapper((AdminIPValidationData)_adminIPValidationData.clone());
	}

	public int compareTo(
		gr.open.marketplace.model.AdminIPValidationData adminIPValidationData) {
		return _adminIPValidationData.compareTo(adminIPValidationData);
	}

	@Override
	public int hashCode() {
		return _adminIPValidationData.hashCode();
	}

	public com.liferay.portal.model.CacheModel<gr.open.marketplace.model.AdminIPValidationData> toCacheModel() {
		return _adminIPValidationData.toCacheModel();
	}

	public gr.open.marketplace.model.AdminIPValidationData toEscapedModel() {
		return new AdminIPValidationDataWrapper(_adminIPValidationData.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adminIPValidationData.toString();
	}

	public java.lang.String toXmlString() {
		return _adminIPValidationData.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adminIPValidationData.persist();
	}

	public java.lang.Long[] getRolesAsArray() {
		return _adminIPValidationData.getRolesAsArray();
	}

	public java.lang.String[] getIpsAsArray() {
		return _adminIPValidationData.getIpsAsArray();
	}

	public java.lang.String getIpsForTable() {
		return _adminIPValidationData.getIpsForTable();
	}

	public java.lang.String getCreateDateForView() {
		return _adminIPValidationData.getCreateDateForView();
	}

	public java.lang.String getModifiedDateForView() {
		return _adminIPValidationData.getModifiedDateForView();
	}

	public java.lang.String getUserEmailForView() {
		return _adminIPValidationData.getUserEmailForView();
	}

	public java.lang.String getRolesForView() {
		return _adminIPValidationData.getRolesForView();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AdminIPValidationData getWrappedAdminIPValidationData() {
		return _adminIPValidationData;
	}

	public AdminIPValidationData getWrappedModel() {
		return _adminIPValidationData;
	}

	public void resetOriginalValues() {
		_adminIPValidationData.resetOriginalValues();
	}

	private AdminIPValidationData _adminIPValidationData;
}