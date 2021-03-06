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

package com.liferay.yithro.ticket.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TicketWorker service. Represents a row in the &quot;Yithro_TicketWorker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketWorkerImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorker
 * @generated
 */
@ProviderType
public interface TicketWorkerModel
	extends BaseModel<TicketWorker>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket worker model instance should use the {@link TicketWorker} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket worker.
	 *
	 * @return the primary key of this ticket worker
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket worker.
	 *
	 * @param primaryKey the primary key of this ticket worker
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket worker ID of this ticket worker.
	 *
	 * @return the ticket worker ID of this ticket worker
	 */
	public long getTicketWorkerId();

	/**
	 * Sets the ticket worker ID of this ticket worker.
	 *
	 * @param ticketWorkerId the ticket worker ID of this ticket worker
	 */
	public void setTicketWorkerId(long ticketWorkerId);

	/**
	 * Returns the company ID of this ticket worker.
	 *
	 * @return the company ID of this ticket worker
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket worker.
	 *
	 * @param companyId the company ID of this ticket worker
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ticket worker.
	 *
	 * @return the user ID of this ticket worker
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ticket worker.
	 *
	 * @param userId the user ID of this ticket worker
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ticket worker.
	 *
	 * @return the user uuid of this ticket worker
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ticket worker.
	 *
	 * @param userUuid the user uuid of this ticket worker
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ticket worker.
	 *
	 * @return the user name of this ticket worker
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this ticket worker.
	 *
	 * @param userName the user name of this ticket worker
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ticket worker.
	 *
	 * @return the create date of this ticket worker
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket worker.
	 *
	 * @param createDate the create date of this ticket worker
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the ticket entry ID of this ticket worker.
	 *
	 * @return the ticket entry ID of this ticket worker
	 */
	public long getTicketEntryId();

	/**
	 * Sets the ticket entry ID of this ticket worker.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket worker
	 */
	public void setTicketEntryId(long ticketEntryId);

	/**
	 * Returns the source class name ID of this ticket worker.
	 *
	 * @return the source class name ID of this ticket worker
	 */
	public long getSourceClassNameId();

	/**
	 * Sets the source class name ID of this ticket worker.
	 *
	 * @param sourceClassNameId the source class name ID of this ticket worker
	 */
	public void setSourceClassNameId(long sourceClassNameId);

	/**
	 * Returns the source class pk of this ticket worker.
	 *
	 * @return the source class pk of this ticket worker
	 */
	public long getSourceClassPK();

	/**
	 * Sets the source class pk of this ticket worker.
	 *
	 * @param sourceClassPK the source class pk of this ticket worker
	 */
	public void setSourceClassPK(long sourceClassPK);

	/**
	 * Returns the role of this ticket worker.
	 *
	 * @return the role of this ticket worker
	 */
	public int getRole();

	/**
	 * Sets the role of this ticket worker.
	 *
	 * @param role the role of this ticket worker
	 */
	public void setRole(int role);

	/**
	 * Returns the primary of this ticket worker.
	 *
	 * @return the primary of this ticket worker
	 */
	public boolean getPrimary();

	/**
	 * Returns <code>true</code> if this ticket worker is primary.
	 *
	 * @return <code>true</code> if this ticket worker is primary; <code>false</code> otherwise
	 */
	public boolean isPrimary();

	/**
	 * Sets whether this ticket worker is primary.
	 *
	 * @param primary the primary of this ticket worker
	 */
	public void setPrimary(boolean primary);

}