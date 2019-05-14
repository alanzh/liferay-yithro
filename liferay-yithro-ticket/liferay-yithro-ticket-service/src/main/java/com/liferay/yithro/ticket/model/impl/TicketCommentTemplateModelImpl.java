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
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.ticket.model.TicketCommentTemplate;
import com.liferay.yithro.ticket.model.TicketCommentTemplateModel;
import com.liferay.yithro.ticket.model.TicketCommentTemplateSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the TicketCommentTemplate service. Represents a row in the &quot;Yithro_TicketCommentTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketCommentTemplateModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketCommentTemplateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplateImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketCommentTemplateModelImpl
	extends BaseModelImpl<TicketCommentTemplate>
	implements TicketCommentTemplateModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket comment template model instance should use the <code>TicketCommentTemplate</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketCommentTemplate";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketCommentTemplateId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"content", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketCommentTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketCommentTemplate (ticketCommentTemplateId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name STRING null,content STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table Yithro_TicketCommentTemplate";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketCommentTemplate.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketCommentTemplate.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

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
	public static TicketCommentTemplate toModel(
		TicketCommentTemplateSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		TicketCommentTemplate model = new TicketCommentTemplateImpl();

		model.setTicketCommentTemplateId(
			soapModel.getTicketCommentTemplateId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setContent(soapModel.getContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketCommentTemplate> toModels(
		TicketCommentTemplateSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<TicketCommentTemplate> models =
			new ArrayList<TicketCommentTemplate>(soapModels.length);

		for (TicketCommentTemplateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketCommentTemplateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketCommentTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketCommentTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketCommentTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketCommentTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return TicketCommentTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketCommentTemplate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketCommentTemplate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketCommentTemplate, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketCommentTemplate)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketCommentTemplate, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketCommentTemplate, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketCommentTemplate)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketCommentTemplate, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketCommentTemplate, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TicketCommentTemplate, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketCommentTemplate, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketCommentTemplate, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<TicketCommentTemplate, Object>>();
		Map<String, BiConsumer<TicketCommentTemplate, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<TicketCommentTemplate, ?>>();

		attributeGetterFunctions.put(
			"ticketCommentTemplateId",
			TicketCommentTemplate::getTicketCommentTemplateId);
		attributeSetterBiConsumers.put(
			"ticketCommentTemplateId",
			(BiConsumer<TicketCommentTemplate, Long>)
				TicketCommentTemplate::setTicketCommentTemplateId);
		attributeGetterFunctions.put(
			"companyId", TicketCommentTemplate::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketCommentTemplate, Long>)
				TicketCommentTemplate::setCompanyId);
		attributeGetterFunctions.put(
			"userId", TicketCommentTemplate::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<TicketCommentTemplate, Long>)
				TicketCommentTemplate::setUserId);
		attributeGetterFunctions.put(
			"userName", TicketCommentTemplate::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TicketCommentTemplate, String>)
				TicketCommentTemplate::setUserName);
		attributeGetterFunctions.put(
			"createDate", TicketCommentTemplate::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketCommentTemplate, Date>)
				TicketCommentTemplate::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TicketCommentTemplate::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketCommentTemplate, Date>)
				TicketCommentTemplate::setModifiedDate);
		attributeGetterFunctions.put("name", TicketCommentTemplate::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<TicketCommentTemplate, String>)
				TicketCommentTemplate::setName);
		attributeGetterFunctions.put(
			"content", TicketCommentTemplate::getContent);
		attributeSetterBiConsumers.put(
			"content",
			(BiConsumer<TicketCommentTemplate, String>)
				TicketCommentTemplate::setContent);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketCommentTemplateId() {
		return _ticketCommentTemplateId;
	}

	@Override
	public void setTicketCommentTemplateId(long ticketCommentTemplateId) {
		_ticketCommentTemplateId = ticketCommentTemplateId;
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

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public String getContent(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId);
	}

	@Override
	public String getContent(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId, useDefault);
	}

	@Override
	public String getContent(String languageId) {
		return LocalizationUtil.getLocalization(getContent(), languageId);
	}

	@Override
	public String getContent(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getContent(), languageId, useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return _contentCurrentLanguageId;
	}

	@JSON
	@Override
	public String getContentCurrentValue() {
		Locale locale = getLocale(_contentCurrentLanguageId);

		return getContent(locale);
	}

	@Override
	public Map<Locale, String> getContentMap() {
		return LocalizationUtil.getLocalizationMap(getContent());
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public void setContent(String content, Locale locale) {
		setContent(content, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setContent(
		String content, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(content)) {
			setContent(
				LocalizationUtil.updateLocalization(
					getContent(), "Content", content, languageId,
					defaultLanguageId));
		}
		else {
			setContent(
				LocalizationUtil.removeLocalization(
					getContent(), "Content", languageId));
		}
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		_contentCurrentLanguageId = languageId;
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap) {
		setContentMap(contentMap, LocaleUtil.getDefault());
	}

	@Override
	public void setContentMap(
		Map<Locale, String> contentMap, Locale defaultLocale) {

		if (contentMap == null) {
			return;
		}

		setContent(
			LocalizationUtil.updateLocalization(
				contentMap, getContent(), "Content",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketCommentTemplate.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> contentMap = getContentMap();

		for (Map.Entry<Locale, String> entry : contentMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			TicketCommentTemplate.class.getName(), getPrimaryKey(),
			defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String content = getContent(defaultLocale);

		if (Validator.isNull(content)) {
			setContent(getContent(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setContent(getContent(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public TicketCommentTemplate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TicketCommentTemplate)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketCommentTemplateImpl ticketCommentTemplateImpl =
			new TicketCommentTemplateImpl();

		ticketCommentTemplateImpl.setTicketCommentTemplateId(
			getTicketCommentTemplateId());
		ticketCommentTemplateImpl.setCompanyId(getCompanyId());
		ticketCommentTemplateImpl.setUserId(getUserId());
		ticketCommentTemplateImpl.setUserName(getUserName());
		ticketCommentTemplateImpl.setCreateDate(getCreateDate());
		ticketCommentTemplateImpl.setModifiedDate(getModifiedDate());
		ticketCommentTemplateImpl.setName(getName());
		ticketCommentTemplateImpl.setContent(getContent());

		ticketCommentTemplateImpl.resetOriginalValues();

		return ticketCommentTemplateImpl;
	}

	@Override
	public int compareTo(TicketCommentTemplate ticketCommentTemplate) {
		int value = 0;

		value = getName().compareToIgnoreCase(ticketCommentTemplate.getName());

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

		if (!(obj instanceof TicketCommentTemplate)) {
			return false;
		}

		TicketCommentTemplate ticketCommentTemplate =
			(TicketCommentTemplate)obj;

		long primaryKey = ticketCommentTemplate.getPrimaryKey();

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
		TicketCommentTemplateModelImpl ticketCommentTemplateModelImpl = this;

		ticketCommentTemplateModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<TicketCommentTemplate> toCacheModel() {
		TicketCommentTemplateCacheModel ticketCommentTemplateCacheModel =
			new TicketCommentTemplateCacheModel();

		ticketCommentTemplateCacheModel.ticketCommentTemplateId =
			getTicketCommentTemplateId();

		ticketCommentTemplateCacheModel.companyId = getCompanyId();

		ticketCommentTemplateCacheModel.userId = getUserId();

		ticketCommentTemplateCacheModel.userName = getUserName();

		String userName = ticketCommentTemplateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ticketCommentTemplateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketCommentTemplateCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketCommentTemplateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketCommentTemplateCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			ticketCommentTemplateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketCommentTemplateCacheModel.name = getName();

		String name = ticketCommentTemplateCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ticketCommentTemplateCacheModel.name = null;
		}

		ticketCommentTemplateCacheModel.content = getContent();

		String content = ticketCommentTemplateCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			ticketCommentTemplateCacheModel.content = null;
		}

		return ticketCommentTemplateCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketCommentTemplate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketCommentTemplate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketCommentTemplate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((TicketCommentTemplate)this));
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
		Map<String, Function<TicketCommentTemplate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketCommentTemplate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketCommentTemplate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((TicketCommentTemplate)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TicketCommentTemplate.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TicketCommentTemplate.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketCommentTemplateId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _content;
	private String _contentCurrentLanguageId;
	private TicketCommentTemplate _escapedModel;

}