package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DecisionHistoryDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private String process;
    private String field;
    private String notes;
    private String recordUser;
    private Date recordDate;
    private DecisionDTO decision;
    
}
