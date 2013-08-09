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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    cotria
 * @generated
 */
public class AdminIPConfigurationSoap implements Serializable {
	public static AdminIPConfigurationSoap toSoapModel(
		AdminIPConfiguration model) {
		AdminIPConfigurationSoap soapModel = new AdminIPConfigurationSoap();

		soapModel.setId(model.getId());
		soapModel.setRedirectUrl(model.getRedirectUrl());
		soapModel.setDebug(model.getDebug());
		soapModel.setMode(model.getMode());

		return soapModel;
	}

	public static AdminIPConfigurationSoap[] toSoapModels(
		AdminIPConfiguration[] models) {
		AdminIPConfigurationSoap[] soapModels = new AdminIPConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdminIPConfigurationSoap[][] toSoapModels(
		AdminIPConfiguration[][] models) {
		AdminIPConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdminIPConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdminIPConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdminIPConfigurationSoap[] toSoapModels(
		List<AdminIPConfiguration> models) {
		List<AdminIPConfigurationSoap> soapModels = new ArrayList<AdminIPConfigurationSoap>(models.size());

		for (AdminIPConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdminIPConfigurationSoap[soapModels.size()]);
	}

	public AdminIPConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private String _redirectUrl;
	private boolean _debug;
	private int _mode;
}