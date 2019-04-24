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

package com.liferay.yithro.audit.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AuditEntry. This utility wraps
 * <code>com.liferay.yithro.audit.service.impl.AuditEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryLocalService
 * @generated
 */
@ProviderType
public class AuditEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.audit.service.impl.AuditEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the audit entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEntry the audit entry
	 * @return the audit entry that was added
	 */
	public static com.liferay.yithro.audit.model.AuditEntry addAuditEntry(
		com.liferay.yithro.audit.model.AuditEntry auditEntry) {

		return getService().addAuditEntry(auditEntry);
	}

	public static com.liferay.yithro.audit.model.AuditEntry addAuditEntry(
			long userId, java.util.Date createDate, Class<?> clazz,
			long classPK, long auditSetId, Class<?> fieldClass,
			long fieldClassPK, int action, String field, int visibility,
			String oldLabel, Object oldValue, String newLabel, Object newValue,
			String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAuditEntry(
			userId, createDate, clazz, classPK, auditSetId, fieldClass,
			fieldClassPK, action, field, visibility, oldLabel, oldValue,
			newLabel, newValue, description);
	}

	public static com.liferay.yithro.audit.model.AuditEntry addAuditEntry(
			long userId, java.util.Date createDate, long classNameId,
			long classPK, long auditSetId, long fieldClassNameId,
			long fieldClassPK, int action, String field, int visibility,
			String oldLabel, Object oldValue, String newLabel, Object newValue,
			String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAuditEntry(
			userId, createDate, classNameId, classPK, auditSetId,
			fieldClassNameId, fieldClassPK, action, field, visibility, oldLabel,
			oldValue, newLabel, newValue, description);
	}

	/**
	 * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
	 *
	 * @param auditEntryId the primary key for the new audit entry
	 * @return the new audit entry
	 */
	public static com.liferay.yithro.audit.model.AuditEntry createAuditEntry(
		long auditEntryId) {

		return getService().createAuditEntry(auditEntryId);
	}

	/**
	 * Deletes the audit entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEntry the audit entry
	 * @return the audit entry that was removed
	 */
	public static com.liferay.yithro.audit.model.AuditEntry deleteAuditEntry(
		com.liferay.yithro.audit.model.AuditEntry auditEntry) {

		return getService().deleteAuditEntry(auditEntry);
	}

	/**
	 * Deletes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry that was removed
	 * @throws PortalException if a audit entry with the primary key could not be found
	 */
	public static com.liferay.yithro.audit.model.AuditEntry deleteAuditEntry(
			long auditEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAuditEntry(auditEntryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.audit.model.impl.AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.audit.model.impl.AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.audit.model.AuditEntry fetchAuditEntry(
		long auditEntryId) {

		return getService().fetchAuditEntry(auditEntryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.yithro.audit.model.AuditEntry>
		getAuditEntries(java.util.Date createDate, long classNameId) {

		return getService().getAuditEntries(createDate, classNameId);
	}

	/**
	 * Returns a range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.audit.model.impl.AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of audit entries
	 */
	public static java.util.List<com.liferay.yithro.audit.model.AuditEntry>
		getAuditEntries(int start, int end) {

		return getService().getAuditEntries(start, end);
	}

	public static java.util.List<com.liferay.yithro.audit.model.AuditEntry>
		getAuditEntries(long classNameId, long classPK, int[] visibilities) {

		return getService().getAuditEntries(classNameId, classPK, visibilities);
	}

	/**
	 * Returns the number of audit entries.
	 *
	 * @return the number of audit entries
	 */
	public static int getAuditEntriesCount() {
		return getService().getAuditEntriesCount();
	}

	/**
	 * Returns the audit entry with the primary key.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry
	 * @throws PortalException if a audit entry with the primary key could not be found
	 */
	public static com.liferay.yithro.audit.model.AuditEntry getAuditEntry(
			long auditEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAuditEntry(auditEntryId);
	}

	public static java.util.List
		<java.util.List<com.liferay.yithro.audit.model.AuditEntry>>
			getAuditEntrySets(
				long classNameId, long classPK, int[] visibilities) {

		return getService().getAuditEntrySets(
			classNameId, classPK, visibilities);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.yithro.audit.model.AuditEntry getLastAuditEntry(
		long fieldClassNameId, long fieldClassPK, String field) {

		return getService().getLastAuditEntry(
			fieldClassNameId, fieldClassPK, field);
	}

	public static com.liferay.yithro.audit.model.AuditEntry getLastAuditEntry(
		long classNameId, long classPK, String field, int action) {

		return getService().getLastAuditEntry(
			classNameId, classPK, field, action);
	}

	public static long getNextAuditSetId(long classNameId, long classPK) {
		return getService().getNextAuditSetId(classNameId, classPK);
	}

	public static long getNextAuditSetId(String className, long classPK) {
		return getService().getNextAuditSetId(className, classPK);
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
	 * Updates the audit entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param auditEntry the audit entry
	 * @return the audit entry that was updated
	 */
	public static com.liferay.yithro.audit.model.AuditEntry updateAuditEntry(
		com.liferay.yithro.audit.model.AuditEntry auditEntry) {

		return getService().updateAuditEntry(auditEntry);
	}

	public static AuditEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuditEntryLocalService, AuditEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuditEntryLocalService.class);

		ServiceTracker<AuditEntryLocalService, AuditEntryLocalService>
			serviceTracker =
				new ServiceTracker
					<AuditEntryLocalService, AuditEntryLocalService>(
						bundle.getBundleContext(), AuditEntryLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}