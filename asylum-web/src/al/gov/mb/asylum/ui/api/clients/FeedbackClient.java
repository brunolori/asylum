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
import al.gov.mb.asylum.ui.forms.FeedbackSx;
import al.gov.mb.asylum.ui.models.FeedbackDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class FeedbackClient {
	
	public FeedbackDTO registerFeedback(FeedbackDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/feedback/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<FeedbackDTO>(dto,headers);
		
		ResponseEntity<FeedbackDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, FeedbackDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public FeedbackDTO updateFeedback(FeedbackDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/feedback/update";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<FeedbackDTO>(dto,headers);
		
		ResponseEntity<FeedbackDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, FeedbackDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public void deleteFeedback(FeedbackDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/feedback/delete";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<FeedbackDTO>(dto,headers);
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);

	}
	
	public List<FeedbackDTO> searchFeedback(FeedbackSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/feedback/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<FeedbackSx>(req,headers);
		
		ParameterizedTypeReference<List<FeedbackDTO>> typeRef = new ParameterizedTypeReference<List<FeedbackDTO>>() {};
		
		ResponseEntity<List<FeedbackDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	

}
