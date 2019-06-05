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
import al.gov.mb.asylum.ui.forms.InterviewForm;
import al.gov.mb.asylum.ui.forms.InterviewSx;
import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.InterviewQuestionDTO;
import al.gov.mb.asylum.ui.utils.Util;



public class InterviewClient {

	
	public InterviewDTO selectForInterview(InterviewDTO dto)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/interview/select";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<InterviewDTO>(dto,headers);
		
		ResponseEntity<InterviewDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, InterviewDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public InterviewDTO registerInterview(InterviewForm form)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/interview/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<InterviewForm>(form,headers);
		
		ResponseEntity<InterviewDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, InterviewDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<InterviewDTO> searchInterview(InterviewSx req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/interview/search";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<InterviewSx>(req,headers);
		
		ParameterizedTypeReference<List<InterviewDTO>> typeRef = new ParameterizedTypeReference<List<InterviewDTO>>() {};
		
		ResponseEntity<List<InterviewDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<InterviewQuestionDTO> getInterviewQuestions(Integer interviewId)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/interview/questions/"+interviewId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<InterviewSx>(headers);
		
		ParameterizedTypeReference<List<InterviewQuestionDTO>> typeRef = new ParameterizedTypeReference<List<InterviewQuestionDTO>>() {};
		
		ResponseEntity<List<InterviewQuestionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	
	
	
}
