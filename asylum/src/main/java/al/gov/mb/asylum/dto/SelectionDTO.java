package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class SelectionDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private EventDTO event;
    private String itinerary;
    private String fleeingReason;
    private Date selectionDate;
    private Date recordDate;
    private String recordUser;
    private String modifUser;
    private String translator;
    private String interviewer;
    private String transLang;
    private String notes;
    private String albAddress;
    private String entryPlace;
    private String entryMode;
    private String reason;
    private HandedOverDTO handed;
    private PersonDTO person;
    private IrStatusDTO irStatus;
    private AsylantDetailsDTO asylantDetails;
    
    
	
}
