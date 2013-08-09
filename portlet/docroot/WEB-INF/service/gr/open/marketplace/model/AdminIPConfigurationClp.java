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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import gr.open.marketplace.service.AdminIPConfigurationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cotria
 */
public class AdminIPConfigurationClp extends BaseModelImpl<AdminIPConfiguration>
	implements AdminIPConfiguration {
	public AdminIPConfigurationClp() {
	}

	public Class<?> getModelClass() {
		return AdminIPConfiguration.class;
	}

	public String getModelClassName() {
		return AdminIPConfiguration.class.getName();
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
		attributes.put("redirectUrl", getRedirectUrl());
		attributes.put("debug", getDebug());
		attributes.put("mode", getMode());

		return attributes;
	}

	@Override
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getRedirectUrl() {
		return _redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		_redirectUrl = redirectUrl;
	}

	public boolean getDebug() {
		return _debug;
	}

	public boolean isDebug() {
		return _debug;
	}

	public void setDebug(boolean debug) {
		_debug = debug;
	}

	public int getMode() {
		return _mode;
	}

	public void setMode(int mode) {
		_mode = mode;
	}

	public BaseModel<?> getAdminIPConfigurationRemoteModel() {
		return _adminIPConfigurationRemoteModel;
	}

	public void setAdminIPConfigurationRemoteModel(
		BaseModel<?> adminIPConfigurationRemoteModel) {
		_adminIPConfigurationRemoteModel = adminIPConfigurationRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AdminIPConfigurationLocalServiceUtil.addAdminIPConfiguration(this);
		}
		else {
			AdminIPConfigurationLocalServiceUtil.updateAdminIPConfiguration(this);
		}
	}

	@Override
	public AdminIPConfiguration toEscapedModel() {
		return (AdminIPConfiguration)Proxy.newProxyInstance(AdminIPConfiguration.class.getClassLoader(),
			new Class[] { AdminIPConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdminIPConfigurationClp clone = new AdminIPConfigurationClp();

		clone.setId(getId());
		clone.setRedirectUrl(getRedirectUrl());
		clone.setDebug(getDebug());
		clone.setMode(getMode());

		return clone;
	}

	public int compareTo(AdminIPConfiguration adminIPConfiguration) {
		long primaryKey = adminIPConfiguration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AdminIPConfigurationClp adminIPConfiguration = null;

		try {
			adminIPConfiguration = (AdminIPConfigurationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = adminIPConfiguration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", redirectUrl=");
		sb.append(getRedirectUrl());
		sb.append(", debug=");
		sb.append(getDebug());
		sb.append(", mode=");
		sb.append(getMode());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("gr.open.marketplace.model.AdminIPConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>redirectUrl</column-name><column-value><![CDATA[");
		sb.append(getRedirectUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>debug</column-name><column-value><![CDATA[");
		sb.append(getDebug());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mode</column-name><column-value><![CDATA[");
		sb.append(getMode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _redirectUrl;
	private boolean _debug;
	private int _mode;
	private BaseModel<?> _adminIPConfigurationRemoteModel;
}