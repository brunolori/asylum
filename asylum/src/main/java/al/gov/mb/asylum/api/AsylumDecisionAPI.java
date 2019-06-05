package al.gov.mb.asylum.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.assemblers.Assembler;
import al.gov.mb.asylum.dto.AsylumDecisionDTO;
import al.gov.mb.asylum.forms.AsylumDecisionSx;
import al.gov.mb.asylum.services.AsylumDecisionService;
import al.gov.mb.asylum.services.TokenService;



@RestController
@RequestMapping("/api/asylumDecision")
public class AsylumDecisionAPI {

	
	@Autowired AsylumDecisionService asylumDecisionService;
	@Autowired TokenService  tokenService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerAsylumDecision(@RequestHeader(value="Authorization") String token, @RequestBody AsylumDecisionDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			AsylumDecisionDTO dto = new Assembler().toDto(asylumDecisionService.register(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchAsylumDecision(@RequestHeader(value="Authorization") String token, @RequestBody AsylumDecisionSx req)
	{
			String uname = tokenService.getUsername(token);
			
			List<AsylumDecisionDTO> list = new Assembler().asylumDecisionListToDto(asylumDecisionService.searchAsylumDecision(req, uname));
			
			if(list == null)
			{
				return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	
	
}
