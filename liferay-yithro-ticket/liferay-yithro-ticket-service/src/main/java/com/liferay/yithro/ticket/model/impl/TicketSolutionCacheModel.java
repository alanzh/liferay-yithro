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

package com.liferay.yithro.ticket.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.yithro.ticket.model.TicketSolution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketSolution in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketSolutionCacheModel
	implements CacheModel<TicketSolution>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketSolutionCacheModel)) {
			return false;
		}

		TicketSolutionCacheModel ticketSolutionCacheModel =
			(TicketSolutionCacheModel)obj;

		if (ticketSolutionId == ticketSolutionCacheModel.ticketSolutionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketSolutionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{ticketSolutionId=");
		sb.append(ticketSolutionId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", solution=");
		sb.append(solution);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", statusMessage=");
		sb.append(statusMessage);
		sb.append(", statusReason=");
		sb.append(statusReason);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketSolution toEntityModel() {
		TicketSolutionImpl ticketSolutionImpl = new TicketSolutionImpl();

		ticketSolutionImpl.setTicketSolutionId(ticketSolutionId);
		ticketSolutionImpl.setUserId(userId);

		if (userName == null) {
			ticketSolutionImpl.setUserName("");
		}
		else {
			ticketSolutionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ticketSolutionImpl.setCreateDate(null);
		}
		else {
			ticketSolutionImpl.setCreateDate(new Date(createDate));
		}

		ticketSolutionImpl.setTicketEntryId(ticketEntryId);

		if (solution == null) {
			ticketSolutionImpl.setSolution("");
		}
		else {
			ticketSolutionImpl.setSolution(solution);
		}

		ticketSolutionImpl.setType(type);
		ticketSolutionImpl.setStatus(status);
		ticketSolutionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			ticketSolutionImpl.setStatusByUserName("");
		}
		else {
			ticketSolutionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			ticketSolutionImpl.setStatusDate(null);
		}
		else {
			ticketSolutionImpl.setStatusDate(new Date(statusDate));
		}

		if (statusMessage == null) {
			ticketSolutionImpl.setStatusMessage("");
		}
		else {
			ticketSolutionImpl.setStatusMessage(statusMessage);
		}

		ticketSolutionImpl.setStatusReason(statusReason);

		ticketSolutionImpl.resetOriginalValues();

		return ticketSolutionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketSolutionId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		ticketEntryId = objectInput.readLong();
		solution = objectInput.readUTF();

		type = objectInput.readInt();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		statusMessage = objectInput.readUTF();

		statusReason = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketSolutionId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(ticketEntryId);

		if (solution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(solution);
		}

		objectOutput.writeInt(type);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (statusMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusMessage);
		}

		objectOutput.writeInt(statusReason);
	}

	public long ticketSolutionId;
	public long userId;
	public String userName;
	public long createDate;
	public long ticketEntryId;
	public String solution;
	public int type;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String statusMessage;
	public int statusReason;

}