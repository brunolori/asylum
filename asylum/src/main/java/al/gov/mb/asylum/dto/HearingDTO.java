package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class HearingDTO implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	   
	    private int id;
	   
	    private SelectionDTO selection;
	    private Date hearingTime;
	    private String hearingUser;
	    private Date selectionTime;
	    private String selectionNotes;
	    private Date predictedHearingDate;
	    private String selectionUser;
	    private String listener;
	    private String language;
	    private String translator;
	    private String notes;
	    private boolean status;
	    private HearingStatusDTO hearingStatus;
	    
	    


}
