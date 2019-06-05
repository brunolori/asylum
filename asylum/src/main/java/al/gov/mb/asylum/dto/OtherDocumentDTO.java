package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Setter @Getter
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
    
    
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + documentId;
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
		if (documentId != other.documentId)
			return false;
		if (eventId != other.eventId)
			return false;
		return true;
	}
    
    
    
    
    
    
    
}
