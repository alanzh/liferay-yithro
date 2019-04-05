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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

/**
 * The base model interface for the TicketLink service. Represents a row in the &quot;Yithro_TicketLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketLinkModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketLinkImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketLink
 * @generated
 */
@ProviderType
public interface TicketLinkModel extends BaseModel<TicketLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket link model instance should use the {@link TicketLink} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket link.
	 *
	 * @return the primary key of this ticket link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket link.
	 *
	 * @param primaryKey the primary key of this ticket link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket link ID of this ticket link.
	 *
	 * @return the ticket link ID of this ticket link
	 */
	public long getTicketLinkId();

	/**
	 * Sets the ticket link ID of this ticket link.
	 *
	 * @param ticketLinkId the ticket link ID of this ticket link
	 */
	public void setTicketLinkId(long ticketLinkId);

	/**
	 * Returns the user ID of this ticket link.
	 *
	 * @return the user ID of this ticket link
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ticket link.
	 *
	 * @param userId the user ID of this ticket link
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ticket link.
	 *
	 * @return the user uuid of this ticket link
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ticket link.
	 *
	 * @param userUuid the user uuid of this ticket link
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ticket link.
	 *
	 * @return the user name of this ticket link
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this ticket link.
	 *
	 * @param userName the user name of this ticket link
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ticket link.
	 *
	 * @return the create date of this ticket link
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket link.
	 *
	 * @param createDate the create date of this ticket link
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the ticket entry ID of this ticket link.
	 *
	 * @return the ticket entry ID of this ticket link
	 */
	public long getTicketEntryId();

	/**
	 * Sets the ticket entry ID of this ticket link.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket link
	 */
	public void setTicketEntryId(long ticketEntryId);

	/**
	 * Returns the ticket solution ID of this ticket link.
	 *
	 * @return the ticket solution ID of this ticket link
	 */
	public long getTicketSolutionId();

	/**
	 * Sets the ticket solution ID of this ticket link.
	 *
	 * @param ticketSolutionId the ticket solution ID of this ticket link
	 */
	public void setTicketSolutionId(long ticketSolutionId);

	/**
	 * Returns the url of this ticket link.
	 *
	 * @return the url of this ticket link
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this ticket link.
	 *
	 * @param url the url of this ticket link
	 */
	public void setUrl(String url);

	/**
	 * Returns the type of this ticket link.
	 *
	 * @return the type of this ticket link
	 */
	public int getType();

	/**
	 * Sets the type of this ticket link.
	 *
	 * @param type the type of this ticket link
	 */
	public void setType(int type);

	/**
	 * Returns the visibility of this ticket link.
	 *
	 * @return the visibility of this ticket link
	 */
	public int getVisibility();

	/**
	 * Sets the visibility of this ticket link.
	 *
	 * @param visibility the visibility of this ticket link
	 */
	public void setVisibility(int visibility);

}