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

package com.liferay.yithro.rules.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ActionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActionLocalService
 * @generated
 */
@ProviderType
public class ActionLocalServiceWrapper
	implements ActionLocalService, ServiceWrapper<ActionLocalService> {

	public ActionLocalServiceWrapper(ActionLocalService actionLocalService) {
		_actionLocalService = actionLocalService;
	}

	/**
	 * Adds the action to the database. Also notifies the appropriate model listeners.
	 *
	 * @param action the action
	 * @return the action that was added
	 */
	@Override
	public com.liferay.yithro.rules.model.Action addAction(
		com.liferay.yithro.rules.model.Action action) {

		return _actionLocalService.addAction(action);
	}

	@Override
	public com.liferay.yithro.rules.model.Action addAction(
			String name, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionLocalService.addAction(name, value);
	}

	/**
	 * Creates a new action with the primary key. Does not add the action to the database.
	 *
	 * @param actionId the primary key for the new action
	 * @return the new action
	 */
	@Override
	public com.liferay.yithro.rules.model.Action createAction(long actionId) {
		return _actionLocalService.createAction(actionId);
	}

	/**
	 * Deletes the action from the database. Also notifies the appropriate model listeners.
	 *
	 * @param action the action
	 * @return the action that was removed
	 */
	@Override
	public com.liferay.yithro.rules.model.Action deleteAction(
		com.liferay.yithro.rules.model.Action action) {

		return _actionLocalService.deleteAction(action);
	}

	/**
	 * Deletes the action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the action
	 * @return the action that was removed
	 * @throws PortalException if a action with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.Action deleteAction(long actionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionLocalService.deleteAction(actionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _actionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _actionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _actionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actionLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _actionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.rules.model.Action fetchAction(long actionId) {
		return _actionLocalService.fetchAction(actionId);
	}

	/**
	 * Returns the action with the primary key.
	 *
	 * @param actionId the primary key of the action
	 * @return the action
	 * @throws PortalException if a action with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.Action getAction(long actionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionLocalService.getAction(actionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _actionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @return the range of actions
	 */
	@Override
	public java.util.List<com.liferay.yithro.rules.model.Action> getActions(
		int start, int end) {

		return _actionLocalService.getActions(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.rules.model.Action> getActions(
		long ruleId) {

		return _actionLocalService.getActions(ruleId);
	}

	/**
	 * Returns the number of actions.
	 *
	 * @return the number of actions
	 */
	@Override
	public int getActionsCount() {
		return _actionLocalService.getActionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _actionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _actionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param action the action
	 * @return the action that was updated
	 */
	@Override
	public com.liferay.yithro.rules.model.Action updateAction(
		com.liferay.yithro.rules.model.Action action) {

		return _actionLocalService.updateAction(action);
	}

	@Override
	public ActionLocalService getWrappedService() {
		return _actionLocalService;
	}

	@Override
	public void setWrappedService(ActionLocalService actionLocalService) {
		_actionLocalService = actionLocalService;
	}

	private ActionLocalService _actionLocalService;

}