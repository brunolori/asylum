package al.gov.mb.asylum.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.entities.AsylumDecision;
import al.gov.mb.asylum.forms.AsylumDecisionSx;
import al.gov.mb.asylum.utils.DateUtil;
import al.gov.mb.asylum.utils.StringUtil;

@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class AsylumDecisionDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	
	public List<AsylumDecision> searchAsylumDecision(AsylumDecisionSx req)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM AsylumDecision t WHERE t.status=:st ";
		String order = "ORDER BY t.id DESC";
		
		if(StringUtil.isValid(req.getUniqueNo()))
		{
			sql += "AND upper(t.selection.event.uniqueNumber) like :un ";
			params.put("un", req.getUniqueNo().trim().toUpperCase());
		}
		
		if(StringUtil.isValid(req.getName()))
		{
			sql += "AND upper(t.selection.person.name) like :name ";
			params.put("name", req.getName().trim().toUpperCase());
		}
		
		if(req.getGender() != null)
		{
			sql += "AND t.selection.person.gender = :gnd ";
			params.put("gnd", req.getGender());
		}
		
		
		if(StringUtil.isValid(req.getSurname()))
		{
			sql += "AND upper(t.selection.person.surname) like :surname ";
			params.put("surname", req.getSurname());
		}
		
		if(req.getFromAge() != null)
		{
			Date from = DateUtil.getBirthdate(req.getFromAge());
			
			sql += "AND t.selection.person.dob <= :fromAge ";
			params.put("fromAge", from);
		}
		
		if(req.getToAge() != null)
		{
			Date to = DateUtil.getBirthdate(req.getToAge());
			
			sql += "AND t.selection.person.dob >= :toAge ";
			params.put("toAge", to);
		}
		
		
		if(req.getSelectionId() != null)
		{
			sql += "AND t.selection.event.id=:sid ";
			params.put("sid", req.getSelectionId());
		}
		
		if(req.getStageId() != null)
		{
			sql += "AND t.newStage.id=:stgid ";
			params.put("stgid", req.getStageId());
		}
		
		if(req.getStatusId() != null)
		{
			sql += "AND t.newStatus.id=:stsid ";
			params.put("stsid", req.getStatusId());
		}
		
		
		if(req.getFromDate() != null)
		{
			sql += "AND trunc(t.orderDate) >= :fdt ";
			params.put("fdt", req.getFromDate());
		}
		
		if(req.getToDate() != null)
		{
			sql += "AND trunc(t.orderDate) <= :tdt ";
			params.put("tdt", req.getToDate());
		}
		
		if(req.getTypeId() != null)
		{
			sql += "AND t.decisionType.id = :dtid ";
			params.put("dtid", req.getTypeId());
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
