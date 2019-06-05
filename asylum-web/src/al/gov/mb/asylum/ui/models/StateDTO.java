package al.gov.mb.asylum.ui.models;

import java.io.Serializable;





public class StateDTO implements Serializable {


	   private static final long serialVersionUID = 1L;
	   
	   
		private String code;
	    private String tag;
	    private String codeAlpha3;
	    private String enTag;
	    
	    
	    
	    
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getCodeAlpha3() {
			return codeAlpha3;
		}
		public void setCodeAlpha3(String codeAlpha3) {
			this.codeAlpha3 = codeAlpha3;
		}
		public String getEnTag() {
			return enTag;
		}
		public void setEnTag(String enTag) {
			this.enTag = enTag;
		}
		
		
		
		
		
		
		@Override
		public String toString() {
			return tag;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((code == null) ? 0 : code.hashCode());
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
			StateDTO other = (StateDTO) obj;
			if (code == null) {
				if (other.code != null)
					return false;
			} else if (!code.equals(other.code))
				return false;
			return true;
		}
	    
	    
	    
	    
	    
	    
	
}
