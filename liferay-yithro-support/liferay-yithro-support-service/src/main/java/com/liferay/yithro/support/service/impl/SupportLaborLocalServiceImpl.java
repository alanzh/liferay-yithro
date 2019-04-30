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

package com.liferay.yithro.support.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.support.exception.SupportLaborHourException;
import com.liferay.yithro.support.exception.SupportLaborNameException;
import com.liferay.yithro.support.model.SupportLabor;
import com.liferay.yithro.support.model.SupportWorker;
import com.liferay.yithro.support.service.base.SupportLaborLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brent Krone-Schmidt
 */
@Component(
	property = "model.class.name=com.liferay.yithro.support.model.SupportLabor",
	service = AopService.class
)
public class SupportLaborLocalServiceImpl
	extends SupportLaborLocalServiceBaseImpl {

	public SupportLabor addSupportLabor(
			long userId, String name, String description, String timeZoneId,
			int sunOpen, int sunClose, int monOpen, int monClose, int tueOpen,
			int tueClose, int wedOpen, int wedClose, int thuOpen, int thuClose,
			int friOpen, int friClose, int satOpen, int satClose)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(
			name, sunOpen, sunClose, monOpen, monClose, tueOpen, tueClose,
			wedOpen, wedClose, thuOpen, thuClose, friOpen, friClose, satOpen,
			satClose);

		long supportLaborId = counterLocalService.increment();

		SupportLabor supportLabor = supportLaborPersistence.create(
			supportLaborId);

		supportLabor.setCompanyId(user.getCompanyId());
		supportLabor.setUserId(user.getUserId());
		supportLabor.setUserName(user.getFullName());
		supportLabor.setName(name);
		supportLabor.setDescription(description);
		supportLabor.setTimeZoneId(timeZoneId);
		supportLabor.setSunOpen(sunOpen);
		supportLabor.setSunClose(sunClose);
		supportLabor.setMonOpen(monOpen);
		supportLabor.setMonClose(monClose);
		supportLabor.setTueOpen(tueOpen);
		supportLabor.setTueClose(tueClose);
		supportLabor.setWedOpen(wedOpen);
		supportLabor.setWedClose(wedClose);
		supportLabor.setThuOpen(thuOpen);
		supportLabor.setThuClose(thuClose);
		supportLabor.setFriOpen(friOpen);
		supportLabor.setFriClose(friClose);
		supportLabor.setSatOpen(satOpen);
		supportLabor.setSatClose(satClose);

		return supportLaborPersistence.update(supportLabor);
	}

	public void addSupportWorkers(long[] supportWorkerIds, long supportLaborId)
		throws PortalException {

		for (long supportWorkerId : supportWorkerIds) {
			SupportWorker supportWorker =
				supportWorkerPersistence.findByPrimaryKey(supportWorkerId);

			supportWorker.setSupportLaborId(supportLaborId);

			supportWorkerPersistence.update(supportWorker);
		}
	}

	@Override
	public SupportLabor deleteSupportLabor(long supportLaborId)
		throws PortalException {

		SupportLabor supportLabor = supportLaborPersistence.remove(
			supportLaborId);

		List<SupportWorker> supportWorkers =
			supportWorkerPersistence.findBySupportLaborId(supportLaborId);

		for (SupportWorker supportWorker : supportWorkers) {
			supportWorker.setSupportLaborId(0);

			supportWorkerPersistence.update(supportWorker);
		}

		return supportLabor;
	}

	public boolean hasSupportWorker(long supportWorkerId, long supportLaborId)
		throws PortalException {

		SupportWorker supportWorker = supportWorkerPersistence.findByPrimaryKey(
			supportWorkerId);

		if (supportWorker.getSupportLaborId() == supportLaborId) {
			return true;
		}

		return false;
	}

	public void removeSupportWorkers(long[] supportWorkerIds)
		throws PortalException {

		for (long supportWorkerId : supportWorkerIds) {
			SupportWorker supportWorker =
				supportWorkerPersistence.fetchByPrimaryKey(supportWorkerId);

			if (supportWorker == null) {
				continue;
			}

			supportWorker.setSupportLaborId(0);

			supportWorkerPersistence.update(supportWorker);
		}
	}

	public SupportLabor updateSupportLabor(
			long supportLaborId, String name, String description,
			String timeZoneId, int sunOpen, int sunClose, int monOpen,
			int monClose, int tueOpen, int tueClose, int wedOpen, int wedClose,
			int thuOpen, int thuClose, int friOpen, int friClose, int satOpen,
			int satClose)
		throws PortalException {

		validate(
			name, sunOpen, sunClose, monOpen, monClose, tueOpen, tueClose,
			wedOpen, wedClose, thuOpen, thuClose, friOpen, friClose, satOpen,
			satClose);

		SupportLabor supportLabor = supportLaborPersistence.findByPrimaryKey(
			supportLaborId);

		supportLabor.setName(name);
		supportLabor.setDescription(description);
		supportLabor.setTimeZoneId(timeZoneId);
		supportLabor.setSunOpen(sunOpen);
		supportLabor.setSunClose(sunClose);
		supportLabor.setMonOpen(monOpen);
		supportLabor.setMonClose(monClose);
		supportLabor.setTueOpen(tueOpen);
		supportLabor.setTueClose(tueClose);
		supportLabor.setWedOpen(wedOpen);
		supportLabor.setWedClose(wedClose);
		supportLabor.setThuOpen(thuOpen);
		supportLabor.setThuClose(thuClose);
		supportLabor.setFriOpen(friOpen);
		supportLabor.setFriClose(friClose);
		supportLabor.setSatOpen(satOpen);
		supportLabor.setSatClose(satClose);

		return supportLaborPersistence.update(supportLabor);
	}

	protected void validate(
			String name, int sunOpen, int sunClose, int monOpen, int monClose,
			int tueOpen, int tueClose, int wedOpen, int wedClose, int thuOpen,
			int thuClose, int friOpen, int friClose, int satOpen, int satClose)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new SupportLaborNameException();
		}

		if ((sunOpen < 0) || (sunOpen > 1440) || (sunClose < 0) ||
			(sunClose > 1440) || (monOpen < 0) || (monOpen > 1440) ||
			(monClose < 0) || (monClose > 1440) || (tueOpen < 0) ||
			(tueOpen > 1440) || (tueClose < 0) || (tueClose > 1440) ||
			(wedOpen < 0) || (wedOpen > 1440) || (wedClose < 0) ||
			(wedClose > 1440) || (thuOpen < 0) || (thuOpen > 1440) ||
			(thuClose < 0) || (thuClose > 1440) || (friOpen < 0) ||
			(friOpen > 1440) || (friClose < 0) || (friClose > 1440) ||
			(satOpen < 0) || (satOpen > 1440) || (satClose < 0) ||
			(satClose > 1440)) {

			throw new SupportLaborHourException();
		}

		if ((sunClose < sunOpen) || (monClose < monOpen) ||
			(tueClose < tueOpen) || (wedClose < wedOpen) ||
			(thuClose < thuOpen) || (friClose < friOpen) ||
			(satClose < satOpen)) {

			throw new SupportLaborHourException();
		}
	}

}