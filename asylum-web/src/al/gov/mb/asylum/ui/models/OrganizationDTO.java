package al.gov.mb.asylum.ui.models;

import java.io.Serializable;




public class OrganizationDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
		private int id;
	    private boolean central;   
	    private String tag;
	    private String oldTag;
	    private int newId;
	    private int oldId;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isCentral() {
			return central;
		}
		public void setCentral(boolean central) {
			this.central = central;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getOldTag() {
			return oldTag;
		}
		public void setOldTag(String oldTag) {
			this.oldTag = oldTag;
		}
		public int getNewId() {
			return newId;
		}
		public void setNewId(int newId) {
			this.newId = newId;
		}
		public int getOldId() {
			return oldId;
		}
		public void setOldId(int oldId) {
			this.oldId = oldId;
		}
	    
	    
		

}
