package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.Date;



public class SelectionSx implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	String uniqueNo;
	String name;
	String surname;
	Date dob;
	String docNo;
	String docTypeCode;
	String irStatusCode;
	String nationalityCode;
	Character gender;
	Integer fromAge;
	Integer toAge;
	Integer asylantStatusId;
	Integer asylantStageId;
	Integer actualLocationId;
	Integer transferStatusId;
	Integer organizationId;
	String handedOverId;
	String uname;
	Date fromDate;
	Date toDate;
	Character inNeed;
	Character unaccompainedChild;
	Character withIncomes;
	Character returned;
	Integer firstResult;
	Integer maxResult;
	
	
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getDocTypeCode() {
		return docTypeCode;
	}
	public void setDocTypeCode(String docTypeCode) {
		this.docTypeCode = docTypeCode;
	}
	public String getIrStatusCode() {
		return irStatusCode;
	}
	public void setIrStatusCode(String irStatusCode) {
		this.irStatusCode = irStatusCode;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public Integer getAsylantStatusId() {
		return asylantStatusId;
	}
	public void setAsylantStatusId(Integer asylantStatusId) {
		this.asylantStatusId = asylantStatusId;
	}
	public Integer getAsylantStageId() {
		return asylantStageId;
	}
	public void setAsylantStageId(Integer asylantStageId) {
		this.asylantStageId = asylantStageId;
	}
	public Character getInNeed() {
		return inNeed;
	}
	public void setInNeed(Character inNeed) {
		this.inNeed = inNeed;
	}
	public Character getUnaccompainedChild() {
		return unaccompainedChild;
	}
	public void setUnaccompainedChild(Character unaccompainedChild) {
		this.unaccompainedChild = unaccompainedChild;
	}
	public Character getWithIncomes() {
		return withIncomes;
	}
	public void setWithIncomes(Character withIncomes) {
		this.withIncomes = withIncomes;
	}
	public String getNationalityCode() {
		return nationalityCode;
	}
	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
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
	public Integer getActualLocationId() {
		return actualLocationId;
	}
	public void setActualLocationId(Integer actualLocationId) {
		this.actualLocationId = actualLocationId;
	}
	public Integer getTransferStatusId() {
		return transferStatusId;
	}
	public void setTransferStatusId(Integer transferStatusId) {
		this.transferStatusId = transferStatusId;
	}
	public Character getReturned() {
		return returned;
	}
	public void setReturned(Character returned) {
		this.returned = returned;
	}
	public String getHandedOverId() {
		return handedOverId;
	}
	public void setHandedOverId(String handedOverId) {
		this.handedOverId = handedOverId;
	}
	
	
	
	

}
