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
import al.gov.mb.asylum.dto.EventDTO;
import al.gov.mb.asylum.forms.EventForm;
import al.gov.mb.asylum.forms.EventSx;
import al.gov.mb.asylum.services.EventService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/event")
public class EventAPI {

	
	@Autowired EventService eventService;
	@Autowired TokenService  tokenService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerEvent(@RequestHeader(value="Authorization") String token, @RequestBody EventForm payload)
	{
			String uname = tokenService.getUsername(token);
			
			EventDTO dto = new Assembler().toDto(eventService.registerEvent(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> updateEvent(@RequestHeader(value="Authorization") String token, @RequestBody EventForm payload)
	{
		String uname = tokenService.getUsername(token);
		
		EventDTO dto = new Assembler().toDto(eventService.updateEvent(payload, uname));
		
		return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/find/uniqueNo/{uniqueNo}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getEventByUniqueNo(@RequestHeader(value="Authorization") String token, @PathVariable String uniqueNo)
	{
		String uname = tokenService.getUsername(token);
		
		EventDTO dto = new Assembler().toDto(eventService.findByUniqueNo(uniqueNo, uname));
		
		if(dto == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchEvent(@RequestHeader(value="Authorization") String token, @RequestBody EventSx req)
	{
		String uname = tokenService.getUsername(token);
		
		List<EventDTO> list = new Assembler().eventListToDto(eventService.searchEvent(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
}
