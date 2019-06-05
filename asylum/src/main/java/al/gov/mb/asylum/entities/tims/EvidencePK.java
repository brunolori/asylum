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

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Embeddable
@Setter @Getter
public class EvidencePK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVIDENCE")
    private Integer evidenceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENT_ID")
    private Integer eventId;

    public EvidencePK() {
    }
    
    public EvidencePK(Integer evidenceId, Integer eventId) {
    	this.evidenceId = evidenceId;
    	this.eventId = eventId;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((evidenceId == null) ? 0 : evidenceId.hashCode());
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
		EvidencePK other = (EvidencePK) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (evidenceId == null) {
			if (other.evidenceId != null)
				return false;
		} else if (!evidenceId.equals(other.evidenceId))
			return false;
		return true;
	}

    
    
}
