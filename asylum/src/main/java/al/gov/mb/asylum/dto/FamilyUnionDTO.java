package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class FamilyUnionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	    private Integer id;
	    private SelectionDTO selection;
	    private Date processTime;
	    private String processUser;
	    private String notes;
	    private Integer familyId;
	    private boolean status;
	    private FamilyUnionStatusDTO familyStatus;
	    
	    
	    
		
}
