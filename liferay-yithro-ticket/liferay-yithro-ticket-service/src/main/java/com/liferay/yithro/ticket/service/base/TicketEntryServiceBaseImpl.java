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

package com.liferay.yithro.ticket.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.service.TicketEntryService;
import com.liferay.yithro.ticket.service.persistence.TicketAttachmentPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketCommentPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketCommentTemplatePersistence;
import com.liferay.yithro.ticket.service.persistence.TicketCommunicationPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketEntryPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFieldDataPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFieldOptionPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFieldPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketFlagPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketLinkPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketStatusPersistence;
import com.liferay.yithro.ticket.service.persistence.TicketStructurePersistence;
import com.liferay.yithro.ticket.service.persistence.TicketWorkerPersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the ticket entry remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.yithro.ticket.service.impl.TicketEntryServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.yithro.ticket.service.impl.TicketEntryServiceImpl
 * @generated
 */
public abstract class TicketEntryServiceBaseImpl
	extends BaseServiceImpl
	implements TicketEntryService, AopService, IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TicketEntryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.yithro.ticket.service.TicketEntryServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TicketEntryService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ticketEntryService = (TicketEntryService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TicketEntryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TicketEntry.class;
	}

	protected String getModelClassName() {
		return TicketEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ticketEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected TicketAttachmentPersistence ticketAttachmentPersistence;

	@Reference
	protected TicketCommentPersistence ticketCommentPersistence;

	@Reference
	protected TicketCommentTemplatePersistence ticketCommentTemplatePersistence;

	@Reference
	protected TicketCommunicationPersistence ticketCommunicationPersistence;

	@Reference
	protected com.liferay.yithro.ticket.service.TicketEntryLocalService
		ticketEntryLocalService;

	protected TicketEntryService ticketEntryService;

	@Reference
	protected TicketEntryPersistence ticketEntryPersistence;

	@Reference
	protected TicketFieldPersistence ticketFieldPersistence;

	@Reference
	protected TicketFieldDataPersistence ticketFieldDataPersistence;

	@Reference
	protected TicketFieldOptionPersistence ticketFieldOptionPersistence;

	@Reference
	protected TicketFlagPersistence ticketFlagPersistence;

	@Reference
	protected TicketLinkPersistence ticketLinkPersistence;

	@Reference
	protected TicketStatusPersistence ticketStatusPersistence;

	@Reference
	protected TicketStructurePersistence ticketStructurePersistence;

	@Reference
	protected TicketWorkerPersistence ticketWorkerPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.mail.kernel.service.MailService mailService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.CompanyLocalService
		companyLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.CompanyService companyService;

	@Reference
	protected com.liferay.portal.kernel.service.OrganizationLocalService
		organizationLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.OrganizationService
		organizationService;

	@Reference
	protected com.liferay.portal.kernel.service.PortletPreferencesLocalService
		portletPreferencesLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.PortletPreferencesService
		portletPreferencesService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.SubscriptionLocalService
		subscriptionLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}