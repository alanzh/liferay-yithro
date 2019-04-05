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

package com.liferay.yithro.audit.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.audit.exception.NoSuchAuditEntryException;
import com.liferay.yithro.audit.model.AuditEntry;
import com.liferay.yithro.audit.model.impl.AuditEntryImpl;
import com.liferay.yithro.audit.model.impl.AuditEntryModelImpl;
import com.liferay.yithro.audit.service.persistence.AuditEntryPersistence;
import com.liferay.yithro.audit.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuditEntryPersistence.class)
@ProviderType
public class AuditEntryPersistenceImpl
	extends BasePersistenceImpl<AuditEntry> implements AuditEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuditEntryUtil</code> to access the audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuditEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGtCD_C;
	private FinderPath _finderPathWithPaginationCountByGtCD_C;

	/**
	 * Returns all the audit entries where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @return the matching audit entries
	 */
	@Override
	public List<AuditEntry> findByGtCD_C(Date createDate, long classNameId) {
		return findByGtCD_C(
			createDate, classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the audit entries where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByGtCD_C(
		Date createDate, long classNameId, int start, int end) {

		return findByGtCD_C(createDate, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit entries where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByGtCD_C(
		Date createDate, long classNameId, int start, int end,
		OrderByComparator<AuditEntry> orderByComparator) {

		return findByGtCD_C(
			createDate, classNameId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the audit entries where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByGtCD_C(
		Date createDate, long classNameId, int start, int end,
		OrderByComparator<AuditEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByGtCD_C;
		finderArgs = new Object[] {
			_getTime(createDate), classNameId, start, end, orderByComparator
		};

		List<AuditEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AuditEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditEntry auditEntry : list) {
					if ((createDate.getTime() >=
							auditEntry.getCreateDate().getTime()) ||
						(classNameId != auditEntry.getClassNameId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_AUDITENTRY_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_GTCD_C_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_GTCD_C_CREATEDATE_2);
			}

			query.append(_FINDER_COLUMN_GTCD_C_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit entry in the ordered set where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByGtCD_C_First(
			Date createDate, long classNameId,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByGtCD_C_First(
			createDate, classNameId, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the first audit entry in the ordered set where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByGtCD_C_First(
		Date createDate, long classNameId,
		OrderByComparator<AuditEntry> orderByComparator) {

		List<AuditEntry> list = findByGtCD_C(
			createDate, classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit entry in the ordered set where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByGtCD_C_Last(
			Date createDate, long classNameId,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByGtCD_C_Last(
			createDate, classNameId, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the last audit entry in the ordered set where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByGtCD_C_Last(
		Date createDate, long classNameId,
		OrderByComparator<AuditEntry> orderByComparator) {

		int count = countByGtCD_C(createDate, classNameId);

		if (count == 0) {
			return null;
		}

		List<AuditEntry> list = findByGtCD_C(
			createDate, classNameId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry[] findByGtCD_C_PrevAndNext(
			long auditEntryId, Date createDate, long classNameId,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = findByPrimaryKey(auditEntryId);

		Session session = null;

		try {
			session = openSession();

			AuditEntry[] array = new AuditEntryImpl[3];

			array[0] = getByGtCD_C_PrevAndNext(
				session, auditEntry, createDate, classNameId, orderByComparator,
				true);

			array[1] = auditEntry;

			array[2] = getByGtCD_C_PrevAndNext(
				session, auditEntry, createDate, classNameId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditEntry getByGtCD_C_PrevAndNext(
		Session session, AuditEntry auditEntry, Date createDate,
		long classNameId, OrderByComparator<AuditEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AUDITENTRY_WHERE);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_GTCD_C_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_GTCD_C_CREATEDATE_2);
		}

		query.append(_FINDER_COLUMN_GTCD_C_CLASSNAMEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		qPos.add(classNameId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AuditEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit entries where createDate &gt; &#63; and classNameId = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 */
	@Override
	public void removeByGtCD_C(Date createDate, long classNameId) {
		for (AuditEntry auditEntry :
				findByGtCD_C(
					createDate, classNameId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(auditEntry);
		}
	}

	/**
	 * Returns the number of audit entries where createDate &gt; &#63; and classNameId = &#63;.
	 *
	 * @param createDate the create date
	 * @param classNameId the class name ID
	 * @return the number of matching audit entries
	 */
	@Override
	public int countByGtCD_C(Date createDate, long classNameId) {
		FinderPath finderPath = _finderPathWithPaginationCountByGtCD_C;

		Object[] finderArgs = new Object[] {_getTime(createDate), classNameId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AUDITENTRY_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_GTCD_C_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_GTCD_C_CREATEDATE_2);
			}

			query.append(_FINDER_COLUMN_GTCD_C_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				qPos.add(classNameId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GTCD_C_CREATEDATE_1 =
		"auditEntry.createDate IS NULL AND ";

	private static final String _FINDER_COLUMN_GTCD_C_CREATEDATE_2 =
		"auditEntry.createDate > ? AND ";

	private static final String _FINDER_COLUMN_GTCD_C_CLASSNAMEID_2 =
		"auditEntry.classNameId = ?";

	private FinderPath _finderPathWithPaginationFindByC_C_V;
	private FinderPath _finderPathWithoutPaginationFindByC_C_V;
	private FinderPath _finderPathCountByC_C_V;
	private FinderPath _finderPathWithPaginationCountByC_C_V;

	/**
	 * Returns all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @return the matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int visibility) {

		return findByC_C_V(
			classNameId, classPK, visibility, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int visibility, int start, int end) {

		return findByC_C_V(classNameId, classPK, visibility, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int visibility, int start, int end,
		OrderByComparator<AuditEntry> orderByComparator) {

		return findByC_C_V(
			classNameId, classPK, visibility, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int visibility, int start, int end,
		OrderByComparator<AuditEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByC_C_V;
			finderArgs = new Object[] {classNameId, classPK, visibility};
		}
		else {
			finderPath = _finderPathWithPaginationFindByC_C_V;
			finderArgs = new Object[] {
				classNameId, classPK, visibility, start, end, orderByComparator
			};
		}

		List<AuditEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AuditEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditEntry auditEntry : list) {
					if ((classNameId != auditEntry.getClassNameId()) ||
						(classPK != auditEntry.getClassPK()) ||
						(visibility != auditEntry.getVisibility())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_V_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_V_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_V_VISIBILITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(visibility);

				if (!pagination) {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByC_C_V_First(
			long classNameId, long classPK, int visibility,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByC_C_V_First(
			classNameId, classPK, visibility, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", visibility=");
		msg.append(visibility);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the first audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByC_C_V_First(
		long classNameId, long classPK, int visibility,
		OrderByComparator<AuditEntry> orderByComparator) {

		List<AuditEntry> list = findByC_C_V(
			classNameId, classPK, visibility, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByC_C_V_Last(
			long classNameId, long classPK, int visibility,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByC_C_V_Last(
			classNameId, classPK, visibility, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", visibility=");
		msg.append(visibility);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the last audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByC_C_V_Last(
		long classNameId, long classPK, int visibility,
		OrderByComparator<AuditEntry> orderByComparator) {

		int count = countByC_C_V(classNameId, classPK, visibility);

		if (count == 0) {
			return null;
		}

		List<AuditEntry> list = findByC_C_V(
			classNameId, classPK, visibility, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry[] findByC_C_V_PrevAndNext(
			long auditEntryId, long classNameId, long classPK, int visibility,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = findByPrimaryKey(auditEntryId);

		Session session = null;

		try {
			session = openSession();

			AuditEntry[] array = new AuditEntryImpl[3];

			array[0] = getByC_C_V_PrevAndNext(
				session, auditEntry, classNameId, classPK, visibility,
				orderByComparator, true);

			array[1] = auditEntry;

			array[2] = getByC_C_V_PrevAndNext(
				session, auditEntry, classNameId, classPK, visibility,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditEntry getByC_C_V_PrevAndNext(
		Session session, AuditEntry auditEntry, long classNameId, long classPK,
		int visibility, OrderByComparator<AuditEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_AUDITENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_C_V_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_V_CLASSPK_2);

		query.append(_FINDER_COLUMN_C_C_V_VISIBILITY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classNameId);

		qPos.add(classPK);

		qPos.add(visibility);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AuditEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibilities the visibilities
	 * @return the matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int[] visibilities) {

		return findByC_C_V(
			classNameId, classPK, visibilities, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibilities the visibilities
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int[] visibilities, int start,
		int end) {

		return findByC_C_V(
			classNameId, classPK, visibilities, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibilities the visibilities
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int[] visibilities, int start, int end,
		OrderByComparator<AuditEntry> orderByComparator) {

		return findByC_C_V(
			classNameId, classPK, visibilities, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_V(
		long classNameId, long classPK, int[] visibilities, int start, int end,
		OrderByComparator<AuditEntry> orderByComparator,
		boolean retrieveFromCache) {

		if (visibilities == null) {
			visibilities = new int[0];
		}
		else if (visibilities.length > 1) {
			visibilities = ArrayUtil.unique(visibilities);

			Arrays.sort(visibilities);
		}

		if (visibilities.length == 1) {
			return findByC_C_V(
				classNameId, classPK, visibilities[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderArgs = new Object[] {
				classNameId, classPK, StringUtil.merge(visibilities)
			};
		}
		else {
			finderArgs = new Object[] {
				classNameId, classPK, StringUtil.merge(visibilities), start,
				end, orderByComparator
			};
		}

		List<AuditEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AuditEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByC_C_V, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditEntry auditEntry : list) {
					if ((classNameId != auditEntry.getClassNameId()) ||
						(classPK != auditEntry.getClassPK()) ||
						!ArrayUtil.contains(
							visibilities, auditEntry.getVisibility())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_V_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_V_CLASSPK_2);

			if (visibilities.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_C_C_V_VISIBILITY_7);

				query.append(StringUtil.merge(visibilities));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(
					_finderPathWithPaginationFindByC_C_V, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationFindByC_C_V, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 */
	@Override
	public void removeByC_C_V(long classNameId, long classPK, int visibility) {
		for (AuditEntry auditEntry :
				findByC_C_V(
					classNameId, classPK, visibility, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(auditEntry);
		}
	}

	/**
	 * Returns the number of audit entries where classNameId = &#63; and classPK = &#63; and visibility = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibility the visibility
	 * @return the number of matching audit entries
	 */
	@Override
	public int countByC_C_V(long classNameId, long classPK, int visibility) {
		FinderPath finderPath = _finderPathCountByC_C_V;

		Object[] finderArgs = new Object[] {classNameId, classPK, visibility};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_V_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_V_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_V_VISIBILITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(visibility);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of audit entries where classNameId = &#63; and classPK = &#63; and visibility = any &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param visibilities the visibilities
	 * @return the number of matching audit entries
	 */
	@Override
	public int countByC_C_V(
		long classNameId, long classPK, int[] visibilities) {

		if (visibilities == null) {
			visibilities = new int[0];
		}
		else if (visibilities.length > 1) {
			visibilities = ArrayUtil.unique(visibilities);

			Arrays.sort(visibilities);
		}

		Object[] finderArgs = new Object[] {
			classNameId, classPK, StringUtil.merge(visibilities)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_C_V, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_V_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_V_CLASSPK_2);

			if (visibilities.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_C_C_V_VISIBILITY_7);

				query.append(StringUtil.merge(visibilities));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_C_V, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByC_C_V, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_C_V_CLASSNAMEID_2 =
		"auditEntry.classNameId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_V_CLASSPK_2 =
		"auditEntry.classPK = ? AND ";

	private static final String _FINDER_COLUMN_C_C_V_VISIBILITY_2 =
		"auditEntry.visibility = ?";

	private static final String _FINDER_COLUMN_C_C_V_VISIBILITY_7 =
		"auditEntry.visibility IN (";

	private FinderPath _finderPathWithPaginationFindByFC_FC_F;
	private FinderPath _finderPathWithoutPaginationFindByFC_FC_F;
	private FinderPath _finderPathCountByFC_FC_F;

	/**
	 * Returns all the audit entries where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @return the matching audit entries
	 */
	@Override
	public List<AuditEntry> findByFC_FC_F(
		long fieldClassNameId, long fieldClassPK, String field) {

		return findByFC_FC_F(
			fieldClassNameId, fieldClassPK, field, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit entries where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByFC_FC_F(
		long fieldClassNameId, long fieldClassPK, String field, int start,
		int end) {

		return findByFC_FC_F(
			fieldClassNameId, fieldClassPK, field, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit entries where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByFC_FC_F(
		long fieldClassNameId, long fieldClassPK, String field, int start,
		int end, OrderByComparator<AuditEntry> orderByComparator) {

		return findByFC_FC_F(
			fieldClassNameId, fieldClassPK, field, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the audit entries where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByFC_FC_F(
		long fieldClassNameId, long fieldClassPK, String field, int start,
		int end, OrderByComparator<AuditEntry> orderByComparator,
		boolean retrieveFromCache) {

		field = Objects.toString(field, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFC_FC_F;
			finderArgs = new Object[] {fieldClassNameId, fieldClassPK, field};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFC_FC_F;
			finderArgs = new Object[] {
				fieldClassNameId, fieldClassPK, field, start, end,
				orderByComparator
			};
		}

		List<AuditEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AuditEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditEntry auditEntry : list) {
					if ((fieldClassNameId !=
							auditEntry.getFieldClassNameId()) ||
						(fieldClassPK != auditEntry.getFieldClassPK()) ||
						!field.equals(auditEntry.getField())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_FC_FC_F_FIELDCLASSNAMEID_2);

			query.append(_FINDER_COLUMN_FC_FC_F_FIELDCLASSPK_2);

			boolean bindField = false;

			if (field.isEmpty()) {
				query.append(_FINDER_COLUMN_FC_FC_F_FIELD_3);
			}
			else {
				bindField = true;

				query.append(_FINDER_COLUMN_FC_FC_F_FIELD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldClassNameId);

				qPos.add(fieldClassPK);

				if (bindField) {
					qPos.add(field);
				}

				if (!pagination) {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit entry in the ordered set where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByFC_FC_F_First(
			long fieldClassNameId, long fieldClassPK, String field,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByFC_FC_F_First(
			fieldClassNameId, fieldClassPK, field, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldClassNameId=");
		msg.append(fieldClassNameId);

		msg.append(", fieldClassPK=");
		msg.append(fieldClassPK);

		msg.append(", field=");
		msg.append(field);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the first audit entry in the ordered set where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByFC_FC_F_First(
		long fieldClassNameId, long fieldClassPK, String field,
		OrderByComparator<AuditEntry> orderByComparator) {

		List<AuditEntry> list = findByFC_FC_F(
			fieldClassNameId, fieldClassPK, field, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit entry in the ordered set where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByFC_FC_F_Last(
			long fieldClassNameId, long fieldClassPK, String field,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByFC_FC_F_Last(
			fieldClassNameId, fieldClassPK, field, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldClassNameId=");
		msg.append(fieldClassNameId);

		msg.append(", fieldClassPK=");
		msg.append(fieldClassPK);

		msg.append(", field=");
		msg.append(field);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the last audit entry in the ordered set where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByFC_FC_F_Last(
		long fieldClassNameId, long fieldClassPK, String field,
		OrderByComparator<AuditEntry> orderByComparator) {

		int count = countByFC_FC_F(fieldClassNameId, fieldClassPK, field);

		if (count == 0) {
			return null;
		}

		List<AuditEntry> list = findByFC_FC_F(
			fieldClassNameId, fieldClassPK, field, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry[] findByFC_FC_F_PrevAndNext(
			long auditEntryId, long fieldClassNameId, long fieldClassPK,
			String field, OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		field = Objects.toString(field, "");

		AuditEntry auditEntry = findByPrimaryKey(auditEntryId);

		Session session = null;

		try {
			session = openSession();

			AuditEntry[] array = new AuditEntryImpl[3];

			array[0] = getByFC_FC_F_PrevAndNext(
				session, auditEntry, fieldClassNameId, fieldClassPK, field,
				orderByComparator, true);

			array[1] = auditEntry;

			array[2] = getByFC_FC_F_PrevAndNext(
				session, auditEntry, fieldClassNameId, fieldClassPK, field,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditEntry getByFC_FC_F_PrevAndNext(
		Session session, AuditEntry auditEntry, long fieldClassNameId,
		long fieldClassPK, String field,
		OrderByComparator<AuditEntry> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_AUDITENTRY_WHERE);

		query.append(_FINDER_COLUMN_FC_FC_F_FIELDCLASSNAMEID_2);

		query.append(_FINDER_COLUMN_FC_FC_F_FIELDCLASSPK_2);

		boolean bindField = false;

		if (field.isEmpty()) {
			query.append(_FINDER_COLUMN_FC_FC_F_FIELD_3);
		}
		else {
			bindField = true;

			query.append(_FINDER_COLUMN_FC_FC_F_FIELD_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldClassNameId);

		qPos.add(fieldClassPK);

		if (bindField) {
			qPos.add(field);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AuditEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit entries where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63; from the database.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 */
	@Override
	public void removeByFC_FC_F(
		long fieldClassNameId, long fieldClassPK, String field) {

		for (AuditEntry auditEntry :
				findByFC_FC_F(
					fieldClassNameId, fieldClassPK, field, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(auditEntry);
		}
	}

	/**
	 * Returns the number of audit entries where fieldClassNameId = &#63; and fieldClassPK = &#63; and field = &#63;.
	 *
	 * @param fieldClassNameId the field class name ID
	 * @param fieldClassPK the field class pk
	 * @param field the field
	 * @return the number of matching audit entries
	 */
	@Override
	public int countByFC_FC_F(
		long fieldClassNameId, long fieldClassPK, String field) {

		field = Objects.toString(field, "");

		FinderPath finderPath = _finderPathCountByFC_FC_F;

		Object[] finderArgs = new Object[] {
			fieldClassNameId, fieldClassPK, field
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_FC_FC_F_FIELDCLASSNAMEID_2);

			query.append(_FINDER_COLUMN_FC_FC_F_FIELDCLASSPK_2);

			boolean bindField = false;

			if (field.isEmpty()) {
				query.append(_FINDER_COLUMN_FC_FC_F_FIELD_3);
			}
			else {
				bindField = true;

				query.append(_FINDER_COLUMN_FC_FC_F_FIELD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldClassNameId);

				qPos.add(fieldClassPK);

				if (bindField) {
					qPos.add(field);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FC_FC_F_FIELDCLASSNAMEID_2 =
		"auditEntry.fieldClassNameId = ? AND ";

	private static final String _FINDER_COLUMN_FC_FC_F_FIELDCLASSPK_2 =
		"auditEntry.fieldClassPK = ? AND ";

	private static final String _FINDER_COLUMN_FC_FC_F_FIELD_2 =
		"auditEntry.field = ?";

	private static final String _FINDER_COLUMN_FC_FC_F_FIELD_3 =
		"(auditEntry.field IS NULL OR auditEntry.field = '')";

	private FinderPath _finderPathWithPaginationFindByC_C_F_A;
	private FinderPath _finderPathWithoutPaginationFindByC_C_F_A;
	private FinderPath _finderPathCountByC_C_F_A;

	/**
	 * Returns all the audit entries where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @return the matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_F_A(
		long classNameId, long classPK, String field, int action) {

		return findByC_C_F_A(
			classNameId, classPK, field, action, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit entries where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_F_A(
		long classNameId, long classPK, String field, int action, int start,
		int end) {

		return findByC_C_F_A(
			classNameId, classPK, field, action, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit entries where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_F_A(
		long classNameId, long classPK, String field, int action, int start,
		int end, OrderByComparator<AuditEntry> orderByComparator) {

		return findByC_C_F_A(
			classNameId, classPK, field, action, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the audit entries where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching audit entries
	 */
	@Override
	public List<AuditEntry> findByC_C_F_A(
		long classNameId, long classPK, String field, int action, int start,
		int end, OrderByComparator<AuditEntry> orderByComparator,
		boolean retrieveFromCache) {

		field = Objects.toString(field, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByC_C_F_A;
			finderArgs = new Object[] {classNameId, classPK, field, action};
		}
		else {
			finderPath = _finderPathWithPaginationFindByC_C_F_A;
			finderArgs = new Object[] {
				classNameId, classPK, field, action, start, end,
				orderByComparator
			};
		}

		List<AuditEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AuditEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditEntry auditEntry : list) {
					if ((classNameId != auditEntry.getClassNameId()) ||
						(classPK != auditEntry.getClassPK()) ||
						!field.equals(auditEntry.getField()) ||
						(action != auditEntry.getAction())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_F_A_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_F_A_CLASSPK_2);

			boolean bindField = false;

			if (field.isEmpty()) {
				query.append(_FINDER_COLUMN_C_C_F_A_FIELD_3);
			}
			else {
				bindField = true;

				query.append(_FINDER_COLUMN_C_C_F_A_FIELD_2);
			}

			query.append(_FINDER_COLUMN_C_C_F_A_ACTION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (bindField) {
					qPos.add(field);
				}

				qPos.add(action);

				if (!pagination) {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByC_C_F_A_First(
			long classNameId, long classPK, String field, int action,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByC_C_F_A_First(
			classNameId, classPK, field, action, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", field=");
		msg.append(field);

		msg.append(", action=");
		msg.append(action);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the first audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByC_C_F_A_First(
		long classNameId, long classPK, String field, int action,
		OrderByComparator<AuditEntry> orderByComparator) {

		List<AuditEntry> list = findByC_C_F_A(
			classNameId, classPK, field, action, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry findByC_C_F_A_Last(
			long classNameId, long classPK, String field, int action,
			OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByC_C_F_A_Last(
			classNameId, classPK, field, action, orderByComparator);

		if (auditEntry != null) {
			return auditEntry;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", field=");
		msg.append(field);

		msg.append(", action=");
		msg.append(action);

		msg.append("}");

		throw new NoSuchAuditEntryException(msg.toString());
	}

	/**
	 * Returns the last audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	@Override
	public AuditEntry fetchByC_C_F_A_Last(
		long classNameId, long classPK, String field, int action,
		OrderByComparator<AuditEntry> orderByComparator) {

		int count = countByC_C_F_A(classNameId, classPK, field, action);

		if (count == 0) {
			return null;
		}

		List<AuditEntry> list = findByC_C_F_A(
			classNameId, classPK, field, action, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry[] findByC_C_F_A_PrevAndNext(
			long auditEntryId, long classNameId, long classPK, String field,
			int action, OrderByComparator<AuditEntry> orderByComparator)
		throws NoSuchAuditEntryException {

		field = Objects.toString(field, "");

		AuditEntry auditEntry = findByPrimaryKey(auditEntryId);

		Session session = null;

		try {
			session = openSession();

			AuditEntry[] array = new AuditEntryImpl[3];

			array[0] = getByC_C_F_A_PrevAndNext(
				session, auditEntry, classNameId, classPK, field, action,
				orderByComparator, true);

			array[1] = auditEntry;

			array[2] = getByC_C_F_A_PrevAndNext(
				session, auditEntry, classNameId, classPK, field, action,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditEntry getByC_C_F_A_PrevAndNext(
		Session session, AuditEntry auditEntry, long classNameId, long classPK,
		String field, int action,
		OrderByComparator<AuditEntry> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_AUDITENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_C_F_A_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_F_A_CLASSPK_2);

		boolean bindField = false;

		if (field.isEmpty()) {
			query.append(_FINDER_COLUMN_C_C_F_A_FIELD_3);
		}
		else {
			bindField = true;

			query.append(_FINDER_COLUMN_C_C_F_A_FIELD_2);
		}

		query.append(_FINDER_COLUMN_C_C_F_A_ACTION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (bindField) {
			qPos.add(field);
		}

		qPos.add(action);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AuditEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit entries where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 */
	@Override
	public void removeByC_C_F_A(
		long classNameId, long classPK, String field, int action) {

		for (AuditEntry auditEntry :
				findByC_C_F_A(
					classNameId, classPK, field, action, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(auditEntry);
		}
	}

	/**
	 * Returns the number of audit entries where classNameId = &#63; and classPK = &#63; and field = &#63; and action = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param field the field
	 * @param action the action
	 * @return the number of matching audit entries
	 */
	@Override
	public int countByC_C_F_A(
		long classNameId, long classPK, String field, int action) {

		field = Objects.toString(field, "");

		FinderPath finderPath = _finderPathCountByC_C_F_A;

		Object[] finderArgs = new Object[] {
			classNameId, classPK, field, action
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_AUDITENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_C_F_A_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_F_A_CLASSPK_2);

			boolean bindField = false;

			if (field.isEmpty()) {
				query.append(_FINDER_COLUMN_C_C_F_A_FIELD_3);
			}
			else {
				bindField = true;

				query.append(_FINDER_COLUMN_C_C_F_A_FIELD_2);
			}

			query.append(_FINDER_COLUMN_C_C_F_A_ACTION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (bindField) {
					qPos.add(field);
				}

				qPos.add(action);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_C_F_A_CLASSNAMEID_2 =
		"auditEntry.classNameId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_F_A_CLASSPK_2 =
		"auditEntry.classPK = ? AND ";

	private static final String _FINDER_COLUMN_C_C_F_A_FIELD_2 =
		"auditEntry.field = ? AND ";

	private static final String _FINDER_COLUMN_C_C_F_A_FIELD_3 =
		"(auditEntry.field IS NULL OR auditEntry.field = '') AND ";

	private static final String _FINDER_COLUMN_C_C_F_A_ACTION_2 =
		"auditEntry.action = ?";

	public AuditEntryPersistenceImpl() {
		setModelClass(AuditEntry.class);

		setModelImplClass(AuditEntryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the audit entry in the entity cache if it is enabled.
	 *
	 * @param auditEntry the audit entry
	 */
	@Override
	public void cacheResult(AuditEntry auditEntry) {
		entityCache.putResult(
			entityCacheEnabled, AuditEntryImpl.class,
			auditEntry.getPrimaryKey(), auditEntry);

		auditEntry.resetOriginalValues();
	}

	/**
	 * Caches the audit entries in the entity cache if it is enabled.
	 *
	 * @param auditEntries the audit entries
	 */
	@Override
	public void cacheResult(List<AuditEntry> auditEntries) {
		for (AuditEntry auditEntry : auditEntries) {
			if (entityCache.getResult(
					entityCacheEnabled, AuditEntryImpl.class,
					auditEntry.getPrimaryKey()) == null) {

				cacheResult(auditEntry);
			}
			else {
				auditEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all audit entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuditEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the audit entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditEntry auditEntry) {
		entityCache.removeResult(
			entityCacheEnabled, AuditEntryImpl.class,
			auditEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AuditEntry> auditEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuditEntry auditEntry : auditEntries) {
			entityCache.removeResult(
				entityCacheEnabled, AuditEntryImpl.class,
				auditEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
	 *
	 * @param auditEntryId the primary key for the new audit entry
	 * @return the new audit entry
	 */
	@Override
	public AuditEntry create(long auditEntryId) {
		AuditEntry auditEntry = new AuditEntryImpl();

		auditEntry.setNew(true);
		auditEntry.setPrimaryKey(auditEntryId);

		auditEntry.setCompanyId(companyProvider.getCompanyId());

		return auditEntry;
	}

	/**
	 * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry that was removed
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry remove(long auditEntryId)
		throws NoSuchAuditEntryException {

		return remove((Serializable)auditEntryId);
	}

	/**
	 * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the audit entry
	 * @return the audit entry that was removed
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry remove(Serializable primaryKey)
		throws NoSuchAuditEntryException {

		Session session = null;

		try {
			session = openSession();

			AuditEntry auditEntry = (AuditEntry)session.get(
				AuditEntryImpl.class, primaryKey);

			if (auditEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auditEntry);
		}
		catch (NoSuchAuditEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AuditEntry removeImpl(AuditEntry auditEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auditEntry)) {
				auditEntry = (AuditEntry)session.get(
					AuditEntryImpl.class, auditEntry.getPrimaryKeyObj());
			}

			if (auditEntry != null) {
				session.delete(auditEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (auditEntry != null) {
			clearCache(auditEntry);
		}

		return auditEntry;
	}

	@Override
	public AuditEntry updateImpl(AuditEntry auditEntry) {
		boolean isNew = auditEntry.isNew();

		if (!(auditEntry instanceof AuditEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(auditEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(auditEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in auditEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AuditEntry implementation " +
					auditEntry.getClass());
		}

		AuditEntryModelImpl auditEntryModelImpl =
			(AuditEntryModelImpl)auditEntry;

		Session session = null;

		try {
			session = openSession();

			if (auditEntry.isNew()) {
				session.save(auditEntry);

				auditEntry.setNew(false);
			}
			else {
				auditEntry = (AuditEntry)session.merge(auditEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				auditEntryModelImpl.getClassNameId(),
				auditEntryModelImpl.getClassPK(),
				auditEntryModelImpl.getVisibility()
			};

			finderCache.removeResult(_finderPathCountByC_C_V, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_C_V, args);

			args = new Object[] {
				auditEntryModelImpl.getFieldClassNameId(),
				auditEntryModelImpl.getFieldClassPK(),
				auditEntryModelImpl.getField()
			};

			finderCache.removeResult(_finderPathCountByFC_FC_F, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFC_FC_F, args);

			args = new Object[] {
				auditEntryModelImpl.getClassNameId(),
				auditEntryModelImpl.getClassPK(),
				auditEntryModelImpl.getField(), auditEntryModelImpl.getAction()
			};

			finderCache.removeResult(_finderPathCountByC_C_F_A, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_C_F_A, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((auditEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_C_V.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					auditEntryModelImpl.getOriginalClassNameId(),
					auditEntryModelImpl.getOriginalClassPK(),
					auditEntryModelImpl.getOriginalVisibility()
				};

				finderCache.removeResult(_finderPathCountByC_C_V, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_C_V, args);

				args = new Object[] {
					auditEntryModelImpl.getClassNameId(),
					auditEntryModelImpl.getClassPK(),
					auditEntryModelImpl.getVisibility()
				};

				finderCache.removeResult(_finderPathCountByC_C_V, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_C_V, args);
			}

			if ((auditEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFC_FC_F.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					auditEntryModelImpl.getOriginalFieldClassNameId(),
					auditEntryModelImpl.getOriginalFieldClassPK(),
					auditEntryModelImpl.getOriginalField()
				};

				finderCache.removeResult(_finderPathCountByFC_FC_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFC_FC_F, args);

				args = new Object[] {
					auditEntryModelImpl.getFieldClassNameId(),
					auditEntryModelImpl.getFieldClassPK(),
					auditEntryModelImpl.getField()
				};

				finderCache.removeResult(_finderPathCountByFC_FC_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFC_FC_F, args);
			}

			if ((auditEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_C_F_A.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					auditEntryModelImpl.getOriginalClassNameId(),
					auditEntryModelImpl.getOriginalClassPK(),
					auditEntryModelImpl.getOriginalField(),
					auditEntryModelImpl.getOriginalAction()
				};

				finderCache.removeResult(_finderPathCountByC_C_F_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_C_F_A, args);

				args = new Object[] {
					auditEntryModelImpl.getClassNameId(),
					auditEntryModelImpl.getClassPK(),
					auditEntryModelImpl.getField(),
					auditEntryModelImpl.getAction()
				};

				finderCache.removeResult(_finderPathCountByC_C_F_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_C_F_A, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AuditEntryImpl.class,
			auditEntry.getPrimaryKey(), auditEntry, false);

		auditEntry.resetOriginalValues();

		return auditEntry;
	}

	/**
	 * Returns the audit entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the audit entry
	 * @return the audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditEntryException {

		AuditEntry auditEntry = fetchByPrimaryKey(primaryKey);

		if (auditEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auditEntry;
	}

	/**
	 * Returns the audit entry with the primary key or throws a <code>NoSuchAuditEntryException</code> if it could not be found.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry findByPrimaryKey(long auditEntryId)
		throws NoSuchAuditEntryException {

		return findByPrimaryKey((Serializable)auditEntryId);
	}

	/**
	 * Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
	 */
	@Override
	public AuditEntry fetchByPrimaryKey(long auditEntryId) {
		return fetchByPrimaryKey((Serializable)auditEntryId);
	}

	/**
	 * Returns all the audit entries.
	 *
	 * @return the audit entries
	 */
	@Override
	public List<AuditEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of audit entries
	 */
	@Override
	public List<AuditEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audit entries
	 */
	@Override
	public List<AuditEntry> findAll(
		int start, int end, OrderByComparator<AuditEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of audit entries
	 */
	@Override
	public List<AuditEntry> findAll(
		int start, int end, OrderByComparator<AuditEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AuditEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AuditEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AUDITENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITENTRY;

				if (pagination) {
					sql = sql.concat(AuditEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AuditEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the audit entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AuditEntry auditEntry : findAll()) {
			remove(auditEntry);
		}
	}

	/**
	 * Returns the number of audit entries.
	 *
	 * @return the number of audit entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDITENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "auditEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUDITENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuditEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the audit entry persistence.
	 */
	@Activate
	public void activate() {
		AuditEntryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AuditEntryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGtCD_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGtCD_C",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByGtCD_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByGtCD_C",
			new String[] {Date.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByC_C_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_C_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			AuditEntryModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			AuditEntryModelImpl.CLASSPK_COLUMN_BITMASK |
			AuditEntryModelImpl.VISIBILITY_COLUMN_BITMASK |
			AuditEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByC_C_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByC_C_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_C_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByFC_FC_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFC_FC_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFC_FC_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFC_FC_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AuditEntryModelImpl.FIELDCLASSNAMEID_COLUMN_BITMASK |
			AuditEntryModelImpl.FIELDCLASSPK_COLUMN_BITMASK |
			AuditEntryModelImpl.FIELD_COLUMN_BITMASK |
			AuditEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByFC_FC_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFC_FC_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByC_C_F_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_F_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_C_F_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuditEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_F_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			},
			AuditEntryModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			AuditEntryModelImpl.CLASSPK_COLUMN_BITMASK |
			AuditEntryModelImpl.FIELD_COLUMN_BITMASK |
			AuditEntryModelImpl.ACTION_COLUMN_BITMASK |
			AuditEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByC_C_F_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_F_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AuditEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.yithro.audit.model.AuditEntry"),
			true);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_AUDITENTRY =
		"SELECT auditEntry FROM AuditEntry auditEntry";

	private static final String _SQL_SELECT_AUDITENTRY_WHERE =
		"SELECT auditEntry FROM AuditEntry auditEntry WHERE ";

	private static final String _SQL_COUNT_AUDITENTRY =
		"SELECT COUNT(auditEntry) FROM AuditEntry auditEntry";

	private static final String _SQL_COUNT_AUDITENTRY_WHERE =
		"SELECT COUNT(auditEntry) FROM AuditEntry auditEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auditEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AuditEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AuditEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuditEntryPersistenceImpl.class);

}