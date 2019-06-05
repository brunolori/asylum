package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;



public class OfficerDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    
    private String officerId;
    private int eventId;
    private String name;
    private String surname;
    private String grade;
    private String organization;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    
    
	
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
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
		result = prime * result + ((officerId == null) ? 0 : officerId.hashCode());
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
		OfficerDTO other = (OfficerDTO) obj;
		if (officerId == null) {
			if (other.officerId != null)
				return false;
		} else if (!officerId.equals(other.officerId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return name+" "+surname+" - "+organization;
	}
    
    
    
    
    
    
    

}
