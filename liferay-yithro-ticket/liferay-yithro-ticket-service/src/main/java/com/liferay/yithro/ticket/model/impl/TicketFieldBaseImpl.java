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

import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.service.TicketFieldLocalServiceUtil;

/**
 * The extended model base implementation for the TicketField service. Represents a row in the &quot;Yithro_TicketField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketFieldImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldImpl
 * @see TicketField
 * @generated
 */
public abstract class TicketFieldBaseImpl
	extends TicketFieldModelImpl implements TicketField {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket field model instance should use the <code>TicketField</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			TicketFieldLocalServiceUtil.addTicketField(this);
		}
		else {
			TicketFieldLocalServiceUtil.updateTicketField(this);
		}
	}

}