package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.Date;



public class HearingSx implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	
	Integer selectionId;
	String uniqueNo;
	String name;
	String surname;
	Date from;
	Date to;
	Integer hearingStatus;
	Integer firstResult;
	Integer maxResult;
	
	
	public HearingSx() {}
	
	public HearingSx(Integer eventId) {
		this.selectionId = eventId;
	}
	public Integer getSelectionId() {
		return selectionId;
	}
	public void setSelectionId(Integer selectionId) {
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
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Integer getHearingStatus() {
		return hearingStatus;
	}
	public void setHearingStatus(Integer hearingStatus) {
		this.hearingStatus = hearingStatus;
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
