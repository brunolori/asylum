package al.gov.mb.asylum.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IIrStatus;
import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.models.KeyValue;

@Repository
@SuppressWarnings("unchecked")
public class RaportDAO {
	
	
	
	@PersistenceContext
	EntityManager em;
	
	
	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to, Integer organizationId)
	{
		
		String sql = "SELECT new "+KeyValue.class.getName()+"(trunc(s.recordDate) as dt,count(s)) FROM Selection s "
				+ "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
		
		sql += "GROUP BY trunc(s.recordDate) ORDER BY dt";
				
		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return q.getResultList();
	}
	
	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to)
	{
		return em.createQuery("SELECT new "+KeyValue.class.getName()+"(s.event.organization.tag as org,count(s)) FROM Selection s "
				+ "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to GROUP BY s.event.organization.tag ORDER BY org")
				.setParameter("from", from)
				.setParameter("to", to)
				.getResultList();
	}
	
	public List<KeyValue> registeredSelectionsByState(Date from, Date to, Integer organizationId)
	{		
		
		String sql = "SELECT new "+KeyValue.class.getName()+"(s.person.codeNationality as state,count(s) as cnt) FROM Selection s " + 
					 "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
		
		sql += "GROUP BY s.person.codeNationality ORDER BY cnt DESC,state ";
				
		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return q.getResultList();
	}
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to, Integer organizationId)
	{		
		
		String sql = "SELECT new "+KeyValue.class.getName()+"(s.person.gender as gender,count(s)) FROM Selection s "
				+ "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
		
		sql += "GROUP BY s.person.gender";

		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return q.getResultList();
	}
	
	public long childCountByPeriod(Date from, Date to, Integer organizationId)
	{
		Calendar cal = Calendar.getInstance(); // kjo duhet pare, te kontrollohet mosha qe ka qene kur eshte bere regjistrimi, jo me daten aktuale
		cal.add(Calendar.YEAR, -18);
		cal.add(Calendar.DATE, -1);
		
		Date dob = cal.getTime();
		
		
		String sql = "SELECT count(s) FROM Selection s "
				+ "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.person.dob >= :dob ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}		
				
		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("dob", dob);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return (Long)q.getSingleResult();
		
		
	}
	
	
	public long countAll(Date from, Date to, Integer organizationId) {		
		
		String sql = "SELECT count(s) FROM Selection s "
				+ "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}		
				
		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return (Long)q.getSingleResult();
		
		
	}
	
	public long countAllByIrStatus(Date from, Date to, String isStatusCode, Integer organizationId) {		
		
		String sql = "SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
		
		Query q = em.createQuery(sql)
				.setParameter("irs", isStatusCode)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return (Long)q.getSingleResult();
		
		
	}
	
	public List<KeyValue> registeredSelectionsByPlaceType(Date from, Date to, Integer organizationId)
	{		
		
		String sql = "SELECT new "+KeyValue.class.getName()+"(s.event.placeType.tag as p_type,count(s) as cnt) FROM Selection s " + 
					 "WHERE TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
		
		sql += "GROUP BY s.event.placeType.tag ORDER BY cnt DESC,p_type";
				
		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return q.getResultList();
	}
	
	public List<KeyValue> registeredDecisionsByType(Date from, Date to, Integer organizationId)
	{		
		
		String sql = "SELECT new "+KeyValue.class.getName()+"(d.decisionType.id as d_type,count(d) as cnt) FROM Decision d " + 
					 "WHERE TRUNC(d.recordDate)>=:from AND TRUNC(d.recordDate)<=:to ";
		
		if(organizationId != null)
		{
			sql += "AND d.selection.event.organization.id=:orgId ";
		}
		
		sql += "GROUP BY d.decisionType.id ORDER BY cnt DESC,d_type";
				
		Query q = em.createQuery(sql)
				.setParameter("from", from)
				.setParameter("to", to);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return q.getResultList();
	}
	
	
	public long gonePersonsCountByPeriod(Date from, Date to, Integer organizationId)
	{
		
		String sql = "SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.currentLocation.id=:clid ";
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
				
		Query q = em.createQuery(sql)
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("clid", IOrganization.GONE_ID);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return (Long) q.getSingleResult();
	}
	
	public long returnedPersonsCountByPeriod(Date from, Date to, Integer organizationId)
	{
		
		
		String sql = "SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.returned=:rtn " ;
		
		if(organizationId != null)
		{
			sql += "AND s.event.organization.id=:orgId ";
		}
				
		Query q = em.createQuery(sql)
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("rtn", IStatus.YES);
		
		if(organizationId != null)
		{
			q.setParameter("orgId", organizationId);
		}
		
		return (Long) q.getSingleResult();
		
		
	}
	
	
	

}
