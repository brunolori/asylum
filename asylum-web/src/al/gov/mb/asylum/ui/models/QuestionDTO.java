package al.gov.mb.asylum.ui.models;

import java.io.Serializable;




public class QuestionDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private int id;
    private String tag;
    private int rank;
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
	
    
    
}
