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

package com.liferay.yithro.ticket.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TicketWorkerService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorkerService
 * @generated
 */
@ProviderType
public class TicketWorkerServiceWrapper
	implements TicketWorkerService, ServiceWrapper<TicketWorkerService> {

	public TicketWorkerServiceWrapper(TicketWorkerService ticketWorkerService) {
		_ticketWorkerService = ticketWorkerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketWorkerService.getOSGiServiceIdentifier();
	}

	@Override
	public TicketWorkerService getWrappedService() {
		return _ticketWorkerService;
	}

	@Override
	public void setWrappedService(TicketWorkerService ticketWorkerService) {
		_ticketWorkerService = ticketWorkerService;
	}

	private TicketWorkerService _ticketWorkerService;

}