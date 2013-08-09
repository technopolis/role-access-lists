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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    cotria
 * @generated
 */
public class AdminIPValidationDataSoap implements Serializable {
	public static AdminIPValidationDataSoap toSoapModel(
		AdminIPValidationData model) {
		AdminIPValidationDataSoap soapModel = new AdminIPValidationDataSoap();

		soapModel.setId(model.getId());
		soapModel.setIpAddresses(model.getIpAddresses());
		soapModel.setRoles(model.getRoles());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNotes(model.getNotes());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static AdminIPValidationDataSoap[] toSoapModels(
		AdminIPValidationData[] models) {
		AdminIPValidationDataSoap[] soapModels = new AdminIPValidationDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdminIPValidationDataSoap[][] toSoapModels(
		AdminIPValidationData[][] models) {
		AdminIPValidationDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdminIPValidationDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdminIPValidationDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdminIPValidationDataSoap[] toSoapModels(
		List<AdminIPValidationData> models) {
		List<AdminIPValidationDataSoap> soapModels = new ArrayList<AdminIPValidationDataSoap>(models.size());

		for (AdminIPValidationData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdminIPValidationDataSoap[soapModels.size()]);
	}

	public AdminIPValidationDataSoap() {
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

	private long _id;
	private String _ipAddresses;
	private String _roles;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _notes;
	private boolean _active;
}