package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FeedbackDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
		private int id;
	    private SelectionDTO selection;
	    private Date feedbackTime;
	    private String feedbackUser;
	    private Character value;
	    private String notes;
	    private boolean status;
	    
	  

}
