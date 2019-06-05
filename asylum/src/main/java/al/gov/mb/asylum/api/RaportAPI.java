package al.gov.mb.asylum.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.models.KeyValue;
import al.gov.mb.asylum.services.RaportService;
import al.gov.mb.asylum.services.TokenService;
import al.gov.mb.asylum.utils.DateUtil;

@RestController
@RequestMapping("/api/raport")
public class RaportAPI {

	
	@Autowired TokenService  tokenService;
	@Autowired RaportService raportService;
	
	
	@RequestMapping(value="/registeredSelectionsByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByPeriod(@RequestHeader(value="Authorization") String token, 
			@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = raportService.registeredSelectionsByPeriod(fromDate, toDate, organizationId, uname);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredSelectionsByOrganization", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByOrganization(@RequestHeader(value="Authorization") String token,
			@RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = raportService.registeredSelectionsByOrganization(fromDate, toDate);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredSelectionsByState", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByState(@RequestHeader(value="Authorization") String token,
			@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = raportService.registeredSelectionsByState(fromDate, toDate, organizationId, uname);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredSelectionsByGender", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByGender(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = raportService.registeredSelectionsByGender(fromDate, toDate, organizationId, uname);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/countAll", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> countAll(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.countAll(fromDate, toDate, organizationId, uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/childCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> childCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.childCountByPeriod(fromDate, toDate, organizationId, uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/gonePersonsCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> gonePersonsCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.gonePersonsCountByPeriod(fromDate, toDate, organizationId,uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/returnedPersonsCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> returnedPersonsCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.returnedPersonsCountByPeriod(fromDate, toDate, organizationId, uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}		
	
	@RequestMapping(value="/countAllAsylants", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> countAllAsylants(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.countAllAsylants(fromDate, toDate, organizationId, uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/countAllTrafficVictims", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> countAllTrafficVictims(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.countAllTrafficVictims(fromDate, toDate, organizationId, uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/countAllIrregularImigrants", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> countAllIrregularImigrants(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = raportService.countAllIrregularImigrants(fromDate, toDate, organizationId, uname);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
		
	@RequestMapping(value="/registeredSelectionsByPlaceType", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByPlaceType(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = raportService.registeredSelectionsByPlaceType(fromDate, toDate, organizationId, uname);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredDecisionsByType", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredDecisionsByType(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(required=false, name="organizationId") Integer organizationId)
	{
		String uname = tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = raportService.registeredDecisionsByType(fromDate, toDate, organizationId, uname);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	
}
