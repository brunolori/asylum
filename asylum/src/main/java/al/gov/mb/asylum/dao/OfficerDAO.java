package al.gov.mb.asylum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.entities.tims.Officer;

@Repository
@SuppressWarnings("unchecked")
public class OfficerDAO {
	
	@PersistenceContext
	EntityManager em;

	public List<Officer> getEventOfficers(Integer eventId) {
		return em.createQuery("FROM Officer o WHERE o.idPK.eventId=:eid ORDER BY o.idPK.officerId")
				.setParameter("eid", eventId)
				.getResultList();
	}

}
