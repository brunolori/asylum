package al.gov.mb.asylum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.entities.tims.Decision;

@Repository
@SuppressWarnings("unchecked")
public class DecisionDAO {
	
	@PersistenceContext
	EntityManager em;

	
	
	public List<Decision> searchDecision(Integer eventId)
	{
		return em.createQuery("FROM Decision d WHERE d.selection.event.id=:id")
				.setParameter("id", eventId).getResultList();
	}
	
	
	
}
