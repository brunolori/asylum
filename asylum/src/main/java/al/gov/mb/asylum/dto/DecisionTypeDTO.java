package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DecisionTypeDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String id;
    private String tag;
    private String tagEng;
    private boolean status;
    
  
	
}
