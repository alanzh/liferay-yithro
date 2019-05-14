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
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TicketComment service. Represents a row in the &quot;Yithro_TicketComment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketCommentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketCommentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketComment
 * @generated
 */
@ProviderType
public interface TicketCommentModel
	extends AuditedModel, BaseModel<TicketComment>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket comment model instance should use the {@link TicketComment} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket comment.
	 *
	 * @return the primary key of this ticket comment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket comment.
	 *
	 * @param primaryKey the primary key of this ticket comment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket comment ID of this ticket comment.
	 *
	 * @return the ticket comment ID of this ticket comment
	 */
	public long getTicketCommentId();

	/**
	 * Sets the ticket comment ID of this ticket comment.
	 *
	 * @param ticketCommentId the ticket comment ID of this ticket comment
	 */
	public void setTicketCommentId(long ticketCommentId);

	/**
	 * Returns the company ID of this ticket comment.
	 *
	 * @return the company ID of this ticket comment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket comment.
	 *
	 * @param companyId the company ID of this ticket comment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ticket comment.
	 *
	 * @return the user ID of this ticket comment
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ticket comment.
	 *
	 * @param userId the user ID of this ticket comment
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ticket comment.
	 *
	 * @return the user uuid of this ticket comment
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ticket comment.
	 *
	 * @param userUuid the user uuid of this ticket comment
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ticket comment.
	 *
	 * @return the user name of this ticket comment
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ticket comment.
	 *
	 * @param userName the user name of this ticket comment
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ticket comment.
	 *
	 * @return the create date of this ticket comment
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket comment.
	 *
	 * @param createDate the create date of this ticket comment
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ticket comment.
	 *
	 * @return the modified date of this ticket comment
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ticket comment.
	 *
	 * @param modifiedDate the modified date of this ticket comment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ticket entry ID of this ticket comment.
	 *
	 * @return the ticket entry ID of this ticket comment
	 */
	public long getTicketEntryId();

	/**
	 * Sets the ticket entry ID of this ticket comment.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket comment
	 */
	public void setTicketEntryId(long ticketEntryId);

	/**
	 * Returns the body of this ticket comment.
	 *
	 * @return the body of this ticket comment
	 */
	@AutoEscape
	public String getBody();

	/**
	 * Sets the body of this ticket comment.
	 *
	 * @param body the body of this ticket comment
	 */
	public void setBody(String body);

	/**
	 * Returns the type of this ticket comment.
	 *
	 * @return the type of this ticket comment
	 */
	public int getType();

	/**
	 * Sets the type of this ticket comment.
	 *
	 * @param type the type of this ticket comment
	 */
	public void setType(int type);

	/**
	 * Returns the format of this ticket comment.
	 *
	 * @return the format of this ticket comment
	 */
	@AutoEscape
	public String getFormat();

	/**
	 * Sets the format of this ticket comment.
	 *
	 * @param format the format of this ticket comment
	 */
	public void setFormat(String format);

	/**
	 * Returns the visibility of this ticket comment.
	 *
	 * @return the visibility of this ticket comment
	 */
	public int getVisibility();

	/**
	 * Sets the visibility of this ticket comment.
	 *
	 * @param visibility the visibility of this ticket comment
	 */
	public void setVisibility(int visibility);

	/**
	 * Returns the settings of this ticket comment.
	 *
	 * @return the settings of this ticket comment
	 */
	@AutoEscape
	public String getSettings();

	/**
	 * Sets the settings of this ticket comment.
	 *
	 * @param settings the settings of this ticket comment
	 */
	public void setSettings(String settings);

	/**
	 * Returns the status of this ticket comment.
	 *
	 * @return the status of this ticket comment
	 */
	public int getStatus();

	/**
	 * Sets the status of this ticket comment.
	 *
	 * @param status the status of this ticket comment
	 */
	public void setStatus(int status);

}