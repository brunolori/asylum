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
import al.gov.mb.asylum.ui.forms.AsylumDecisionSx;
import al.gov.mb.asylum.ui.models.AsylumDecisionDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class AsylumDecisionClient {

	
	
	public AsylumDecisionDTO registerDecision(AsylumDecisionDTO dto) {


		final String BASE_URL = IApiClient.SERVER+"/api/asylumDecision/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<AsylumDecisionDTO>(dto,headers);
		
		ResponseEntity<AsylumDecisionDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, AsylumDecisionDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;

	}

	public List<AsylumDecisionDTO> search(AsylumDecisionSx req) {
		
		final String BASE_URL = IApiClient.SERVER+"/api/asylumDecision/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<AsylumDecisionSx>(req,headers);
		
		ParameterizedTypeReference<List<AsylumDecisionDTO>> typeRef = new ParameterizedTypeReference<List<AsylumDecisionDTO>>() {};
		
		ResponseEntity<List<AsylumDecisionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

}
