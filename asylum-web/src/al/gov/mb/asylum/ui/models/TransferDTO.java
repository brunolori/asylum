package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;




public class TransferDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	    private int id;
	    private SelectionDTO selection;
	    private OrganizationDTO fromOrganization;
	    private OrganizationDTO toOrganization;
	    private Date checkOutTime;
	    private String checkOutUser;
	    private String checkOutNotes;
	    private Date checkInTime;
	    private String checkInUser;
	    private String checkInNotes;
	    private boolean status;
	    private TransferStatusDTO transferStatus;
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
		public OrganizationDTO getFromOrganization() {
			return fromOrganization;
		}
		public void setFromOrganization(OrganizationDTO fromOrganization) {
			this.fromOrganization = fromOrganization;
		}
		public OrganizationDTO getToOrganization() {
			return toOrganization;
		}
		public void setToOrganization(OrganizationDTO toOrganization) {
			this.toOrganization = toOrganization;
		}
		public Date getCheckOutTime() {
			return checkOutTime;
		}
		public void setCheckOutTime(Date checkOutTime) {
			this.checkOutTime = checkOutTime;
		}
		public String getCheckOutUser() {
			return checkOutUser;
		}
		public void setCheckOutUser(String checkOutUser) {
			this.checkOutUser = checkOutUser;
		}
		public String getCheckOutNotes() {
			return checkOutNotes;
		}
		public void setCheckOutNotes(String checkOutNotes) {
			this.checkOutNotes = checkOutNotes;
		}
		public Date getCheckInTime() {
			return checkInTime;
		}
		public void setCheckInTime(Date checkInTime) {
			this.checkInTime = checkInTime;
		}
		public String getCheckInUser() {
			return checkInUser;
		}
		public void setCheckInUser(String checkInUser) {
			this.checkInUser = checkInUser;
		}
		public String getCheckInNotes() {
			return checkInNotes;
		}
		public void setCheckInNotes(String checkInNotes) {
			this.checkInNotes = checkInNotes;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public TransferStatusDTO getTransferStatus() {
			return transferStatus;
		}
		public void setTransferStatus(TransferStatusDTO transferStatus) {
			this.transferStatus = transferStatus;
		}
	    
	    
	  
	    

}
