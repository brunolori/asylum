package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class UserDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private String username;
    private String secret;
    private String surname;
    private String name;
    private String role;
    private OrganizationDTO organization;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private boolean status;
    
    
    

}
