/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package gr.open.marketplace;

import com.liferay.portal.NoSuchModelException;

/**
 * @author cotria
 */
public class NoSuchAdminIPValidationDataException extends NoSuchModelException {

	public NoSuchAdminIPValidationDataException() {
		super();
	}

	public NoSuchAdminIPValidationDataException(String msg) {
		super(msg);
	}

	public NoSuchAdminIPValidationDataException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAdminIPValidationDataException(Throwable cause) {
		super(cause);
	}

}