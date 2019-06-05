package al.gov.mb.asylum.assemblers;

import java.util.ArrayList;
import java.util.List;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dto.AppealDTO;
import al.gov.mb.asylum.dto.AsylantDetailsDTO;
import al.gov.mb.asylum.dto.AsylantStageDTO;
import al.gov.mb.asylum.dto.AsylantStatusDTO;
import al.gov.mb.asylum.dto.AsylumDecisionDTO;
import al.gov.mb.asylum.dto.AsylumDecisionTypeDTO;
import al.gov.mb.asylum.dto.BiometricDTO;
import al.gov.mb.asylum.dto.DecisionDTO;
import al.gov.mb.asylum.dto.DecisionHistoryDTO;
import al.gov.mb.asylum.dto.DecisionReasonDTO;
import al.gov.mb.asylum.dto.DecisionStatusDTO;
import al.gov.mb.asylum.dto.DecisionTypeDTO;
import al.gov.mb.asylum.dto.DocTypeDTO;
import al.gov.mb.asylum.dto.DocumentDTO;
import al.gov.mb.asylum.dto.EventDTO;
import al.gov.mb.asylum.dto.EvidenceDTO;
import al.gov.mb.asylum.dto.FamilyUnionDTO;
import al.gov.mb.asylum.dto.FamilyUnionStatusDTO;
import al.gov.mb.asylum.dto.FeedbackDTO;
import al.gov.mb.asylum.dto.HandedOverDTO;
import al.gov.mb.asylum.dto.HearingDTO;
import al.gov.mb.asylum.dto.HearingStatusDTO;
import al.gov.mb.asylum.dto.InstitutionOpinionDTO;
import al.gov.mb.asylum.dto.InterviewDTO;
import al.gov.mb.asylum.dto.InterviewQuestionDTO;
import al.gov.mb.asylum.dto.InterviewStatusDTO;
import al.gov.mb.asylum.dto.IrStatusDTO;
import al.gov.mb.asylum.dto.OfficerDTO;
import al.gov.mb.asylum.dto.OrganizationDTO;
import al.gov.mb.asylum.dto.OtherDocumentDTO;
import al.gov.mb.asylum.dto.PersonDTO;
import al.gov.mb.asylum.dto.PlaceTypeDTO;
import al.gov.mb.asylum.dto.QuestionDTO;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.dto.StateDTO;
import al.gov.mb.asylum.dto.TimsDocumentDTO;
import al.gov.mb.asylum.dto.TransferDTO;
import al.gov.mb.asylum.dto.TransferStatusDTO;
import al.gov.mb.asylum.dto.UserDTO;
import al.gov.mb.asylum.entities.Appeal;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.AsylantStage;
import al.gov.mb.asylum.entities.AsylantStatus;
import al.gov.mb.asylum.entities.AsylumDecision;
import al.gov.mb.asylum.entities.AsylumDecisionType;
import al.gov.mb.asylum.entities.FamilyUnion;
import al.gov.mb.asylum.entities.FamilyUnionStatus;
import al.gov.mb.asylum.entities.Feedback;
import al.gov.mb.asylum.entities.Hearing;
import al.gov.mb.asylum.entities.HearingStatus;
import al.gov.mb.asylum.entities.InstitutionOpinion;
import al.gov.mb.asylum.entities.Interview;
import al.gov.mb.asylum.entities.InterviewQuestion;
import al.gov.mb.asylum.entities.InterviewStatus;
import al.gov.mb.asylum.entities.Question;
import al.gov.mb.asylum.entities.Transfer;
import al.gov.mb.asylum.entities.TransferStatus;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.Biometric;
import al.gov.mb.asylum.entities.tims.Decision;
import al.gov.mb.asylum.entities.tims.DecisionHistory;
import al.gov.mb.asylum.entities.tims.DecisionReason;
import al.gov.mb.asylum.entities.tims.DecisionStatus;
import al.gov.mb.asylum.entities.tims.DecisionType;
import al.gov.mb.asylum.entities.tims.DocType;
import al.gov.mb.asylum.entities.tims.Document;
import al.gov.mb.asylum.entities.tims.Evidence;
import al.gov.mb.asylum.entities.tims.HandedOver;
import al.gov.mb.asylum.entities.tims.IrStatus;
import al.gov.mb.asylum.entities.tims.IrregularEvent;
import al.gov.mb.asylum.entities.tims.Officer;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.OtherDocument;
import al.gov.mb.asylum.entities.tims.Person;
import al.gov.mb.asylum.entities.tims.PlaceType;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.entities.tims.State;
import al.gov.mb.asylum.entities.tims.TravelDocument;
import al.gov.mb.asylum.utils.CalculatorUtil;

public class Assembler {

	
	public StateDTO toDto(State e)
	{
		if(e==null) return null;
		
		StateDTO dto = new StateDTO();
		dto.setCode(e.getCode());
		dto.setCodeAlpha3(e.getCodeAlpha3());
		dto.setEnTag(e.getEnTag());
		dto.setTag(e.getTag());
		
		return dto;
	}
	
	public AppealDTO toDto(Appeal e)
	{
		if(e==null) return null;
		
		AppealDTO dto = new AppealDTO();
		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setAppealTime(e.getAppealTime());
		dto.setAppealUser(e.getAppealUser());
		dto.setDecisionDate(e.getDecisionDate());
		dto.setDecisionNo(e.getDecisionNo());
		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setSelection(toDto(e.getSelection()));
		
		return dto;
	}
	
	public SelectionDTO toDto(Selection e) {
		
		if(e==null) return null;
		
		SelectionDTO dto = new SelectionDTO();
		dto.setAlbAddress(e.getAlbAddress());
		
		if(e.getAsylantDetails() == null)
		{
			e.setAsylantDetails(new AsylantDetails());
		}
		
		dto.setAsylantDetails(toDto(e.getAsylantDetails()));
		dto.setEntryMode(e.getEntryMode());
		dto.setEntryPlace(e.getEntryPlace());
		dto.setEvent(toDto(e.getEvent()));
		dto.setFleeingReason(e.getFleeingReason());
		dto.setHanded(toDto(e.getHanded()));
		dto.setInterviewer(e.getInterviewer());
		dto.setIrStatus(toDto(e.getIrStatus()));
		dto.setItinerary(e.getItinerary());
		dto.setModifUser(e.getModifUser());
		dto.setNotes(e.getNotes());
		dto.setPerson(toDto(e.getPerson()));
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setSelectionDate(e.getSelectionDate());
		dto.setTransLang(e.getTransLang());
		dto.setTranslator(e.getTranslator());
		return dto;
	}
	
	public PersonDTO toDto(Person e) {

		if(e==null) return null;
		
		PersonDTO dto = new PersonDTO();
		
		dto.setCodeCityBirth(e.getCodeCityBirth());
		dto.setCodeCivilStatus(e.getCodeCivilStatus());
		dto.setCodeNationality(e.getCodeNationality());
		dto.setCodeOS(e.getCodeOS());
		dto.setCodeStateBirth(e.getCodeStateBirth());
		dto.setDob(e.getDob());
		dto.setDobText(e.getDobText());
		dto.setFatherName(e.getFatherName());
		dto.setGender(e.getGender());
		dto.setId(e.getId());
		dto.setMidleName(e.getMidleName());
		dto.setModifUser(e.getModifUser());
		dto.setMotherName(e.getMotherName());
		dto.setName(e.getName());
		dto.setName1(e.getName1());
		dto.setNid(e.getNid());
		dto.setPersonTimsId(e.getPersonTimsId());
		dto.setProfesion(e.getProfesion());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setReligion(e.getReligion());
		dto.setSurname(e.getSurname());
		dto.setSurname1(e.getSurname1());
		
		return dto;
	}

	public AsylantDetailsDTO toDto(AsylantDetails e) {

		if(e==null) return null;
		
		AsylantDetailsDTO dto = new AsylantDetailsDTO();
		dto.setAsylantStage(toDto(e.getAsylantStage()));
		dto.setAsylantStatus(toDto(e.getAsylantStatus()));
		dto.setCurrentLocation(toDto(e.getCurrentLocation()));
		dto.setEventId(e.getEventId());
		dto.setFamilyId(e.getFamilyId());
		dto.setFamilyUnionStatus(toDto(e.getFamilyUnionStatus()));
		dto.setFeedbackValue(e.getFeedbackValue());
		dto.setHearingCnt(e.getHearingCnt() == null?0:e.getHearingCnt());
		dto.setInNeed(e.getInNeed());
		dto.setInterviewCnt(e.getInterviewCnt()== null?0:e.getInterviewCnt());
		dto.setIssuedAlbDocs(e.getIssuedAlbDocs());
		dto.setLastHearingStatus(toDto(e.getLastHearingStatus()));
		dto.setLastInterviewStatus(toDto(e.getLastInterviewStatus()));
		dto.setNeeds(e.getNeeds());
		dto.setTransferStatus(toDto(e.getTransferStatus()));
		dto.setUnaccompainedChild(e.getUnaccompainedChild());
		dto.setWithIncomes(e.getWithIncomes());
		dto.setReturned(e.getReturned());
		dto.setIncomes(e.getIncomes());
		dto.setAcceleratedProcess(e.getAcceleratedProcess());
		return dto;
	}

	public AsylantStageDTO toDto(AsylantStage e)
	{
		if(e==null) return null;
		
		AsylantStageDTO dto = new AsylantStageDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public AsylantStatusDTO toDto(AsylantStatus e)
	{
		if(e==null) return null;
		
		AsylantStatusDTO dto = new AsylantStatusDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public AsylumDecisionTypeDTO toDto(AsylumDecisionType e)
	{
		if(e==null) return null;
		
		AsylumDecisionTypeDTO dto = new AsylumDecisionTypeDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public DecisionStatusDTO toDto(DecisionStatus e)
	{
		if(e==null) return null;
		
		DecisionStatusDTO dto = new DecisionStatusDTO();
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEng(e.getTagEng());
		return dto;
	}

	public DecisionTypeDTO toDto(DecisionType e)
	{
		if(e==null) return null;
		
		DecisionTypeDTO dto = new DecisionTypeDTO();
		dto.setStatus(e.getStatus() != null && e.getStatus().equals(IStatus.F_ACTIVE));
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEng(e.getTagEng());
		return dto;
	}
	
	public FamilyUnionStatusDTO toDto(FamilyUnionStatus e)
	{
		if(e==null) return null;
		
		FamilyUnionStatusDTO dto = new FamilyUnionStatusDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public HearingStatusDTO toDto(HearingStatus e)
	{
		if(e==null) return null;
		
		HearingStatusDTO dto = new HearingStatusDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public InterviewStatusDTO toDto(InterviewStatus e)
	{
		if(e==null) return null;
		
		InterviewStatusDTO dto = new InterviewStatusDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public IrStatusDTO toDto(IrStatus e)
	{
		if(e==null) return null;
		
		IrStatusDTO dto = new IrStatusDTO();
		dto.setStatus(e.getStatus() != null && e.getStatus().equals(IStatus.F_ACTIVE));
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		return dto;
	}
	
	public PlaceTypeDTO toDto(PlaceType e)
	{
		if(e==null) return null;
		
		PlaceTypeDTO dto = new PlaceTypeDTO();
		dto.setStatus(e.getStatus() == (short)IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		return dto;
	}
	
	public TransferStatusDTO toDto(TransferStatus e)
	{
		if(e==null) return null;
		
		TransferStatusDTO dto = new TransferStatusDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setTag(e.getTag());
		dto.setTagEn(e.getTagEn());
		return dto;
	}
	
	public DecisionReasonDTO toDto(DecisionReason e)
	{
		if(e==null) return null;
		
		DecisionReasonDTO dto = new DecisionReasonDTO();
		dto.setStatus(e.getStatus() != null && e.getStatus().equals(IStatus.F_ACTIVE));
		dto.setCodeOrder(e.getIdPK().getCodeOrder());
		dto.setDecisionType(toDto(e.getDecisionType()));
		dto.setTypeOrder(e.getIdPK().getTypeOrder());
		dto.setTag(e.getTag());
		dto.setTagEng(e.getTagEng());
		return dto;
	}
	
	public AsylumDecisionDTO toDto(AsylumDecision e)
	{
		if(e==null) return null;
		
		AsylumDecisionDTO dto = new AsylumDecisionDTO();
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setArticle(e.getArticle());
		dto.setDecisionTime(e.getDecisionTime());
		dto.setDecisionType(toDto(e.getDecisionType()));
		dto.setDecisionUser(e.getDecisionUser());
		dto.setId(e.getId());
		dto.setNewStage(toDto(e.getNewStage()));
		dto.setNewStatus(toDto(e.getNewStatus()));
		dto.setNotes(e.getNotes());
		dto.setOldStage(toDto(e.getOldStage()));
		dto.setOldStatus(toDto(e.getOldStatus()));
		dto.setOrderDate(e.getOrderDate());
		dto.setOrderNo(e.getOrderNo());
		dto.setSelection(toDto(e.getSelection()));
		
		return dto;
	}

	public DecisionHistoryDTO toDto(DecisionHistory e)
	{
		if(e==null) return null;
		
		DecisionHistoryDTO dto = new DecisionHistoryDTO();
		dto.setDecision(toDto(e.getDecision()));
		dto.setField(e.getField());
		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setProcess(e.getProcess());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		return dto;
	}

	public DecisionDTO toDto(Decision e)
	{
		if(e==null) return null;
		
		DecisionDTO dto = new DecisionDTO();
		dto.setArticle(e.getArticle());
		dto.setId(e.getId());
		dto.setBorderCrossingPoint(e.getBorderCrossingPoint());
		dto.setDatePermitEntrance(e.getDatePermitEntrance());
		dto.setDayRemoval(e.getDayRemoval());
		dto.setDecisionReason(toDto(e.getDecisionReason()));
		dto.setModifUser(e.getModifUser());
		dto.setOrderDate(e.getOrderDate());
		dto.setOrderNumber(e.getOrderNumber());
		dto.setOrderStatus(toDto(e.getOrderStatus()));
		dto.setReason(e.getReason());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setSelection(toDto(e.getSelection()));
		dto.setDecisionType(toDto(e.getDecisionType()));
		return dto;
	}

	public BiometricDTO toDto(Biometric e)
	{
		if(e==null) return null;
		
		BiometricDTO dto = new BiometricDTO();
		//dto.setEvent(toDto(e.getEvent()));
		dto.setEventId(e.getEventId());
		dto.setModifUser(e.getModifUser());
		dto.setPhoto(CalculatorUtil.encodeBASE64(e.getPhoto()));
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setUniqueNumber(e.getUniqueNumber());
		
		return dto;
	}

	public DocumentDTO toDto(Document e)
	{
		if(e==null) return null;
		
		DocumentDTO dto = new DocumentDTO();
		dto.setCodeState(e.getIdPK().getCodeState());
		dto.setCodeTypeTravelDoc(e.getIdPK().getCodeTypeTravelDoc());
		dto.setDateOfExpiration(e.getDateOfExpiration());
		dto.setDateOfExtension(e.getDateOfExtension());
		dto.setDateOfIssue(e.getDateOfIssue());
		dto.setEventId(e.getIdPK().getEventId());
		dto.setModifUser(e.getModifUser());
		dto.setPersonId(e.getPersonId());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setTravelDocNo(e.getIdPK().getTravelDocNo());
		
		return dto;
	}

	public EventDTO toDto(IrregularEvent e)
	{
		if(e==null) return null;
		
		EventDTO dto = new EventDTO();
		dto.setId(e.getId());
		dto.setDescription(e.getDescription());
		dto.setEventDate(e.getEventDate());
		dto.setModifUser(e.getModifUser());
		dto.setOrganization(toDto(e.getOrganization()));
		dto.setPlace(e.getPlace());
		dto.setPlaceType(toDto(e.getPlaceType()));
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setUniqurNumber(e.getUniqurNumber());
		return dto;
	}
	
	public OrganizationDTO toDto(Organization e) {
		if(e==null) return null;
		
		OrganizationDTO dto = new OrganizationDTO();
		dto.setCentral(e.getCentral() != null && e.getCentral().equals(IStatus.F_ACTIVE));
		dto.setId(e.getId());
		dto.setNewId(e.getNewId());
		dto.setOldId(e.getOldId());
		dto.setOldTag(e.getOldTag());
		dto.setTag(e.getTag());
		return dto;
	}

	public EvidenceDTO toDto(Evidence e)
	{
		if(e==null) return null;
		
		EvidenceDTO dto = new EvidenceDTO();
		dto.setDescription(e.getDescription());
		dto.setEvent(toDto(e.getEvent()));
		dto.setEventId(e.getIdPK().getEventId());
		dto.setEvidenceId(e.getIdPK().getEvidenceId());
		dto.setModifUser(e.getModifUser());
		dto.setName(e.getName());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		return dto;
	}

	public FamilyUnionDTO toDto(FamilyUnion e)
	{
		if(e==null) return null;
		
		FamilyUnionDTO dto = new FamilyUnionDTO();
		dto.setFamilyId(e.getFamilyId());
		dto.setFamilyStatus(toDto(e.getFamilyStatus()));
		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		return dto;
	}
	
	public FeedbackDTO toDto(Feedback e)
	{
		if(e==null) return null;
		
		FeedbackDTO dto = new FeedbackDTO();
		dto.setFeedbackTime(e.getFeedbackTime());
		dto.setFeedbackUser(e.getFeedbackUser());
		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setSelection(toDto(e.getSelection()));
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setValue(e.getValue());
		return dto;
	}

	public HandedOverDTO toDto(HandedOver e)
	{
		if(e==null) return null;
		
		HandedOverDTO dto = new HandedOverDTO();
		dto.setId(e.getId());
		dto.setStatus(e.getStatus() != null && e.getStatus().equals(IStatus.F_ACTIVE));
		dto.setTag(e.getTag());
		return dto;
	}
	
	public HearingDTO toDto(Hearing e)
	{
		if(e==null) return null;
		
		HearingDTO dto = new HearingDTO();
		dto.setHearingStatus(toDto(e.getHearingStatus()));
		dto.setHearingTime(e.getHearingTime());
		dto.setHearingUser(e.getHearingUser());
		dto.setId(e.getId());
		dto.setLanguage(e.getLanguage());
		dto.setListener(e.getListener());
		dto.setNotes(e.getNotes());
		dto.setSelection(toDto(e.getSelection()));
		dto.setSelectionTime(e.getSelectionTime());
		dto.setSelectionUser(e.getSelectionUser());
		dto.setTranslator(e.getTranslator());
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setSelectionNotes(e.getSelectionNotes());
		dto.setPredictedHearingDate(e.getPredictedHearingDate());
		return dto;
	}
	
	public InterviewDTO toDto(Interview e)
	{
		if(e==null) return null;
		
		InterviewDTO dto = new InterviewDTO();
		dto.setInterviewStatus(toDto(e.getInterviewStatus()));
		dto.setInterviewTime(e.getInterviewTime());
		dto.setInterviewUser(e.getInterviewUser());
		dto.setId(e.getId());
		dto.setLanguage(e.getLanguage());
		dto.setInterviewer(e.getInterviewer());
		dto.setNotes(e.getNotes());
		dto.setSelectionNotes(e.getSelectionNotes());
		dto.setPredictedInterviewDate(e.getPredictedInteviewDate());
		dto.setSelection(toDto(e.getSelection()));
		dto.setSelectionTime(e.getSelectionTime());
		dto.setSelectionUser(e.getSelectionUser());
		dto.setTranslator(e.getTranslator());
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		return dto;
	}

	public InstitutionOpinionDTO toDto(InstitutionOpinion e)
	{
		if(e==null) return null;
		
		InstitutionOpinionDTO dto = new InstitutionOpinionDTO();
		dto.setInstitution(e.getInstitution());
		dto.setOpinionTime(e.getOpinionTime());
		dto.setOpinionUser(e.getOpinionUser());
		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setSelection(toDto(e.getSelection()));
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		return dto;
	}

	public InterviewQuestionDTO toDto(InterviewQuestion e)
	{
		if(e==null) return null;
		
		InterviewQuestionDTO dto = new InterviewQuestionDTO();
		dto.setAnswer(e.getAnswer());
		dto.setId(e.getId());
		dto.setInterview(toDto(e.getInterview()));
		dto.setQuestion(e.getQuestion());
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		return dto;
		
	}

	public OfficerDTO toDto(Officer e)
	{
		if(e==null) return null;
		
		OfficerDTO dto = new OfficerDTO();
		dto.setEventId(e.getIdPK().getEventId());
		dto.setGrade(e.getGrade());
		dto.setModifUser(e.getModifUser());
		dto.setName(e.getName());
		dto.setOfficerId(e.getIdPK().getOfficerId());
		dto.setOrganization(e.getOrganization());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setSurname(e.getSurname());
		return dto;
	}

	public OtherDocumentDTO toDto(OtherDocument e)
	{
		if(e==null) return null;
		
		OtherDocumentDTO dto = new OtherDocumentDTO();
		dto.setDocType(e.getDocType());
		dto.setDocumentId(e.getIdPK().getDocumentId());
		dto.setDocumentNo(e.getDocumentNo());
		dto.setEventId(e.getIdPK().getEventId());
		dto.setModifUser(e.getModifUser());
		dto.setRecordDate(e.getRecordDate());
		dto.setRecordUser(e.getRecordUser());
		dto.setState(e.getState());
		return dto;
	}

	public QuestionDTO toDto(Question e)
	{
		if(e==null) return null;
	
		QuestionDTO dto = new QuestionDTO();
		dto.setId(e.getId());
		dto.setRank(e.getRank());
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setTag(e.getTag());
		return dto;
	}

	public TransferDTO toDto(Transfer e)
	{
			if(e==null) return null;
			
			TransferDTO dto = new TransferDTO();
			dto.setCheckInNotes(e.getCheckInNotes());
			dto.setCheckInTime(e.getCheckInTime());
			dto.setCheckInUser(e.getCheckInUser());
			dto.setCheckOutUser(e.getCheckOutUser());
			dto.setCheckOutTime(e.getCheckOutTime());
			dto.setCheckOutNotes(e.getCheckOutNotes());
			dto.setFromOrganization(toDto(e.getFromOrganization()));
			dto.setId(e.getId());
			dto.setSelection(toDto(e.getSelection()));
			dto.setStatus(e.getStatus() == IStatus.ACTIVE);
			dto.setToOrganization(toDto(e.getToOrganization()));
			dto.setTransferStatus(toDto(e.getTransferStatus()));
			return dto;
			
	}
	
	public UserDTO toDto(User e)
	{
		if(e==null) return null;
		
		UserDTO dto = new UserDTO();
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(e.getCreateUser());
		dto.setName(e.getName());
		dto.setOrganization(toDto(e.getOrganization()));
		dto.setRole(e.getRole());
		//dto.setSecret(e.getSecret());
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		dto.setSurname(e.getSurname());
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(e.getUpdateUser());
		dto.setUsername(e.getUsername());
		return dto;
	}
	
	public TimsDocumentDTO toDto(TravelDocument e)
	{
		if(e==null) return null;
		
		TimsDocumentDTO dto = new TimsDocumentDTO();
		dto.setCodeOs(e.getPersonsInstitutions().getIdPK().getCodeOS());
		dto.setPersonId(e.getPersonsInstitutions().getIdPK().getPersonId());
		dto.setCodeCityBirth(e.getPersonsInstitutions().getCodeCityBirth());
		dto.setCodeStateBirth(e.getPersonsInstitutions().getCodeStateBirth());
		dto.setDateOfExpiration(e.getDateOfExpiration());
		dto.setDateOfExtension(e.getDateOfExtension());
		dto.setDateOfIssue(e.getDateOfIssue());
		dto.setDob(e.getPersonsInstitutions().getDob());
		dto.setDocStateCode(e.getIdPK().getCodeState());
		dto.setDocType(e.getDocType().getTag());
		dto.setDocTypeCode(e.getDocType().getId());
		dto.setDocumentNo(e.getIdPK().getTravelDocNo());
		dto.setFatherName(e.getPersonsInstitutions().getFatherName());
		dto.setGender(e.getPersonsInstitutions().getGender());
		dto.setMotherName(e.getPersonsInstitutions().getMotherName());
		dto.setName(e.getPersonsInstitutions().getName());
		if(e.getPersonsInstitutions().getNationality() != null) {
		  dto.setNationalityStateCode(e.getPersonsInstitutions().getNationality().getCode());;
		}
		dto.setNid(e.getPersonsInstitutions().getNid());
		dto.setPob(e.getPersonsInstitutions().getPob());
		dto.setSurname(e.getPersonsInstitutions().getSurname());
		
		return dto;
	}
	
	
	//************ LIST TO DTO **************************
	
	
	public List<StateDTO> stateListToDto(List<State> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<StateDTO> list = new ArrayList<>();
		
		for(State i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<TimsDocumentDTO> timsDocumentListToDto(List<TravelDocument> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<TimsDocumentDTO> list = new ArrayList<>();
		
		for(TravelDocument i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	public List<PersonDTO> personListToDto(List<Person> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<PersonDTO> list = new ArrayList<>();
		
		for(Person i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<EventDTO> eventListToDto(List<IrregularEvent> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<EventDTO> list = new ArrayList<>();
		
		for(IrregularEvent i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<SelectionDTO> selectionListToDto(List<Selection> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<SelectionDTO> list = new ArrayList<>();
		
		for(Selection i : data)
		{			
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<FeedbackDTO> feedbackListToDto(List<Feedback> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<FeedbackDTO> list = new ArrayList<>();
		
		for(Feedback i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<TransferDTO> transferListToDto(List<Transfer> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<TransferDTO> list = new ArrayList<>();
		
		for(Transfer i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<InterviewDTO> interviewListToDto(List<Interview> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<InterviewDTO> list = new ArrayList<>();
		
		for(Interview i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<HearingDTO> hearingListToDto(List<Hearing> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<HearingDTO> list = new ArrayList<>();
		
		for(Hearing i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<AsylumDecisionDTO> asylumDecisionListToDto(List<AsylumDecision> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<AsylumDecisionDTO> list = new ArrayList<>();
		
		for(AsylumDecision i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<FamilyUnionDTO> familyUnionListToDto(List<FamilyUnion> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<FamilyUnionDTO> list = new ArrayList<>();
		
		for(FamilyUnion i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<AppealDTO> appealListToDto(List<Appeal> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<AppealDTO> list = new ArrayList<>();
		
		for(Appeal i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<DecisionDTO> decisionListToDto(List<Decision> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<DecisionDTO> list = new ArrayList<>();
		
		for(Decision i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<DocumentDTO> documentListToDto(List<Document> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<DocumentDTO> list = new ArrayList<>();
		
		for(Document i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<OtherDocumentDTO> otherDocumentListToDto(List<OtherDocument> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<OtherDocumentDTO> list = new ArrayList<>();
		
		for(OtherDocument i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<OfficerDTO> officerListToDto(List<Officer> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<OfficerDTO> list = new ArrayList<>();
		
		for(Officer i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<InstitutionOpinionDTO> institutionOpinionListToDto(List<InstitutionOpinion> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<InstitutionOpinionDTO> list = new ArrayList<>();
		
		for(InstitutionOpinion i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<QuestionDTO> questiontListToDto(List<Question> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<QuestionDTO> list = new ArrayList<>();
		
		for(Question i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<InterviewQuestionDTO> interviewQuestiontListToDto(List<InterviewQuestion> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<InterviewQuestionDTO> list = new ArrayList<>();
		
		for(InterviewQuestion i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<AsylantStageDTO> asylantStageListToDto(List<AsylantStage> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<AsylantStageDTO> list = new ArrayList<>();
		
		for(AsylantStage i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<AsylantStatusDTO> asylantStatusListToDto(List<AsylantStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<AsylantStatusDTO> list = new ArrayList<>();
		
		for(AsylantStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<AsylumDecisionTypeDTO> asylumDecisionTypeListToDto(List<AsylumDecisionType> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<AsylumDecisionTypeDTO> list = new ArrayList<>();
		
		for(AsylumDecisionType i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<DecisionHistoryDTO> decisionHistoryListToDto(List<DecisionHistory> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<DecisionHistoryDTO> list = new ArrayList<>();
		
		for(DecisionHistory i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<DecisionReasonDTO> decisionReasonListToDto(List<DecisionReason> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<DecisionReasonDTO> list = new ArrayList<>();
		
		for(DecisionReason i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<DecisionStatusDTO> decisionStatusListToDto(List<DecisionStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<DecisionStatusDTO> list = new ArrayList<>();
		
		for(DecisionStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<DecisionTypeDTO> decisionTypeListToDto(List<DecisionType> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<DecisionTypeDTO> list = new ArrayList<>();
		
		for(DecisionType i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<EvidenceDTO> evidenceListToDto(List<Evidence> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<EvidenceDTO> list = new ArrayList<>();
		
		for(Evidence i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	public List<FamilyUnionStatusDTO> familyUnionStatusListToDto(List<FamilyUnionStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<FamilyUnionStatusDTO> list = new ArrayList<>();
		
		for(FamilyUnionStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<HandedOverDTO> handedOverListToDto(List<HandedOver> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<HandedOverDTO> list = new ArrayList<>();
		
		for(HandedOver i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<HearingStatusDTO> hearingStatusListToDto(List<HearingStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<HearingStatusDTO> list = new ArrayList<>();
		
		for(HearingStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	public List<InterviewStatusDTO> interviewStatusListToDto(List<InterviewStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<InterviewStatusDTO> list = new ArrayList<>();
		
		for(InterviewStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	public List<IrStatusDTO> irStatusListToDto(List<IrStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<IrStatusDTO> list = new ArrayList<>();
		
		for(IrStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	public List<PlaceTypeDTO> placeTypeListToDto(List<PlaceType> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<PlaceTypeDTO> list = new ArrayList<>();
		
		for(PlaceType i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	public List<TransferStatusDTO> transferStatusListToDto(List<TransferStatus> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<TransferStatusDTO> list = new ArrayList<>();
		
		for(TransferStatus i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	public List<UserDTO> userListToDto(List<User> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<UserDTO> list = new ArrayList<>();
		
		for(User i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public List<OrganizationDTO> organizationListToDto(List<Organization> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<OrganizationDTO> list = new ArrayList<>();
		
		for(Organization i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	
	public DocTypeDTO toDto(DocType e)
	{
		if(e == null) return null;
		
		DocTypeDTO dto = new DocTypeDTO();
		dto.setCode(e.getId());
		dto.setShortTag(e.getShortTag());
		dto.setTag(e.getTag());
		return dto;
	}
	
	
	public List<DocTypeDTO> docTypeListToDto(List<DocType> data) {
		
		if(data == null || data.isEmpty()) return null;
		
		List<DocTypeDTO> list = new ArrayList<>();
		
		for(DocType i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
	}
	
	
	
	
	
	
}
