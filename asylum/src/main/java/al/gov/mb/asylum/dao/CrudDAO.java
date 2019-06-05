package al.gov.mb.asylum.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.entities.AsylantStage;
import al.gov.mb.asylum.entities.AsylantStatus;
import al.gov.mb.asylum.entities.AsylumDecisionType;
import al.gov.mb.asylum.entities.FamilyUnionStatus;
import al.gov.mb.asylum.entities.HearingStatus;
import al.gov.mb.asylum.entities.InterviewStatus;
import al.gov.mb.asylum.entities.Question;
import al.gov.mb.asylum.entities.TransferStatus;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.DecisionReason;
import al.gov.mb.asylum.entities.tims.DecisionStatus;
import al.gov.mb.asylum.entities.tims.DecisionType;
import al.gov.mb.asylum.entities.tims.DocType;
import al.gov.mb.asylum.entities.tims.HandedOver;
import al.gov.mb.asylum.entities.tims.IrStatus;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.PlaceType;
import al.gov.mb.asylum.entities.tims.State;

@Repository
@SuppressWarnings("unchecked")
public class CrudDAO {


	@PersistenceContext
	EntityManager em;
	
	@Autowired UserDAO userDAO;

	public <T> T create(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	public <T> T update(T entity) {
		return em.merge(entity);
	}

	public <T> T findById(Class<T> claxx, Object id) {
				
		if(claxx.getName().equals(User.class.getName()))
		{
			return (T) userDAO.findByUsername((String)id);
		}
		return em.find(claxx, id);
	}
	
	//*******FER*****************************
	
	
	public List<State> listState(String name)
	{
		return em.createQuery("FROM State s WHERE s.tag like :tag ORDER BY s.tag")
				.setParameter("tag", name.trim().toUpperCase()+"%")
				.getResultList();
	}
	
	
	
	public List<DecisionReason> listDecisionReason(String typeOrder)
	{
		return em.createQuery("FROM DecisionReason dr WHERE dr.status=:st AND dr.idPK.typeOrder=:to ORDER BY dr.idPK.codeOrder")
				.setParameter("st", IStatus.F_ACTIVE)
				.setParameter("to", typeOrder)
				.getResultList();
	}
	
	public List<DecisionStatus> listDecisionStatus()
	{
		return em.createQuery("FROM DecisionStatus ds ORDER BY ds.id").getResultList();
	}
	
	public List<DecisionType> listDecisionType()
	{
		return em.createQuery("FROM DecisionType dt WHERE dt.status=:st ORDER BY dt.id")
				.setParameter("st", IStatus.F_ACTIVE)
				.getResultList();
	}
	
	public List<HandedOver> listHandedOver()
	{
		return em.createQuery("FROM HandedOver ho ORDER BY ho.id").getResultList();
	}
	
	public List<IrStatus> listIrStatus()
	{
		return em.createQuery("FROM IrStatus ist WHERE ist.status=:st ORDER BY ist.id")
				.setParameter("st", IStatus.F_ACTIVE)
				.getResultList();
	}
	
	public List<Organization> listOrganization()
	{
		return em.createQuery("FROM Organization o ORDER BY o.tag")
				.getResultList();
	}
	
	public List<PlaceType> listPlaceType()
	{
		return em.createQuery("FROM PlaceType pt WHERE pt.status=:st ORDER BY pt.id")
				.setParameter("st", (short)IStatus.ACTIVE)
				.getResultList();
	}
	
	////**********ASYLUM**************
	
	public List<AsylantStage> listAsylantStage()
	{
		return em.createQuery("FROM AsylantStage t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<AsylantStatus> listAsylantStatus()
	{
		return em.createQuery("FROM AsylantStatus t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<AsylumDecisionType> listAsylumDecisionType()
	{
		return em.createQuery("FROM AsylumDecisionType t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<FamilyUnionStatus> listFamilyUnionStatus()
	{
		return em.createQuery("FROM FamilyUnionStatus t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<HearingStatus> listHearingStatus()
	{
		return em.createQuery("FROM HearingStatus t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<InterviewStatus> listInterviewStatus()
	{
		return em.createQuery("FROM InterviewStatus t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<TransferStatus> listTransferStatus()
	{
		return em.createQuery("FROM TransferStatus t WHERE t.status=:st ORDER BY t.id")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}
	
	public List<Question> listQuestion()
	{
		return em.createQuery("FROM Question q WHERE q.status=:st ORDER BY q.rank")
				.setParameter("st", IStatus.ACTIVE)
				.getResultList();
	}

	public List<DocType> listDocTypes() {
		return em.createQuery("FROM DocType q")
				.getResultList();
	}
	
	
	
	
	
	
	
	
	
}
