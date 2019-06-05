package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;

public class PasswordForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String oldPassword;
	private String newPassword;
	private int userId;
	private String username;
	
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
