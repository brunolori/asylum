package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;




public class TimsDocumentDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
		private String codeOs;
		private BigInteger personId;
	    private String documentNo;
	    private String nid;
	    private Date dateOfIssue;
	    private Date dateOfExpiration;
	    private Date dateOfExtension;
	    private String docType;
	    private String docTypeCode;
	    private String docStateCode;
	    
	    private String name;
	    private String surname;
	    private String maidenName;
	    private String fatherName;
	    private String pob;
	    private String motherName;
	    private Date dob;
	    private Character gender;
	    private String codeStateBirth;
	    private String codeCityBirth;
	    private String nationalityStateCode;
	    
	    
	    
		public String getDocumentNo() {
			return documentNo;
		}
		public void setDocumentNo(String documentNo) {
			this.documentNo = documentNo;
		}
		public String getNid() {
			return nid;
		}
		public void setNid(String nid) {
			this.nid = nid;
		}
		public Date getDateOfIssue() {
			return dateOfIssue;
		}
		public void setDateOfIssue(Date dateOfIssue) {
			this.dateOfIssue = dateOfIssue;
		}
		public Date getDateOfExpiration() {
			return dateOfExpiration;
		}
		public void setDateOfExpiration(Date dateOfExpiration) {
			this.dateOfExpiration = dateOfExpiration;
		}
		public Date getDateOfExtension() {
			return dateOfExtension;
		}
		public void setDateOfExtension(Date dateOfExtension) {
			this.dateOfExtension = dateOfExtension;
		}
		public String getDocType() {
			return docType;
		}
		public void setDocType(String docType) {
			this.docType = docType;
		}
		public String getDocTypeCode() {
			return docTypeCode;
		}
		public void setDocTypeCode(String docTypeCode) {
			this.docTypeCode = docTypeCode;
		}
		public String getDocStateCode() {
			return docStateCode;
		}
		public void setDocStateCode(String docStateCode) {
			this.docStateCode = docStateCode;
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
		public String getMaidenName() {
			return maidenName;
		}
		public void setMaidenName(String maidenName) {
			this.maidenName = maidenName;
		}
		public String getFatherName() {
			return fatherName;
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		public String getPob() {
			return pob;
		}
		public void setPob(String pob) {
			this.pob = pob;
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
		public Character getGender() {
			return gender;
		}
		public void setGender(Character gender) {
			this.gender = gender;
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
		public String getNationalityStateCode() {
			return nationalityStateCode;
		}
		public void setNationalityStateCode(String nationalityStateCode) {
			this.nationalityStateCode = nationalityStateCode;
		}
		
		public String getCodeOs() {
			return codeOs;
		}
		public void setCodeOs(String codeOs) {
			this.codeOs = codeOs;
		}
		public BigInteger getPersonId() {
			return personId;
		}
		public void setPersonId(BigInteger personId) {
			this.personId = personId;
		}
		public String getKey()
		{
			return documentNo+","+docTypeCode+","+docStateCode;
		}
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((docStateCode == null) ? 0 : docStateCode.hashCode());
			result = prime * result + ((docTypeCode == null) ? 0 : docTypeCode.hashCode());
			result = prime * result + ((documentNo == null) ? 0 : documentNo.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TimsDocumentDTO other = (TimsDocumentDTO) obj;
			if (docStateCode == null) {
				if (other.docStateCode != null)
					return false;
			} else if (!docStateCode.equals(other.docStateCode))
				return false;
			if (docTypeCode == null) {
				if (other.docTypeCode != null)
					return false;
			} else if (!docTypeCode.equals(other.docTypeCode))
				return false;
			if (documentNo == null) {
				if (other.documentNo != null)
					return false;
			} else if (!documentNo.equals(other.documentNo))
				return false;
			return true;
		}
	    
	    
	    
	    public String toString()
	    {
	    	return documentNo+" ("+docStateCode+") - "+docType+"; "+name+" "+surname;
	    }
	    
	

}
