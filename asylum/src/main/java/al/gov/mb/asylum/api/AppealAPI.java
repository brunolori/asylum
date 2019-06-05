package al.gov.mb.asylum.api;

import java.util.List;

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
import al.gov.mb.asylum.dto.AppealDTO;
import al.gov.mb.asylum.services.AppealService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/appeal")
public class AppealAPI {

	
	@Autowired AppealService appealService;
	@Autowired TokenService  tokenService;
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerAppeal(@RequestHeader(value="Authorization") String token, @RequestBody AppealDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			AppealDTO dto = new Assembler().toDto(appealService.registerAppeal(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/list/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionAppeals(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		tokenService.getUsername(token);
		
		List<AppealDTO> list = new Assembler().appealListToDto(appealService.getSelectionAppeals(eventId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
}
