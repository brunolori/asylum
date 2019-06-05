package al.gov.mb.asylum.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IIrStatus;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.entities.Transfer;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.forms.TransferSx;
import al.gov.mb.asylum.utils.StringUtil;

@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class TransferDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	public List<Transfer> searchTransfer(TransferSx req)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Transfer t WHERE t.status=:st ";
		String order = "ORDER BY t.id DESC";
		
		if(StringUtil.isValid(req.getUniqueNo()))
		{
			sql += "AND upper(t.selection.event.uniqueNumber) like :un ";
			params.put("un", req.getUniqueNo().trim().toUpperCase());
		}
		if(req.getTransferStatusId() != null)
		{
			sql += "AND t.transferStatus.id = :ts ";
			params.put("ts", req.getTransferStatusId());
		}
		if(StringUtil.isValid(req.getName()))
		{
			sql += "AND upper(t.selection.person.name) like :name ";
			params.put("name", req.getName().trim().toUpperCase());
		}
		if(StringUtil.isValid(req.getSurname()))
		{
			sql += "AND upper(t.selection.person.surname) like :surname ";
			params.put("surname", req.getSurname());
		}
		if(req.getSelectionId() != null)
		{
			sql += "AND t.selection.event.id=:sid ";
			params.put("sid", req.getSelectionId());
		}
		if(req.getDepartureOrganizationId() != null)
		{
			sql += "AND t.fromOrganization.id=:doid ";
			params.put("doid", req.getDepartureOrganizationId());
		}
		if(req.getDestinationOrganizationId() != null)
		{
			sql += "AND t.toOrganization.id=:aoid ";
			params.put("aoid", req.getDestinationOrganizationId());
		}
		if(req.getFromCheckInTime() != null)
		{
			sql += "AND trunc(t.checkInTime)>=:fromCI ";
			params.put("fromCI", req.getFromCheckInTime());
		}
		if(req.getToCheckInTime() != null)
		{
			sql += "AND trunc(t.checkInTime)<=:toCI ";
			params.put("toCI", req.getToCheckInTime());
		}
		if(req.getFromCheckOutTime() != null)
		{
			sql += "AND trunc(t.checkOutTime)>=:fromCO ";
			params.put("fromCO", req.getFromCheckOutTime());
		}
		if(req.getToCheckOutTime() != null)
		{
			sql += "AND trunc(t.checkOutTime)<=:toCO ";
			params.put("toCO",  req.getToCheckOutTime());
		}
		
		sql += order;
		
		
		Query q = em.createQuery(sql).setParameter("st", IStatus.ACTIVE);
		Iterator it = params.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}
		
		
		if(req.getFirstResult() != null)
		{
			q.setFirstResult(req.getFirstResult());
		}
		
		if(req.getMaxResult() != null)
		{
			q.setMaxResults(req.getMaxResult());
		}
		
		
		
		return q.getResultList();
	}


	public List<Selection> getDrkmSelectionsForTransfer(Integer orgId) {

		
		return em.createQuery("FROM Selection s WHERE s.irStatus.id=:irs AND s.asylantDetails.currentLocation.id=:clid or (s.event.organization.id=:oid and s.asylantDetails.currentLocation is null) ORDER BY s.event.id DESC")
				.setParameter("oid", orgId)
				.setParameter("clid", orgId)
				.setParameter("irs", IIrStatus.AZILANT)
				.getResultList();
		
		
	}
	
	

}
