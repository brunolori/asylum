package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class DecisionStatusDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String tag;
    private String tagEng;
   
}
