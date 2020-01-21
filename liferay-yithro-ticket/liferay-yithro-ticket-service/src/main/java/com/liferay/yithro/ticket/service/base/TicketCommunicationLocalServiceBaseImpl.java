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

package com.liferay.yithro.ticket.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.yithro.ticket.model.TicketCommunication;
import com.liferay.yithro.ticket.service.TicketCommunicationLocalService;
import com.liferay.yithro.ticket.service.persistence.TicketAttachmentPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketCommentPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketCommentTemplatePersistence;
import com.liferay.yithro.ticket.service.persistence.TicketCommunicationPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketEntryPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFieldDataPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFieldOptionPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFieldPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFlagPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketLinkPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketStatusPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketStructurePersistence;
import com.liferay.yithro.ticket.service.persistence.TicketWorkerPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the ticket communication local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.yithro.ticket.service.impl.TicketCommunicationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.yithro.ticket.service.impl.TicketCommunicationLocalServiceImpl
 * @generated
 */
public abstract class TicketCommunicationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   TicketCommunicationLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TicketCommunicationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.yithro.ticket.service.TicketCommunicationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ticket communication to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TicketCommunication addTicketCommunication(
		TicketCommunication ticketCommunication) {

		ticketCommunication.setNew(true);

		return ticketCommunicationPersistence.update(ticketCommunication);
	}

	/**
	 * Creates a new ticket communication with the primary key. Does not add the ticket communication to the database.
	 *
	 * @param ticketCommunicationId the primary key for the new ticket communication
	 * @return the new ticket communication
	 */
	@Override
	@Transactional(enabled = false)
	public TicketCommunication createTicketCommunication(
		long ticketCommunicationId) {

		return ticketCommunicationPersistence.create(ticketCommunicationId);
	}

	/**
	 * Deletes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws PortalException if a ticket communication with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TicketCommunication deleteTicketCommunication(
			long ticketCommunicationId)
		throws PortalException {

		return ticketCommunicationPersistence.remove(ticketCommunicationId);
	}

	/**
	 * Deletes the ticket communication from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TicketCommunication deleteTicketCommunication(
		TicketCommunication ticketCommunication) {

		return ticketCommunicationPersistence.remove(ticketCommunication);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			TicketCommunication.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ticketCommunicationPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return ticketCommunicationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return ticketCommunicationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ticketCommunicationPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return ticketCommunicationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TicketCommunication fetchTicketCommunication(
		long ticketCommunicationId) {

		return ticketCommunicationPersistence.fetchByPrimaryKey(
			ticketCommunicationId);
	}

	/**
	 * Returns the ticket communication with the primary key.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws PortalException if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication getTicketCommunication(
			long ticketCommunicationId)
		throws PortalException {

		return ticketCommunicationPersistence.findByPrimaryKey(
			ticketCommunicationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			ticketCommunicationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TicketCommunication.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"ticketCommunicationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ticketCommunicationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			TicketCommunication.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"ticketCommunicationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			ticketCommunicationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TicketCommunication.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"ticketCommunicationId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ticketCommunicationLocalService.deleteTicketCommunication(
			(TicketCommunication)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ticketCommunicationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of ticket communications
	 */
	@Override
	public List<TicketCommunication> getTicketCommunications(
		int start, int end) {

		return ticketCommunicationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ticket communications.
	 *
	 * @return the number of ticket communications
	 */
	@Override
	public int getTicketCommunicationsCount() {
		return ticketCommunicationPersistence.countAll();
	}

	/**
	 * Updates the ticket communication in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TicketCommunication updateTicketCommunication(
		TicketCommunication ticketCommunication) {

		return ticketCommunicationPersistence.update(ticketCommunication);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TicketCommunicationLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ticketCommunicationLocalService =
			(TicketCommunicationLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TicketCommunicationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TicketCommunication.class;
	}

	protected String getModelClassName() {
		return TicketCommunication.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				ticketCommunicationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected TicketAttachmentPersistence ticketAttachmentPersistence;

	@Reference
	protected TicketCommentPersistence ticketCommentPersistence;

	@Reference
	protected TicketCommentTemplatePersistence ticketCommentTemplatePersistence;

	protected TicketCommunicationLocalService ticketCommunicationLocalService;

	@Reference
	protected TicketCommunicationPersistence ticketCommunicationPersistence;

	@Reference
	protected TicketEntryPersistence ticketEntryPersistence;

	@Reference
	protected TicketFieldPersistence ticketFieldPersistence;

	@Reference
	protected TicketFieldDataPersistence ticketFieldDataPersistence;

	@Reference
	protected TicketFieldOptionPersistence ticketFieldOptionPersistence;

	@Reference
	protected TicketFlagPersistence ticketFlagPersistence;

	@Reference
	protected TicketLinkPersistence ticketLinkPersistence;

	@Reference
	protected TicketStatusPersistence ticketStatusPersistence;

	@Reference
	protected TicketStructurePersistence ticketStructurePersistence;

	@Reference
	protected TicketWorkerPersistence ticketWorkerPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}