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

package com.liferay.yithro.rules.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.yithro.rules.model.Action;
import com.liferay.yithro.rules.service.base.ActionLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.yithro.rules.model.Action",
	service = AopService.class
)
public class ActionLocalServiceImpl extends ActionLocalServiceBaseImpl {

	public Action addAction(String name, String value) throws PortalException {
		long actionId = counterLocalService.increment();

		Action action = actionPersistence.create(actionId);

		action.setName(name);
		action.setValue(value);

		return action;
	}

	public List<Action> getActions(long ruleId) {
		return actionPersistence.findByRuleId(ruleId);
	}

}