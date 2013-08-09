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

package gr.open.marketplace.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import gr.open.marketplace.model.AdminIPValidationData;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AdminIPValidationData in entity cache.
 *
 * @author cotria
 * @see AdminIPValidationData
 * @generated
 */
public class AdminIPValidationDataCacheModel implements CacheModel<AdminIPValidationData>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ipAddresses=");
		sb.append(ipAddresses);
		sb.append(", roles=");
		sb.append(roles);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	public AdminIPValidationData toEntityModel() {
		AdminIPValidationDataImpl adminIPValidationDataImpl = new AdminIPValidationDataImpl();

		adminIPValidationDataImpl.setId(id);

		if (ipAddresses == null) {
			adminIPValidationDataImpl.setIpAddresses(StringPool.BLANK);
		}
		else {
			adminIPValidationDataImpl.setIpAddresses(ipAddresses);
		}

		if (roles == null) {
			adminIPValidationDataImpl.setRoles(StringPool.BLANK);
		}
		else {
			adminIPValidationDataImpl.setRoles(roles);
		}

		adminIPValidationDataImpl.setCompanyId(companyId);
		adminIPValidationDataImpl.setUserId(userId);

		if (userName == null) {
			adminIPValidationDataImpl.setUserName(StringPool.BLANK);
		}
		else {
			adminIPValidationDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			adminIPValidationDataImpl.setCreateDate(null);
		}
		else {
			adminIPValidationDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adminIPValidationDataImpl.setModifiedDate(null);
		}
		else {
			adminIPValidationDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (notes == null) {
			adminIPValidationDataImpl.setNotes(StringPool.BLANK);
		}
		else {
			adminIPValidationDataImpl.setNotes(notes);
		}

		adminIPValidationDataImpl.setActive(active);

		adminIPValidationDataImpl.resetOriginalValues();

		return adminIPValidationDataImpl;
	}

	public long id;
	public String ipAddresses;
	public String roles;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String notes;
	public boolean active;
}