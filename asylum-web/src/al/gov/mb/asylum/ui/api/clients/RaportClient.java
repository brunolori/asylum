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

public class RaportClient {
	
	
	
	public long countAll(Date fromDate, Date toDate, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/countAll?from="+DateUtil.formatDate(fromDate)+"&to="+DateUtil.formatDate(toDate);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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

	public long childCountByPeriod(Date from, Date to, Integer organizationId) {
		
		String BASE_URL = IApiClient.SERVER+"/api/raport/childCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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

	public long gonePersonsCountByPeriod(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/gonePersonsCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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
	
	public long returnedPersonsCountByPeriod(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/returnedPersonsCountByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/registeredSelectionsByGender?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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

	public List<KeyValue> registeredSelectionsByState(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/registeredSelectionsByState?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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
		final String BASE_URL = IApiClient.SERVER+"/api/raport/registeredSelectionsByOrganization?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
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

	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/registeredSelectionsByPeriod?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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

	public long countAllAsylants(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/countAllAsylants?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
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

	public long countAllTrafficVictims(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/countAllTrafficVictims?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
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
	
	public long countAllIrregularImigrants(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/countAllIrregularImigrants?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
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
	
	public List<KeyValue> registeredSelectionsByPlaceType(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/registeredSelectionsByPlaceType?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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
	
	public List<KeyValue> registeredDecisionsByType(Date from, Date to, Integer organizationId) {
		String BASE_URL = IApiClient.SERVER+"/api/raport/registeredDecisionsByType?from="+DateUtil.formatDate(from)+"&to="+DateUtil.formatDate(to);
		if(organizationId != null)
		{
			BASE_URL += "&organizationId="+organizationId;
		}
		
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
	
	
}
