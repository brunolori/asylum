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
import al.gov.mb.asylum.dto.DecisionDTO;
import al.gov.mb.asylum.services.DecisionService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/decision")
public class DecisionAPI {

	@Autowired DecisionService decisionService;
	@Autowired TokenService  tokenService;
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerDecision(@RequestHeader(value="Authorization") String token, @RequestBody DecisionDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			DecisionDTO dto = new Assembler().toDto(decisionService.registerDecision(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> updateDecision(@RequestHeader(value="Authorization") String token, @RequestBody DecisionDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			DecisionDTO dto = new Assembler().toDto(decisionService.modifyDecision(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/list/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionDecisions(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		tokenService.getUsername(token);
		
		List<DecisionDTO> list = new Assembler().decisionListToDto(decisionService.getEventDecisions(eventId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
}
