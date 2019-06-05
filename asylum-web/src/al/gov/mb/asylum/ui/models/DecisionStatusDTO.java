package al.gov.mb.asylum.ui.models;

import java.io.Serializable;




public class DecisionStatusDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String tag;
    private String tagEng;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTagEng() {
		return tagEng;
	}
	public void setTagEng(String tagEng) {
		this.tagEng = tagEng;
	}
    
    
    
    
   
}
