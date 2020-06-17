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
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.forms.SelectionForm;
import al.gov.mb.asylum.forms.SelectionSx;
import al.gov.mb.asylum.services.SelectionService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/selection")
public class SelectionAPI {

	
	@Autowired TokenService  tokenService;
	@Autowired SelectionService selectionService;
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerSelection(@RequestHeader(value="Authorization") String token, @RequestBody SelectionForm payload)
	{
			String uname = tokenService.getUsername(token);
			
			SelectionDTO dto = new Assembler().toDto(selectionService.registerSelection(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> updateSelection(@RequestHeader(value="Authorization") String token, @RequestBody SelectionDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			SelectionDTO dto = new Assembler().toDto(selectionService.modifySelection(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchSelectionw(@RequestHeader(value="Authorization") String token, @RequestBody SelectionSx req)
	{
		String uname = tokenService.getUsername(token);
		
		
		List<SelectionDTO> list = new Assembler().selectionListToDto(selectionService.searchSelection(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/notGoneFromQkpa", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> notGoneFromQkpa(@RequestHeader(value="Authorization") String token)
	{
		String uname = tokenService.getUsername(token);
		
		
		List<SelectionDTO> list = new Assembler().selectionListToDto(selectionService.notGoneFromQkpa(uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/find/uniqueNo/{uniqueNo}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionByUniqueNo(@RequestHeader(value="Authorization") String token, @PathVariable String uniqueNo)
	{
		String uname = tokenService.getUsername(token);
		
		SelectionDTO dto = new Assembler().toDto(selectionService.findByUniqueNo(uniqueNo, uname));
		
		if(dto == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/find/eventId/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionByEventId(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		String uname = tokenService.getUsername(token);
		
		SelectionDTO dto = new Assembler().toDto(selectionService.findByEventId(eventId, uname));
		
		if(dto == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
}
