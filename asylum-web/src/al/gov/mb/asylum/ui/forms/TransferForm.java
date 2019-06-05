package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.List;

import al.gov.mb.asylum.ui.models.SelectionDTO;

public class TransferForm implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	
	List<SelectionDTO> selections;
	String notes;
	Integer destinationOrgId;
	
	
	public List<SelectionDTO> getSelections() {
		return selections;
	}
	public void setSelections(List<SelectionDTO> selections) {
		this.selections = selections;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getDestinationOrgId() {
		return destinationOrgId;
	}
	public void setDestinationOrgId(Integer destinationOrgId) {
		this.destinationOrgId = destinationOrgId;
	}
	
	
	
	
	

}
