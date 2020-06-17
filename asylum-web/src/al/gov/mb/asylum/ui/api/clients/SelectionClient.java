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
import al.gov.mb.asylum.ui.forms.SelectionForm;
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class SelectionClient {

	
	public SelectionDTO registerSelection(SelectionForm form)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/selection/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<SelectionForm>(form,headers);
		
		ResponseEntity<SelectionDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, SelectionDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<SelectionDTO> searchSelection(SelectionSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/selection/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<SelectionSx>(req,headers);
		
		ParameterizedTypeReference<List<SelectionDTO>> typeRef = new ParameterizedTypeReference<List<SelectionDTO>>() {};
		
		ResponseEntity<List<SelectionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public SelectionDTO getSelectionByUniqueNo(String uniqueNo)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/selection/find/uniqueNo/"+uniqueNo;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<SelectionDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, SelectionDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public SelectionDTO getSelectionByEventId(Integer eventId) {
		final String BASE_URL = IApiClient.SERVER+"/api/selection/find/eventId/"+eventId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<SelectionDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, SelectionDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public SelectionDTO modifySelection(SelectionDTO selection) {

        final String BASE_URL = IApiClient.SERVER+"/api/selection/update";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<SelectionDTO>(selection,headers);
		
		ResponseEntity<SelectionDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, SelectionDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public List<SelectionDTO> getSelectionsNotGoneFromQkpa() {
		final String BASE_URL = IApiClient.SERVER+"/api/selection/notGoneFromQkpa";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<SelectionDTO>(headers);
		
		ParameterizedTypeReference<List<SelectionDTO>> typeRef = new ParameterizedTypeReference<List<SelectionDTO>>() {};
		
		ResponseEntity<List<SelectionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	
	
}
