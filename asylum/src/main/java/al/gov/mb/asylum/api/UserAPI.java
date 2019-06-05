package al.gov.mb.asylum.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.assemblers.Assembler;
import al.gov.mb.asylum.dto.UserDTO;
import al.gov.mb.asylum.forms.PasswordForm;
import al.gov.mb.asylum.models.Principal;
import al.gov.mb.asylum.models.UserToken;
import al.gov.mb.asylum.services.TokenService;
import al.gov.mb.asylum.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
	
	
	
	@Autowired UserService userService;
	@Autowired TokenService tokenService;
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> login(@RequestBody Principal principal)
	{
			UserDTO user = new Assembler().toDto(userService.login(principal));
			
			String token = tokenService.generateToken(user);
			
			UserToken ut = new UserToken(user, token);			
			
			return new ResponseEntity<>(ut,HttpStatus.OK);		
	}

	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> login(@RequestHeader(value="Authorization") String token, @RequestBody PasswordForm form)
	{
		    String uname = tokenService.getUsername(token);
			userService.changePassword(form, uname);
			
			return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	
	
	
}
