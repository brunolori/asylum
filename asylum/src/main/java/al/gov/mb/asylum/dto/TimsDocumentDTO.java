package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
	    
	    
	    
	    
	    
	

}
