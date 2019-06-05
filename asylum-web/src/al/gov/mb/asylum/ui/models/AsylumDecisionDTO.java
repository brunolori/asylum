package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;




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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SelectionDTO getSelection() {
		return selection;
	}

	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}

	public Date getDecisionTime() {
		return decisionTime;
	}

	public void setDecisionTime(Date decisionTime) {
		this.decisionTime = decisionTime;
	}

	public String getDecisionUser() {
		return decisionUser;
	}

	public void setDecisionUser(String decisionUser) {
		this.decisionUser = decisionUser;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public AsylantStageDTO getOldStage() {
		return oldStage;
	}

	public void setOldStage(AsylantStageDTO oldStage) {
		this.oldStage = oldStage;
	}

	public AsylantStageDTO getNewStage() {
		return newStage;
	}

	public void setNewStage(AsylantStageDTO newStage) {
		this.newStage = newStage;
	}

	public AsylantStatusDTO getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(AsylantStatusDTO oldStatus) {
		this.oldStatus = oldStatus;
	}

	public AsylantStatusDTO getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(AsylantStatusDTO newStatus) {
		this.newStatus = newStatus;
	}

	public AsylumDecisionTypeDTO getDecisionType() {
		return decisionType;
	}

	public void setDecisionType(AsylumDecisionTypeDTO decisionType) {
		this.decisionType = decisionType;
	}
    
    
    
    
    
    
}
