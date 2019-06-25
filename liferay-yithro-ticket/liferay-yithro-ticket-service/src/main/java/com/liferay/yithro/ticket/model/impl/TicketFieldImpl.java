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

package com.liferay.yithro.ticket.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketFieldType;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketFieldImpl extends TicketFieldBaseImpl {

	public TicketFieldImpl() {
	}

	public String getTypeLabel() {
		return TicketFieldType.getLabel(getType());
	}

	public String getVisibilityLabel() {
		return Visibilities.getLabel(getVisibility());
	}

}