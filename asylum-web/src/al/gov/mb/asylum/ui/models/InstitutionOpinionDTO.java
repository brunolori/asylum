package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;




public class InstitutionOpinionDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;
   
    private int id;
    private SelectionDTO selection;
    private Date opinionTime;
    private String opinionUser;
    private String institution;
    private String notes;
    private boolean status;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SelectionDTO getSelection() {
		return selection;
	}
	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}
	public Date getOpinionTime() {
		return opinionTime;
	}
	public void setOpinionTime(Date opinionTime) {
		this.opinionTime = opinionTime;
	}
	public String getOpinionUser() {
		return opinionUser;
	}
	public void setOpinionUser(String opinionUser) {
		this.opinionUser = opinionUser;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
      
    
    
    
}
