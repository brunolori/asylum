/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Embeddable
@Getter @Setter
public class PersonsInstitutionsPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODE_O_S")
    private String codeOS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSON_ID")
    private BigInteger personId;

    public PersonsInstitutionsPK() {
    }

    public PersonsInstitutionsPK(String codeOS, BigInteger personId) {
        this.codeOS = codeOS;
        this.personId = personId;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeOS == null) ? 0 : codeOS.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
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
		PersonsInstitutionsPK other = (PersonsInstitutionsPK) obj;
		if (codeOS == null) {
			if (other.codeOS != null)
				return false;
		} else if (!codeOS.equals(other.codeOS))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

    
   
}
