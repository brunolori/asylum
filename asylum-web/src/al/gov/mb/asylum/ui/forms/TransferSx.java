package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.Date;



public class TransferSx implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	String uniqueNo;
	String name;
	String surname;
	Integer departureOrganizationId;
	Integer destinationOrganizationId;
	Integer selectionId;
	Integer transferStatusId;
	Date fromCheckOutTime;
	Date toCheckOutTime;
	Date fromCheckInTime;
	Date toCheckInTime;
	
	Integer firstResult;
	Integer maxResult;
	

	
	public TransferSx() {
		super();
	}
	
	public TransferSx(Integer selectionId) {
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
	public Integer getDepartureOrganizationId() {
		return departureOrganizationId;
	}
	public void setDepartureOrganizationId(Integer departureOrganizationId) {
		this.departureOrganizationId = departureOrganizationId;
	}
	public Integer getDestinationOrganizationId() {
		return destinationOrganizationId;
	}
	public void setDestinationOrganizationId(Integer destinationOrganizationId) {
		this.destinationOrganizationId = destinationOrganizationId;
	}
	public Integer getSelectionId() {
		return selectionId;
	}
	public void setSelectionId(Integer selectionId) {
		this.selectionId = selectionId;
	}
	public Integer getTransferStatusId() {
		return transferStatusId;
	}
	public void setTransferStatusId(Integer transferStatusId) {
		this.transferStatusId = transferStatusId;
	}
	public Date getFromCheckOutTime() {
		return fromCheckOutTime;
	}
	public void setFromCheckOutTime(Date fromCheckOutTime) {
		this.fromCheckOutTime = fromCheckOutTime;
	}
	public Date getToCheckOutTime() {
		return toCheckOutTime;
	}
	public void setToCheckOutTime(Date toCheckOutTime) {
		this.toCheckOutTime = toCheckOutTime;
	}
	public Date getFromCheckInTime() {
		return fromCheckInTime;
	}
	public void setFromCheckInTime(Date fromCheckInTime) {
		this.fromCheckInTime = fromCheckInTime;
	}
	public Date getToCheckInTime() {
		return toCheckInTime;
	}
	public void setToCheckInTime(Date toCheckInTime) {
		this.toCheckInTime = toCheckInTime;
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
	
	
	
	
	
	

}
