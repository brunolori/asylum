package al.gov.mb.asylum.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.entities.Hearing;
import al.gov.mb.asylum.forms.HearingSx;
import al.gov.mb.asylum.utils.StringUtil;

@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class HearingDAO {
	
	@PersistenceContext
	EntityManager em;

	
	
	public List<Hearing> searchHearing(HearingSx req)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Hearing t WHERE t.status=:st ";
		String order = "ORDER BY t.id DESC";
		
		if(StringUtil.isValid(req.getUniqueNo()))
		{
			sql += "AND upper(t.selection.event.uniqueNumber) like :un ";
			params.put("un", req.getUniqueNo().trim().toUpperCase());
		}
		if(req.getHearingStatus() != null)
		{
			sql += "AND t.hearingStatus.id = :isid ";
			params.put("isid", req.getHearingStatus());
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
		
		if(req.getFrom() != null)
		{
			sql += "AND trunc(t.hearingTime)>=:from ";
			params.put("from", req.getFrom());
		}
		if(req.getTo() != null)
		{
			sql += "AND trunc(t.hearingTime)<=:to ";
			params.put("to", req.getTo());
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
	
	
}
