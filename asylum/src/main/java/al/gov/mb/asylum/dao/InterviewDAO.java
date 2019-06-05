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
import al.gov.mb.asylum.entities.Interview;
import al.gov.mb.asylum.entities.InterviewQuestion;
import al.gov.mb.asylum.forms.InterviewSx;
import al.gov.mb.asylum.utils.StringUtil;

@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class InterviewDAO {
	
	@PersistenceContext
	EntityManager em;

	
	
	public List<InterviewQuestion> getInterviewQuestions(Integer interviewId){
		
		return em.createQuery("FROM InterviewQuestion iq WHERE iq.status=:st and iq.interview.id=:iid ORDER BY iq.id")
				.setParameter("st", IStatus.ACTIVE)
				.setParameter("iid", interviewId)
				.getResultList();

	}
	
	
	public List<Interview> searchInterview(InterviewSx req)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Interview t WHERE t.status=:st ";
		String order = "ORDER BY t.id DESC";
		
		if(StringUtil.isValid(req.getUniqueNo()))
		{
			sql += "AND upper(t.selection.event.uniqueNumber) like :un ";
			params.put("un", req.getUniqueNo().trim().toUpperCase());
		}
		if(req.getInterviewStatus() != null)
		{
			sql += "AND t.interviewStatus.id = :isid ";
			params.put("isid", req.getInterviewStatus());
		}
		if(StringUtil.isValid(req.getName()))
		{
			sql += "AND upper(t.selection.person.name) like :name ";
			params.put("name", req.getName().trim().toUpperCase());
		}
		if(StringUtil.isValid(req.getSurname()))
		{
			sql += "AND upper(t.selection.person.surname) like :surname ";
			params.put("surname", req.getSurname().trim().toUpperCase());
		}
		if(req.getSelectionId() != null)
		{
			sql += "AND t.selection.event.id=:sid ";
			params.put("sid", req.getSelectionId());
		}
		
		if(req.getFrom() != null)
		{
			sql += "AND trunc(t.interviewTime)>=:from ";
			params.put("from", req.getFrom());
		}
		if(req.getTo() != null)
		{
			sql += "AND trunc(t.interviewTime)<=:to ";
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
