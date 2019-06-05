package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;




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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getDayRemoval() {
		return dayRemoval;
	}
	public void setDayRemoval(Integer dayRemoval) {
		this.dayRemoval = dayRemoval;
	}
	public String getBorderCrossingPoint() {
		return borderCrossingPoint;
	}
	public void setBorderCrossingPoint(String borderCrossingPoint) {
		this.borderCrossingPoint = borderCrossingPoint;
	}
	public Date getDatePermitEntrance() {
		return datePermitEntrance;
	}
	public void setDatePermitEntrance(Date datePermitEntrance) {
		this.datePermitEntrance = datePermitEntrance;
	}
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getModifUser() {
		return modifUser;
	}
	public void setModifUser(String modifUser) {
		this.modifUser = modifUser;
	}
	public DecisionReasonDTO getDecisionReason() {
		return decisionReason;
	}
	public void setDecisionReason(DecisionReasonDTO decisionReason) {
		this.decisionReason = decisionReason;
	}
	public DecisionStatusDTO getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(DecisionStatusDTO orderStatus) {
		this.orderStatus = orderStatus;
	}
	public DecisionTypeDTO getDecisionType() {
		return decisionType;
	}
	public void setDecisionType(DecisionTypeDTO decisionType) {
		this.decisionType = decisionType;
	}
	public SelectionDTO getSelection() {
		return selection;
	}
	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}
   
    
    

}
