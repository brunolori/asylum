package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;



public class SelectionDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private EventDTO event;
    private String itinerary;
    private String fleeingReason;
    private Date selectionDate;
    private Date recordDate;
    private String recordUser;
    private String modifUser;
    private String translator;
    private String interviewer;
    private String transLang;
    private String notes;
    private String albAddress;
    private String entryPlace;
    private String entryMode;
    private String reason;
    private HandedOverDTO handed;
    private PersonDTO person;
    private IrStatusDTO irStatus;
    private AsylantDetailsDTO asylantDetails;
    
    
	public EventDTO getEvent() {
		return event;
	}
	public void setEvent(EventDTO event) {
		this.event = event;
	}
	public String getItinerary() {
		return itinerary;
	}
	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}
	public String getFleeingReason() {
		return fleeingReason;
	}
	public void setFleeingReason(String fleeingReason) {
		this.fleeingReason = fleeingReason;
	}
	public Date getSelectionDate() {
		return selectionDate;
	}
	public void setSelectionDate(Date selectionDate) {
		this.selectionDate = selectionDate;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	public String getModifUser() {
		return modifUser;
	}
	public void setModifUser(String modifUser) {
		this.modifUser = modifUser;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	public String getTransLang() {
		return transLang;
	}
	public void setTransLang(String transLang) {
		this.transLang = transLang;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getAlbAddress() {
		return albAddress;
	}
	public void setAlbAddress(String albAddress) {
		this.albAddress = albAddress;
	}
	public String getEntryPlace() {
		return entryPlace;
	}
	public void setEntryPlace(String entryPlace) {
		this.entryPlace = entryPlace;
	}
	public String getEntryMode() {
		return entryMode;
	}
	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public HandedOverDTO getHanded() {
		return handed;
	}
	public void setHanded(HandedOverDTO handed) {
		this.handed = handed;
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public IrStatusDTO getIrStatus() {
		return irStatus;
	}
	public void setIrStatus(IrStatusDTO irStatus) {
		this.irStatus = irStatus;
	}
	public AsylantDetailsDTO getAsylantDetails() {
		return asylantDetails;
	}
	public void setAsylantDetails(AsylantDetailsDTO asylantDetails) {
		this.asylantDetails = asylantDetails;
	}
    
    
	
}
