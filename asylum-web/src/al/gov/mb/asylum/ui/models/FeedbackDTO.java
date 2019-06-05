package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;



public class FeedbackDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
		private int id;
	    private SelectionDTO selection;
	    private Date feedbackTime;
	    private String feedbackUser;
	    private Character value;
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
		public Date getFeedbackTime() {
			return feedbackTime;
		}
		public void setFeedbackTime(Date feedbackTime) {
			this.feedbackTime = feedbackTime;
		}
		public String getFeedbackUser() {
			return feedbackUser;
		}
		public void setFeedbackUser(String feedbackUser) {
			this.feedbackUser = feedbackUser;
		}
		public Character getValue() {
			return value;
		}
		public void setValue(Character value) {
			this.value = value;
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
