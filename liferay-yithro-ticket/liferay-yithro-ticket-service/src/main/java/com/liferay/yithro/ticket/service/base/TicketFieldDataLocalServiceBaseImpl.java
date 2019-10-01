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
import com.liferay.yithro.ticket.model.TicketFieldData;
import com.liferay.yithro.ticket.service.TicketFieldDataLocalService;
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
 * Provides the base implementation for the ticket field data local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.yithro.ticket.service.impl.TicketFieldDataLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.yithro.ticket.service.impl.TicketFieldDataLocalServiceImpl
 * @generated
 */
public abstract class TicketFieldDataLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements TicketFieldDataLocalService, AopService,
			   IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TicketFieldDataLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.yithro.ticket.service.TicketFieldDataLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ticket field data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldData the ticket field data
	 * @return the ticket field data that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TicketFieldData addTicketFieldData(TicketFieldData ticketFieldData) {
		ticketFieldData.setNew(true);

		return ticketFieldDataPersistence.update(ticketFieldData);
	}

	/**
	 * Creates a new ticket field data with the primary key. Does not add the ticket field data to the database.
	 *
	 * @param ticketFieldDataId the primary key for the new ticket field data
	 * @return the new ticket field data
	 */
	@Override
	@Transactional(enabled = false)
	public TicketFieldData createTicketFieldData(long ticketFieldDataId) {
		return ticketFieldDataPersistence.create(ticketFieldDataId);
	}

	/**
	 * Deletes the ticket field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data that was removed
	 * @throws PortalException if a ticket field data with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TicketFieldData deleteTicketFieldData(long ticketFieldDataId)
		throws PortalException {

		return ticketFieldDataPersistence.remove(ticketFieldDataId);
	}

	/**
	 * Deletes the ticket field data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldData the ticket field data
	 * @return the ticket field data that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TicketFieldData deleteTicketFieldData(
		TicketFieldData ticketFieldData) {

		return ticketFieldDataPersistence.remove(ticketFieldData);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			TicketFieldData.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ticketFieldDataPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return ticketFieldDataPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return ticketFieldDataPersistence.findWithDynamicQuery(
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
		return ticketFieldDataPersistence.countWithDynamicQuery(dynamicQuery);
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

		return ticketFieldDataPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TicketFieldData fetchTicketFieldData(long ticketFieldDataId) {
		return ticketFieldDataPersistence.fetchByPrimaryKey(ticketFieldDataId);
	}

	/**
	 * Returns the ticket field data with the primary key.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data
	 * @throws PortalException if a ticket field data with the primary key could not be found
	 */
	@Override
	public TicketFieldData getTicketFieldData(long ticketFieldDataId)
		throws PortalException {

		return ticketFieldDataPersistence.findByPrimaryKey(ticketFieldDataId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ticketFieldDataLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TicketFieldData.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ticketFieldDataId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ticketFieldDataLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TicketFieldData.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"ticketFieldDataId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ticketFieldDataLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TicketFieldData.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ticketFieldDataId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ticketFieldDataLocalService.deleteTicketFieldData(
			(TicketFieldData)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ticketFieldDataPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @return the range of ticket field datas
	 */
	@Override
	public List<TicketFieldData> getTicketFieldDatas(int start, int end) {
		return ticketFieldDataPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ticket field datas.
	 *
	 * @return the number of ticket field datas
	 */
	@Override
	public int getTicketFieldDatasCount() {
		return ticketFieldDataPersistence.countAll();
	}

	/**
	 * Updates the ticket field data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldData the ticket field data
	 * @return the ticket field data that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TicketFieldData updateTicketFieldData(
		TicketFieldData ticketFieldData) {

		return ticketFieldDataPersistence.update(ticketFieldData);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TicketFieldDataLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ticketFieldDataLocalService = (TicketFieldDataLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TicketFieldDataLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TicketFieldData.class;
	}

	protected String getModelClassName() {
		return TicketFieldData.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ticketFieldDataPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected TicketAttachmentPersistence ticketAttachmentPersistence;

	@Reference
	protected TicketCommentPersistence ticketCommentPersistence;

	@Reference
	protected TicketCommentTemplatePersistence ticketCommentTemplatePersistence;

	@Reference
	protected TicketCommunicationPersistence ticketCommunicationPersistence;

	@Reference
	protected TicketEntryPersistence ticketEntryPersistence;

	@Reference
	protected TicketFieldPersistence ticketFieldPersistence;

	protected TicketFieldDataLocalService ticketFieldDataLocalService;

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