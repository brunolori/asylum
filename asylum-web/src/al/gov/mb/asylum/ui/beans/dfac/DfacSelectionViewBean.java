package al.gov.mb.asylum.ui.beans.dfac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.IHearingStatus;
import al.gov.mb.asylum.ui.constants.IInterviewStatus;
import al.gov.mb.asylum.ui.constants.IStatus;
import al.gov.mb.asylum.ui.forms.AsylumDecisionSx;
import al.gov.mb.asylum.ui.forms.HearingSx;
import al.gov.mb.asylum.ui.forms.InterviewForm;
import al.gov.mb.asylum.ui.forms.InterviewSx;
import al.gov.mb.asylum.ui.models.AppealDTO;
import al.gov.mb.asylum.ui.models.AsylumDecisionDTO;
import al.gov.mb.asylum.ui.models.DecisionDTO;
import al.gov.mb.asylum.ui.models.DocumentDTO;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.models.FeedbackDTO;
import al.gov.mb.asylum.ui.models.HearingDTO;
import al.gov.mb.asylum.ui.models.InstitutionOpinionDTO;
import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.InterviewQuestionDTO;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.OtherDocumentDTO;
import al.gov.mb.asylum.ui.models.QuestionDTO;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.models.TransferDTO;
import al.gov.mb.asylum.ui.services.AppealService;
import al.gov.mb.asylum.ui.services.AsylumDecisionService;
import al.gov.mb.asylum.ui.services.DecisionService;
import al.gov.mb.asylum.ui.services.DocumentService;
import al.gov.mb.asylum.ui.services.EvidenceService;
import al.gov.mb.asylum.ui.services.FeedbackService;
import al.gov.mb.asylum.ui.services.HearingService;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.InstitutionOpinionService;
import al.gov.mb.asylum.ui.services.InterviewService;
import al.gov.mb.asylum.ui.services.OfficerService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.services.TransferService;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class DfacSelectionViewBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	SelectionDTO selection;
	List<OfficerDTO> eventOfficers;
	List<EvidenceDTO> eventEvidences;
	DocumentDTO document;
	List<FeedbackDTO> feedbacks;
	List<OtherDocumentDTO> otherDocuments;
	List<DecisionDTO> decisions;
	List<AsylumDecisionDTO> asylumDecisions;
	List<TransferDTO> transfers;
	List<AppealDTO> appeals;
	List<InstitutionOpinionDTO> opinions;
	List<InterviewDTO> interviews;
	List<HearingDTO> hearings;
	
	boolean edit;
	
	//  Per regjistrime
	FeedbackDTO feedback;
	AsylumDecisionDTO asylumDecision;
	AppealDTO appeal;
	InstitutionOpinionDTO opinion;
	InterviewDTO interview;
	List<InterviewQuestionDTO> questions;
	HearingDTO hearing;
	
	
	String actualView;
	
	
	

	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}
	public SelectionDTO getSelection() {
		return selection;
	}
	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}
	public List<OfficerDTO> getEventOfficers() {
		return eventOfficers;
	}
	public void setEventOfficers(List<OfficerDTO> eventOfficers) {
		this.eventOfficers = eventOfficers;
	}
	public List<EvidenceDTO> getEventEvidences() {
		return eventEvidences;
	}
	public void setEventEvidences(List<EvidenceDTO> eventEvidences) {
		this.eventEvidences = eventEvidences;
	}
	public DocumentDTO getDocument() {
		return document;
	}
	public void setDocument(DocumentDTO document) {
		this.document = document;
	}
	
	public List<FeedbackDTO> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<FeedbackDTO> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public List<OtherDocumentDTO> getOtherDocuments() {
		return otherDocuments;
	}
	public void setOtherDocuments(List<OtherDocumentDTO> otherDocuments) {
		this.otherDocuments = otherDocuments;
	}
	public List<DecisionDTO> getDecisions() {
		return decisions;
	}
	public void setDecisions(List<DecisionDTO> decisions) {
		this.decisions = decisions;
	}
	public List<AsylumDecisionDTO> getAsylumDecisions() {
		return asylumDecisions;
	}
	public void setAsylumDecisions(List<AsylumDecisionDTO> asylumDecisions) {
		this.asylumDecisions = asylumDecisions;
	}
	public List<AppealDTO> getAppeals() {
		return appeals;
	}
	public void setAppeals(List<AppealDTO> appeals) {
		this.appeals = appeals;
	}
	public List<InstitutionOpinionDTO> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<InstitutionOpinionDTO> opinions) {
		this.opinions = opinions;
	}
	public List<InterviewDTO> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<InterviewDTO> interviews) {
		this.interviews = interviews;
	}
	public List<HearingDTO> getHearings() {
		return hearings;
	}
	public void setHearings(List<HearingDTO> hearings) {
		this.hearings = hearings;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public FeedbackDTO getFeedback() {
		return feedback;
	}
	public void setFeedback(FeedbackDTO feedback) {
		this.feedback = feedback;
	}
	public AsylumDecisionDTO getAsylumDecision() {
		return asylumDecision;
	}
	public void setAsylumDecision(AsylumDecisionDTO asylumDecision) {
		this.asylumDecision = asylumDecision;
	}
	public AppealDTO getAppeal() {
		return appeal;
	}
	public void setAppeal(AppealDTO appeal) {
		this.appeal = appeal;
	}
	public InterviewDTO getInterview() {
		return interview;
	}
	public void setInterview(InterviewDTO interview) {
		this.interview = interview;
	}
	public List<InterviewQuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<InterviewQuestionDTO> questions) {
		this.questions = questions;
	}
	public HearingDTO getHearing() {
		return hearing;
	}
	public void setHearing(HearingDTO hearing) {
		this.hearing = hearing;
	}
	public InstitutionOpinionDTO getOpinion() {
		return opinion;
	}
	public void setOpinion(InstitutionOpinionDTO opinion) {
		this.opinion = opinion;
	}
	public List<TransferDTO> getTransfers() {
		return transfers;
	}
	public void setTransfers(List<TransferDTO> transfers) {
		this.transfers = transfers;
	}

	public String getActualView() {
		return actualView;
	}
	public void setActualView(String actualView) {
		this.actualView = actualView;
	}
	
	
	
	
	public void init()
	{		
		String eventId = nav.getParam("event_id");	
		if(!StringUtil.isValid(eventId))
		{
			Messages.throwFacesMessage("I perzgjedhuri i papercaktuar",3);
			return;
		}
		onMenuSelect("selection_view_feedback_list.xhtml");
		loadRaport(Integer.valueOf(eventId));	
		this.edit = false;
	}



	private void loadRaport(Integer eventId) {

		try {
			
			this.selection = new SelectionService().getSelectionByEventId(eventId);
			if(selection == null)
			{
				Messages.throwFacesMessage("I perzgjedhuri nuk u gjet",3);
				return;
			}
						
			this.eventOfficers = new OfficerService().getEventOfficers(eventId);
			this.eventEvidences = new EvidenceService().getEventEvidences(eventId);
			this.document = new DocumentService().getSelectionDocument(eventId);
			this.feedbacks = new FeedbackService().getSelectionFeedbacks(eventId);
			this.otherDocuments = new DocumentService().getSelectionOtherDocuments(eventId);
			this.decisions = new DecisionService().getSelectionDecisions(eventId);
			this.asylumDecisions = new AsylumDecisionService().searchAsylumDecision(new AsylumDecisionSx(eventId));
			this.appeals = new AppealService().getSelectionAppeals(eventId);
			this.opinions = new InstitutionOpinionService().getSelectionInstitutionOpinions(eventId);
			this.interviews = new InterviewService().searchInterview(new InterviewSx(eventId));
			this.hearings = new HearingService().searchHearing(new HearingSx(eventId));
			this.transfers = new TransferService().getSelectionTransfers(eventId);
			
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
		
	}
	
	public void closeEdit()
	{
		this.edit = false;
		this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());
	}
	
	public void openEdit()
	{
		this.edit = true;
	}
	
	public void edit()
	{
		try {
			
			new SelectionService().modifySelection(this.selection);
			closeEdit();
			Messages.throwFacesMessage("Te dhenat u ndryshuan me sukses!",1);
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	public void prepareFeedback()
	{
		this.feedback = new FeedbackDTO();
				
	}
	
	public void registerFeedback()
	{
		try {
			
			this.feedback.setSelection(this.selection);
			new FeedbackService().registerFeedback(feedback);
			this.feedbacks = new FeedbackService().getSelectionFeedbacks(selection.getEvent().getId());
			this.feedback = null;
			this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());

			Messages.throwFacesMessage("Feedback-u u regjistrua me sukses!",1);
			
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('feedbackWid').hide();");
			PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	public void acceleratedProcess()
	{
		this.selection.getAsylantDetails().setAcceleratedProcess(IStatus.YES);
		edit();
	}
	
	public void prepareSelectForInterview()
	{
		this.interview = new InterviewDTO();
	}
	
	public void registerSelectForInterview()
	{
		try {
			this.interview.setSelection(selection);
			this.interview = new InterviewService().selectForInterview(interview);
			this.interviews = new InterviewService().searchInterview(new InterviewSx(selection.getEvent().getId()));
			this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());
			Messages.throwFacesMessage("Personi u perzgjodh per Interviste!",1);
			
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('selectInterviewWid').hide();");
			PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
			
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	public void prepareSelectForHearing()
	{
		this.hearing = new HearingDTO();
	}
	
	public void registerSelectForHearing()
	{
		try {
			
			this.hearing.setSelection(selection);
			this.hearing = new HearingService().selectForHearing(hearing);
			this.hearings = new HearingService().searchHearing(new HearingSx(selection.getEvent().getId()));
			this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());
			Messages.throwFacesMessage("Personi u perzgjodh per Degjim!",1);
			
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('selectHearingWid').hide();");
			PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
			
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	public void prepareHearing()
	{
		HearingSx sx = new HearingSx();
		sx.setSelectionId(this.selection.getEvent().getId());
		sx.setMaxResult(1);
		sx.setHearingStatus(IHearingStatus.SELECTED);
		List<HearingDTO> selList = new HearingService().searchHearing(sx);
		if(selList == null || selList.isEmpty())
		{
			Messages.throwFacesMessage("Personi nuk eshte perzgjedhur per degjese!", 3);
			return;
		}
		
		this.hearing = selList.get(0);
		PrimeFaces current = PrimeFaces.current();		
		current.executeScript("PF('hearingWid').show();");
		current.ajax().update("hearing_dlg");
	}
	
	public void registerHearing()
	{
		try {
			this.hearing.setSelection(selection);
			new HearingService().registerHearing(hearing);
			this.hearings = new HearingService().searchHearing(new HearingSx(selection.getEvent().getId()));
			this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());

			Messages.throwFacesMessage("Degjesa u regjistrua!",1);
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('hearingWid').hide();");
			PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public List<InterviewQuestionDTO> listInterviewQuestions(InterviewDTO i)
	{
		return new InterviewService().getInterviewQuestions(i.getId());
	}
	
	
	
	public void prepareInterview()
	{
		InterviewSx sx = new InterviewSx();
		sx.setSelectionId(this.selection.getEvent().getId());
		sx.setMaxResult(1);
		sx.setInterviewStatus(IInterviewStatus.SELECTED);
		List<InterviewDTO> selList = new InterviewService().searchInterview(sx);
		if(selList == null || selList.isEmpty())
		{
			Messages.throwFacesMessage("Personi nuk eshte perzgjedhur per intervise!", 3);
			return;
		}
		
		this.interview = selList.get(0);
		List<QuestionDTO> list = new HelperService().listQuestion();
		this.questions = new ArrayList<>();
		if(list != null && !list.isEmpty())
		{
			for(QuestionDTO q : list)
			{
				InterviewQuestionDTO iq = new InterviewQuestionDTO();
				iq.setQuestion(q.getTag());
				
				this.questions.add(iq);
			}
		}
		
		PrimeFaces current = PrimeFaces.current();		
		current.executeScript("PF('interviewWid').show();");
		current.ajax().update("interview_dlg");
		
		
	}
	
	public void registerInterview()
	{
		try {
			
			InterviewForm form = new InterviewForm();			
			this.interview.setSelection(selection);
			
			form.setInterview(interview);
			form.setQuestions(questions);
			
			new InterviewService().registerInterview(form);
			this.interviews = new InterviewService().searchInterview(new InterviewSx(selection.getEvent().getId()));
			this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());

			Messages.throwFacesMessage("Intervista u regjistrua!!",1);
			
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('interviewWid').hide();");
			PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public void prepareAsylumDecision()
	{
		this.asylumDecision = new AsylumDecisionDTO();
		asylumDecision.setOldStage(selection.getAsylantDetails().getAsylantStage());
		asylumDecision.setOldStatus(selection.getAsylantDetails().getAsylantStatus());
		asylumDecision.setSelection(selection);
	}
	
	public void registerAsylumDecision()
	{
			try {
				
				new AsylumDecisionService().registerDecision(asylumDecision);
				this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());
				this.asylumDecisions = new AsylumDecisionService().searchAsylumDecision(new AsylumDecisionSx(selection.getEvent().getId()));
				Messages.throwFacesMessage("Vendimi u regjistrua!",1);
				PrimeFaces current = PrimeFaces.current();
				current.executeScript("PF('asDecisionWid').hide();");
				PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
			}catch(Exception e)
			{
				Messages.throwFacesMessage(e);
			}
	}
	
	public void prepareAppeal()
	{
		this.appeal = new AppealDTO();
		
	}
	
	public void registerAppeal()
	{
			try {
				
				this.appeal.setSelection(selection);
				new AppealService().registerAppeal(appeal);
				this.appeals = new AppealService().getSelectionAppeals(selection.getEvent().getId());		
				Messages.throwFacesMessage("Ankimimi u regjistrua!",1);
				PrimeFaces current = PrimeFaces.current();
				current.executeScript("PF('appealWid').hide();");
				PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
				
			}catch(Exception e)
			{
				Messages.throwFacesMessage(e);
			}
	}
	
	
	public void prepareOpinion()
	{
		this.opinion = new InstitutionOpinionDTO();
	}
	
	public void registerOpinion()
	{
			try {
				
				this.opinion.setSelection(selection);
				new InstitutionOpinionService().registerInstitutionOpinion(opinion);
				this.opinions = new InstitutionOpinionService().getSelectionInstitutionOpinions(selection.getEvent().getId());		
				
				PrimeFaces current = PrimeFaces.current();
				current.executeScript("PF('opinionWid').hide();");
				PrimeFaces.current().ajax().update("dfac_selection_view_form:selection_data");
			}catch(Exception e)
			{
				Messages.throwFacesMessage(e);
			}
	}
	
	
	
	public void onMenuSelect(String view)
	{
		this.actualView = view;
	}
	
	
	
	
}
