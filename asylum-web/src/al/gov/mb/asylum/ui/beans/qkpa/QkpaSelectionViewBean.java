package al.gov.mb.asylum.ui.beans.qkpa;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.AsylumDecisionSx;
import al.gov.mb.asylum.ui.forms.HearingSx;
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
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.OtherDocumentDTO;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.models.TransferDTO;
import al.gov.mb.asylum.ui.services.AppealService;
import al.gov.mb.asylum.ui.services.AsylumDecisionService;
import al.gov.mb.asylum.ui.services.DecisionService;
import al.gov.mb.asylum.ui.services.DocumentService;
import al.gov.mb.asylum.ui.services.EvidenceService;
import al.gov.mb.asylum.ui.services.FeedbackService;
import al.gov.mb.asylum.ui.services.HearingService;
import al.gov.mb.asylum.ui.services.InstitutionOpinionService;
import al.gov.mb.asylum.ui.services.InterviewService;
import al.gov.mb.asylum.ui.services.OfficerService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.services.TransferService;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class QkpaSelectionViewBean implements Serializable {


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
		
	//  Per regjistrime
	FeedbackDTO feedback;
	
	
	
	

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
	public FeedbackDTO getFeedback() {
		return feedback;
	}
	public void setFeedback(FeedbackDTO feedback) {
		this.feedback = feedback;
	}
	
	public List<TransferDTO> getTransfers() {
		return transfers;
	}
	public void setTransfers(List<TransferDTO> transfers) {
		this.transfers = transfers;
	}
	
	
	
	
			
	
	public void init()
	{		
		String eventId = nav.getParam("event_id");	
		if(!StringUtil.isValid(eventId))
		{
			Messages.throwFacesMessage("I perzgjedhuri i papercaktuar",3);
			return;
		}
		loadRaport(Integer.valueOf(eventId));	
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
	
	
	
	public void prepareFeedback()
	{
		this.feedback = new FeedbackDTO();
				
	}
	
	public void prepareGone()
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
			PrimeFaces.current().ajax().update("qkpa_selection_view_form:selection_data");
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public void registerGone()
	{
		try {
				
				new TransferService().registerGoneSelection(this.selection);
			
				this.feedback.setSelection(this.selection);
				String message = "LARGUAR nga Q.K.P.A: "+feedback.getNotes();
				feedback.setNotes(message);
				new FeedbackService().registerFeedback(feedback);
				this.feedbacks = new FeedbackService().getSelectionFeedbacks(selection.getEvent().getId());
				this.feedback = null;
				this.selection = new SelectionService().getSelectionByEventId(selection.getEvent().getId());
				this.transfers = new TransferService().getSelectionTransfers(selection.getEvent().getId());
	
				Messages.throwFacesMessage("Ngjarja u regjistrua me sukses!",1);
				
				PrimeFaces current = PrimeFaces.current();
				current.executeScript("PF('goneFeedbackWid').hide();");
				PrimeFaces.current().ajax().update("qkpa_selection_view_form:selection_data");
				
			}catch(Exception e) {
				Messages.throwFacesMessage(e);
			}
	}
}
