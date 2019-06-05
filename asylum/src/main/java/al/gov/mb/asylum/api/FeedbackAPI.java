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
import al.gov.mb.asylum.dto.FeedbackDTO;
import al.gov.mb.asylum.forms.FeedbackSx;
import al.gov.mb.asylum.services.FeedbackService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackAPI {

	
	@Autowired FeedbackService feedbackService;
	@Autowired TokenService  tokenService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerFeedback(@RequestHeader(value="Authorization") String token, @RequestBody FeedbackDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			FeedbackDTO dto = new Assembler().toDto(feedbackService.registerFeedback(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> updateFeedback(@RequestHeader(value="Authorization") String token, @RequestBody FeedbackDTO payload)
	{
		String uname = tokenService.getUsername(token);
		
		FeedbackDTO dto = new Assembler().toDto(feedbackService.modifyFeedback(payload, uname));
		
		return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> deleteFeedback(@RequestHeader(value="Authorization") String token, @RequestBody FeedbackDTO payload)
	{
		String uname = tokenService.getUsername(token);
		
		feedbackService.deleteFeedback(payload, uname);
		
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchFeedback(@RequestHeader(value="Authorization") String token, @RequestBody FeedbackSx req)
	{
		String uname = tokenService.getUsername(token);
		
		List<FeedbackDTO> list = new Assembler().feedbackListToDto(feedbackService.searchFeedback(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
