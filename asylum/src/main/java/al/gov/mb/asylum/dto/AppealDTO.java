package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AppealDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private SelectionDTO selection;
    private Date appealTime;
    private String appealUser;
    private String decisionNo;
    private Date decisionDate;
	private String notes;
    private boolean active;
    
    
    
	
    
    
	
	
}
