package al.gov.mb.asylum.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.assemblers.Assembler;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.dto.TransferDTO;
import al.gov.mb.asylum.forms.TransferForm;
import al.gov.mb.asylum.forms.TransferSx;
import al.gov.mb.asylum.services.TokenService;
import al.gov.mb.asylum.services.TransferService;

@RestController
@RequestMapping("/api/transfer")
public class TransferAPI {
	
	
	@Autowired TokenService tokenService;
	@Autowired TransferService transferService;
	
	
	@RequestMapping(value="/checkOut", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerCheckOut(@RequestHeader(value="Authorization") String token, @RequestBody TransferDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			TransferDTO dto = new Assembler().toDto(transferService.registerCheckOut(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/gone", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerGoneSelection(@RequestHeader(value="Authorization") String token, @RequestBody SelectionDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			TransferDTO dto = new Assembler().toDto(transferService.registerGoneSelection(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/checkOutList", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> registerCheckOut(@RequestHeader(value="Authorization") String token, @RequestBody TransferForm payload)
	{
			String uname = tokenService.getUsername(token);
			
			transferService.registerCheckOut(payload, uname);
			
			return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@RequestMapping(value="/checkIn", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> completeCheckIn(@RequestHeader(value="Authorization") String token, @RequestBody TransferDTO payload)
	{
			String uname = tokenService.getUsername(token);
			
			TransferDTO dto = new Assembler().toDto(transferService.completeCheckIn(payload, uname));
			
			return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchTransfer(@RequestHeader(value="Authorization") String token, @RequestBody TransferSx req)
	{
		String uname = tokenService.getUsername(token);
		
		List<TransferDTO> list = new Assembler().transferListToDto(transferService.searchTransfer(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/searchGone", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?> searchGone(@RequestHeader(value="Authorization") String token, @RequestBody TransferSx req)
	{
		String uname = tokenService.getUsername(token);
		
		List<TransferDTO> list = new Assembler().transferListToDto(transferService.searchGone(req, uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getDrkmSelectionsForTransfer", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getDrkmSelectionsForTransfer(@RequestHeader(value="Authorization") String token)
	{
		String uname = tokenService.getUsername(token);
		
		List<SelectionDTO> list = new Assembler().selectionListToDto(transferService.getDrkmSelectionsForTransfer(uname));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getSelectionTransfers", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionTransfers(@RequestHeader(value="Authorization") String token, @RequestParam("eventId") Integer eventId)
	{
		tokenService.getUsername(token);
		
		List<TransferDTO> list = new Assembler().transferListToDto(transferService.getSelectionTransfers(eventId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}

}
