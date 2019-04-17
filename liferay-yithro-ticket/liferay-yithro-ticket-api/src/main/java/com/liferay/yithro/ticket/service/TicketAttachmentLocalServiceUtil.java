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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TicketAttachment. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketAttachmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketAttachmentLocalService
 * @generated
 */
@ProviderType
public class TicketAttachmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketAttachmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
			addTicketAttachment(
				long userId, long ticketEntryId, String fileName,
				java.io.File file, int visibility, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketAttachment(
			userId, ticketEntryId, fileName, file, visibility, status,
			serviceContext);
	}

	/**
	 * Adds the ticket attachment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachment the ticket attachment
	 * @return the ticket attachment that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
		addTicketAttachment(
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment) {

		return getService().addTicketAttachment(ticketAttachment);
	}

	/**
	 * Creates a new ticket attachment with the primary key. Does not add the ticket attachment to the database.
	 *
	 * @param ticketAttachmentId the primary key for the new ticket attachment
	 * @return the new ticket attachment
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
		createTicketAttachment(long ticketAttachmentId) {

		return getService().createTicketAttachment(ticketAttachmentId);
	}

	public static void deleteOrphanTicketAttachments()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteOrphanTicketAttachments();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment that was removed
	 * @throws PortalException if a ticket attachment with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
			deleteTicketAttachment(long ticketAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketAttachment(ticketAttachmentId);
	}

	public static com.liferay.yithro.ticket.model.TicketAttachment
			deleteTicketAttachment(long userId, long ticketAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketAttachment(userId, ticketAttachmentId);
	}

	public static com.liferay.yithro.ticket.model.TicketAttachment
			deleteTicketAttachment(
				long userId,
				com.liferay.yithro.ticket.model.TicketAttachment
					ticketAttachment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketAttachment(userId, ticketAttachment);
	}

	/**
	 * Deletes the ticket attachment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachment the ticket attachment
	 * @return the ticket attachment that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
		deleteTicketAttachment(
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment) {

		return getService().deleteTicketAttachment(ticketAttachment);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.yithro.ticket.model.TicketAttachment
		fetchTicketAttachment(long ticketAttachmentId) {

		return getService().fetchTicketAttachment(ticketAttachmentId);
	}

	public static com.liferay.yithro.ticket.model.TicketAttachment
		fetchTicketAttachment(
			long ticketEntryId, String fileName, int visibility, int status) {

		return getService().fetchTicketAttachment(
			ticketEntryId, fileName, visibility, status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.io.InputStream getFileAsStream(
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFileAsStream(ticketAttachment);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket attachment with the primary key.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment
	 * @throws PortalException if a ticket attachment with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
			getTicketAttachment(long ticketAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketAttachment(ticketAttachmentId);
	}

	/**
	 * Returns a range of all the ticket attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of ticket attachments
	 */
	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketAttachment> getTicketAttachments(
			int start, int end) {

		return getService().getTicketAttachments(start, end);
	}

	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketAttachment> getTicketAttachments(
			long ticketEntryId, int status) {

		return getService().getTicketAttachments(ticketEntryId, status);
	}

	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketAttachment> getTicketAttachments(
			long ticketEntryId, int[] visibilities, int status) {

		return getService().getTicketAttachments(
			ticketEntryId, visibilities, status);
	}

	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketAttachment> getTicketAttachments(
			long userId, long ticketEntryId, int visibility, int status) {

		return getService().getTicketAttachments(
			userId, ticketEntryId, visibility, status);
	}

	/**
	 * Returns the number of ticket attachments.
	 *
	 * @return the number of ticket attachments
	 */
	public static int getTicketAttachmentsCount() {
		return getService().getTicketAttachmentsCount();
	}

	public static java.io.File getTicketAttachmentsZipFile(
			long ticketEntryId, int[] visibilities)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketAttachmentsZipFile(
			ticketEntryId, visibilities);
	}

	public static void updateStatus(
			long userId,
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment,
			long ticketEntryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(
			userId, ticketAttachment, ticketEntryId, status, serviceContext);
	}

	public static com.liferay.yithro.ticket.model.TicketAttachment
			updateTicketAttachment(long ticketAttachmentId, long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketAttachment(
			ticketAttachmentId, ticketEntryId);
	}

	/**
	 * Updates the ticket attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachment the ticket attachment
	 * @return the ticket attachment that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketAttachment
		updateTicketAttachment(
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment) {

		return getService().updateTicketAttachment(ticketAttachment);
	}

	public static TicketAttachmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketAttachmentLocalService, TicketAttachmentLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketAttachmentLocalService.class);

		ServiceTracker
			<TicketAttachmentLocalService, TicketAttachmentLocalService>
				serviceTracker =
					new ServiceTracker
						<TicketAttachmentLocalService,
						 TicketAttachmentLocalService>(
							 bundle.getBundleContext(),
							 TicketAttachmentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}