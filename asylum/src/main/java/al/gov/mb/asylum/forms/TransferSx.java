package al.gov.mb.asylum.forms;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TransferSx {
	
	String uniqueNo;
	String name;
	String surname;
	Integer departureOrganizationId;
	Integer destinationOrganizationId;
	Integer selectionId;
	Integer transferStatusId;
	Date fromCheckOutTime;
	Date toCheckOutTime;
	Date fromCheckInTime;
	Date toCheckInTime;
	
	Integer firstResult;
	Integer maxResult;

}
