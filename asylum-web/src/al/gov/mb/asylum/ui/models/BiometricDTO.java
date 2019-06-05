package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;





public class BiometricDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	
	private int eventId;
    private String uniqueNumber;
    private String photo;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    
    
    
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getUniqueNumber() {
		return uniqueNumber;
	}
	public void setUniqueNumber(String uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getModifUser() {
		return modifUser;
	}
	public void setModifUser(String modifUser) {
		this.modifUser = modifUser;
	}
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BiometricDTO other = (BiometricDTO) obj;
		if (eventId != other.eventId)
			return false;
		return true;
	}
    
   
    

}
