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
import al.gov.mb.asylum.services.StatisticService;
import al.gov.mb.asylum.services.TokenService;
import al.gov.mb.asylum.utils.DateUtil;

@RestController
@RequestMapping("/api/statistic")
public class StatisticAPI {
	
	@Autowired TokenService  tokenService;
	@Autowired StatisticService statisticService;
	
	
	@RequestMapping(value="/registeredSelectionsByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = statisticService.registeredSelectionsByPeriod(fromDate, toDate);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredSelectionsByOrganization", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByOrganization(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = statisticService.registeredSelectionsByOrganization(fromDate, toDate);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredSelectionsByState", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByState(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = statisticService.registeredSelectionsByState(fromDate, toDate);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registeredSelectionsByGender", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> registeredSelectionsByGender(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		List<KeyValue> list = statisticService.registeredSelectionsByGender(fromDate, toDate);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/countAll", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> countAll(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.countAll(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/childCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> childCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.childCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/unaccompainedChildCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> unaccompainedChildCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
        long value = statisticService.unaccompainedChildCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/personsInNeedCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> personsInNeedCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.personsInNeedCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/gonePersonsCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> gonePersonsCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.gonePersonsCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/returnedPersonsCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> returnedPersonsCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.returnedPersonsCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/refugeeCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> refugeeCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.refugeeCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/temporaryProtectionCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> temporaryProtectionCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.temporaryProtectionCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	@RequestMapping(value="/internationalProtectionCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> internationalProtectionCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.internationalProtectionCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	@RequestMapping(value="/extraProtectionCountByPeriod", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> extraProtectionCountByPeriod(@RequestHeader(value="Authorization") String token, @RequestParam("from") String from, @RequestParam("to") String to)
	{
		tokenService.getUsername(token);
		
		Date fromDate = DateUtil.formatStringToDate(from);
		Date toDate = DateUtil.formatStringToDate(to);
		
		long value = statisticService.extraProtectionCountByPeriod(fromDate, toDate);
		
		return new ResponseEntity<>(value,HttpStatus.OK);
		
	}
	
	
	
	

}
