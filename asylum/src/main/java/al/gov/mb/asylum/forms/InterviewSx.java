package al.gov.mb.asylum.forms;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class InterviewSx {

	Integer selectionId;
	String uniqueNo;
	String name;
	String surname;
	Date from;
	Date to;
	Integer interviewStatus;
	Integer firstResult;
	Integer maxResult;
	
	
	
	
}
