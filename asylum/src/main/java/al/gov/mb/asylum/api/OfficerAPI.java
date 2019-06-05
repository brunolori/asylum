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
import al.gov.mb.asylum.dto.OfficerDTO;
import al.gov.mb.asylum.forms.OfficerSx;
import al.gov.mb.asylum.services.OfficerService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/officer")
public class OfficerAPI {
	
	
	@Autowired TokenService  tokenService;
	@Autowired OfficerService officerService;
	
	
	@RequestMapping(value="/list/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getEventOfficers(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		tokenService.getUsername(token);
		
		List<OfficerDTO> list = new Assembler().officerListToDto(officerService.getEventOfficers(eventId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchOfficer(@RequestHeader(value="Authorization") String token, @RequestBody OfficerSx req)
	{
		tokenService.getUsername(token);
		
		List<OfficerDTO> list = new Assembler().officerListToDto(officerService.searchOfficerRims(req));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	

}
