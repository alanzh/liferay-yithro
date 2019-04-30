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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SupportTeamService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeamService
 * @generated
 */
@ProviderType
public class SupportTeamServiceWrapper
	implements SupportTeamService, ServiceWrapper<SupportTeamService> {

	public SupportTeamServiceWrapper(SupportTeamService supportTeamService) {
		_supportTeamService = supportTeamService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportTeamService.getOSGiServiceIdentifier();
	}

	@Override
	public SupportTeamService getWrappedService() {
		return _supportTeamService;
	}

	@Override
	public void setWrappedService(SupportTeamService supportTeamService) {
		_supportTeamService = supportTeamService;
	}

	private SupportTeamService _supportTeamService;

}