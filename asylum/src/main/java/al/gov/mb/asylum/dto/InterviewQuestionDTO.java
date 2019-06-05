package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class InterviewQuestionDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	    private int id;
	    private String question;
	    private String answer;
	    private boolean status;
	    private InterviewDTO interview;
	    
	    
		

}
