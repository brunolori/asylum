package al.gov.mb.asylum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.entities.AsylantStage;
import al.gov.mb.asylum.entities.AsylantStatus;
import al.gov.mb.asylum.entities.AsylumDecisionType;
import al.gov.mb.asylum.entities.FamilyUnionStatus;
import al.gov.mb.asylum.entities.HearingStatus;
import al.gov.mb.asylum.entities.InterviewStatus;
import al.gov.mb.asylum.entities.Question;
import al.gov.mb.asylum.entities.TransferStatus;
import al.gov.mb.asylum.entities.tims.DecisionReason;
import al.gov.mb.asylum.entities.tims.DecisionReasonPK;
import al.gov.mb.asylum.entities.tims.DecisionStatus;
import al.gov.mb.asylum.entities.tims.DecisionType;
import al.gov.mb.asylum.entities.tims.DocType;
import al.gov.mb.asylum.entities.tims.HandedOver;
import al.gov.mb.asylum.entities.tims.IrStatus;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.PlaceType;
import al.gov.mb.asylum.entities.tims.State;
import al.gov.mb.asylum.entities.tims.TravelDocument;
import al.gov.mb.asylum.entities.tims.TravelDocumentPK;

@Service
public class HelperService {
	
	@Autowired CrudDAO crudDAO;

	
	public List<State> listState(String name)
	{
		return crudDAO.listState(name);
	}
	public List<DecisionReason> listDecisionReason(String typeOrder)
	{
		return crudDAO.listDecisionReason(typeOrder);
	}
	
	public List<DecisionStatus> listDecisionStatus()
	{
		return crudDAO.listDecisionStatus();
	}
	
	public List<DecisionType> listDecisionType()
	{
		return crudDAO.listDecisionType();
	}
	
	public List<HandedOver> listHandedOver()
	{
		return crudDAO.listHandedOver();
	}
	
	public List<IrStatus> listIrStatus()
	{
		return crudDAO.listIrStatus();
	}
	
	public List<Organization> listOrganization()
	{
		return crudDAO.listOrganization();
	}
	
	public List<PlaceType> listPlaceType()
	{
		return crudDAO.listPlaceType();
	}
	
	////**********ASYLUM**************
	
	public List<AsylantStage> listAsylantStage()
	{
		return crudDAO.listAsylantStage();
	}
	
	public List<AsylantStatus> listAsylantStatus()
	{
		return crudDAO.listAsylantStatus();
	}
	
	public List<AsylumDecisionType> listAsylumDecisionType()
	{
		return crudDAO.listAsylumDecisionType();
	}
	
	public List<FamilyUnionStatus> listFamilyUnionStatus()
	{
		return crudDAO.listFamilyUnionStatus();
	}
	
	public List<HearingStatus> listHearingStatus()
	{
		return crudDAO.listHearingStatus();
	}
	
	public List<InterviewStatus> listInterviewStatus()
	{
		return crudDAO.listInterviewStatus();
	}
	
	public List<TransferStatus> listTransferStatus()
	{
		return crudDAO.listTransferStatus();
	}
	
	public List<Question> listQuestion()
	{
		return crudDAO.listQuestion();
	}
	
	//*********** FIND BY ID INTEGER******************
	public <T> T findById(Class<T> claxx, Integer id) {
		return crudDAO.findById(claxx, id);
	}
	
	//*********** FIND BY ID STRING******************
	public <T> T findById(Class<T> claxx, String id) {
		return crudDAO.findById(claxx, id);
	}
	
	
	//*********** FIND BY ID COMPOSITE******************
     public DecisionReason findDecisionReasonById(String codeOrder, String typeOrder) {
		 return crudDAO.findById(DecisionReason.class, new DecisionReasonPK(codeOrder,typeOrder));
	 }
		
     public TravelDocument findTravelDocumentById(String stateCode,String typeCode, String docNo) {
		 return crudDAO.findById(TravelDocument.class, new TravelDocumentPK(stateCode,typeCode,docNo));
	 }
	public List<DocType> listDocType() {
		return crudDAO.listDocTypes();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
