/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
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
public class CityPK implements Serializable {
   
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODE_STATE")
    private String codeState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODE_CITY")
    private String codeCity;

    public CityPK() {
    }

    public CityPK(String codeState, String codeCity) {
        this.codeState = codeState;
        this.codeCity = codeCity;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCity == null) ? 0 : codeCity.hashCode());
		result = prime * result + ((codeState == null) ? 0 : codeState.hashCode());
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
		CityPK other = (CityPK) obj;
		if (codeCity == null) {
			if (other.codeCity != null)
				return false;
		} else if (!codeCity.equals(other.codeCity))
			return false;
		if (codeState == null) {
			if (other.codeState != null)
				return false;
		} else if (!codeState.equals(other.codeState))
			return false;
		return true;
	}

    

    
    
}
