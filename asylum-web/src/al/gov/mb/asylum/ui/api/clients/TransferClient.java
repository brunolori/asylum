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
import al.gov.mb.asylum.ui.forms.TransferForm;
import al.gov.mb.asylum.ui.forms.TransferSx;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.models.TransferDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class TransferClient {
	
	
	
	public TransferDTO registerCheckOut(TransferDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/checkOut";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferDTO>(dto,headers);
		
		ResponseEntity<TransferDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, TransferDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public TransferDTO registerGoneSelection(SelectionDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/gone";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<SelectionDTO>(dto,headers);
		
		ResponseEntity<TransferDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, TransferDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public void registerCheckOut(TransferForm dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/checkOutList";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferForm>(dto,headers);
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);
		
		
	}
	
	public TransferDTO completeCheckIn(TransferDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/checkIn";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferDTO>(dto,headers);
		
		ResponseEntity<TransferDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, TransferDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<TransferDTO> searchTransfer(TransferSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferSx>(req,headers);
		
		ParameterizedTypeReference<List<TransferDTO>> typeRef = new ParameterizedTypeReference<List<TransferDTO>>() {};
		
		ResponseEntity<List<TransferDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<TransferDTO> searchGone(TransferSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/searchGone";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferSx>(req,headers);
		
		ParameterizedTypeReference<List<TransferDTO>> typeRef = new ParameterizedTypeReference<List<TransferDTO>>() {};
		
		ResponseEntity<List<TransferDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<SelectionDTO> getDrkmSelectionsForTransfer()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/getDrkmSelectionsForTransfer";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferSx>(headers);
		
		ParameterizedTypeReference<List<SelectionDTO>> typeRef = new ParameterizedTypeReference<List<SelectionDTO>>() {};
		
		ResponseEntity<List<SelectionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	public List<TransferDTO> getSelectionTransfers(Integer eventId)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/transfer/getSelectionTransfers?eventId="+eventId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<TransferSx>(headers);
		
		ParameterizedTypeReference<List<TransferDTO>> typeRef = new ParameterizedTypeReference<List<TransferDTO>>() {};
		
		ResponseEntity<List<TransferDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	
	
	

}
