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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.support.model.SupportLabor;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SupportLabor. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupportLaborLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SupportLaborLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportLaborLocalServiceUtil} to access the support labor local service. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportLaborLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public SupportLabor addSupportLabor(
			long userId, String name, String description, String timeZoneId,
			int sunOpen, int sunClose, int monOpen, int monClose, int tueOpen,
			int tueClose, int wedOpen, int wedClose, int thuOpen, int thuClose,
			int friOpen, int friClose, int satOpen, int satClose)
		throws PortalException;

	/**
	 * Adds the support labor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLabor the support labor
	 * @return the support labor that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SupportLabor addSupportLabor(SupportLabor supportLabor);

	public void addSupportWorkers(long[] supportWorkerIds, long supportLaborId)
		throws PortalException;

	/**
	 * Creates a new support labor with the primary key. Does not add the support labor to the database.
	 *
	 * @param supportLaborId the primary key for the new support labor
	 * @return the new support labor
	 */
	@Transactional(enabled = false)
	public SupportLabor createSupportLabor(long supportLaborId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the support labor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor that was removed
	 * @throws PortalException if a support labor with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SupportLabor deleteSupportLabor(long supportLaborId)
		throws PortalException;

	/**
	 * Deletes the support labor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLabor the support labor
	 * @return the support labor that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SupportLabor deleteSupportLabor(SupportLabor supportLabor);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLaborModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLaborModelImpl</code>.
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
	public SupportLabor fetchSupportLabor(long supportLaborId);

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

	/**
	 * Returns the support labor with the primary key.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor
	 * @throws PortalException if a support labor with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportLabor getSupportLabor(long supportLaborId)
		throws PortalException;

	/**
	 * Returns a range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLaborModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @return the range of support labors
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SupportLabor> getSupportLabors(int start, int end);

	/**
	 * Returns the number of support labors.
	 *
	 * @return the number of support labors
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSupportLaborsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasSupportWorker(long supportWorkerId, long supportLaborId)
		throws PortalException;

	public void removeSupportWorkers(long[] supportWorkerIds)
		throws PortalException;

	public SupportLabor updateSupportLabor(
			long supportLaborId, String name, String description,
			String timeZoneId, int sunOpen, int sunClose, int monOpen,
			int monClose, int tueOpen, int tueClose, int wedOpen, int wedClose,
			int thuOpen, int thuClose, int friOpen, int friClose, int satOpen,
			int satClose)
		throws PortalException;

	/**
	 * Updates the support labor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportLabor the support labor
	 * @return the support labor that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SupportLabor updateSupportLabor(SupportLabor supportLabor);

}