package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DecisionReasonDTO  implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private String codeOrder;
    private String typeOrder;
    private String tag;
    private String tagEng;    
    private boolean status;
    private DecisionTypeDTO decisionType;
    
    
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
		DecisionReasonDTO other = (DecisionReasonDTO) obj;
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
