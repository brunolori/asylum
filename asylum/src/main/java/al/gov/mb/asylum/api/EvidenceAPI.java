package al.gov.mb.asylum.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.assemblers.Assembler;
import al.gov.mb.asylum.dto.EvidenceDTO;
import al.gov.mb.asylum.services.EvidenceService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceAPI {

	
	@Autowired TokenService  tokenService;
	@Autowired EvidenceService  evidenceService;
	
	
	@RequestMapping(value="/list/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getEventOfficers(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		tokenService.getUsername(token);
		
		List<EvidenceDTO> list = new Assembler().evidenceListToDto(evidenceService.getEventEvidences(eventId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
}
