package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
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
		if (eventId != other.eventId)
			return false;
		if (officerId == null) {
			if (other.officerId != null)
				return false;
		} else if (!officerId.equals(other.officerId))
			return false;
		return true;
	}
    
    
    
    
    
    
    

}
