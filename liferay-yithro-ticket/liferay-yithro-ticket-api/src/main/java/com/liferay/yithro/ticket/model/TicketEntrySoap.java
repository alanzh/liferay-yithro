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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketEntrySoap implements Serializable {

	public static TicketEntrySoap toSoapModel(TicketEntry model) {
		TicketEntrySoap soapModel = new TicketEntrySoap();

		soapModel.setTicketEntryId(model.getTicketEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTicketStructureId(model.getTicketStructureId());
		soapModel.setTicketStatusId(model.getTicketStatusId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setTicketNumber(model.getTicketNumber());
		soapModel.setSummary(model.getSummary());
		soapModel.setDescription(model.getDescription());
		soapModel.setWeight(model.getWeight());
		soapModel.setHoldDate(model.getHoldDate());
		soapModel.setClosedDate(model.getClosedDate());
		soapModel.setDueDate(model.getDueDate());

		return soapModel;
	}

	public static TicketEntrySoap[] toSoapModels(TicketEntry[] models) {
		TicketEntrySoap[] soapModels = new TicketEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketEntrySoap[][] toSoapModels(TicketEntry[][] models) {
		TicketEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketEntrySoap[] toSoapModels(List<TicketEntry> models) {
		List<TicketEntrySoap> soapModels = new ArrayList<TicketEntrySoap>(
			models.size());

		for (TicketEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketEntrySoap[soapModels.size()]);
	}

	public TicketEntrySoap() {
	}

	public long getPrimaryKey() {
		return _ticketEntryId;
	}

	public void setPrimaryKey(long pk) {
		setTicketEntryId(pk);
	}

	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	public void setTicketEntryId(long ticketEntryId) {
		_ticketEntryId = ticketEntryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getTicketStructureId() {
		return _ticketStructureId;
	}

	public void setTicketStructureId(long ticketStructureId) {
		_ticketStructureId = ticketStructureId;
	}

	public long getTicketStatusId() {
		return _ticketStatusId;
	}

	public void setTicketStatusId(long ticketStatusId) {
		_ticketStatusId = ticketStatusId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public long getTicketNumber() {
		return _ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		_ticketNumber = ticketNumber;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public Date getHoldDate() {
		return _holdDate;
	}

	public void setHoldDate(Date holdDate) {
		_holdDate = holdDate;
	}

	public Date getClosedDate() {
		return _closedDate;
	}

	public void setClosedDate(Date closedDate) {
		_closedDate = closedDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	private long _ticketEntryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private long _ticketStructureId;
	private long _ticketStatusId;
	private String _languageId;
	private long _ticketNumber;
	private String _summary;
	private String _description;
	private int _weight;
	private Date _holdDate;
	private Date _closedDate;
	private Date _dueDate;

}