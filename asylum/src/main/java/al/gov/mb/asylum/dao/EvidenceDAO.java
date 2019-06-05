package al.gov.mb.asylum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.entities.tims.Evidence;

@Repository
@SuppressWarnings("unchecked")
public class EvidenceDAO {
	
	@PersistenceContext
	EntityManager em;

	
	public List<Evidence> getEventEvidences(Integer eventId) {
		return em.createQuery("FROM Evidence e WHERE e.idPK.eventId=:eid ORDER BY e.idPK.evidenceId")
				.setParameter("eid", eventId).getResultList();
	}
	
	
	
	

}
