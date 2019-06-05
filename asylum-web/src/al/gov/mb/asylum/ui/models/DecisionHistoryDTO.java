package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;





public class DecisionHistoryDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private String process;
    private String field;
    private String notes;
    private String recordUser;
    private Date recordDate;
    private DecisionDTO decision;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public DecisionDTO getDecision() {
		return decision;
	}
	public void setDecision(DecisionDTO decision) {
		this.decision = decision;
	}
    
    
    
    
    
}
