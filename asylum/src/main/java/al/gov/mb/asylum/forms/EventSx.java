package al.gov.mb.asylum.forms;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class EventSx {

	String uniqueNo;
	Date fromDate;
	Date toDate;
	Integer organizationId;
	String uname;
	Integer firstResult;
	Integer maxResult;
	
	
}
