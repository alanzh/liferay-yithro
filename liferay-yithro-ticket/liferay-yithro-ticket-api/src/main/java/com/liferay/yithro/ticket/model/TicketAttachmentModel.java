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
 * The base model interface for the TicketAttachment service. Represents a row in the &quot;Yithro_TicketAttachment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketAttachment
 * @generated
 */
@ProviderType
public interface TicketAttachmentModel
	extends BaseModel<TicketAttachment>, ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket attachment model instance should use the {@link TicketAttachment} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket attachment.
	 *
	 * @return the primary key of this ticket attachment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket attachment.
	 *
	 * @param primaryKey the primary key of this ticket attachment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket attachment ID of this ticket attachment.
	 *
	 * @return the ticket attachment ID of this ticket attachment
	 */
	public long getTicketAttachmentId();

	/**
	 * Sets the ticket attachment ID of this ticket attachment.
	 *
	 * @param ticketAttachmentId the ticket attachment ID of this ticket attachment
	 */
	public void setTicketAttachmentId(long ticketAttachmentId);

	/**
	 * Returns the company ID of this ticket attachment.
	 *
	 * @return the company ID of this ticket attachment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket attachment.
	 *
	 * @param companyId the company ID of this ticket attachment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ticket attachment.
	 *
	 * @return the user ID of this ticket attachment
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ticket attachment.
	 *
	 * @param userId the user ID of this ticket attachment
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ticket attachment.
	 *
	 * @return the user uuid of this ticket attachment
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ticket attachment.
	 *
	 * @param userUuid the user uuid of this ticket attachment
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ticket attachment.
	 *
	 * @return the user name of this ticket attachment
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this ticket attachment.
	 *
	 * @param userName the user name of this ticket attachment
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ticket attachment.
	 *
	 * @return the create date of this ticket attachment
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket attachment.
	 *
	 * @param createDate the create date of this ticket attachment
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the ticket entry ID of this ticket attachment.
	 *
	 * @return the ticket entry ID of this ticket attachment
	 */
	public long getTicketEntryId();

	/**
	 * Sets the ticket entry ID of this ticket attachment.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket attachment
	 */
	public void setTicketEntryId(long ticketEntryId);

	/**
	 * Returns the ticket field ID of this ticket attachment.
	 *
	 * @return the ticket field ID of this ticket attachment
	 */
	public long getTicketFieldId();

	/**
	 * Sets the ticket field ID of this ticket attachment.
	 *
	 * @param ticketFieldId the ticket field ID of this ticket attachment
	 */
	public void setTicketFieldId(long ticketFieldId);

	/**
	 * Returns the ticket communication ID of this ticket attachment.
	 *
	 * @return the ticket communication ID of this ticket attachment
	 */
	public long getTicketCommunicationId();

	/**
	 * Sets the ticket communication ID of this ticket attachment.
	 *
	 * @param ticketCommunicationId the ticket communication ID of this ticket attachment
	 */
	public void setTicketCommunicationId(long ticketCommunicationId);

	/**
	 * Returns the file name of this ticket attachment.
	 *
	 * @return the file name of this ticket attachment
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this ticket attachment.
	 *
	 * @param fileName the file name of this ticket attachment
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the file size of this ticket attachment.
	 *
	 * @return the file size of this ticket attachment
	 */
	public long getFileSize();

	/**
	 * Sets the file size of this ticket attachment.
	 *
	 * @param fileSize the file size of this ticket attachment
	 */
	public void setFileSize(long fileSize);

	/**
	 * Returns the visibility of this ticket attachment.
	 *
	 * @return the visibility of this ticket attachment
	 */
	public int getVisibility();

	/**
	 * Sets the visibility of this ticket attachment.
	 *
	 * @param visibility the visibility of this ticket attachment
	 */
	public void setVisibility(int visibility);

	/**
	 * Returns the status of this ticket attachment.
	 *
	 * @return the status of this ticket attachment
	 */
	public int getStatus();

	/**
	 * Sets the status of this ticket attachment.
	 *
	 * @param status the status of this ticket attachment
	 */
	public void setStatus(int status);

}