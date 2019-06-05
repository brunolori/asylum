package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DecisionDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private String article;
    private String orderNumber;
    private Date orderDate;
    private String reason;
    private Integer dayRemoval;
    private String borderCrossingPoint;
    private Date datePermitEntrance;
    private String recordUser;
    private Date recordDate;
    private String modifUser;
    private DecisionReasonDTO decisionReason;
    private DecisionStatusDTO orderStatus;
    private DecisionTypeDTO decisionType;
    private SelectionDTO selection;
   
    
    

}
