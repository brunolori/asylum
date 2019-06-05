package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;



public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String codeOS;
    private BigInteger personTimsId;
    private String nid;
    private String name;
    private String midleName;
    private String surname;
    private String name1;
    private String surname1;
    private String fatherName;
    private String motherName;
    private Date dob;
    private String dobText;
    private Character gender;
    private Character codeCivilStatus;
    private String codeNationality;
    private String codeStateBirth;
    private String codeCityBirth;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    private String profesion;
    private String religion;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeOS() {
		return codeOS;
	}
	public void setCodeOS(String codeOS) {
		this.codeOS = codeOS;
	}
	public BigInteger getPersonTimsId() {
		return personTimsId;
	}
	public void setPersonTimsId(BigInteger personTimsId) {
		this.personTimsId = personTimsId;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMidleName() {
		return midleName;
	}
	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getSurname1() {
		return surname1;
	}
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDobText() {
		return dobText;
	}
	public void setDobText(String dobText) {
		this.dobText = dobText;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Character getCodeCivilStatus() {
		return codeCivilStatus;
	}
	public void setCodeCivilStatus(Character codeCivilStatus) {
		this.codeCivilStatus = codeCivilStatus;
	}
	public String getCodeNationality() {
		return codeNationality;
	}
	public void setCodeNationality(String codeNationality) {
		this.codeNationality = codeNationality;
	}
	public String getCodeStateBirth() {
		return codeStateBirth;
	}
	public void setCodeStateBirth(String codeStateBirth) {
		this.codeStateBirth = codeStateBirth;
	}
	public String getCodeCityBirth() {
		return codeCityBirth;
	}
	public void setCodeCityBirth(String codeCityBirth) {
		this.codeCityBirth = codeCityBirth;
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
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	

}
