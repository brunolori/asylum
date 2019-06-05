package al.gov.mb.asylum.forms;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class FeedbackSx implements Serializable {


	private static final long serialVersionUID = 1L;
	
	Integer selectionId;
	String uniqueNo;
	String name;
	String surname;
	Date from;
	Date to;
	Character value;
	Integer organizationId;
	Integer firstResult;
	Integer maxResult;
	
	

}
