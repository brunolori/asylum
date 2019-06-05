package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AsylumDecisionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private SelectionDTO selection;

    private Date decisionTime;

    private String decisionUser;

    private String notes;

    private String orderNo;

    private Date orderDate;

    private String article;
    
    private boolean status;

    private AsylantStageDTO oldStage;

    private AsylantStageDTO newStage;

    private AsylantStatusDTO oldStatus;

    private AsylantStatusDTO newStatus;

    private AsylumDecisionTypeDTO decisionType;
    
    
}
