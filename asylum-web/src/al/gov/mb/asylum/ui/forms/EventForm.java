package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.List;

import al.gov.mb.asylum.ui.models.EventDTO;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.models.OfficerDTO;


public class EventForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	EventDTO event;
	List<OfficerDTO> officers;
	List<EvidenceDTO> evidences;
	
	
	public EventDTO getEvent() {
		return event;
	}
	public void setEvent(EventDTO event) {
		this.event = event;
	}
	public List<OfficerDTO> getOfficers() {
		return officers;
	}
	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
	}
	public List<EvidenceDTO> getEvidences() {
		return evidences;
	}
	public void setEvidences(List<EvidenceDTO> evidences) {
		this.evidences = evidences;
	}
	
	
	

}
