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
import al.gov.mb.asylum.dto.InterviewDTO;
import al.gov.mb.asylum.dto.InterviewQuestionDTO;
import al.gov.mb.asylum.forms.InterviewForm;
import al.gov.mb.asylum.forms.InterviewSx;
import al.gov.mb.asylum.services.InterviewService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/interview")
public class InterviewAPI {
	
	
	
	@Autowired TokenService  tokenService;
	@Autowired InterviewService interviewService;
	
	
	
	@RequestMapping(value="/select", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> selectForInterview(@RequestHeader(value="Authorization") String token, @RequestBody InterviewDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			InterviewDTO dto = new Assembler().toDto(interviewService.selectForInterview(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerInterview(@RequestHeader(value="Authorization") String token, @RequestBody InterviewForm payload)
	{
			String uname = tokenService.getUsername(token);
			
			InterviewDTO dto = new Assembler().toDto(interviewService.registerInterview(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchInterview(@RequestHeader(value="Authorization") String token, @RequestBody InterviewSx req)
	{
		String uname = tokenService.getUsername(token);
		
		List<InterviewDTO> list = new Assembler().interviewListToDto(interviewService.searchInterview(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/questions/{interviewId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getInterviewQuestions(@RequestHeader(value="Authorization") String token, @PathVariable Integer interviewId)
	{
		tokenService.getUsername(token);
		
		List<InterviewQuestionDTO> list = new Assembler().interviewQuestiontListToDto(interviewService.getInterviewQuestions(interviewId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	

}
