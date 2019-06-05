package al.gov.mb.asylum.models;

import al.gov.mb.asylum.dto.UserDTO;

public class UserToken {

	UserDTO user;
	String token;
	
	
	public UserToken() {}
	
	
	public UserToken(UserDTO user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
