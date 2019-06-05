package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;


public class AppealDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private SelectionDTO selection;
    private Date appealTime;
    private String appealUser;
    private String decisionNo;
    private Date decisionDate;
	private String notes;
    private boolean active;
    
    
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
	public Date getAppealTime() {
		return appealTime;
	}
	public void setAppealTime(Date appealTime) {
		this.appealTime = appealTime;
	}
	public String getAppealUser() {
		return appealUser;
	}
	public void setAppealUser(String appealUser) {
		this.appealUser = appealUser;
	}
	public String getDecisionNo() {
		return decisionNo;
	}
	public void setDecisionNo(String decisionNo) {
		this.decisionNo = decisionNo;
	}
	public Date getDecisionDate() {
		return decisionDate;
	}
	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
    
    
    
	
    
    
	
	
}
