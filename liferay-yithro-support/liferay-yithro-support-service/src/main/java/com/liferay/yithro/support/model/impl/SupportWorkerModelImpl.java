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

package com.liferay.yithro.support.model.impl;

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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.yithro.support.model.SupportWorker;
import com.liferay.yithro.support.model.SupportWorkerModel;
import com.liferay.yithro.support.model.SupportWorkerSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SupportWorker service. Represents a row in the &quot;Yithro_SupportWorker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>SupportWorkerModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SupportWorkerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SupportWorkerModelImpl
	extends BaseModelImpl<SupportWorker> implements SupportWorkerModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a support worker model instance should use the <code>SupportWorker</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_SupportWorker";

	public static final Object[][] TABLE_COLUMNS = {
		{"supportWorkerId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"supportTeamId", Types.BIGINT}, {"supportLaborId", Types.BIGINT},
		{"assignedWork", Types.DOUBLE}, {"maxWork", Types.DOUBLE},
		{"role_", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("supportWorkerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supportTeamId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supportLaborId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("assignedWork", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("maxWork", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("role_", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_SupportWorker (supportWorkerId LONG not null primary key,userId LONG,supportTeamId LONG,supportLaborId LONG,assignedWork DOUBLE,maxWork DOUBLE,role_ INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table Yithro_SupportWorker";

	public static final String ORDER_BY_JPQL =
		" ORDER BY supportWorker.supportWorkerId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_SupportWorker.supportWorkerId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long MAXWORK_COLUMN_BITMASK = 1L;

	public static final long ROLE_COLUMN_BITMASK = 2L;

	public static final long SUPPORTLABORID_COLUMN_BITMASK = 4L;

	public static final long SUPPORTTEAMID_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long SUPPORTWORKERID_COLUMN_BITMASK = 32L;

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
	public static SupportWorker toModel(SupportWorkerSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SupportWorker model = new SupportWorkerImpl();

		model.setSupportWorkerId(soapModel.getSupportWorkerId());
		model.setUserId(soapModel.getUserId());
		model.setSupportTeamId(soapModel.getSupportTeamId());
		model.setSupportLaborId(soapModel.getSupportLaborId());
		model.setAssignedWork(soapModel.getAssignedWork());
		model.setMaxWork(soapModel.getMaxWork());
		model.setRole(soapModel.getRole());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SupportWorker> toModels(SupportWorkerSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SupportWorker> models = new ArrayList<SupportWorker>(
			soapModels.length);

		for (SupportWorkerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SupportWorkerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _supportWorkerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupportWorkerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supportWorkerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SupportWorker.class;
	}

	@Override
	public String getModelClassName() {
		return SupportWorker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SupportWorker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SupportWorker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SupportWorker, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SupportWorker)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SupportWorker, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SupportWorker, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SupportWorker)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SupportWorker, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SupportWorker, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SupportWorker, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SupportWorker, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SupportWorker, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SupportWorker, Object>>();
		Map<String, BiConsumer<SupportWorker, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SupportWorker, ?>>();

		attributeGetterFunctions.put(
			"supportWorkerId", SupportWorker::getSupportWorkerId);
		attributeSetterBiConsumers.put(
			"supportWorkerId",
			(BiConsumer<SupportWorker, Long>)SupportWorker::setSupportWorkerId);
		attributeGetterFunctions.put("userId", SupportWorker::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SupportWorker, Long>)SupportWorker::setUserId);
		attributeGetterFunctions.put(
			"supportTeamId", SupportWorker::getSupportTeamId);
		attributeSetterBiConsumers.put(
			"supportTeamId",
			(BiConsumer<SupportWorker, Long>)SupportWorker::setSupportTeamId);
		attributeGetterFunctions.put(
			"supportLaborId", SupportWorker::getSupportLaborId);
		attributeSetterBiConsumers.put(
			"supportLaborId",
			(BiConsumer<SupportWorker, Long>)SupportWorker::setSupportLaborId);
		attributeGetterFunctions.put(
			"assignedWork", SupportWorker::getAssignedWork);
		attributeSetterBiConsumers.put(
			"assignedWork",
			(BiConsumer<SupportWorker, Double>)SupportWorker::setAssignedWork);
		attributeGetterFunctions.put("maxWork", SupportWorker::getMaxWork);
		attributeSetterBiConsumers.put(
			"maxWork",
			(BiConsumer<SupportWorker, Double>)SupportWorker::setMaxWork);
		attributeGetterFunctions.put("role", SupportWorker::getRole);
		attributeSetterBiConsumers.put(
			"role", (BiConsumer<SupportWorker, Integer>)SupportWorker::setRole);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getSupportWorkerId() {
		return _supportWorkerId;
	}

	@Override
	public void setSupportWorkerId(long supportWorkerId) {
		_supportWorkerId = supportWorkerId;
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
	public long getSupportTeamId() {
		return _supportTeamId;
	}

	@Override
	public void setSupportTeamId(long supportTeamId) {
		_columnBitmask |= SUPPORTTEAMID_COLUMN_BITMASK;

		if (!_setOriginalSupportTeamId) {
			_setOriginalSupportTeamId = true;

			_originalSupportTeamId = _supportTeamId;
		}

		_supportTeamId = supportTeamId;
	}

	public long getOriginalSupportTeamId() {
		return _originalSupportTeamId;
	}

	@JSON
	@Override
	public long getSupportLaborId() {
		return _supportLaborId;
	}

	@Override
	public void setSupportLaborId(long supportLaborId) {
		_columnBitmask |= SUPPORTLABORID_COLUMN_BITMASK;

		if (!_setOriginalSupportLaborId) {
			_setOriginalSupportLaborId = true;

			_originalSupportLaborId = _supportLaborId;
		}

		_supportLaborId = supportLaborId;
	}

	public long getOriginalSupportLaborId() {
		return _originalSupportLaborId;
	}

	@JSON
	@Override
	public double getAssignedWork() {
		return _assignedWork;
	}

	@Override
	public void setAssignedWork(double assignedWork) {
		_assignedWork = assignedWork;
	}

	@JSON
	@Override
	public double getMaxWork() {
		return _maxWork;
	}

	@Override
	public void setMaxWork(double maxWork) {
		_columnBitmask |= MAXWORK_COLUMN_BITMASK;

		if (!_setOriginalMaxWork) {
			_setOriginalMaxWork = true;

			_originalMaxWork = _maxWork;
		}

		_maxWork = maxWork;
	}

	public double getOriginalMaxWork() {
		return _originalMaxWork;
	}

	@JSON
	@Override
	public int getRole() {
		return _role;
	}

	@Override
	public void setRole(int role) {
		_columnBitmask |= ROLE_COLUMN_BITMASK;

		if (!_setOriginalRole) {
			_setOriginalRole = true;

			_originalRole = _role;
		}

		_role = role;
	}

	public int getOriginalRole() {
		return _originalRole;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, SupportWorker.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SupportWorker toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SupportWorker)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SupportWorkerImpl supportWorkerImpl = new SupportWorkerImpl();

		supportWorkerImpl.setSupportWorkerId(getSupportWorkerId());
		supportWorkerImpl.setUserId(getUserId());
		supportWorkerImpl.setSupportTeamId(getSupportTeamId());
		supportWorkerImpl.setSupportLaborId(getSupportLaborId());
		supportWorkerImpl.setAssignedWork(getAssignedWork());
		supportWorkerImpl.setMaxWork(getMaxWork());
		supportWorkerImpl.setRole(getRole());

		supportWorkerImpl.resetOriginalValues();

		return supportWorkerImpl;
	}

	@Override
	public int compareTo(SupportWorker supportWorker) {
		long primaryKey = supportWorker.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupportWorker)) {
			return false;
		}

		SupportWorker supportWorker = (SupportWorker)obj;

		long primaryKey = supportWorker.getPrimaryKey();

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
		SupportWorkerModelImpl supportWorkerModelImpl = this;

		supportWorkerModelImpl._originalUserId = supportWorkerModelImpl._userId;

		supportWorkerModelImpl._setOriginalUserId = false;

		supportWorkerModelImpl._originalSupportTeamId =
			supportWorkerModelImpl._supportTeamId;

		supportWorkerModelImpl._setOriginalSupportTeamId = false;

		supportWorkerModelImpl._originalSupportLaborId =
			supportWorkerModelImpl._supportLaborId;

		supportWorkerModelImpl._setOriginalSupportLaborId = false;

		supportWorkerModelImpl._originalMaxWork =
			supportWorkerModelImpl._maxWork;

		supportWorkerModelImpl._setOriginalMaxWork = false;

		supportWorkerModelImpl._originalRole = supportWorkerModelImpl._role;

		supportWorkerModelImpl._setOriginalRole = false;

		supportWorkerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SupportWorker> toCacheModel() {
		SupportWorkerCacheModel supportWorkerCacheModel =
			new SupportWorkerCacheModel();

		supportWorkerCacheModel.supportWorkerId = getSupportWorkerId();

		supportWorkerCacheModel.userId = getUserId();

		supportWorkerCacheModel.supportTeamId = getSupportTeamId();

		supportWorkerCacheModel.supportLaborId = getSupportLaborId();

		supportWorkerCacheModel.assignedWork = getAssignedWork();

		supportWorkerCacheModel.maxWork = getMaxWork();

		supportWorkerCacheModel.role = getRole();

		return supportWorkerCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SupportWorker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SupportWorker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SupportWorker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SupportWorker)this));
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
		Map<String, Function<SupportWorker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SupportWorker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SupportWorker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SupportWorker)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		SupportWorker.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		SupportWorker.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _supportWorkerId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _supportTeamId;
	private long _originalSupportTeamId;
	private boolean _setOriginalSupportTeamId;
	private long _supportLaborId;
	private long _originalSupportLaborId;
	private boolean _setOriginalSupportLaborId;
	private double _assignedWork;
	private double _maxWork;
	private double _originalMaxWork;
	private boolean _setOriginalMaxWork;
	private int _role;
	private int _originalRole;
	private boolean _setOriginalRole;
	private long _columnBitmask;
	private SupportWorker _escapedModel;

}