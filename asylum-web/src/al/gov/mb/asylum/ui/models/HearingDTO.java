package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;




public class HearingDTO implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	   
	    private int id;
	   
	    private SelectionDTO selection;
	    private Date hearingTime;
	    private String hearingUser;
	    private Date selectionTime;
	    private String selectionNotes;
	    private Date predictedHearingDate;
	    private String selectionUser;
	    private String listener;
	    private String language;
	    private String translator;
	    private String notes;
	    private boolean status;
	    private HearingStatusDTO hearingStatus;
	    
	    
	    
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
		public Date getHearingTime() {
			return hearingTime;
		}
		public void setHearingTime(Date hearingTime) {
			this.hearingTime = hearingTime;
		}
		public String getHearingUser() {
			return hearingUser;
		}
		public void setHearingUser(String hearingUser) {
			this.hearingUser = hearingUser;
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
		public String getListener() {
			return listener;
		}
		public void setListener(String listener) {
			this.listener = listener;
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
		public HearingStatusDTO getHearingStatus() {
			return hearingStatus;
		}
		public void setHearingStatus(HearingStatusDTO hearingStatus) {
			this.hearingStatus = hearingStatus;
		}
		public String getSelectionNotes() {
			return selectionNotes;
		}
		public void setSelectionNotes(String selectionNotes) {
			this.selectionNotes = selectionNotes;
		}
		public Date getPredictedHearingDate() {
			return predictedHearingDate;
		}
		public void setPredictedHearingDate(Date predictedHearingDate) {
			this.predictedHearingDate = predictedHearingDate;
		}
	    
	    


}
