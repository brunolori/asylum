package al.gov.mb.asylum.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.assemblers.Assembler;
import al.gov.mb.asylum.dto.BiometricDTO;
import al.gov.mb.asylum.services.BiometricService;
import al.gov.mb.asylum.services.TokenService;


@RestController
@RequestMapping("/api/biometric")
public class BiometricAPI {

	
	@Autowired BiometricService biometricService;
	@Autowired TokenService  tokenService;
	
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerBiometric(@RequestHeader(value="Authorization") String token, @RequestBody BiometricDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			biometricService.registerPhoto(payload, uname);
			
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/find/photo/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findBiometric(@PathVariable Integer eventId)
	{
		BiometricDTO dto = new Assembler().toDto(biometricService.findById(eventId));
		if(dto == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	
	
}
