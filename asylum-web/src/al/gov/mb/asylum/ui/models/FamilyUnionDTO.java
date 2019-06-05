package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;



public class FamilyUnionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	    private Integer id;
	    private SelectionDTO selection;
	    private Date processTime;
	    private String processUser;
	    private String notes;
	    private Integer familyId;
	    private boolean status;
	    private FamilyUnionStatusDTO familyStatus;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public SelectionDTO getSelection() {
			return selection;
		}
		public void setSelection(SelectionDTO selection) {
			this.selection = selection;
		}
		public Date getProcessTime() {
			return processTime;
		}
		public void setProcessTime(Date processTime) {
			this.processTime = processTime;
		}
		public String getProcessUser() {
			return processUser;
		}
		public void setProcessUser(String processUser) {
			this.processUser = processUser;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public Integer getFamilyId() {
			return familyId;
		}
		public void setFamilyId(Integer familyId) {
			this.familyId = familyId;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public FamilyUnionStatusDTO getFamilyStatus() {
			return familyStatus;
		}
		public void setFamilyStatus(FamilyUnionStatusDTO familyStatus) {
			this.familyStatus = familyStatus;
		}
	    
	    
	    
		
}
