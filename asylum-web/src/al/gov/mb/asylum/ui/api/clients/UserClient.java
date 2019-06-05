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
import al.gov.mb.asylum.ui.forms.PasswordForm;
import al.gov.mb.asylum.ui.models.Principal;
import al.gov.mb.asylum.ui.models.UserToken;
import al.gov.mb.asylum.ui.utils.Util;

public class UserClient {
	
	
	public UserToken login(Principal principal)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/user/login";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Principal>(principal,headers);
		
		ResponseEntity<UserToken> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, UserToken.class);			
		
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public void changePassword(PasswordForm form)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/user/changePassword";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ApiErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<PasswordForm>(form,headers);
		
		restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);			
		
		
		
	}
	
	

}
