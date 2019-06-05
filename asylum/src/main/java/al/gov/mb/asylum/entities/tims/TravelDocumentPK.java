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
public class TravelDocumentPK implements Serializable {
   
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODE_STATE")
    private String codeState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODE_TYPE_TRAVEL_DOC")
    private String codeTypeTravelDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TRAVEL_DOC_NO")
    private String travelDocNo;

    public TravelDocumentPK() {
    }

    public TravelDocumentPK(String codeState, String codeTypeTravelDoc, String travelDocNo) {
        this.codeState = codeState;
        this.codeTypeTravelDoc = codeTypeTravelDoc;
        this.travelDocNo = travelDocNo;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeState == null) ? 0 : codeState.hashCode());
		result = prime * result + ((codeTypeTravelDoc == null) ? 0 : codeTypeTravelDoc.hashCode());
		result = prime * result + ((travelDocNo == null) ? 0 : travelDocNo.hashCode());
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
		TravelDocumentPK other = (TravelDocumentPK) obj;
		if (codeState == null) {
			if (other.codeState != null)
				return false;
		} else if (!codeState.equals(other.codeState))
			return false;
		if (codeTypeTravelDoc == null) {
			if (other.codeTypeTravelDoc != null)
				return false;
		} else if (!codeTypeTravelDoc.equals(other.codeTypeTravelDoc))
			return false;
		if (travelDocNo == null) {
			if (other.travelDocNo != null)
				return false;
		} else if (!travelDocNo.equals(other.travelDocNo))
			return false;
		return true;
	}

    
   
    
}
