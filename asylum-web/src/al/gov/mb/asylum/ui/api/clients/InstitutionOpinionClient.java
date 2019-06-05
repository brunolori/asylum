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
import al.gov.mb.asylum.ui.models.InstitutionOpinionDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class InstitutionOpinionClient {
	
	
	public InstitutionOpinionDTO registerInstitutionOpinion(InstitutionOpinionDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/institutionOpinon/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<InstitutionOpinionDTO>(dto,headers);
		
		ResponseEntity<InstitutionOpinionDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, InstitutionOpinionDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	

	
	public List<InstitutionOpinionDTO> getSelectionInstitutionOpinions(Integer eventId)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/institutionOpinon/list/"+eventId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<InstitutionOpinionDTO>> typeRef = new ParameterizedTypeReference<List<InstitutionOpinionDTO>>() {};
		
		ResponseEntity<List<InstitutionOpinionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	
	
}
