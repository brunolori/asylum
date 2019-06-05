package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;

public class OfficerSx implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	String rimsNo;
	String name;
	String surname;
	String fullname;
	
	
	public String getRimsNo() {
		return rimsNo;
	}
	public void setRimsNo(String rimsNo) {
		this.rimsNo = rimsNo;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
}
