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
public class DecisionReasonPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODE_ORDER")
    private String codeOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IR_TYPE_ORDER")
    private String typeOrder;

    public DecisionReasonPK() {
    }

    public DecisionReasonPK(String codeOrder, String irTypeOrder) {
        this.codeOrder = codeOrder;
        this.typeOrder = irTypeOrder;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeOrder == null) ? 0 : codeOrder.hashCode());
		result = prime * result + ((typeOrder == null) ? 0 : typeOrder.hashCode());
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
		DecisionReasonPK other = (DecisionReasonPK) obj;
		if (codeOrder == null) {
			if (other.codeOrder != null)
				return false;
		} else if (!codeOrder.equals(other.codeOrder))
			return false;
		if (typeOrder == null) {
			if (other.typeOrder != null)
				return false;
		} else if (!typeOrder.equals(other.typeOrder))
			return false;
		return true;
	}

    
    
    
    
}
