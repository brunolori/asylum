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
import al.gov.mb.asylum.ui.forms.HearingSx;
import al.gov.mb.asylum.ui.models.HearingDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class HearingClient {
	
	public HearingDTO selectForHearing(HearingDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/hearing/select";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<HearingDTO>(dto,headers);
		
		ResponseEntity<HearingDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, HearingDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public HearingDTO registerHearing(HearingDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/hearing/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<HearingDTO>(dto,headers);
		
		ResponseEntity<HearingDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, HearingDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<HearingDTO> searchHearing(HearingSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/hearing/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<HearingSx>(req,headers);
		
		ParameterizedTypeReference<List<HearingDTO>> typeRef = new ParameterizedTypeReference<List<HearingDTO>>() {};
		
		ResponseEntity<List<HearingDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	

}
