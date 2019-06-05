package al.gov.mb.asylum.ui.models;

import java.io.Serializable;




public class AsylantStatusDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String tag;
    private String tagEn;
    private boolean status;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTagEn() {
		return tagEn;
	}
	public void setTagEn(String tagEn) {
		this.tagEn = tagEn;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		AsylantStatusDTO other = (AsylantStatusDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
   
    
    

}