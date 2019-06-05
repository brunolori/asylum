package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class TransferDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	    private int id;
	    private SelectionDTO selection;
	    private OrganizationDTO fromOrganization;
	    private OrganizationDTO toOrganization;
	    private Date checkOutTime;
	    private String checkOutUser;
	    private String checkOutNotes;
	    private Date checkInTime;
	    private String checkInUser;
	    private String checkInNotes;
	    private boolean status;
	    private TransferStatusDTO transferStatus;
	    
	    
	  
	    

}
