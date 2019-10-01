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
import com.liferay.yithro.ticket.model.TicketComment;
import com.liferay.yithro.ticket.model.TicketCommentModel;
import com.liferay.yithro.ticket.model.TicketCommentSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

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
 * The base model implementation for the TicketComment service. Represents a row in the &quot;Yithro_TicketComment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketCommentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketCommentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentImpl
 * @generated
 */
@JSON(strict = true)
public class TicketCommentModelImpl
	extends BaseModelImpl<TicketComment> implements TicketCommentModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket comment model instance should use the <code>TicketComment</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketComment";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketCommentId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"ticketEntryId", Types.BIGINT},
		{"ticketCommunicationId", Types.BIGINT}, {"body", Types.VARCHAR},
		{"type_", Types.INTEGER}, {"format", Types.VARCHAR},
		{"visibility", Types.INTEGER}, {"settings_", Types.VARCHAR},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketCommentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ticketEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ticketCommunicationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("body", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("format", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("visibility", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("settings_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketComment (ticketCommentId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,ticketEntryId LONG,ticketCommunicationId LONG,body TEXT null,type_ INTEGER,format VARCHAR(75) null,visibility INTEGER,settings_ VARCHAR(75) null,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table Yithro_TicketComment";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketComment.createDate ASC, ticketComment.ticketCommentId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketComment.createDate ASC, Yithro_TicketComment.ticketCommentId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long STATUS_COLUMN_BITMASK = 1L;

	public static final long TICKETCOMMUNICATIONID_COLUMN_BITMASK = 2L;

	public static final long TICKETENTRYID_COLUMN_BITMASK = 4L;

	public static final long TYPE_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long VISIBILITY_COLUMN_BITMASK = 32L;

	public static final long CREATEDATE_COLUMN_BITMASK = 64L;

	public static final long TICKETCOMMENTID_COLUMN_BITMASK = 128L;

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
	public static TicketComment toModel(TicketCommentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketComment model = new TicketCommentImpl();

		model.setTicketCommentId(soapModel.getTicketCommentId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTicketEntryId(soapModel.getTicketEntryId());
		model.setTicketCommunicationId(soapModel.getTicketCommunicationId());
		model.setBody(soapModel.getBody());
		model.setType(soapModel.getType());
		model.setFormat(soapModel.getFormat());
		model.setVisibility(soapModel.getVisibility());
		model.setSettings(soapModel.getSettings());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketComment> toModels(TicketCommentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TicketComment> models = new ArrayList<TicketComment>(
			soapModels.length);

		for (TicketCommentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketCommentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketCommentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketCommentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketCommentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketComment.class;
	}

	@Override
	public String getModelClassName() {
		return TicketComment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketComment, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketComment, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketComment, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketComment)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketComment, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketComment, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketComment)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketComment, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketComment, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TicketComment>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TicketComment.class.getClassLoader(), TicketComment.class,
			ModelWrapper.class);

		try {
			Constructor<TicketComment> constructor =
				(Constructor<TicketComment>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<TicketComment, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketComment, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketComment, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TicketComment, Object>>();
		Map<String, BiConsumer<TicketComment, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TicketComment, ?>>();

		attributeGetterFunctions.put(
			"ticketCommentId", TicketComment::getTicketCommentId);
		attributeSetterBiConsumers.put(
			"ticketCommentId",
			(BiConsumer<TicketComment, Long>)TicketComment::setTicketCommentId);
		attributeGetterFunctions.put("companyId", TicketComment::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketComment, Long>)TicketComment::setCompanyId);
		attributeGetterFunctions.put("userId", TicketComment::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<TicketComment, Long>)TicketComment::setUserId);
		attributeGetterFunctions.put("userName", TicketComment::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TicketComment, String>)TicketComment::setUserName);
		attributeGetterFunctions.put(
			"createDate", TicketComment::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketComment, Date>)TicketComment::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TicketComment::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketComment, Date>)TicketComment::setModifiedDate);
		attributeGetterFunctions.put(
			"ticketEntryId", TicketComment::getTicketEntryId);
		attributeSetterBiConsumers.put(
			"ticketEntryId",
			(BiConsumer<TicketComment, Long>)TicketComment::setTicketEntryId);
		attributeGetterFunctions.put(
			"ticketCommunicationId", TicketComment::getTicketCommunicationId);
		attributeSetterBiConsumers.put(
			"ticketCommunicationId",
			(BiConsumer<TicketComment, Long>)
				TicketComment::setTicketCommunicationId);
		attributeGetterFunctions.put("body", TicketComment::getBody);
		attributeSetterBiConsumers.put(
			"body", (BiConsumer<TicketComment, String>)TicketComment::setBody);
		attributeGetterFunctions.put("type", TicketComment::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<TicketComment, Integer>)TicketComment::setType);
		attributeGetterFunctions.put("format", TicketComment::getFormat);
		attributeSetterBiConsumers.put(
			"format",
			(BiConsumer<TicketComment, String>)TicketComment::setFormat);
		attributeGetterFunctions.put(
			"visibility", TicketComment::getVisibility);
		attributeSetterBiConsumers.put(
			"visibility",
			(BiConsumer<TicketComment, Integer>)TicketComment::setVisibility);
		attributeGetterFunctions.put("settings", TicketComment::getSettings);
		attributeSetterBiConsumers.put(
			"settings",
			(BiConsumer<TicketComment, String>)TicketComment::setSettings);
		attributeGetterFunctions.put("status", TicketComment::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<TicketComment, Integer>)TicketComment::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketCommentId() {
		return _ticketCommentId;
	}

	@Override
	public void setTicketCommentId(long ticketCommentId) {
		_columnBitmask = -1L;

		_ticketCommentId = ticketCommentId;
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
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
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
		_columnBitmask = -1L;

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

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	@Override
	public void setTicketEntryId(long ticketEntryId) {
		_columnBitmask |= TICKETENTRYID_COLUMN_BITMASK;

		if (!_setOriginalTicketEntryId) {
			_setOriginalTicketEntryId = true;

			_originalTicketEntryId = _ticketEntryId;
		}

		_ticketEntryId = ticketEntryId;
	}

	public long getOriginalTicketEntryId() {
		return _originalTicketEntryId;
	}

	@JSON
	@Override
	public long getTicketCommunicationId() {
		return _ticketCommunicationId;
	}

	@Override
	public void setTicketCommunicationId(long ticketCommunicationId) {
		_columnBitmask |= TICKETCOMMUNICATIONID_COLUMN_BITMASK;

		if (!_setOriginalTicketCommunicationId) {
			_setOriginalTicketCommunicationId = true;

			_originalTicketCommunicationId = _ticketCommunicationId;
		}

		_ticketCommunicationId = ticketCommunicationId;
	}

	public long getOriginalTicketCommunicationId() {
		return _originalTicketCommunicationId;
	}

	@JSON
	@Override
	public String getBody() {
		if (_body == null) {
			return "";
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	@JSON
	@Override
	public String getFormat() {
		if (_format == null) {
			return "";
		}
		else {
			return _format;
		}
	}

	@Override
	public void setFormat(String format) {
		_format = format;
	}

	@JSON
	@Override
	public int getVisibility() {
		return _visibility;
	}

	@Override
	public void setVisibility(int visibility) {
		_columnBitmask |= VISIBILITY_COLUMN_BITMASK;

		if (!_setOriginalVisibility) {
			_setOriginalVisibility = true;

			_originalVisibility = _visibility;
		}

		_visibility = visibility;
	}

	public int getOriginalVisibility() {
		return _originalVisibility;
	}

	@JSON
	@Override
	public String getSettings() {
		if (_settings == null) {
			return "";
		}
		else {
			return _settings;
		}
	}

	@Override
	public void setSettings(String settings) {
		_settings = settings;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketComment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TicketComment toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TicketComment>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketCommentImpl ticketCommentImpl = new TicketCommentImpl();

		ticketCommentImpl.setTicketCommentId(getTicketCommentId());
		ticketCommentImpl.setCompanyId(getCompanyId());
		ticketCommentImpl.setUserId(getUserId());
		ticketCommentImpl.setUserName(getUserName());
		ticketCommentImpl.setCreateDate(getCreateDate());
		ticketCommentImpl.setModifiedDate(getModifiedDate());
		ticketCommentImpl.setTicketEntryId(getTicketEntryId());
		ticketCommentImpl.setTicketCommunicationId(getTicketCommunicationId());
		ticketCommentImpl.setBody(getBody());
		ticketCommentImpl.setType(getType());
		ticketCommentImpl.setFormat(getFormat());
		ticketCommentImpl.setVisibility(getVisibility());
		ticketCommentImpl.setSettings(getSettings());
		ticketCommentImpl.setStatus(getStatus());

		ticketCommentImpl.resetOriginalValues();

		return ticketCommentImpl;
	}

	@Override
	public int compareTo(TicketComment ticketComment) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), ticketComment.getCreateDate());

		if (value != 0) {
			return value;
		}

		if (getTicketCommentId() < ticketComment.getTicketCommentId()) {
			value = -1;
		}
		else if (getTicketCommentId() > ticketComment.getTicketCommentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof TicketComment)) {
			return false;
		}

		TicketComment ticketComment = (TicketComment)obj;

		long primaryKey = ticketComment.getPrimaryKey();

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
		TicketCommentModelImpl ticketCommentModelImpl = this;

		ticketCommentModelImpl._originalUserId = ticketCommentModelImpl._userId;

		ticketCommentModelImpl._setOriginalUserId = false;

		ticketCommentModelImpl._setModifiedDate = false;

		ticketCommentModelImpl._originalTicketEntryId =
			ticketCommentModelImpl._ticketEntryId;

		ticketCommentModelImpl._setOriginalTicketEntryId = false;

		ticketCommentModelImpl._originalTicketCommunicationId =
			ticketCommentModelImpl._ticketCommunicationId;

		ticketCommentModelImpl._setOriginalTicketCommunicationId = false;

		ticketCommentModelImpl._originalType = ticketCommentModelImpl._type;

		ticketCommentModelImpl._setOriginalType = false;

		ticketCommentModelImpl._originalVisibility =
			ticketCommentModelImpl._visibility;

		ticketCommentModelImpl._setOriginalVisibility = false;

		ticketCommentModelImpl._originalStatus = ticketCommentModelImpl._status;

		ticketCommentModelImpl._setOriginalStatus = false;

		ticketCommentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketComment> toCacheModel() {
		TicketCommentCacheModel ticketCommentCacheModel =
			new TicketCommentCacheModel();

		ticketCommentCacheModel.ticketCommentId = getTicketCommentId();

		ticketCommentCacheModel.companyId = getCompanyId();

		ticketCommentCacheModel.userId = getUserId();

		ticketCommentCacheModel.userName = getUserName();

		String userName = ticketCommentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ticketCommentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketCommentCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketCommentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketCommentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ticketCommentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketCommentCacheModel.ticketEntryId = getTicketEntryId();

		ticketCommentCacheModel.ticketCommunicationId =
			getTicketCommunicationId();

		ticketCommentCacheModel.body = getBody();

		String body = ticketCommentCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			ticketCommentCacheModel.body = null;
		}

		ticketCommentCacheModel.type = getType();

		ticketCommentCacheModel.format = getFormat();

		String format = ticketCommentCacheModel.format;

		if ((format != null) && (format.length() == 0)) {
			ticketCommentCacheModel.format = null;
		}

		ticketCommentCacheModel.visibility = getVisibility();

		ticketCommentCacheModel.settings = getSettings();

		String settings = ticketCommentCacheModel.settings;

		if ((settings != null) && (settings.length() == 0)) {
			ticketCommentCacheModel.settings = null;
		}

		ticketCommentCacheModel.status = getStatus();

		return ticketCommentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketComment, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketComment, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketComment, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketComment)this));
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
		Map<String, Function<TicketComment, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketComment, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketComment, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketComment)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TicketComment>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketCommentId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _ticketEntryId;
	private long _originalTicketEntryId;
	private boolean _setOriginalTicketEntryId;
	private long _ticketCommunicationId;
	private long _originalTicketCommunicationId;
	private boolean _setOriginalTicketCommunicationId;
	private String _body;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private String _format;
	private int _visibility;
	private int _originalVisibility;
	private boolean _setOriginalVisibility;
	private String _settings;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private TicketComment _escapedModel;

}