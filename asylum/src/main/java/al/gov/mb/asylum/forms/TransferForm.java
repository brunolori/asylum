package al.gov.mb.asylum.forms;

import java.util.List;

import al.gov.mb.asylum.dto.SelectionDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TransferForm  {
		
	List<SelectionDTO> selections;
	String notes;
	Integer destinationOrgId;
	
	
	
	

}
