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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketEntryModel;
import com.liferay.yithro.ticket.model.TicketEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TicketEntry service. Represents a row in the &quot;Yithro_TicketEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketEntryModelImpl
	extends BaseModelImpl<TicketEntry> implements TicketEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket entry model instance should use the <code>TicketEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketEntryId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"languageId", Types.VARCHAR}, {"ticketNumber", Types.BIGINT},
		{"subject", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"severity", Types.INTEGER}, {"status", Types.INTEGER},
		{"weight", Types.INTEGER}, {"escalationLevel", Types.INTEGER},
		{"resolution", Types.INTEGER}, {"holdDate", Types.TIMESTAMP},
		{"closedDate", Types.TIMESTAMP}, {"dueDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ticketNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("severity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("weight", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("escalationLevel", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("resolution", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("holdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("closedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dueDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketEntry (ticketEntryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,languageId VARCHAR(75) null,ticketNumber LONG,subject VARCHAR(255) null,description STRING null,severity INTEGER,status INTEGER,weight INTEGER,escalationLevel INTEGER,resolution INTEGER,holdDate DATE null,closedDate DATE null,dueDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Yithro_TicketEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketEntry.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketEntry.modifiedDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long MODIFIEDDATE_COLUMN_BITMASK = 1L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TicketEntry toModel(TicketEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketEntry model = new TicketEntryImpl();

		model.setTicketEntryId(soapModel.getTicketEntryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLanguageId(soapModel.getLanguageId());
		model.setTicketNumber(soapModel.getTicketNumber());
		model.setSubject(soapModel.getSubject());
		model.setDescription(soapModel.getDescription());
		model.setSeverity(soapModel.getSeverity());
		model.setStatus(soapModel.getStatus());
		model.setWeight(soapModel.getWeight());
		model.setEscalationLevel(soapModel.getEscalationLevel());
		model.setResolution(soapModel.getResolution());
		model.setHoldDate(soapModel.getHoldDate());
		model.setClosedDate(soapModel.getClosedDate());
		model.setDueDate(soapModel.getDueDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketEntry> toModels(TicketEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TicketEntry> models = new ArrayList<TicketEntry>(
			soapModels.length);

		for (TicketEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TicketEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TicketEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TicketEntry, Object>>();
		Map<String, BiConsumer<TicketEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TicketEntry, ?>>();

		attributeGetterFunctions.put(
			"ticketEntryId", TicketEntry::getTicketEntryId);
		attributeSetterBiConsumers.put(
			"ticketEntryId",
			(BiConsumer<TicketEntry, Long>)TicketEntry::setTicketEntryId);
		attributeGetterFunctions.put("companyId", TicketEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketEntry, Long>)TicketEntry::setCompanyId);
		attributeGetterFunctions.put("userId", TicketEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TicketEntry, Long>)TicketEntry::setUserId);
		attributeGetterFunctions.put("userName", TicketEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TicketEntry, String>)TicketEntry::setUserName);
		attributeGetterFunctions.put("createDate", TicketEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketEntry, Date>)TicketEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TicketEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketEntry, Date>)TicketEntry::setModifiedDate);
		attributeGetterFunctions.put("languageId", TicketEntry::getLanguageId);
		attributeSetterBiConsumers.put(
			"languageId",
			(BiConsumer<TicketEntry, String>)TicketEntry::setLanguageId);
		attributeGetterFunctions.put(
			"ticketNumber", TicketEntry::getTicketNumber);
		attributeSetterBiConsumers.put(
			"ticketNumber",
			(BiConsumer<TicketEntry, Long>)TicketEntry::setTicketNumber);
		attributeGetterFunctions.put("subject", TicketEntry::getSubject);
		attributeSetterBiConsumers.put(
			"subject",
			(BiConsumer<TicketEntry, String>)TicketEntry::setSubject);
		attributeGetterFunctions.put(
			"description", TicketEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<TicketEntry, String>)TicketEntry::setDescription);
		attributeGetterFunctions.put("severity", TicketEntry::getSeverity);
		attributeSetterBiConsumers.put(
			"severity",
			(BiConsumer<TicketEntry, Integer>)TicketEntry::setSeverity);
		attributeGetterFunctions.put("status", TicketEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<TicketEntry, Integer>)TicketEntry::setStatus);
		attributeGetterFunctions.put("weight", TicketEntry::getWeight);
		attributeSetterBiConsumers.put(
			"weight", (BiConsumer<TicketEntry, Integer>)TicketEntry::setWeight);
		attributeGetterFunctions.put(
			"escalationLevel", TicketEntry::getEscalationLevel);
		attributeSetterBiConsumers.put(
			"escalationLevel",
			(BiConsumer<TicketEntry, Integer>)TicketEntry::setEscalationLevel);
		attributeGetterFunctions.put("resolution", TicketEntry::getResolution);
		attributeSetterBiConsumers.put(
			"resolution",
			(BiConsumer<TicketEntry, Integer>)TicketEntry::setResolution);
		attributeGetterFunctions.put("holdDate", TicketEntry::getHoldDate);
		attributeSetterBiConsumers.put(
			"holdDate",
			(BiConsumer<TicketEntry, Date>)TicketEntry::setHoldDate);
		attributeGetterFunctions.put("closedDate", TicketEntry::getClosedDate);
		attributeSetterBiConsumers.put(
			"closedDate",
			(BiConsumer<TicketEntry, Date>)TicketEntry::setClosedDate);
		attributeGetterFunctions.put("dueDate", TicketEntry::getDueDate);
		attributeSetterBiConsumers.put(
			"dueDate", (BiConsumer<TicketEntry, Date>)TicketEntry::setDueDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	@Override
	public void setTicketEntryId(long ticketEntryId) {
		_ticketEntryId = ticketEntryId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_columnBitmask = -1L;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@JSON
	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@JSON
	@Override
	public long getTicketNumber() {
		return _ticketNumber;
	}

	@Override
	public void setTicketNumber(long ticketNumber) {
		_ticketNumber = ticketNumber;
	}

	@JSON
	@Override
	public String getSubject() {
		if (_subject == null) {
			return "";
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public int getSeverity() {
		return _severity;
	}

	@Override
	public void setSeverity(int severity) {
		_severity = severity;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public int getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(int weight) {
		_weight = weight;
	}

	@JSON
	@Override
	public int getEscalationLevel() {
		return _escalationLevel;
	}

	@Override
	public void setEscalationLevel(int escalationLevel) {
		_escalationLevel = escalationLevel;
	}

	@JSON
	@Override
	public int getResolution() {
		return _resolution;
	}

	@Override
	public void setResolution(int resolution) {
		_resolution = resolution;
	}

	@JSON
	@Override
	public Date getHoldDate() {
		return _holdDate;
	}

	@Override
	public void setHoldDate(Date holdDate) {
		_holdDate = holdDate;
	}

	@JSON
	@Override
	public Date getClosedDate() {
		return _closedDate;
	}

	@Override
	public void setClosedDate(Date closedDate) {
		_closedDate = closedDate;
	}

	@JSON
	@Override
	public Date getDueDate() {
		return _dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TicketEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TicketEntry)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketEntryImpl ticketEntryImpl = new TicketEntryImpl();

		ticketEntryImpl.setTicketEntryId(getTicketEntryId());
		ticketEntryImpl.setCompanyId(getCompanyId());
		ticketEntryImpl.setUserId(getUserId());
		ticketEntryImpl.setUserName(getUserName());
		ticketEntryImpl.setCreateDate(getCreateDate());
		ticketEntryImpl.setModifiedDate(getModifiedDate());
		ticketEntryImpl.setLanguageId(getLanguageId());
		ticketEntryImpl.setTicketNumber(getTicketNumber());
		ticketEntryImpl.setSubject(getSubject());
		ticketEntryImpl.setDescription(getDescription());
		ticketEntryImpl.setSeverity(getSeverity());
		ticketEntryImpl.setStatus(getStatus());
		ticketEntryImpl.setWeight(getWeight());
		ticketEntryImpl.setEscalationLevel(getEscalationLevel());
		ticketEntryImpl.setResolution(getResolution());
		ticketEntryImpl.setHoldDate(getHoldDate());
		ticketEntryImpl.setClosedDate(getClosedDate());
		ticketEntryImpl.setDueDate(getDueDate());

		ticketEntryImpl.resetOriginalValues();

		return ticketEntryImpl;
	}

	@Override
	public int compareTo(TicketEntry ticketEntry) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), ticketEntry.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketEntry)) {
			return false;
		}

		TicketEntry ticketEntry = (TicketEntry)obj;

		long primaryKey = ticketEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		TicketEntryModelImpl ticketEntryModelImpl = this;

		ticketEntryModelImpl._originalModifiedDate =
			ticketEntryModelImpl._modifiedDate;

		ticketEntryModelImpl._setModifiedDate = false;

		ticketEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketEntry> toCacheModel() {
		TicketEntryCacheModel ticketEntryCacheModel =
			new TicketEntryCacheModel();

		ticketEntryCacheModel.ticketEntryId = getTicketEntryId();

		ticketEntryCacheModel.companyId = getCompanyId();

		ticketEntryCacheModel.userId = getUserId();

		ticketEntryCacheModel.userName = getUserName();

		String userName = ticketEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ticketEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ticketEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketEntryCacheModel.languageId = getLanguageId();

		String languageId = ticketEntryCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			ticketEntryCacheModel.languageId = null;
		}

		ticketEntryCacheModel.ticketNumber = getTicketNumber();

		ticketEntryCacheModel.subject = getSubject();

		String subject = ticketEntryCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			ticketEntryCacheModel.subject = null;
		}

		ticketEntryCacheModel.description = getDescription();

		String description = ticketEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ticketEntryCacheModel.description = null;
		}

		ticketEntryCacheModel.severity = getSeverity();

		ticketEntryCacheModel.status = getStatus();

		ticketEntryCacheModel.weight = getWeight();

		ticketEntryCacheModel.escalationLevel = getEscalationLevel();

		ticketEntryCacheModel.resolution = getResolution();

		Date holdDate = getHoldDate();

		if (holdDate != null) {
			ticketEntryCacheModel.holdDate = holdDate.getTime();
		}
		else {
			ticketEntryCacheModel.holdDate = Long.MIN_VALUE;
		}

		Date closedDate = getClosedDate();

		if (closedDate != null) {
			ticketEntryCacheModel.closedDate = closedDate.getTime();
		}
		else {
			ticketEntryCacheModel.closedDate = Long.MIN_VALUE;
		}

		Date dueDate = getDueDate();

		if (dueDate != null) {
			ticketEntryCacheModel.dueDate = dueDate.getTime();
		}
		else {
			ticketEntryCacheModel.dueDate = Long.MIN_VALUE;
		}

		return ticketEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TicketEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TicketEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TicketEntry.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketEntryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private boolean _setModifiedDate;
	private String _languageId;
	private long _ticketNumber;
	private String _subject;
	private String _description;
	private int _severity;
	private int _status;
	private int _weight;
	private int _escalationLevel;
	private int _resolution;
	private Date _holdDate;
	private Date _closedDate;
	private Date _dueDate;
	private long _columnBitmask;
	private TicketEntry _escapedModel;

}