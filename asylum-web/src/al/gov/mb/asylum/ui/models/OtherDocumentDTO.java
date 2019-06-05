package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;




public class OtherDocumentDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private int documentId;
    private int eventId;

    private String documentNo;
    private String state;
    private String docType;
    private String recordUser;
    private String modifUser;
    private Date recordDate;
    
    
	
	
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	public String getModifUser() {
		return modifUser;
	}
	public void setModifUser(String modifUser) {
		this.modifUser = modifUser;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((docType == null) ? 0 : docType.hashCode());
		result = prime * result + documentId;
		result = prime * result + ((documentNo == null) ? 0 : documentNo.hashCode());
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
		OtherDocumentDTO other = (OtherDocumentDTO) obj;
		if (docType == null) {
			if (other.docType != null)
				return false;
		} else if (!docType.equals(other.docType))
			return false;
		if (documentId != other.documentId)
			return false;
		if (documentNo == null) {
			if (other.documentNo != null)
				return false;
		} else if (!documentNo.equals(other.documentNo))
			return false;
		if (eventId != other.eventId)
			return false;
		return true;
	}
    
    
    
    
    
    
    
}
