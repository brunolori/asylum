package al.gov.mb.asylum.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class EvidenceDTO {
	
	 private int evidenceId;
	    private int eventId;
	    private String name;
	    private String description;
	    private Date recordDate;
	    private String modifUser;
	    private String recordUser;
	    private EventDTO event;

}
