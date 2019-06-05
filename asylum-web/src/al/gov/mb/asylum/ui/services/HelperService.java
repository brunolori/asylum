package al.gov.mb.asylum.ui.services;

import java.util.List;


import al.gov.mb.asylum.ui.api.clients.HelperClient;
import al.gov.mb.asylum.ui.models.AsylantStageDTO;
import al.gov.mb.asylum.ui.models.AsylantStatusDTO;
import al.gov.mb.asylum.ui.models.AsylumDecisionTypeDTO;
import al.gov.mb.asylum.ui.models.DecisionReasonDTO;
import al.gov.mb.asylum.ui.models.DecisionStatusDTO;
import al.gov.mb.asylum.ui.models.DecisionTypeDTO;
import al.gov.mb.asylum.ui.models.DocTypeDTO;
import al.gov.mb.asylum.ui.models.FamilyUnionStatusDTO;
import al.gov.mb.asylum.ui.models.HandedOverDTO;
import al.gov.mb.asylum.ui.models.HearingStatusDTO;
import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.InterviewStatusDTO;
import al.gov.mb.asylum.ui.models.IrStatusDTO;
import al.gov.mb.asylum.ui.models.OrganizationDTO;
import al.gov.mb.asylum.ui.models.PlaceTypeDTO;
import al.gov.mb.asylum.ui.models.QuestionDTO;
import al.gov.mb.asylum.ui.models.StateDTO;
import al.gov.mb.asylum.ui.models.TimsDocumentDTO;
import al.gov.mb.asylum.ui.models.TransferStatusDTO;
import al.gov.mb.asylum.ui.utils.StringUtil;



public class HelperService {
	
	
	public List<DecisionReasonDTO> listDecisionReason(String typeOrder)
	{
		return new HelperClient().listDecisionReason(typeOrder);
	}
	
	public List<DecisionStatusDTO> listDecisionStatus()
	{
		return new HelperClient().listDecisionStatus();
	}
	
	public List<StateDTO> listStates(String name)
	{
		return new HelperClient().listStates(name);
	}
	
	public List<DecisionTypeDTO> listDecisionType()
	{
		return new HelperClient().listDecisionType();
	}
	
	public List<HandedOverDTO> listHandedOver()
	{
		return new HelperClient().listHandedOver();
	}
	
	public List<IrStatusDTO> listIrStatus()
	{
		return new HelperClient().listIrStatus();
	}
	
	public List<OrganizationDTO> listOrganization()
	{
		return new HelperClient().listOrganization();
	}
	
	public List<PlaceTypeDTO> listPlaceType()
	{
		return new HelperClient().listPlaceType();
	}
	
	public List<AsylantStageDTO> listAsylantStage()
	{
		return new HelperClient().listAsylantStage();
	}
	
	public List<AsylantStatusDTO> listAsylantStatus()
	{
		return new HelperClient().listAsylantStatus();
	}
	
	public List<AsylumDecisionTypeDTO> listAsylumDecisionType()
	{
		return new HelperClient().listAsylumDecisionType();
	}
	
	public List<FamilyUnionStatusDTO> listFamilyUnionStatus()
	{
		return new HelperClient().listFamilyUnionStatus();
	}
	
	public List<HearingStatusDTO> listHearingStatus()
	{
		return new HelperClient().listHearingStatus();
	}
	
	public List<InterviewDTO> listInterviewStatus()
	{
		return new HelperClient().listInterviewStatus();
	}
	
	public List<TransferStatusDTO> listTransferStatus()
	{
		return new HelperClient().listTransferStatus();
	}
	
	public List<QuestionDTO> listQuestion()
	{
		return new HelperClient().listQuestion();
	}
	
	
	
	
	
	
	public DecisionReasonDTO findDecisionReason(String codeOrder, String typeOrder)
	{
		return new HelperClient().findDecisionReason(codeOrder, typeOrder);
	}
	
	public DecisionStatusDTO findDecisionStatus(String id)
	{
		return new HelperClient().findDecisionStatus(id);
	}
	
	public DecisionTypeDTO findDecisionType(String id)
	{
		return new HelperClient().findDecisionType(id);
	}
	
	public HandedOverDTO findHandedOver(String id)
	{
		return new HelperClient().findHandedOver(id);
	}
	
	public IrStatusDTO findIrStatus(String id)
	{
		return new HelperClient().findIrStatus(id);
	}
	
	public OrganizationDTO findOrganization(Integer id)
	{
		return new HelperClient().findOrganization(id);
	}
	
	public PlaceTypeDTO findPlaceType(String id)
	{
		return new HelperClient().findPlaceType(id);
	}
	
	public AsylantStageDTO findAsylantStage(Integer id)
	{
		return new HelperClient().findAsylantStage(id);
	}
	
	public AsylantStatusDTO findAsylantStatus(Integer id)
	{
		return new HelperClient().findAsylantStatus(id);
	}
	
	public AsylumDecisionTypeDTO findAsylumDecisionType(Integer id)
	{
		return new HelperClient().findAsylumDecisionType(id);
	}
	
	public FamilyUnionStatusDTO findFamilyUnionStatus(Integer id)
	{
		return new HelperClient().findFamilyUnionStatus(id);
	}
	
	public HearingStatusDTO findHearingStatus(Integer id)
	{
		return new HelperClient().findHearingStatus(id);
	}
	
	public InterviewStatusDTO findInterviewStatus(Integer id)
	{
		return new HelperClient().findInterviewStatus(id);
	}
	
	public TransferStatusDTO  findTransferStatus(Integer id)
	{
		return new HelperClient().findTransferStatus(id);
	}
	
	public QuestionDTO findQuestion(Integer id)
	{
		return new HelperClient().findQuestion(id);
	}

	public TimsDocumentDTO findTimsDocument(String value) {

		if(!StringUtil.isValid(value)) return null;
		
		String[] data = value.split(",",-1);
		
		if(data.length != 3) return null;
		
		String docNo = data[0];
		String typeCode = data[1];
		String stateCode = data[2];
		
		return new HelperClient().findTimsDocument(docNo,typeCode,stateCode);
		
	}

	public List<DocTypeDTO> listDocType() {
		return new HelperClient().listDocType();
	}

	public StateDTO findStateByCode(String value) {
		return new HelperClient().findStateByCode(value);
	}
	
	
	
	
	

}
