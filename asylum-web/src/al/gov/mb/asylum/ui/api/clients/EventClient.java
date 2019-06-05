package al.gov.mb.asylum.ui.api.clients;

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

import al.gov.mb.asylum.ui.api.security.ApiErrorHandler;
import al.gov.mb.asylum.ui.constants.IApiClient;
import al.gov.mb.asylum.ui.forms.EventForm;
import al.gov.mb.asylum.ui.forms.EventSx;
import al.gov.mb.asylum.ui.models.EventDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class EventClient {

	public EventDTO registerEvent(EventForm form)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/event/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventForm>(form,headers);
		
		ResponseEntity<EventDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, EventDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public EventDTO updateEvent(EventForm form)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/event/update";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventForm>(form,headers);
		
		ResponseEntity<EventDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, EventDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public EventDTO getEventByUniqueNo(String uniqueNo)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/event/find/uniqueNo/"+uniqueNo;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<EventDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, EventDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<EventDTO> searchEvent(EventSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/event/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<EventSx>(req,headers);
		
		ParameterizedTypeReference<List<EventDTO>> typeRef = new ParameterizedTypeReference<List<EventDTO>>() {};
		
		ResponseEntity<List<EventDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
}
