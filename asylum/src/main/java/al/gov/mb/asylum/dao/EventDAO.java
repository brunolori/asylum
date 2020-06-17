package al.gov.mb.asylum.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.entities.tims.IrregularEvent;
import al.gov.mb.asylum.forms.EventSx;
import al.gov.mb.asylum.utils.StringUtil;

@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class EventDAO {
	
	@PersistenceContext
	EntityManager em;

	
	
	public List<IrregularEvent> searchEvent(EventSx req)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM IrregularEvent t WHERE 1=1 ";
		String order = "ORDER BY t.id DESC";
		
		if(StringUtil.isValid(req.getUname()))
		{
			sql += "AND t.recordUser=:uname ";
			params.put("uname", req.getUname());
		}
		if(StringUtil.isValid(req.getUniqueNo()))
		{
			sql += "AND t.uniqurNumber=:unq ";
			params.put("unq", req.getUniqueNo().trim().toUpperCase());
		}
		if(req.getOrganizationId() != null)
		{
			sql += "AND t.organization.id=:oid ";
			params.put("oid", req.getOrganizationId());
		}
		if(req.getFromDate() != null)
		{
			sql += "AND trunc(t.eventDate)>=:from ";
			params.put("from", req.getFromDate());
		}
		if(req.getToDate() != null)
		{
			sql += "AND trunc(t.eventDate)<=:to ";
			params.put("to", req.getToDate());
		}
		
		sql += order;
		
		Query q = em.createQuery(sql);
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
	
	
	public long getTodayCount()
	{
		return (long)em.createQuery("SELECT COUNT(t) FROM IrregularEvent t WHERE t.eventDate>=TRUNC(:today)")
				.setParameter("today", Calendar.getInstance().getTime())
				.getSingleResult();
	}
	
	
}
