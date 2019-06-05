package al.gov.mb.asylum.ui.api.clients;

import java.util.Date;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import al.gov.mb.asylum.ui.constants.IApiClient;
import al.gov.mb.asylum.ui.forms.EventSx;
import al.gov.mb.asylum.ui.models.KeyValue;
import al.gov.mb.asylum.ui.utils.DateUtil;
import al.gov.mb.asylum.ui.utils.Util;

public class StatisticClient {

	public long countAll(Date fromDate, Date toDate) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/countAll?from="+DateUtil.formatDate(fromDate)+"&to="+DateUtil.formatDate(toDate);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long refugeeCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/refugeeCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long unaccompainedChildCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/unaccompainedChildCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long childCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/childCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long gonePersonsCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/gonePersonsCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long personsInNeedCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/personsInNeedCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public List<KeyValue> registeredSelectionsByGender(Date from, Date to) {


		final String BASE_URL = IApiClient.SERVER+"/api/statistic/registeredSelectionsByGender?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		ParameterizedTypeReference<List<KeyValue>> typeRef = new ParameterizedTypeReference<List<KeyValue>>() {};
		
		ResponseEntity<List<KeyValue>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
		
	}

	public List<KeyValue> registeredSelectionsByState(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/registeredSelectionsByState?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		ParameterizedTypeReference<List<KeyValue>> typeRef = new ParameterizedTypeReference<List<KeyValue>>() {};
		
		ResponseEntity<List<KeyValue>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/registeredSelectionsByOrganization?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		ParameterizedTypeReference<List<KeyValue>> typeRef = new ParameterizedTypeReference<List<KeyValue>>() {};
		
		ResponseEntity<List<KeyValue>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/registeredSelectionsByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		ParameterizedTypeReference<List<KeyValue>> typeRef = new ParameterizedTypeReference<List<KeyValue>>() {};
		
		ResponseEntity<List<KeyValue>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public long extraProtectionCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/extraProtectionCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long internationalProtectionCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/internationalProtectionCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

	public long temporaryProtectionCountByPeriod(Date from, Date to) {
		final String BASE_URL = IApiClient.SERVER+"/api/statistic/temporaryProtectionCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(headers);
		
		
		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return 0;
	}

}
