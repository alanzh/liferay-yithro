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

package com.liferay.yithro.support.model;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SupportWorker service. Represents a row in the &quot;Yithro_SupportWorker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.support.model.impl.SupportWorkerImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorker
 * @generated
 */
@ProviderType
public interface SupportWorkerModel
	extends BaseModel<SupportWorker>, ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a support worker model instance should use the {@link SupportWorker} interface instead.
	 */

	/**
	 * Returns the primary key of this support worker.
	 *
	 * @return the primary key of this support worker
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this support worker.
	 *
	 * @param primaryKey the primary key of this support worker
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the support worker ID of this support worker.
	 *
	 * @return the support worker ID of this support worker
	 */
	public long getSupportWorkerId();

	/**
	 * Sets the support worker ID of this support worker.
	 *
	 * @param supportWorkerId the support worker ID of this support worker
	 */
	public void setSupportWorkerId(long supportWorkerId);

	/**
	 * Returns the company ID of this support worker.
	 *
	 * @return the company ID of this support worker
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this support worker.
	 *
	 * @param companyId the company ID of this support worker
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this support worker.
	 *
	 * @return the user ID of this support worker
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this support worker.
	 *
	 * @param userId the user ID of this support worker
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this support worker.
	 *
	 * @return the user uuid of this support worker
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this support worker.
	 *
	 * @param userUuid the user uuid of this support worker
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the support team ID of this support worker.
	 *
	 * @return the support team ID of this support worker
	 */
	public long getSupportTeamId();

	/**
	 * Sets the support team ID of this support worker.
	 *
	 * @param supportTeamId the support team ID of this support worker
	 */
	public void setSupportTeamId(long supportTeamId);

	/**
	 * Returns the support labor ID of this support worker.
	 *
	 * @return the support labor ID of this support worker
	 */
	public long getSupportLaborId();

	/**
	 * Sets the support labor ID of this support worker.
	 *
	 * @param supportLaborId the support labor ID of this support worker
	 */
	public void setSupportLaborId(long supportLaborId);

	/**
	 * Returns the assigned work of this support worker.
	 *
	 * @return the assigned work of this support worker
	 */
	public double getAssignedWork();

	/**
	 * Sets the assigned work of this support worker.
	 *
	 * @param assignedWork the assigned work of this support worker
	 */
	public void setAssignedWork(double assignedWork);

	/**
	 * Returns the max work of this support worker.
	 *
	 * @return the max work of this support worker
	 */
	public double getMaxWork();

	/**
	 * Sets the max work of this support worker.
	 *
	 * @param maxWork the max work of this support worker
	 */
	public void setMaxWork(double maxWork);

	/**
	 * Returns the role of this support worker.
	 *
	 * @return the role of this support worker
	 */
	public int getRole();

	/**
	 * Sets the role of this support worker.
	 *
	 * @param role the role of this support worker
	 */
	public void setRole(int role);

}