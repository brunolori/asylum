package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.EventSx;
import al.gov.mb.asylum.ui.forms.SelectionForm;
import al.gov.mb.asylum.ui.models.AsylantDetailsDTO;
import al.gov.mb.asylum.ui.models.AsylantStageDTO;
import al.gov.mb.asylum.ui.models.AsylantStatusDTO;
import al.gov.mb.asylum.ui.models.DocTypeDTO;
import al.gov.mb.asylum.ui.models.DocumentDTO;
import al.gov.mb.asylum.ui.models.EventDTO;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.models.HandedOverDTO;
import al.gov.mb.asylum.ui.models.IrStatusDTO;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.OtherDocumentDTO;
import al.gov.mb.asylum.ui.models.PersonDTO;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.models.TimsDocumentDTO;
import al.gov.mb.asylum.ui.services.EventService;
import al.gov.mb.asylum.ui.services.EvidenceService;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.OfficerService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class DrkmSelectionBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	String uniqueNo;
	
	EventDTO event;
	EventDTO selectedEvent;
	List<OfficerDTO> eventOfficers;
	List<EvidenceDTO> eventEvidences;
	
	
	List<EventDTO> events;
	
	SelectionDTO selection;
	OtherDocumentDTO otherDocument;
	List<OtherDocumentDTO> otherDocuments;
	PersonDTO person;
	DocumentDTO document;
	AsylantDetailsDTO details;
	
	TimsDocumentDTO timsDocument;
	
	List<HandedOverDTO> handedOvers;
	List<IrStatusDTO> irStatuses;
	List<DocTypeDTO> docTypes;
	List<AsylantStageDTO> stages;
	List<AsylantStatusDTO> statuses;
	
	

	
	public NavBean getNav() {
		return nav;
	}

	public void setNav(NavBean nav) {
		this.nav = nav;
	}

	public String getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}

	public EventDTO getEvent() {
		return event;
	}

	public void setEvent(EventDTO event) {
		this.event = event;
	}

	public EventDTO getSelectedEvent() {
		return selectedEvent;
	}

	public void setSelectedEvent(EventDTO selectedEvent) {
		this.selectedEvent = selectedEvent;
	}

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}

	public SelectionDTO getSelection() {
		return selection;
	}

	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}

	public OtherDocumentDTO getOtherDocument() {
		return otherDocument;
	}

	public void setOtherDocument(OtherDocumentDTO otherDocument) {
		this.otherDocument = otherDocument;
	}

	public List<OtherDocumentDTO> getOtherDocuments() {
		return otherDocuments;
	}

	public void setOtherDocuments(List<OtherDocumentDTO> otherDocuments) {
		this.otherDocuments = otherDocuments;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public AsylantDetailsDTO getDetails() {
		return details;
	}

	public void setDetails(AsylantDetailsDTO details) {
		this.details = details;
	}

	public TimsDocumentDTO getTimsDocument() {
		return timsDocument;
	}

	public void setTimsDocument(TimsDocumentDTO timsDocument) {
		this.timsDocument = timsDocument;
	}

	public List<HandedOverDTO> getHandedOvers() {
		return handedOvers;
	}

	public void setHandedOvers(List<HandedOverDTO> handedOvers) {
		this.handedOvers = handedOvers;
	}

	public List<IrStatusDTO> getIrStatuses() {
		return irStatuses;
	}

	public void setIrStatuses(List<IrStatusDTO> irStatuses) {
		this.irStatuses = irStatuses;
	}

	public List<DocTypeDTO> getDocTypes() {
		return docTypes;
	}

	public void setDocTypes(List<DocTypeDTO> docTypes) {
		this.docTypes = docTypes;
	}
	
	
	public List<AsylantStageDTO> getStages() {
		return stages;
	}

	public void setStages(List<AsylantStageDTO> stages) {
		this.stages = stages;
	}

	public List<AsylantStatusDTO> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<AsylantStatusDTO> statuses) {
		this.statuses = statuses;
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

	
	
	
	@PostConstruct
	public void load()
	{
		this.handedOvers = new HelperService().listHandedOver();
		this.irStatuses = new HelperService().listIrStatus();
		this.docTypes = new HelperService().listDocType();
		this.stages = new HelperService().listAsylantStage();
		this.statuses = new HelperService().listAsylantStatus();
		
	}
	
	public void init()
	{
				
		this.uniqueNo = nav.getParam("unique_no");
		
		if(StringUtil.isValid(uniqueNo)){
			
			searchEvent();			
		}
		else{
			clearUniqueNo();
		}
		
	}
	
	public void searchEvent()
	{
		try {
			
			if(!StringUtil.isValid(uniqueNo))
			{
				Messages.throwFacesMessage("Plotesoni Numrin Unik",3);
				return;
			}
			
			this.event = new EventService().getEventByUniqueNo(uniqueNo);
			if(event == null)
			{
				Messages.throwFacesMessage("Konstatimi me Nr Unik: "+uniqueNo+" nuk u gjet",3);
				return;
			}
			this.eventEvidences = new EvidenceService().getEventEvidences(event.getId());
			this.eventOfficers = new OfficerService().getEventOfficers(event.getId());
			prepareSelectionForm();
						
			
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	public void clearUniqueNo()
	{
		this.uniqueNo = null;
		EventSx req = new EventSx();
		req.setMaxResult(10);
		this.events = new EventService().searchEvent(req);
		this.event = null;
		this.eventEvidences = null;
		this.eventOfficers = null;
		this.selectedEvent = null;
		prepareSelectionForm();
	}
	
	public void onEventSelect()
	{
		this.event = selectedEvent;
		prepareSelectionForm();
		this.eventEvidences = new EvidenceService().getEventEvidences(event.getId());
		this.eventOfficers = new OfficerService().getEventOfficers(event.getId());
		this.uniqueNo = event.getUniqurNumber();		
	}
	
	private void prepareSelectionForm()
	{
		this.selection = new SelectionDTO();
		this.person = new PersonDTO();
		this.document = new DocumentDTO();
		this.otherDocuments = new ArrayList<>();
		this.details = new AsylantDetailsDTO();
		clearOtherDocument();	
	}
	
	public void clearOtherDocument()
	{
		this.otherDocument = new OtherDocumentDTO();
	}
	
	public void addOtherDocument()
	{
		if(!StringUtil.isValid(this.otherDocument.getDocumentNo()))
		{
			Messages.throwFacesMessage("Ploteso numrin e dokumentit",3);
			return;
		}
		this.otherDocuments.add(this.otherDocument);
		clearOtherDocument();
	}
	
	public void removeOtherDocument(OtherDocumentDTO d)
	{
		this.otherDocuments.remove(d);
	}
	
	
	public void onTimsDocumentSelect(SelectEvent event)
	{
		this.timsDocument = (TimsDocumentDTO) event.getObject();
		if(timsDocument != null)
		{
			this.person.setDob(timsDocument.getDob());
			this.person.setName(timsDocument.getName());
			this.person.setSurname(timsDocument.getSurname());
			this.person.setGender(timsDocument.getGender());
			this.person.setCodeNationality(timsDocument.getNationalityStateCode());
			this.person.setFatherName(timsDocument.getFatherName());
			this.person.setNid(timsDocument.getNid());
			this.person.setCodeOS(timsDocument.getCodeOs());
			this.person.setPersonTimsId(timsDocument.getPersonId());
			
			this.document.setCodeState(timsDocument.getDocStateCode());
			this.document.setCodeTypeTravelDoc(timsDocument.getDocTypeCode());
			this.document.setDateOfExpiration(timsDocument.getDateOfExpiration());
			this.document.setDateOfIssue(timsDocument.getDateOfIssue());
			this.document.setTravelDocNo(timsDocument.getDocumentNo());
		}
		
		
	}
	
	
	
	public void clear()
	{
		clearUniqueNo();
		prepareSelectionForm();
		
	}
	
	
	
	
	
	public void register()
	{
		try {
			
			selection.setPerson(person);
			selection.setEvent(event);
			selection.setAsylantDetails(details);
			
			
			SelectionForm form = new SelectionForm();
			form.setDocument(document);
			form.setOtherDocuments(otherDocuments);
			form.setSelection(selection);
						
			SelectionDTO s = new SelectionService().registerSelection(form);
						
			Messages.throwFacesMessage("Regjistrimi u krye me sukses! NR UNIK: "+s.getEvent().getUniqurNumber(),1);
			
			prepareSelectionForm();
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	

	public void registerAndPrint()
	{
		try {
			
			selection.setPerson(person);
			selection.setEvent(event);
			selection.setAsylantDetails(details);
			
			
			SelectionForm form = new SelectionForm();
			form.setDocument(document);
			form.setOtherDocuments(otherDocuments);
			form.setSelection(selection);
			SelectionDTO s = new SelectionService().registerSelection(form);
			
			Messages.throwFacesMessage("Regjistrimi u krye me sukses! NR UNIK: "+s.getEvent().getUniqurNumber(),1);
			prepareSelectionForm();
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	

}
