package al.gov.mb.asylum.forms;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SelectionSx {
	
	
	String uniqueNo;
	String name;
	String surname;
	Date dob;
	String docNo;
	String docTypeCode;
	String irStatusCode;
	String nationalityCode;
	Character gender;
	Integer fromAge;
	Integer toAge;
	Integer asylantStatusId;
	Integer asylantStageId;
	Integer actualLocationId;
	Integer transferStatusId;
	Integer organizationId;
	String handedOverId;
	Character inNeed;
	Character unaccompainedChild;
	Character withIncomes;
	Character returned;
	String uname;
	Date fromDate;
	Date toDate;
	Integer firstResult;
	Integer maxResult;

}
