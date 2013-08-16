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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import gr.open.marketplace.service.AdminIPValidationDataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cotria
 */
public class AdminIPValidationDataClp extends BaseModelImpl<AdminIPValidationData>
	implements AdminIPValidationData {
	public AdminIPValidationDataClp() {
	}

	public Class<?> getModelClass() {
		return AdminIPValidationData.class;
	}

	public String getModelClassName() {
		return AdminIPValidationData.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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
		attributes.put("debugMode", getDebugMode());

		return attributes;
	}

	@Override
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

		Boolean debugMode = (Boolean)attributes.get("debugMode");

		if (debugMode != null) {
			setDebugMode(debugMode);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getIpAddresses() {
		return _ipAddresses;
	}

	public void setIpAddresses(String ipAddresses) {
		_ipAddresses = ipAddresses;
	}

	public String getRoles() {
		return _roles;
	}

	public void setRoles(String roles) {
		_roles = roles;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public boolean getDebugMode() {
		return _debugMode;
	}

	public boolean isDebugMode() {
		return _debugMode;
	}

	public void setDebugMode(boolean debugMode) {
		_debugMode = debugMode;
	}

	public java.lang.String getIpsForTable() {
		throw new UnsupportedOperationException();
	}

	public java.lang.Long[] getRolesAsArray() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String[] getIpsAsArray() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getCreateDateForView() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getModifiedDateForView() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getRolesForView() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getUserEmailForView() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getAdminIPValidationDataRemoteModel() {
		return _adminIPValidationDataRemoteModel;
	}

	public void setAdminIPValidationDataRemoteModel(
		BaseModel<?> adminIPValidationDataRemoteModel) {
		_adminIPValidationDataRemoteModel = adminIPValidationDataRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AdminIPValidationDataLocalServiceUtil.addAdminIPValidationData(this);
		}
		else {
			AdminIPValidationDataLocalServiceUtil.updateAdminIPValidationData(this);
		}
	}

	@Override
	public AdminIPValidationData toEscapedModel() {
		return (AdminIPValidationData)Proxy.newProxyInstance(AdminIPValidationData.class.getClassLoader(),
			new Class[] { AdminIPValidationData.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdminIPValidationDataClp clone = new AdminIPValidationDataClp();

		clone.setId(getId());
		clone.setIpAddresses(getIpAddresses());
		clone.setRoles(getRoles());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNotes(getNotes());
		clone.setActive(getActive());
		clone.setDebugMode(getDebugMode());

		return clone;
	}

	public int compareTo(AdminIPValidationData adminIPValidationData) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				adminIPValidationData.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AdminIPValidationDataClp adminIPValidationData = null;

		try {
			adminIPValidationData = (AdminIPValidationDataClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = adminIPValidationData.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ipAddresses=");
		sb.append(getIpAddresses());
		sb.append(", roles=");
		sb.append(getRoles());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", debugMode=");
		sb.append(getDebugMode());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("gr.open.marketplace.model.AdminIPValidationData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddresses</column-name><column-value><![CDATA[");
		sb.append(getIpAddresses());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roles</column-name><column-value><![CDATA[");
		sb.append(getRoles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>debugMode</column-name><column-value><![CDATA[");
		sb.append(getDebugMode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ipAddresses;
	private String _roles;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _notes;
	private boolean _active;
	private boolean _debugMode;
	private BaseModel<?> _adminIPValidationDataRemoteModel;
}