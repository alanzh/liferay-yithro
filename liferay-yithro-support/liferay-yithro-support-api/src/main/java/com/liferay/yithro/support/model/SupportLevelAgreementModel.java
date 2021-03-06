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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SupportLevelAgreement service. Represents a row in the &quot;Yithro_SupportLevelAgreement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportLevelAgreement
 * @generated
 */
@ProviderType
public interface SupportLevelAgreementModel
	extends BaseModel<SupportLevelAgreement>, ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a support level agreement model instance should use the {@link SupportLevelAgreement} interface instead.
	 */

	/**
	 * Returns the primary key of this support level agreement.
	 *
	 * @return the primary key of this support level agreement
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this support level agreement.
	 *
	 * @param primaryKey the primary key of this support level agreement
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the support level agreement ID of this support level agreement.
	 *
	 * @return the support level agreement ID of this support level agreement
	 */
	public long getSupportLevelAgreementId();

	/**
	 * Sets the support level agreement ID of this support level agreement.
	 *
	 * @param supportLevelAgreementId the support level agreement ID of this support level agreement
	 */
	public void setSupportLevelAgreementId(long supportLevelAgreementId);

	/**
	 * Returns the company ID of this support level agreement.
	 *
	 * @return the company ID of this support level agreement
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this support level agreement.
	 *
	 * @param companyId the company ID of this support level agreement
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this support level agreement.
	 *
	 * @return the user ID of this support level agreement
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this support level agreement.
	 *
	 * @param userId the user ID of this support level agreement
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this support level agreement.
	 *
	 * @return the user uuid of this support level agreement
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this support level agreement.
	 *
	 * @param userUuid the user uuid of this support level agreement
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this support level agreement.
	 *
	 * @return the create date of this support level agreement
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this support level agreement.
	 *
	 * @param createDate the create date of this support level agreement
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this support level agreement.
	 *
	 * @return the modified date of this support level agreement
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this support level agreement.
	 *
	 * @param modifiedDate the modified date of this support level agreement
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this support level agreement.
	 *
	 * @return the name of this support level agreement
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this support level agreement.
	 *
	 * @param name the name of this support level agreement
	 */
	public void setName(String name);

	/**
	 * Returns the description of this support level agreement.
	 *
	 * @return the description of this support level agreement
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this support level agreement.
	 *
	 * @param description the description of this support level agreement
	 */
	public void setDescription(String description);

}