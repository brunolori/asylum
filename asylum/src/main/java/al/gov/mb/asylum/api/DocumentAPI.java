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
import al.gov.mb.asylum.dto.DocumentDTO;
import al.gov.mb.asylum.dto.OtherDocumentDTO;
import al.gov.mb.asylum.entities.tims.TravelDocument;
import al.gov.mb.asylum.services.DocumentService;
import al.gov.mb.asylum.services.TokenService;

@RestController
@RequestMapping("/api/document")
public class DocumentAPI {

	@Autowired DocumentService documentService;
	@Autowired TokenService  tokenService;
	
	@RequestMapping(value="/list/tims/{docNo}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getTimsDocument(@PathVariable String docNo)
	{
		
		List<TravelDocument> list = documentService.searchTimsDocument(docNo);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().timsDocumentListToDto(list),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/list/otherDocument/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionOtherDocuments(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		tokenService.getUsername(token);
		
		List<OtherDocumentDTO> list = new Assembler().otherDocumentListToDto(documentService.getSelectionOtherDocuments(eventId));
		
		if(list == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/find/document/{eventId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getSelectionDocument(@RequestHeader(value="Authorization") String token, @PathVariable Integer eventId)
	{
		tokenService.getUsername(token);
		
		DocumentDTO dto = new Assembler().toDto(documentService.getSelectionDocument(eventId));
		
		if(dto == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	
}
