package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.Date;

public class AsylumDecisionSx implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	
	String uniqueNo;
	String name;
	String surname;
	String gender;
	Integer fromAge;
	Integer toAge;
	String orderNo;
	Integer statusId;
	Integer stageId;
	Integer selectionId;
	Integer typeId;
	Date fromDate;
	Date toDate;
	
	Integer firstResult;
	Integer maxResult;
	
	
	
	public AsylumDecisionSx() {
		super();
	}
	
	
	
	
	public AsylumDecisionSx(Integer selectionId) {
		super();
		this.selectionId = selectionId;
	}




	public String getUniqueNo() {
		return uniqueNo;
	}
	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getStageId() {
		return stageId;
	}
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}
	public Integer getSelectionId() {
		return selectionId;
	}
	public void setSelectionId(Integer selectionId) {
		this.selectionId = selectionId;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getFromAge() {
		return fromAge;
	}

	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}

	public Integer getToAge() {
		return toAge;
	}

	public void setToAge(Integer toAge) {
		this.toAge = toAge;
	}
	
	
	
	
	
	
	
	
}