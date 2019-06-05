package al.gov.mb.asylum.forms;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class AsylumDecisionSx {

	
	String uniqueNo;
	String name;
	String surname;
	String orderNo;
	Integer statusId;
	Integer stageId;
	Integer selectionId;
	Integer transferStatusId;
	Date fromDate;
	Date toDate;
	
	Integer firstResult;
	Integer maxResult;
	
	
	
}
