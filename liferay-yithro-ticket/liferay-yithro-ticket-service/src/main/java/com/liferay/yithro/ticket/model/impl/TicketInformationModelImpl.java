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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.yithro.ticket.model.TicketInformation;
import com.liferay.yithro.ticket.model.TicketInformationModel;
import com.liferay.yithro.ticket.model.TicketInformationSoap;

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
 * The base model implementation for the TicketInformation service. Represents a row in the &quot;Yithro_TicketInformation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketInformationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketInformationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketInformationImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketInformationModelImpl
	extends BaseModelImpl<TicketInformation> implements TicketInformationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket information model instance should use the <code>TicketInformation</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketInformation";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketInformationId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"ticketEntryId", Types.BIGINT}, {"fieldId", Types.BIGINT},
		{"data_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketInformationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ticketEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fieldId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("data_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketInformation (ticketInformationId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,ticketEntryId LONG,fieldId LONG,data_ STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table Yithro_TicketInformation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketInformation.ticketInformationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketInformation.ticketInformationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long FIELDID_COLUMN_BITMASK = 1L;

	public static final long TICKETENTRYID_COLUMN_BITMASK = 2L;

	public static final long TICKETINFORMATIONID_COLUMN_BITMASK = 4L;

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
	public static TicketInformation toModel(TicketInformationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketInformation model = new TicketInformationImpl();

		model.setTicketInformationId(soapModel.getTicketInformationId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTicketEntryId(soapModel.getTicketEntryId());
		model.setFieldId(soapModel.getFieldId());
		model.setData(soapModel.getData());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketInformation> toModels(
		TicketInformationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<TicketInformation> models = new ArrayList<TicketInformation>(
			soapModels.length);

		for (TicketInformationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketInformationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketInformationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketInformationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketInformationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketInformation.class;
	}

	@Override
	public String getModelClassName() {
		return TicketInformation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketInformation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketInformation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketInformation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketInformation)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketInformation, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketInformation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketInformation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketInformation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketInformation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TicketInformation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketInformation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketInformation, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<TicketInformation, Object>>();
		Map<String, BiConsumer<TicketInformation, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<TicketInformation, ?>>();

		attributeGetterFunctions.put(
			"ticketInformationId", TicketInformation::getTicketInformationId);
		attributeSetterBiConsumers.put(
			"ticketInformationId",
			(BiConsumer<TicketInformation, Long>)
				TicketInformation::setTicketInformationId);
		attributeGetterFunctions.put(
			"companyId", TicketInformation::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketInformation, Long>)
				TicketInformation::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", TicketInformation::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketInformation, Date>)
				TicketInformation::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TicketInformation::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketInformation, Date>)
				TicketInformation::setModifiedDate);
		attributeGetterFunctions.put(
			"ticketEntryId", TicketInformation::getTicketEntryId);
		attributeSetterBiConsumers.put(
			"ticketEntryId",
			(BiConsumer<TicketInformation, Long>)
				TicketInformation::setTicketEntryId);
		attributeGetterFunctions.put("fieldId", TicketInformation::getFieldId);
		attributeSetterBiConsumers.put(
			"fieldId",
			(BiConsumer<TicketInformation, Long>)TicketInformation::setFieldId);
		attributeGetterFunctions.put("data", TicketInformation::getData);
		attributeSetterBiConsumers.put(
			"data",
			(BiConsumer<TicketInformation, String>)TicketInformation::setData);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketInformationId() {
		return _ticketInformationId;
	}

	@Override
	public void setTicketInformationId(long ticketInformationId) {
		_ticketInformationId = ticketInformationId;
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
	public long getFieldId() {
		return _fieldId;
	}

	@Override
	public void setFieldId(long fieldId) {
		_columnBitmask |= FIELDID_COLUMN_BITMASK;

		if (!_setOriginalFieldId) {
			_setOriginalFieldId = true;

			_originalFieldId = _fieldId;
		}

		_fieldId = fieldId;
	}

	public long getOriginalFieldId() {
		return _originalFieldId;
	}

	@JSON
	@Override
	public String getData() {
		if (_data == null) {
			return "";
		}
		else {
			return _data;
		}
	}

	@Override
	public void setData(String data) {
		_data = data;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketInformation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TicketInformation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TicketInformation)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketInformationImpl ticketInformationImpl =
			new TicketInformationImpl();

		ticketInformationImpl.setTicketInformationId(getTicketInformationId());
		ticketInformationImpl.setCompanyId(getCompanyId());
		ticketInformationImpl.setCreateDate(getCreateDate());
		ticketInformationImpl.setModifiedDate(getModifiedDate());
		ticketInformationImpl.setTicketEntryId(getTicketEntryId());
		ticketInformationImpl.setFieldId(getFieldId());
		ticketInformationImpl.setData(getData());

		ticketInformationImpl.resetOriginalValues();

		return ticketInformationImpl;
	}

	@Override
	public int compareTo(TicketInformation ticketInformation) {
		long primaryKey = ticketInformation.getPrimaryKey();

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

		if (!(obj instanceof TicketInformation)) {
			return false;
		}

		TicketInformation ticketInformation = (TicketInformation)obj;

		long primaryKey = ticketInformation.getPrimaryKey();

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
		TicketInformationModelImpl ticketInformationModelImpl = this;

		ticketInformationModelImpl._setModifiedDate = false;

		ticketInformationModelImpl._originalTicketEntryId =
			ticketInformationModelImpl._ticketEntryId;

		ticketInformationModelImpl._setOriginalTicketEntryId = false;

		ticketInformationModelImpl._originalFieldId =
			ticketInformationModelImpl._fieldId;

		ticketInformationModelImpl._setOriginalFieldId = false;

		ticketInformationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketInformation> toCacheModel() {
		TicketInformationCacheModel ticketInformationCacheModel =
			new TicketInformationCacheModel();

		ticketInformationCacheModel.ticketInformationId =
			getTicketInformationId();

		ticketInformationCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketInformationCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketInformationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketInformationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ticketInformationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketInformationCacheModel.ticketEntryId = getTicketEntryId();

		ticketInformationCacheModel.fieldId = getFieldId();

		ticketInformationCacheModel.data = getData();

		String data = ticketInformationCacheModel.data;

		if ((data != null) && (data.length() == 0)) {
			ticketInformationCacheModel.data = null;
		}

		return ticketInformationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketInformation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketInformation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketInformation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketInformation)this));
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
		Map<String, Function<TicketInformation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketInformation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketInformation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketInformation)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TicketInformation.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TicketInformation.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketInformationId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _ticketEntryId;
	private long _originalTicketEntryId;
	private boolean _setOriginalTicketEntryId;
	private long _fieldId;
	private long _originalFieldId;
	private boolean _setOriginalFieldId;
	private String _data;
	private long _columnBitmask;
	private TicketInformation _escapedModel;

}