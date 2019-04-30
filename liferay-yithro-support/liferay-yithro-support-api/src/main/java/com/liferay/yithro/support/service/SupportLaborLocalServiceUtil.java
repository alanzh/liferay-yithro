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

package com.liferay.yithro.support.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SupportLabor. This utility wraps
 * <code>com.liferay.yithro.support.service.impl.SupportLaborLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupportLaborLocalService
 * @generated
 */
@ProviderType
public class SupportLaborLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportLaborLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.support.model.SupportLabor addSupportLabor(
			String name, String description, String timeZoneId, int sunOpen,
			int sunClose, int monOpen, int monClose, int tueOpen, int tueClose,
			int wedOpen, int wedClose, int thuOpen, int thuClose, int friOpen,
			int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSupportLabor(
			name, description, timeZoneId, sunOpen, sunClose, monOpen, monClose,
			tueOpen, tueClose, wedOpen, wedClose, thuOpen, thuClose, friOpen,
			friClose, satOpen, satClose);
	}

	/**
	 * Adds the support labor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLabor the support labor
	 * @return the support labor that was added
	 */
	public static com.liferay.yithro.support.model.SupportLabor addSupportLabor(
		com.liferay.yithro.support.model.SupportLabor supportLabor) {

		return getService().addSupportLabor(supportLabor);
	}

	public static void addSupportWorkers(
			long[] supportWorkerIds, long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addSupportWorkers(supportWorkerIds, supportLaborId);
	}

	/**
	 * Creates a new support labor with the primary key. Does not add the support labor to the database.
	 *
	 * @param supportLaborId the primary key for the new support labor
	 * @return the new support labor
	 */
	public static com.liferay.yithro.support.model.SupportLabor
		createSupportLabor(long supportLaborId) {

		return getService().createSupportLabor(supportLaborId);
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
	 * Deletes the support labor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor that was removed
	 * @throws PortalException if a support labor with the primary key could not be found
	 */
	public static com.liferay.yithro.support.model.SupportLabor
			deleteSupportLabor(long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSupportLabor(supportLaborId);
	}

	/**
	 * Deletes the support labor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLabor the support labor
	 * @return the support labor that was removed
	 */
	public static com.liferay.yithro.support.model.SupportLabor
		deleteSupportLabor(
			com.liferay.yithro.support.model.SupportLabor supportLabor) {

		return getService().deleteSupportLabor(supportLabor);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLaborModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLaborModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.support.model.SupportLabor
		fetchSupportLabor(long supportLaborId) {

		return getService().fetchSupportLabor(supportLaborId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the support labor with the primary key.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor
	 * @throws PortalException if a support labor with the primary key could not be found
	 */
	public static com.liferay.yithro.support.model.SupportLabor getSupportLabor(
			long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSupportLabor(supportLaborId);
	}

	/**
	 * Returns a range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLaborModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @return the range of support labors
	 */
	public static java.util.List<com.liferay.yithro.support.model.SupportLabor>
		getSupportLabors(int start, int end) {

		return getService().getSupportLabors(start, end);
	}

	/**
	 * Returns the number of support labors.
	 *
	 * @return the number of support labors
	 */
	public static int getSupportLaborsCount() {
		return getService().getSupportLaborsCount();
	}

	public static boolean hasSupportWorker(
			long supportWorkerId, long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().hasSupportWorker(supportWorkerId, supportLaborId);
	}

	public static void removeSupportWorkers(long[] supportWorkerIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().removeSupportWorkers(supportWorkerIds);
	}

	public static com.liferay.yithro.support.model.SupportLabor
			updateSupportLabor(
				long supportLaborId, String name, String description,
				String timeZoneId, int sunOpen, int sunClose, int monOpen,
				int monClose, int tueOpen, int tueClose, int wedOpen,
				int wedClose, int thuOpen, int thuClose, int friOpen,
				int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSupportLabor(
			supportLaborId, name, description, timeZoneId, sunOpen, sunClose,
			monOpen, monClose, tueOpen, tueClose, wedOpen, wedClose, thuOpen,
			thuClose, friOpen, friClose, satOpen, satClose);
	}

	/**
	 * Updates the support labor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportLabor the support labor
	 * @return the support labor that was updated
	 */
	public static com.liferay.yithro.support.model.SupportLabor
		updateSupportLabor(
			com.liferay.yithro.support.model.SupportLabor supportLabor) {

		return getService().updateSupportLabor(supportLabor);
	}

	public static SupportLaborLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportLaborLocalService, SupportLaborLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SupportLaborLocalService.class);

		ServiceTracker<SupportLaborLocalService, SupportLaborLocalService>
			serviceTracker =
				new ServiceTracker
					<SupportLaborLocalService, SupportLaborLocalService>(
						bundle.getBundleContext(),
						SupportLaborLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}