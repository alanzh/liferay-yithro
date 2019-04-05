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

package com.liferay.yithro.ticket.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.ticket.exception.NoSuchTicketWorkerException;
import com.liferay.yithro.ticket.model.TicketWorker;

/**
 * The persistence interface for the ticket worker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorkerUtil
 * @generated
 */
@ProviderType
public interface TicketWorkerPersistence extends BasePersistence<TicketWorker> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketWorkerUtil} to access the ticket worker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket workers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ticket workers
	 */
	public java.util.List<TicketWorker> findByUserId(long userId);

	/**
	 * Returns a range of all the ticket workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @return the range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the ticket workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ticket worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the first ticket worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns the last ticket worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the last ticket worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns the ticket workers before and after the current ticket worker in the ordered set where userId = &#63;.
	 *
	 * @param ticketWorkerId the primary key of the current ticket worker
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket worker
	 * @throws NoSuchTicketWorkerException if a ticket worker with the primary key could not be found
	 */
	public TicketWorker[] findByUserId_PrevAndNext(
			long ticketWorkerId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Removes all the ticket workers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of ticket workers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ticket workers
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the ticket workers where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket workers
	 */
	public java.util.List<TicketWorker> findByTicketEntryId(long ticketEntryId);

	/**
	 * Returns a range of all the ticket workers where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @return the range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findByTicketEntryId(
		long ticketEntryId, int start, int end);

	/**
	 * Returns an ordered range of all the ticket workers where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket workers where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ticket worker in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findByTicketEntryId_First(
			long ticketEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the first ticket worker in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByTicketEntryId_First(
		long ticketEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns the last ticket worker in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findByTicketEntryId_Last(
			long ticketEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the last ticket worker in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByTicketEntryId_Last(
		long ticketEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns the ticket workers before and after the current ticket worker in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketWorkerId the primary key of the current ticket worker
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket worker
	 * @throws NoSuchTicketWorkerException if a ticket worker with the primary key could not be found
	 */
	public TicketWorker[] findByTicketEntryId_PrevAndNext(
			long ticketWorkerId, long ticketEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Removes all the ticket workers where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	public void removeByTicketEntryId(long ticketEntryId);

	/**
	 * Returns the number of ticket workers where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket workers
	 */
	public int countByTicketEntryId(long ticketEntryId);

	/**
	 * Returns the ticket worker where userId = &#63; and ticketEntryId = &#63; or throws a <code>NoSuchTicketWorkerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findByU_TEI(long userId, long ticketEntryId)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the ticket worker where userId = &#63; and ticketEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByU_TEI(long userId, long ticketEntryId);

	/**
	 * Returns the ticket worker where userId = &#63; and ticketEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByU_TEI(
		long userId, long ticketEntryId, boolean retrieveFromCache);

	/**
	 * Removes the ticket worker where userId = &#63; and ticketEntryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @return the ticket worker that was removed
	 */
	public TicketWorker removeByU_TEI(long userId, long ticketEntryId)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the number of ticket workers where userId = &#63; and ticketEntryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket workers
	 */
	public int countByU_TEI(long userId, long ticketEntryId);

	/**
	 * Returns the ticket worker where ticketEntryId = &#63; and primary = &#63; or throws a <code>NoSuchTicketWorkerException</code> if it could not be found.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param primary the primary
	 * @return the matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findByTEI_P(long ticketEntryId, boolean primary)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the ticket worker where ticketEntryId = &#63; and primary = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param primary the primary
	 * @return the matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByTEI_P(long ticketEntryId, boolean primary);

	/**
	 * Returns the ticket worker where ticketEntryId = &#63; and primary = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param primary the primary
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchByTEI_P(
		long ticketEntryId, boolean primary, boolean retrieveFromCache);

	/**
	 * Removes the ticket worker where ticketEntryId = &#63; and primary = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param primary the primary
	 * @return the ticket worker that was removed
	 */
	public TicketWorker removeByTEI_P(long ticketEntryId, boolean primary)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the number of ticket workers where ticketEntryId = &#63; and primary = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param primary the primary
	 * @return the number of matching ticket workers
	 */
	public int countByTEI_P(long ticketEntryId, boolean primary);

	/**
	 * Returns all the ticket workers where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @return the matching ticket workers
	 */
	public java.util.List<TicketWorker> findBySCNI_SCPK(
		long sourceClassNameId, long sourceClassPK);

	/**
	 * Returns a range of all the ticket workers where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @return the range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findBySCNI_SCPK(
		long sourceClassNameId, long sourceClassPK, int start, int end);

	/**
	 * Returns an ordered range of all the ticket workers where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findBySCNI_SCPK(
		long sourceClassNameId, long sourceClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket workers where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket workers
	 */
	public java.util.List<TicketWorker> findBySCNI_SCPK(
		long sourceClassNameId, long sourceClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ticket worker in the ordered set where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findBySCNI_SCPK_First(
			long sourceClassNameId, long sourceClassPK,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the first ticket worker in the ordered set where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchBySCNI_SCPK_First(
		long sourceClassNameId, long sourceClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns the last ticket worker in the ordered set where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket worker
	 * @throws NoSuchTicketWorkerException if a matching ticket worker could not be found
	 */
	public TicketWorker findBySCNI_SCPK_Last(
			long sourceClassNameId, long sourceClassPK,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the last ticket worker in the ordered set where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket worker, or <code>null</code> if a matching ticket worker could not be found
	 */
	public TicketWorker fetchBySCNI_SCPK_Last(
		long sourceClassNameId, long sourceClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns the ticket workers before and after the current ticket worker in the ordered set where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param ticketWorkerId the primary key of the current ticket worker
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket worker
	 * @throws NoSuchTicketWorkerException if a ticket worker with the primary key could not be found
	 */
	public TicketWorker[] findBySCNI_SCPK_PrevAndNext(
			long ticketWorkerId, long sourceClassNameId, long sourceClassPK,
			com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
				orderByComparator)
		throws NoSuchTicketWorkerException;

	/**
	 * Removes all the ticket workers where sourceClassNameId = &#63; and sourceClassPK = &#63; from the database.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 */
	public void removeBySCNI_SCPK(long sourceClassNameId, long sourceClassPK);

	/**
	 * Returns the number of ticket workers where sourceClassNameId = &#63; and sourceClassPK = &#63;.
	 *
	 * @param sourceClassNameId the source class name ID
	 * @param sourceClassPK the source class pk
	 * @return the number of matching ticket workers
	 */
	public int countBySCNI_SCPK(long sourceClassNameId, long sourceClassPK);

	/**
	 * Caches the ticket worker in the entity cache if it is enabled.
	 *
	 * @param ticketWorker the ticket worker
	 */
	public void cacheResult(TicketWorker ticketWorker);

	/**
	 * Caches the ticket workers in the entity cache if it is enabled.
	 *
	 * @param ticketWorkers the ticket workers
	 */
	public void cacheResult(java.util.List<TicketWorker> ticketWorkers);

	/**
	 * Creates a new ticket worker with the primary key. Does not add the ticket worker to the database.
	 *
	 * @param ticketWorkerId the primary key for the new ticket worker
	 * @return the new ticket worker
	 */
	public TicketWorker create(long ticketWorkerId);

	/**
	 * Removes the ticket worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker that was removed
	 * @throws NoSuchTicketWorkerException if a ticket worker with the primary key could not be found
	 */
	public TicketWorker remove(long ticketWorkerId)
		throws NoSuchTicketWorkerException;

	public TicketWorker updateImpl(TicketWorker ticketWorker);

	/**
	 * Returns the ticket worker with the primary key or throws a <code>NoSuchTicketWorkerException</code> if it could not be found.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker
	 * @throws NoSuchTicketWorkerException if a ticket worker with the primary key could not be found
	 */
	public TicketWorker findByPrimaryKey(long ticketWorkerId)
		throws NoSuchTicketWorkerException;

	/**
	 * Returns the ticket worker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker, or <code>null</code> if a ticket worker with the primary key could not be found
	 */
	public TicketWorker fetchByPrimaryKey(long ticketWorkerId);

	/**
	 * Returns all the ticket workers.
	 *
	 * @return the ticket workers
	 */
	public java.util.List<TicketWorker> findAll();

	/**
	 * Returns a range of all the ticket workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @return the range of ticket workers
	 */
	public java.util.List<TicketWorker> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket workers
	 */
	public java.util.List<TicketWorker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket workers
	 */
	public java.util.List<TicketWorker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketWorker>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ticket workers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket workers.
	 *
	 * @return the number of ticket workers
	 */
	public int countAll();

}