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
import al.gov.mb.asylum.dto.HearingDTO;
import al.gov.mb.asylum.forms.HearingSx;
import al.gov.mb.asylum.services.HearingService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/hearing")
public class HearingAPI {

	
	@Autowired TokenService  tokenService;
	@Autowired HearingService hearingService;
	
	
	
	@RequestMapping(value="/select", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> selectForHearing(@RequestHeader(value="Authorization") String token, @RequestBody HearingDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			HearingDTO dto = new Assembler().toDto(hearingService.selectForHearing(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerHearing(@RequestHeader(value="Authorization") String token, @RequestBody HearingDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			HearingDTO dto = new Assembler().toDto(hearingService.registerHearing(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchHearing(@RequestHeader(value="Authorization") String token, @RequestBody HearingSx req)
	{
		String uname = tokenService.getUsername(token);
		
		List<HearingDTO> list = new Assembler().hearingListToDto(hearingService.searchHearing(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
}
