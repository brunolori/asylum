package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
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
    
    
	
}
