package al.gov.mb.asylum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.entities.Appeal;

@Repository
@SuppressWarnings("unchecked")
public class AppealDAO {
	
	@PersistenceContext
	EntityManager em;

	
	public List<Appeal> getSelectionAppeals(Integer eventId) {
		return em.createQuery("FROM Appeal a WHERE a.status=:st and a.selection.event.id=:eid ORDER BY a.id DESC")
				.setParameter("st", IStatus.ACTIVE)
				.setParameter("eid", eventId)
				.getResultList();
	}

}
