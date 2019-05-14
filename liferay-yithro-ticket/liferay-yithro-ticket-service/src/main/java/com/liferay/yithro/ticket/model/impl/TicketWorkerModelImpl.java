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
import com.liferay.yithro.ticket.model.TicketWorker;
import com.liferay.yithro.ticket.model.TicketWorkerModel;
import com.liferay.yithro.ticket.model.TicketWorkerSoap;

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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the TicketWorker service. Represents a row in the &quot;Yithro_TicketWorker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketWorkerModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketWorkerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorkerImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketWorkerModelImpl
	extends BaseModelImpl<TicketWorker> implements TicketWorkerModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket worker model instance should use the <code>TicketWorker</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketWorker";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketWorkerId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"ticketEntryId", Types.BIGINT},
		{"sourceClassNameId", Types.BIGINT}, {"sourceClassPK", Types.BIGINT},
		{"role_", Types.INTEGER}, {"primary_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketWorkerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ticketEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sourceClassNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sourceClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("role_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("primary_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketWorker (ticketWorkerId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,ticketEntryId LONG,sourceClassNameId LONG,sourceClassPK LONG,role_ INTEGER,primary_ BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table Yithro_TicketWorker";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketWorker.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketWorker.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long PRIMARY_COLUMN_BITMASK = 1L;

	public static final long SOURCECLASSNAMEID_COLUMN_BITMASK = 2L;

	public static final long SOURCECLASSPK_COLUMN_BITMASK = 4L;

	public static final long TICKETENTRYID_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long CREATEDATE_COLUMN_BITMASK = 32L;

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
	public static TicketWorker toModel(TicketWorkerSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketWorker model = new TicketWorkerImpl();

		model.setTicketWorkerId(soapModel.getTicketWorkerId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setTicketEntryId(soapModel.getTicketEntryId());
		model.setSourceClassNameId(soapModel.getSourceClassNameId());
		model.setSourceClassPK(soapModel.getSourceClassPK());
		model.setRole(soapModel.getRole());
		model.setPrimary(soapModel.isPrimary());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketWorker> toModels(TicketWorkerSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TicketWorker> models = new ArrayList<TicketWorker>(
			soapModels.length);

		for (TicketWorkerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketWorkerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketWorkerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketWorkerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketWorkerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketWorker.class;
	}

	@Override
	public String getModelClassName() {
		return TicketWorker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketWorker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketWorker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketWorker, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketWorker)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketWorker, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketWorker, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketWorker)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketWorker, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketWorker, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TicketWorker, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketWorker, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketWorker, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TicketWorker, Object>>();
		Map<String, BiConsumer<TicketWorker, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TicketWorker, ?>>();

		attributeGetterFunctions.put(
			"ticketWorkerId", TicketWorker::getTicketWorkerId);
		attributeSetterBiConsumers.put(
			"ticketWorkerId",
			(BiConsumer<TicketWorker, Long>)TicketWorker::setTicketWorkerId);
		attributeGetterFunctions.put("companyId", TicketWorker::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketWorker, Long>)TicketWorker::setCompanyId);
		attributeGetterFunctions.put("userId", TicketWorker::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TicketWorker, Long>)TicketWorker::setUserId);
		attributeGetterFunctions.put("userName", TicketWorker::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TicketWorker, String>)TicketWorker::setUserName);
		attributeGetterFunctions.put("createDate", TicketWorker::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketWorker, Date>)TicketWorker::setCreateDate);
		attributeGetterFunctions.put(
			"ticketEntryId", TicketWorker::getTicketEntryId);
		attributeSetterBiConsumers.put(
			"ticketEntryId",
			(BiConsumer<TicketWorker, Long>)TicketWorker::setTicketEntryId);
		attributeGetterFunctions.put(
			"sourceClassNameId", TicketWorker::getSourceClassNameId);
		attributeSetterBiConsumers.put(
			"sourceClassNameId",
			(BiConsumer<TicketWorker, Long>)TicketWorker::setSourceClassNameId);
		attributeGetterFunctions.put(
			"sourceClassPK", TicketWorker::getSourceClassPK);
		attributeSetterBiConsumers.put(
			"sourceClassPK",
			(BiConsumer<TicketWorker, Long>)TicketWorker::setSourceClassPK);
		attributeGetterFunctions.put("role", TicketWorker::getRole);
		attributeSetterBiConsumers.put(
			"role", (BiConsumer<TicketWorker, Integer>)TicketWorker::setRole);
		attributeGetterFunctions.put("primary", TicketWorker::getPrimary);
		attributeSetterBiConsumers.put(
			"primary",
			(BiConsumer<TicketWorker, Boolean>)TicketWorker::setPrimary);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketWorkerId() {
		return _ticketWorkerId;
	}

	@Override
	public void setTicketWorkerId(long ticketWorkerId) {
		_ticketWorkerId = ticketWorkerId;
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
	public long getSourceClassNameId() {
		return _sourceClassNameId;
	}

	@Override
	public void setSourceClassNameId(long sourceClassNameId) {
		_columnBitmask |= SOURCECLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalSourceClassNameId) {
			_setOriginalSourceClassNameId = true;

			_originalSourceClassNameId = _sourceClassNameId;
		}

		_sourceClassNameId = sourceClassNameId;
	}

	public long getOriginalSourceClassNameId() {
		return _originalSourceClassNameId;
	}

	@JSON
	@Override
	public long getSourceClassPK() {
		return _sourceClassPK;
	}

	@Override
	public void setSourceClassPK(long sourceClassPK) {
		_columnBitmask |= SOURCECLASSPK_COLUMN_BITMASK;

		if (!_setOriginalSourceClassPK) {
			_setOriginalSourceClassPK = true;

			_originalSourceClassPK = _sourceClassPK;
		}

		_sourceClassPK = sourceClassPK;
	}

	public long getOriginalSourceClassPK() {
		return _originalSourceClassPK;
	}

	@JSON
	@Override
	public int getRole() {
		return _role;
	}

	@Override
	public void setRole(int role) {
		_role = role;
	}

	@JSON
	@Override
	public boolean getPrimary() {
		return _primary;
	}

	@JSON
	@Override
	public boolean isPrimary() {
		return _primary;
	}

	@Override
	public void setPrimary(boolean primary) {
		_columnBitmask |= PRIMARY_COLUMN_BITMASK;

		if (!_setOriginalPrimary) {
			_setOriginalPrimary = true;

			_originalPrimary = _primary;
		}

		_primary = primary;
	}

	public boolean getOriginalPrimary() {
		return _originalPrimary;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketWorker.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TicketWorker toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TicketWorker)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketWorkerImpl ticketWorkerImpl = new TicketWorkerImpl();

		ticketWorkerImpl.setTicketWorkerId(getTicketWorkerId());
		ticketWorkerImpl.setCompanyId(getCompanyId());
		ticketWorkerImpl.setUserId(getUserId());
		ticketWorkerImpl.setUserName(getUserName());
		ticketWorkerImpl.setCreateDate(getCreateDate());
		ticketWorkerImpl.setTicketEntryId(getTicketEntryId());
		ticketWorkerImpl.setSourceClassNameId(getSourceClassNameId());
		ticketWorkerImpl.setSourceClassPK(getSourceClassPK());
		ticketWorkerImpl.setRole(getRole());
		ticketWorkerImpl.setPrimary(isPrimary());

		ticketWorkerImpl.resetOriginalValues();

		return ticketWorkerImpl;
	}

	@Override
	public int compareTo(TicketWorker ticketWorker) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), ticketWorker.getCreateDate());

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

		if (!(obj instanceof TicketWorker)) {
			return false;
		}

		TicketWorker ticketWorker = (TicketWorker)obj;

		long primaryKey = ticketWorker.getPrimaryKey();

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
		TicketWorkerModelImpl ticketWorkerModelImpl = this;

		ticketWorkerModelImpl._originalUserId = ticketWorkerModelImpl._userId;

		ticketWorkerModelImpl._setOriginalUserId = false;

		ticketWorkerModelImpl._originalTicketEntryId =
			ticketWorkerModelImpl._ticketEntryId;

		ticketWorkerModelImpl._setOriginalTicketEntryId = false;

		ticketWorkerModelImpl._originalSourceClassNameId =
			ticketWorkerModelImpl._sourceClassNameId;

		ticketWorkerModelImpl._setOriginalSourceClassNameId = false;

		ticketWorkerModelImpl._originalSourceClassPK =
			ticketWorkerModelImpl._sourceClassPK;

		ticketWorkerModelImpl._setOriginalSourceClassPK = false;

		ticketWorkerModelImpl._originalPrimary = ticketWorkerModelImpl._primary;

		ticketWorkerModelImpl._setOriginalPrimary = false;

		ticketWorkerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketWorker> toCacheModel() {
		TicketWorkerCacheModel ticketWorkerCacheModel =
			new TicketWorkerCacheModel();

		ticketWorkerCacheModel.ticketWorkerId = getTicketWorkerId();

		ticketWorkerCacheModel.companyId = getCompanyId();

		ticketWorkerCacheModel.userId = getUserId();

		ticketWorkerCacheModel.userName = getUserName();

		String userName = ticketWorkerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ticketWorkerCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketWorkerCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketWorkerCacheModel.createDate = Long.MIN_VALUE;
		}

		ticketWorkerCacheModel.ticketEntryId = getTicketEntryId();

		ticketWorkerCacheModel.sourceClassNameId = getSourceClassNameId();

		ticketWorkerCacheModel.sourceClassPK = getSourceClassPK();

		ticketWorkerCacheModel.role = getRole();

		ticketWorkerCacheModel.primary = isPrimary();

		return ticketWorkerCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketWorker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketWorker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketWorker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketWorker)this));
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
		Map<String, Function<TicketWorker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketWorker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketWorker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketWorker)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TicketWorker.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TicketWorker.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketWorkerId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private long _ticketEntryId;
	private long _originalTicketEntryId;
	private boolean _setOriginalTicketEntryId;
	private long _sourceClassNameId;
	private long _originalSourceClassNameId;
	private boolean _setOriginalSourceClassNameId;
	private long _sourceClassPK;
	private long _originalSourceClassPK;
	private boolean _setOriginalSourceClassPK;
	private int _role;
	private boolean _primary;
	private boolean _originalPrimary;
	private boolean _setOriginalPrimary;
	private long _columnBitmask;
	private TicketWorker _escapedModel;

}