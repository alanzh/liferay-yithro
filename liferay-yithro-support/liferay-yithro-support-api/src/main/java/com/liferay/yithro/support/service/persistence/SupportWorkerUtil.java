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

package com.liferay.yithro.support.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.support.model.SupportWorker;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the support worker service. This utility wraps <code>com.liferay.yithro.support.service.persistence.impl.SupportWorkerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerPersistence
 * @generated
 */
@ProviderType
public class SupportWorkerUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SupportWorker supportWorker) {
		getPersistence().clearCache(supportWorker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SupportWorker> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SupportWorker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupportWorker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupportWorker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SupportWorker update(SupportWorker supportWorker) {
		return getPersistence().update(supportWorker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SupportWorker update(
		SupportWorker supportWorker, ServiceContext serviceContext) {

		return getPersistence().update(supportWorker, serviceContext);
	}

	/**
	 * Returns all the support workers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching support workers
	 */
	public static List<SupportWorker> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the support workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	public static List<SupportWorker> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findByUserId_First(
			long userId, OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchByUserId_First(
		long userId, OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findByUserId_Last(
			long userId, OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchByUserId_Last(
		long userId, OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where userId = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	public static SupportWorker[] findByUserId_PrevAndNext(
			long supportWorkerId, long userId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByUserId_PrevAndNext(
			supportWorkerId, userId, orderByComparator);
	}

	/**
	 * Removes all the support workers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of support workers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching support workers
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the support workers where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @return the matching support workers
	 */
	public static List<SupportWorker> findBySupportTeamId(long supportTeamId) {
		return getPersistence().findBySupportTeamId(supportTeamId);
	}

	/**
	 * Returns a range of all the support workers where supportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportTeamId the support team ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	public static List<SupportWorker> findBySupportTeamId(
		long supportTeamId, int start, int end) {

		return getPersistence().findBySupportTeamId(supportTeamId, start, end);
	}

	/**
	 * Returns an ordered range of all the support workers where supportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportTeamId the support team ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findBySupportTeamId(
		long supportTeamId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findBySupportTeamId(
			supportTeamId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support workers where supportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportTeamId the support team ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findBySupportTeamId(
		long supportTeamId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBySupportTeamId(
			supportTeamId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findBySupportTeamId_First(
			long supportTeamId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findBySupportTeamId_First(
			supportTeamId, orderByComparator);
	}

	/**
	 * Returns the first support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchBySupportTeamId_First(
		long supportTeamId,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchBySupportTeamId_First(
			supportTeamId, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findBySupportTeamId_Last(
			long supportTeamId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findBySupportTeamId_Last(
			supportTeamId, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchBySupportTeamId_Last(
		long supportTeamId,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchBySupportTeamId_Last(
			supportTeamId, orderByComparator);
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	public static SupportWorker[] findBySupportTeamId_PrevAndNext(
			long supportWorkerId, long supportTeamId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findBySupportTeamId_PrevAndNext(
			supportWorkerId, supportTeamId, orderByComparator);
	}

	/**
	 * Removes all the support workers where supportTeamId = &#63; from the database.
	 *
	 * @param supportTeamId the support team ID
	 */
	public static void removeBySupportTeamId(long supportTeamId) {
		getPersistence().removeBySupportTeamId(supportTeamId);
	}

	/**
	 * Returns the number of support workers where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @return the number of matching support workers
	 */
	public static int countBySupportTeamId(long supportTeamId) {
		return getPersistence().countBySupportTeamId(supportTeamId);
	}

	/**
	 * Returns all the support workers where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the matching support workers
	 */
	public static List<SupportWorker> findBySupportLaborId(
		long supportLaborId) {

		return getPersistence().findBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns a range of all the support workers where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	public static List<SupportWorker> findBySupportLaborId(
		long supportLaborId, int start, int end) {

		return getPersistence().findBySupportLaborId(
			supportLaborId, start, end);
	}

	/**
	 * Returns an ordered range of all the support workers where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findBySupportLaborId(
			supportLaborId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support workers where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBySupportLaborId(
			supportLaborId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findBySupportLaborId_First(
			long supportLaborId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findBySupportLaborId_First(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the first support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchBySupportLaborId_First(
		long supportLaborId,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchBySupportLaborId_First(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findBySupportLaborId_Last(
			long supportLaborId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findBySupportLaborId_Last(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchBySupportLaborId_Last(
		long supportLaborId,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchBySupportLaborId_Last(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	public static SupportWorker[] findBySupportLaborId_PrevAndNext(
			long supportWorkerId, long supportLaborId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findBySupportLaborId_PrevAndNext(
			supportWorkerId, supportLaborId, orderByComparator);
	}

	/**
	 * Removes all the support workers where supportLaborId = &#63; from the database.
	 *
	 * @param supportLaborId the support labor ID
	 */
	public static void removeBySupportLaborId(long supportLaborId) {
		getPersistence().removeBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns the number of support workers where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the number of matching support workers
	 */
	public static int countBySupportLaborId(long supportLaborId) {
		return getPersistence().countBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns the support worker where userId = &#63; and supportTeamId = &#63; or throws a <code>NoSuchSupportWorkerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findByU_STI(long userId, long supportTeamId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByU_STI(userId, supportTeamId);
	}

	/**
	 * Returns the support worker where userId = &#63; and supportTeamId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchByU_STI(long userId, long supportTeamId) {
		return getPersistence().fetchByU_STI(userId, supportTeamId);
	}

	/**
	 * Returns the support worker where userId = &#63; and supportTeamId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchByU_STI(
		long userId, long supportTeamId, boolean retrieveFromCache) {

		return getPersistence().fetchByU_STI(
			userId, supportTeamId, retrieveFromCache);
	}

	/**
	 * Removes the support worker where userId = &#63; and supportTeamId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the support worker that was removed
	 */
	public static SupportWorker removeByU_STI(long userId, long supportTeamId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().removeByU_STI(userId, supportTeamId);
	}

	/**
	 * Returns the number of support workers where userId = &#63; and supportTeamId = &#63;.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the number of matching support workers
	 */
	public static int countByU_STI(long userId, long supportTeamId) {
		return getPersistence().countByU_STI(userId, supportTeamId);
	}

	/**
	 * Returns all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @return the matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role) {

		return getPersistence().findByU_MW_R(userId, maxWork, role);
	}

	/**
	 * Returns a range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role, int start, int end) {

		return getPersistence().findByU_MW_R(userId, maxWork, role, start, end);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findByU_MW_R(
			userId, maxWork, role, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByU_MW_R(
			userId, maxWork, role, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findByU_MW_R_First(
			long userId, double maxWork, int role,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByU_MW_R_First(
			userId, maxWork, role, orderByComparator);
	}

	/**
	 * Returns the first support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchByU_MW_R_First(
		long userId, double maxWork, int role,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchByU_MW_R_First(
			userId, maxWork, role, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	public static SupportWorker findByU_MW_R_Last(
			long userId, double maxWork, int role,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByU_MW_R_Last(
			userId, maxWork, role, orderByComparator);
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	public static SupportWorker fetchByU_MW_R_Last(
		long userId, double maxWork, int role,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().fetchByU_MW_R_Last(
			userId, maxWork, role, orderByComparator);
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	public static SupportWorker[] findByU_MW_R_PrevAndNext(
			long supportWorkerId, long userId, double maxWork, int role,
			OrderByComparator<SupportWorker> orderByComparator)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByU_MW_R_PrevAndNext(
			supportWorkerId, userId, maxWork, role, orderByComparator);
	}

	/**
	 * Returns all the support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @return the matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles) {

		return getPersistence().findByU_MW_R(userIds, maxWork, roles);
	}

	/**
	 * Returns a range of all the support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles, int start, int end) {

		return getPersistence().findByU_MW_R(
			userIds, maxWork, roles, start, end);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findByU_MW_R(
			userIds, maxWork, roles, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	public static List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByU_MW_R(
			userIds, maxWork, roles, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Removes all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 */
	public static void removeByU_MW_R(long userId, double maxWork, int role) {
		getPersistence().removeByU_MW_R(userId, maxWork, role);
	}

	/**
	 * Returns the number of support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @return the number of matching support workers
	 */
	public static int countByU_MW_R(long userId, double maxWork, int role) {
		return getPersistence().countByU_MW_R(userId, maxWork, role);
	}

	/**
	 * Returns the number of support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @return the number of matching support workers
	 */
	public static int countByU_MW_R(
		long[] userIds, double maxWork, int[] roles) {

		return getPersistence().countByU_MW_R(userIds, maxWork, roles);
	}

	/**
	 * Caches the support worker in the entity cache if it is enabled.
	 *
	 * @param supportWorker the support worker
	 */
	public static void cacheResult(SupportWorker supportWorker) {
		getPersistence().cacheResult(supportWorker);
	}

	/**
	 * Caches the support workers in the entity cache if it is enabled.
	 *
	 * @param supportWorkers the support workers
	 */
	public static void cacheResult(List<SupportWorker> supportWorkers) {
		getPersistence().cacheResult(supportWorkers);
	}

	/**
	 * Creates a new support worker with the primary key. Does not add the support worker to the database.
	 *
	 * @param supportWorkerId the primary key for the new support worker
	 * @return the new support worker
	 */
	public static SupportWorker create(long supportWorkerId) {
		return getPersistence().create(supportWorkerId);
	}

	/**
	 * Removes the support worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker that was removed
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	public static SupportWorker remove(long supportWorkerId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().remove(supportWorkerId);
	}

	public static SupportWorker updateImpl(SupportWorker supportWorker) {
		return getPersistence().updateImpl(supportWorker);
	}

	/**
	 * Returns the support worker with the primary key or throws a <code>NoSuchSupportWorkerException</code> if it could not be found.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	public static SupportWorker findByPrimaryKey(long supportWorkerId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportWorkerException {

		return getPersistence().findByPrimaryKey(supportWorkerId);
	}

	/**
	 * Returns the support worker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker, or <code>null</code> if a support worker with the primary key could not be found
	 */
	public static SupportWorker fetchByPrimaryKey(long supportWorkerId) {
		return getPersistence().fetchByPrimaryKey(supportWorkerId);
	}

	/**
	 * Returns all the support workers.
	 *
	 * @return the support workers
	 */
	public static List<SupportWorker> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of support workers
	 */
	public static List<SupportWorker> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support workers
	 */
	public static List<SupportWorker> findAll(
		int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of support workers
	 */
	public static List<SupportWorker> findAll(
		int start, int end, OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the support workers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of support workers.
	 *
	 * @return the number of support workers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SupportWorkerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportWorkerPersistence, SupportWorkerPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SupportWorkerPersistence.class);

		ServiceTracker<SupportWorkerPersistence, SupportWorkerPersistence>
			serviceTracker =
				new ServiceTracker
					<SupportWorkerPersistence, SupportWorkerPersistence>(
						bundle.getBundleContext(),
						SupportWorkerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}