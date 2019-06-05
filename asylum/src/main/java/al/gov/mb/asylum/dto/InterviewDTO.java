package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class InterviewDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private int id;
    private SelectionDTO selection;
    private Date selectionTime;
    private String selectionNotes;
    private String selectionUser;
    private Date predictedInterviewDate;
    private Date interviewTime;
    private String interviewUser;
    private String notes;
    private String interviewer;
    private String language;
    private String translator;
    private boolean status;
    private InterviewStatusDTO interviewStatus;
    
    
	
    
    

}
