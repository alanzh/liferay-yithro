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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TicketCommentTemplate service. Represents a row in the &quot;Yithro_TicketCommentTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplate
 * @generated
 */
@ProviderType
public interface TicketCommentTemplateModel
	extends AuditedModel, BaseModel<TicketCommentTemplate>, LocalizedModel,
			ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket comment template model instance should use the {@link TicketCommentTemplate} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket comment template.
	 *
	 * @return the primary key of this ticket comment template
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket comment template.
	 *
	 * @param primaryKey the primary key of this ticket comment template
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket comment template ID of this ticket comment template.
	 *
	 * @return the ticket comment template ID of this ticket comment template
	 */
	public long getTicketCommentTemplateId();

	/**
	 * Sets the ticket comment template ID of this ticket comment template.
	 *
	 * @param ticketCommentTemplateId the ticket comment template ID of this ticket comment template
	 */
	public void setTicketCommentTemplateId(long ticketCommentTemplateId);

	/**
	 * Returns the company ID of this ticket comment template.
	 *
	 * @return the company ID of this ticket comment template
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket comment template.
	 *
	 * @param companyId the company ID of this ticket comment template
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ticket comment template.
	 *
	 * @return the user ID of this ticket comment template
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ticket comment template.
	 *
	 * @param userId the user ID of this ticket comment template
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ticket comment template.
	 *
	 * @return the user uuid of this ticket comment template
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ticket comment template.
	 *
	 * @param userUuid the user uuid of this ticket comment template
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ticket comment template.
	 *
	 * @return the user name of this ticket comment template
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ticket comment template.
	 *
	 * @param userName the user name of this ticket comment template
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ticket comment template.
	 *
	 * @return the create date of this ticket comment template
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket comment template.
	 *
	 * @param createDate the create date of this ticket comment template
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ticket comment template.
	 *
	 * @return the modified date of this ticket comment template
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ticket comment template.
	 *
	 * @param modifiedDate the modified date of this ticket comment template
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this ticket comment template.
	 *
	 * @return the name of this ticket comment template
	 */
	public String getName();

	/**
	 * Returns the localized name of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this ticket comment template
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket comment template. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this ticket comment template
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket comment template
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this ticket comment template.
	 *
	 * @return the locales and localized names of this ticket comment template
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this ticket comment template.
	 *
	 * @param name the name of this ticket comment template
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this ticket comment template in the language.
	 *
	 * @param name the localized name of this ticket comment template
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this ticket comment template in the language, and sets the default locale.
	 *
	 * @param name the localized name of this ticket comment template
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this ticket comment template from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this ticket comment template
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this ticket comment template from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this ticket comment template
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the content of this ticket comment template.
	 *
	 * @return the content of this ticket comment template
	 */
	public String getContent();

	/**
	 * Returns the localized content of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized content of this ticket comment template
	 */
	@AutoEscape
	public String getContent(Locale locale);

	/**
	 * Returns the localized content of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this ticket comment template. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getContent(Locale locale, boolean useDefault);

	/**
	 * Returns the localized content of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized content of this ticket comment template
	 */
	@AutoEscape
	public String getContent(String languageId);

	/**
	 * Returns the localized content of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this ticket comment template
	 */
	@AutoEscape
	public String getContent(String languageId, boolean useDefault);

	@AutoEscape
	public String getContentCurrentLanguageId();

	@AutoEscape
	public String getContentCurrentValue();

	/**
	 * Returns a map of the locales and localized contents of this ticket comment template.
	 *
	 * @return the locales and localized contents of this ticket comment template
	 */
	public Map<Locale, String> getContentMap();

	/**
	 * Sets the content of this ticket comment template.
	 *
	 * @param content the content of this ticket comment template
	 */
	public void setContent(String content);

	/**
	 * Sets the localized content of this ticket comment template in the language.
	 *
	 * @param content the localized content of this ticket comment template
	 * @param locale the locale of the language
	 */
	public void setContent(String content, Locale locale);

	/**
	 * Sets the localized content of this ticket comment template in the language, and sets the default locale.
	 *
	 * @param content the localized content of this ticket comment template
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setContent(String content, Locale locale, Locale defaultLocale);

	public void setContentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized contents of this ticket comment template from the map of locales and localized contents.
	 *
	 * @param contentMap the locales and localized contents of this ticket comment template
	 */
	public void setContentMap(Map<Locale, String> contentMap);

	/**
	 * Sets the localized contents of this ticket comment template from the map of locales and localized contents, and sets the default locale.
	 *
	 * @param contentMap the locales and localized contents of this ticket comment template
	 * @param defaultLocale the default locale
	 */
	public void setContentMap(
		Map<Locale, String> contentMap, Locale defaultLocale);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}