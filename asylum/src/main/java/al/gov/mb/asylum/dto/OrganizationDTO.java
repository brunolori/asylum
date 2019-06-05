package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class OrganizationDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
		private int id;
	    private boolean central;   
	    private String tag;
	    private String oldTag;
	    private int newId;
	    private int oldId;
	    
	    
		

}
