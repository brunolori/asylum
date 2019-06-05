package al.gov.mb.asylum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.entities.InstitutionOpinion;


@Repository
@SuppressWarnings("unchecked")
public class InstitutionOpinionDAO {
	
	@PersistenceContext
	EntityManager em;

	
	public List<InstitutionOpinion> getSelectionOpinions(Integer eventId) {

		return em.createQuery("FROM InstitutionOpinion o WHERE o.status=:st and o.selection.event.id=:eid ORDER BY o.id DESC")
				.setParameter("st", IStatus.ACTIVE)
				.setParameter("eid", eventId)
				.getResultList();
		
	}
	
	
	

}
