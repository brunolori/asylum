package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
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
