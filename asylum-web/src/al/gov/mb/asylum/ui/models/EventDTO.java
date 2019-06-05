package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;





public class EventDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private String uniqurNumber;
    private String place;
    private Date eventDate;
    private String description;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    private OrganizationDTO organization;
    private PlaceTypeDTO placeType;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUniqurNumber() {
		return uniqurNumber;
	}
	public void setUniqurNumber(String uniqurNumber) {
		this.uniqurNumber = uniqurNumber;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public OrganizationDTO getOrganization() {
		return organization;
	}
	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}
	public PlaceTypeDTO getPlaceType() {
		return placeType;
	}
	public void setPlaceType(PlaceTypeDTO placeType) {
		this.placeType = placeType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EventDTO other = (EventDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
    
	
}
