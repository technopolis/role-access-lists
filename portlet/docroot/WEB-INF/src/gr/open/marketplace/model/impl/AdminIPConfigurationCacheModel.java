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

import gr.open.marketplace.model.AdminIPConfiguration;

import java.io.Serializable;

/**
 * The cache model class for representing AdminIPConfiguration in entity cache.
 *
 * @author cotria
 * @see AdminIPConfiguration
 * @generated
 */
public class AdminIPConfigurationCacheModel implements CacheModel<AdminIPConfiguration>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", redirectUrl=");
		sb.append(redirectUrl);
		sb.append(", debug=");
		sb.append(debug);
		sb.append(", mode=");
		sb.append(mode);
		sb.append("}");

		return sb.toString();
	}

	public AdminIPConfiguration toEntityModel() {
		AdminIPConfigurationImpl adminIPConfigurationImpl = new AdminIPConfigurationImpl();

		adminIPConfigurationImpl.setId(id);

		if (redirectUrl == null) {
			adminIPConfigurationImpl.setRedirectUrl(StringPool.BLANK);
		}
		else {
			adminIPConfigurationImpl.setRedirectUrl(redirectUrl);
		}

		adminIPConfigurationImpl.setDebug(debug);
		adminIPConfigurationImpl.setMode(mode);

		adminIPConfigurationImpl.resetOriginalValues();

		return adminIPConfigurationImpl;
	}

	public long id;
	public String redirectUrl;
	public boolean debug;
	public int mode;
}