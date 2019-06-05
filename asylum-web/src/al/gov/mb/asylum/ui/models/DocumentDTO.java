package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;





public class DocumentDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private String codeState;
	private String codeTypeTravelDoc;
	private String travelDocNo;
	private int eventId;
	
	private Date dateOfIssue;
    private Date dateOfExpiration;
    private Date dateOfExtension;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    private int personId;
    
    
	
	public String getCodeState() {
		return codeState;
	}
	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}
	public String getCodeTypeTravelDoc() {
		return codeTypeTravelDoc;
	}
	public void setCodeTypeTravelDoc(String codeTypeTravelDoc) {
		this.codeTypeTravelDoc = codeTypeTravelDoc;
	}
	public String getTravelDocNo() {
		return travelDocNo;
	}
	public void setTravelDocNo(String travelDocNo) {
		this.travelDocNo = travelDocNo;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public Date getDateOfExpiration() {
		return dateOfExpiration;
	}
	public void setDateOfExpiration(Date dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}
	public Date getDateOfExtension() {
		return dateOfExtension;
	}
	public void setDateOfExtension(Date dateOfExtension) {
		this.dateOfExtension = dateOfExtension;
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
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeState == null) ? 0 : codeState.hashCode());
		result = prime * result + ((codeTypeTravelDoc == null) ? 0 : codeTypeTravelDoc.hashCode());
		result = prime * result + eventId;
		result = prime * result + ((travelDocNo == null) ? 0 : travelDocNo.hashCode());
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
		DocumentDTO other = (DocumentDTO) obj;
		if (codeState == null) {
			if (other.codeState != null)
				return false;
		} else if (!codeState.equals(other.codeState))
			return false;
		if (codeTypeTravelDoc == null) {
			if (other.codeTypeTravelDoc != null)
				return false;
		} else if (!codeTypeTravelDoc.equals(other.codeTypeTravelDoc))
			return false;
		if (eventId != other.eventId)
			return false;
		if (travelDocNo == null) {
			if (other.travelDocNo != null)
				return false;
		} else if (!travelDocNo.equals(other.travelDocNo))
			return false;
		return true;
	}
	
	
	
    
    
    
	
}
