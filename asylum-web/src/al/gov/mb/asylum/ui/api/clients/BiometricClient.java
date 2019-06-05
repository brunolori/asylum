package al.gov.mb.asylum.ui.api.clients;


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
import al.gov.mb.asylum.ui.models.BiometricDTO;
import al.gov.mb.asylum.ui.utils.Util;




public class BiometricClient {
	
	
	public void registerBiometric(BiometricDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/biometric/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<BiometricDTO>(dto,headers);
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);
		
		
	}
	
	public BiometricDTO findBiometric(Integer eventId)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/biometric//find/photo/"+eventId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
				
		ResponseEntity<BiometricDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, BiometricDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

}
