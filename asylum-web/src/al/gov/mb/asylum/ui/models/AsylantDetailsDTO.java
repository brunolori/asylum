package al.gov.mb.asylum.ui.models;

import java.io.Serializable;




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
    
    
    
    
    
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Character getInNeed() {
		return inNeed;
	}
	public void setInNeed(Character inNeed) {
		this.inNeed = inNeed;
	}
	public String getNeeds() {
		return needs;
	}
	public void setNeeds(String needs) {
		this.needs = needs;
	}
	public Character getWithIncomes() {
		return withIncomes;
	}
	public void setWithIncomes(Character withIncomes) {
		this.withIncomes = withIncomes;
	}
	public String getIncomes() {
		return incomes;
	}
	public void setIncomes(String incomes) {
		this.incomes = incomes;
	}
	public Character getUnaccompainedChild() {
		return unaccompainedChild;
	}
	public void setUnaccompainedChild(Character unaccompainedChild) {
		this.unaccompainedChild = unaccompainedChild;
	}
	public Character getFeedbackValue() {
		return feedbackValue;
	}
	public void setFeedbackValue(Character feedbackValue) {
		this.feedbackValue = feedbackValue;
	}
	public OrganizationDTO getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(OrganizationDTO currentLocation) {
		this.currentLocation = currentLocation;
	}
	public Character getAcceleratedProcess() {
		return acceleratedProcess;
	}
	public void setAcceleratedProcess(Character acceleratedProcess) {
		this.acceleratedProcess = acceleratedProcess;
	}
	public int getInterviewCnt() {
		return interviewCnt;
	}
	public void setInterviewCnt(int interviewCnt) {
		this.interviewCnt = interviewCnt;
	}
	public int getHearingCnt() {
		return hearingCnt;
	}
	public void setHearingCnt(int hearingCnt) {
		this.hearingCnt = hearingCnt;
	}
	public String getIssuedAlbDocs() {
		return issuedAlbDocs;
	}
	public void setIssuedAlbDocs(String issuedAlbDocs) {
		this.issuedAlbDocs = issuedAlbDocs;
	}
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public AsylantStageDTO getAsylantStage() {
		return asylantStage;
	}
	public void setAsylantStage(AsylantStageDTO asylantStage) {
		this.asylantStage = asylantStage;
	}
	public AsylantStatusDTO getAsylantStatus() {
		return asylantStatus;
	}
	public void setAsylantStatus(AsylantStatusDTO asylantStatus) {
		this.asylantStatus = asylantStatus;
	}
	public FamilyUnionStatusDTO getFamilyUnionStatus() {
		return familyUnionStatus;
	}
	public void setFamilyUnionStatus(FamilyUnionStatusDTO familyUnionStatus) {
		this.familyUnionStatus = familyUnionStatus;
	}
	public HearingStatusDTO getLastHearingStatus() {
		return lastHearingStatus;
	}
	public void setLastHearingStatus(HearingStatusDTO lastHearingStatus) {
		this.lastHearingStatus = lastHearingStatus;
	}
	public InterviewStatusDTO getLastInterviewStatus() {
		return lastInterviewStatus;
	}
	public void setLastInterviewStatus(InterviewStatusDTO lastInterviewStatus) {
		this.lastInterviewStatus = lastInterviewStatus;
	}
	public TransferStatusDTO getTransferStatus() {
		return transferStatus;
	}
	public void setTransferStatus(TransferStatusDTO transferStatus) {
		this.transferStatus = transferStatus;
	}
	public Character getReturned() {
		return returned;
	}
	public void setReturned(Character returned) {
		this.returned = returned;
	}
    
    
   
    
    
    
    
    
    


}
