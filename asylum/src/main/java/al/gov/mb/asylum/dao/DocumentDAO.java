package al.gov.mb.asylum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.entities.tims.Document;
import al.gov.mb.asylum.entities.tims.OtherDocument;
import al.gov.mb.asylum.entities.tims.TravelDocument;

@Repository
@SuppressWarnings("unchecked")
public class DocumentDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	
	public List<TravelDocument> searchTimsDocument(String docNo)
	{
		return em.createQuery("SELECT d FROM TravelDocument d JOIN FETCH d.personsInstitutions p WHERE d.idPK.travelDocNo like :dn")
				.setParameter("dn", docNo.trim().toUpperCase()+"%")
				.getResultList();
	}



	public List<OtherDocument> getSelectionOtherDocuments(Integer eventId) {
		return em.createQuery("SELECT d FROM OtherDocument d WHERE d.idPK.eventId=:eid ORDER BY d.idPK.documentId")
				.setParameter("eid", eventId)
				.getResultList();
	}



	public List<Document> getSelectionDocuments(Integer eventId) {
		return em.createQuery("FROM Document d WHERE d.idPK.eventId=:eid")
				.setParameter("eid", eventId)
				.getResultList();
	}
	
	
	
	

}
