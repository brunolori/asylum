package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;



public class InterviewDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private int id;
    private SelectionDTO selection;
    private Date selectionTime;
    private String selectionNotes;
    private String selectionUser;
    private Date predictedInterviewDate;
    private Date interviewTime;
    private String interviewUser;
    private String notes;
    private String interviewer;
    private String language;
    private String translator;
    private boolean status;
    private InterviewStatusDTO interviewStatus;
    
    
    
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
	public Date getSelectionTime() {
		return selectionTime;
	}
	public void setSelectionTime(Date selectionTime) {
		this.selectionTime = selectionTime;
	}
	public String getSelectionUser() {
		return selectionUser;
	}
	public void setSelectionUser(String selectionUser) {
		this.selectionUser = selectionUser;
	}
	public Date getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	public String getInterviewUser() {
		return interviewUser;
	}
	public void setInterviewUser(String interviewUser) {
		this.interviewUser = interviewUser;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public InterviewStatusDTO getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(InterviewStatusDTO interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getSelectionNotes() {
		return selectionNotes;
	}
	public void setSelectionNotes(String selectionNotes) {
		this.selectionNotes = selectionNotes;
	}
	public Date getPredictedInterviewDate() {
		return predictedInterviewDate;
	}
	public void setPredictedInterviewDate(Date predictedInterviewDate) {
		this.predictedInterviewDate = predictedInterviewDate;
	}
    
    
	
    
    

}
