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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketComment;
import com.liferay.yithro.ticket.model.TicketEntry;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TicketEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TicketEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketEntryLocalServiceUtil} to access the ticket entry local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketEntry addTicketEntry(
			long userId, long groupId, long ticketStructureId,
			long ticketStatusId, String languageId, String summary,
			String description, int weight, Map<Long, String> ticketFieldsMap,
			List<TicketAttachment> ticketAttachments)
		throws PortalException;

	/**
	 * Adds the ticket entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketEntry addTicketEntry(TicketEntry ticketEntry);

	/**
	 * Creates a new ticket entry with the primary key. Does not add the ticket entry to the database.
	 *
	 * @param ticketEntryId the primary key for the new ticket entry
	 * @return the new ticket entry
	 */
	@Transactional(enabled = false)
	public TicketEntry createTicketEntry(long ticketEntryId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws PortalException if a ticket entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TicketEntry deleteTicketEntry(long ticketEntryId)
		throws PortalException;

	/**
	 * Deletes the ticket entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	public TicketEntry deleteTicketEntry(TicketEntry ticketEntry)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketEntry fetchTicketEntry(long ticketEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketEntry> getTicketEntries(
		Date modifiedDate, int start, int end);

	/**
	 * Returns a range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of ticket entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketEntry> getTicketEntries(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketEntry> getTicketEntries(
		long userId, long[] ticketStatusIds, int start, int end);

	/**
	 * Returns the number of ticket entries.
	 *
	 * @return the number of ticket entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTicketEntriesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTicketEntriesCount(Date modifiedDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTicketEntriesCount(long userId, long[] ticketStatusIds);

	/**
	 * Returns the ticket entry with the primary key.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws PortalException if a ticket entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketEntry getTicketEntry(long ticketEntryId)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketEntry reindexTicketEntry(long ticketEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(
		long companyId, String keywords, int start, int end, Sort sort);

	public void sendEmail(
			long userId, TicketEntry ticketEntry, TicketComment ticketComment,
			String action)
		throws PortalException;

	public void updatePendingTypes(
			long userId, long ticketEntryId, int[] pendingTypes)
		throws PortalException;

	public TicketEntry updateTicketEntry(
			long ticketEntryId, long reportedByUserId, long ticketStatusId,
			String languageId, String summary, String description, int weight,
			Date dueDate)
		throws PortalException;

	/**
	 * Updates the ticket entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketEntry updateTicketEntry(TicketEntry ticketEntry);

	public TicketEntry updateTicketStatus(
			long ticketEntryId, long ticketStatusId)
		throws PortalException;

}