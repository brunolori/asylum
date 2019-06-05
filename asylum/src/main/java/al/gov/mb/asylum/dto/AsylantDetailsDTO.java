package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class AsylantDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private int eventId;
    private Character inNeed;
    private String needs;
    private Character withIncomes;
    private String incomes;
    private Character unaccompainedChild;
    private Character returned;
    private Character feedbackValue;
    private OrganizationDTO currentLocation;
    private Character acceleratedProcess;
    private int interviewCnt;
    private int hearingCnt;
    private String issuedAlbDocs;
    private Integer familyId;
    private AsylantStageDTO asylantStage;
    private AsylantStatusDTO asylantStatus;
    private FamilyUnionStatusDTO familyUnionStatus;
    private HearingStatusDTO lastHearingStatus;
    private InterviewStatusDTO lastInterviewStatus;
    private TransferStatusDTO transferStatus;
    
    
   
    
    
    
    
    
    


}
