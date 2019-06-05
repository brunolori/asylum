package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class BiometricDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	
	private int eventId;
    private String uniqueNumber;
    private String photo;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    
   
    

}
