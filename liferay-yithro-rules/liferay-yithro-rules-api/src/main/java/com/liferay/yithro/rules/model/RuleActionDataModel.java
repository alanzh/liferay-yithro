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
 * The base model interface for the RuleActionData service. Represents a row in the &quot;Yithro_RuleActionData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.rules.model.impl.RuleActionDataImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionData
 * @generated
 */
@ProviderType
public interface RuleActionDataModel extends BaseModel<RuleActionData> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rule action data model instance should use the {@link RuleActionData} interface instead.
	 */

	/**
	 * Returns the primary key of this rule action data.
	 *
	 * @return the primary key of this rule action data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rule action data.
	 *
	 * @param primaryKey the primary key of this rule action data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the rule action data ID of this rule action data.
	 *
	 * @return the rule action data ID of this rule action data
	 */
	public long getRuleActionDataId();

	/**
	 * Sets the rule action data ID of this rule action data.
	 *
	 * @param ruleActionDataId the rule action data ID of this rule action data
	 */
	public void setRuleActionDataId(long ruleActionDataId);

	/**
	 * Returns the rule action ID of this rule action data.
	 *
	 * @return the rule action ID of this rule action data
	 */
	public long getRuleActionId();

	/**
	 * Sets the rule action ID of this rule action data.
	 *
	 * @param ruleActionId the rule action ID of this rule action data
	 */
	public void setRuleActionId(long ruleActionId);

	/**
	 * Returns the field of this rule action data.
	 *
	 * @return the field of this rule action data
	 */
	@AutoEscape
	public String getField();

	/**
	 * Sets the field of this rule action data.
	 *
	 * @param field the field of this rule action data
	 */
	public void setField(String field);

	/**
	 * Returns the value of this rule action data.
	 *
	 * @return the value of this rule action data
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this rule action data.
	 *
	 * @param value the value of this rule action data
	 */
	public void setValue(String value);

}