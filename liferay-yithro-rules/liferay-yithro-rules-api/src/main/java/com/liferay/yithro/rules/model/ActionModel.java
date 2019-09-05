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

package com.liferay.yithro.rules.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Action service. Represents a row in the &quot;Yithro_Action&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.rules.model.impl.ActionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.rules.model.impl.ActionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Action
 * @generated
 */
@ProviderType
public interface ActionModel extends BaseModel<Action> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a action model instance should use the {@link Action} interface instead.
	 */

	/**
	 * Returns the primary key of this action.
	 *
	 * @return the primary key of this action
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this action.
	 *
	 * @param primaryKey the primary key of this action
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the action ID of this action.
	 *
	 * @return the action ID of this action
	 */
	public long getActionId();

	/**
	 * Sets the action ID of this action.
	 *
	 * @param actionId the action ID of this action
	 */
	public void setActionId(long actionId);

	/**
	 * Returns the rule ID of this action.
	 *
	 * @return the rule ID of this action
	 */
	public long getRuleId();

	/**
	 * Sets the rule ID of this action.
	 *
	 * @param ruleId the rule ID of this action
	 */
	public void setRuleId(long ruleId);

	/**
	 * Returns the entity of this action.
	 *
	 * @return the entity of this action
	 */
	@AutoEscape
	public String getEntity();

	/**
	 * Sets the entity of this action.
	 *
	 * @param entity the entity of this action
	 */
	public void setEntity(String entity);

	/**
	 * Returns the name of this action.
	 *
	 * @return the name of this action
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this action.
	 *
	 * @param name the name of this action
	 */
	public void setName(String name);

	/**
	 * Returns the value of this action.
	 *
	 * @return the value of this action
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this action.
	 *
	 * @param value the value of this action
	 */
	public void setValue(String value);

}