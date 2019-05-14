/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.yithro.support.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link SupportWorkerService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerService
 * @generated
 */
@ProviderType
public class SupportWorkerServiceWrapper
	implements SupportWorkerService, ServiceWrapper<SupportWorkerService> {

	public SupportWorkerServiceWrapper(
		SupportWorkerService supportWorkerService) {

		_supportWorkerService = supportWorkerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportWorkerService.getOSGiServiceIdentifier();
	}

	@Override
	public SupportWorkerService getWrappedService() {
		return _supportWorkerService;
	}

	@Override
	public void setWrappedService(SupportWorkerService supportWorkerService) {
		_supportWorkerService = supportWorkerService;
	}

	private SupportWorkerService _supportWorkerService;

}