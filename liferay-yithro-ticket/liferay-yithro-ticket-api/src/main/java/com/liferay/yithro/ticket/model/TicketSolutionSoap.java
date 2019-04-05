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

package com.liferay.yithro.ticket.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketSolutionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketSolutionSoap implements Serializable {

	public static TicketSolutionSoap toSoapModel(TicketSolution model) {
		TicketSolutionSoap soapModel = new TicketSolutionSoap();

		soapModel.setTicketSolutionId(model.getTicketSolutionId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTicketEntryId(model.getTicketEntryId());
		soapModel.setSolution(model.getSolution());
		soapModel.setType(model.getType());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setStatusMessage(model.getStatusMessage());
		soapModel.setStatusReason(model.getStatusReason());

		return soapModel;
	}

	public static TicketSolutionSoap[] toSoapModels(TicketSolution[] models) {
		TicketSolutionSoap[] soapModels = new TicketSolutionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketSolutionSoap[][] toSoapModels(
		TicketSolution[][] models) {

		TicketSolutionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TicketSolutionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketSolutionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketSolutionSoap[] toSoapModels(
		List<TicketSolution> models) {

		List<TicketSolutionSoap> soapModels = new ArrayList<TicketSolutionSoap>(
			models.size());

		for (TicketSolution model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketSolutionSoap[soapModels.size()]);
	}

	public TicketSolutionSoap() {
	}

	public long getPrimaryKey() {
		return _ticketSolutionId;
	}

	public void setPrimaryKey(long pk) {
		setTicketSolutionId(pk);
	}

	public long getTicketSolutionId() {
		return _ticketSolutionId;
	}

	public void setTicketSolutionId(long ticketSolutionId) {
		_ticketSolutionId = ticketSolutionId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	public void setTicketEntryId(long ticketEntryId) {
		_ticketEntryId = ticketEntryId;
	}

	public String getSolution() {
		return _solution;
	}

	public void setSolution(String solution) {
		_solution = solution;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getStatusMessage() {
		return _statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		_statusMessage = statusMessage;
	}

	public int getStatusReason() {
		return _statusReason;
	}

	public void setStatusReason(int statusReason) {
		_statusReason = statusReason;
	}

	private long _ticketSolutionId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _ticketEntryId;
	private String _solution;
	private int _type;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _statusMessage;
	private int _statusReason;

}