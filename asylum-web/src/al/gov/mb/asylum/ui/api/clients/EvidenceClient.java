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

import al.gov.mb.asylum.ui.constants.IApiClient;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.utils.Util;

public class EvidenceClient {

	public List<EvidenceDTO> getEventEvidences(Integer eventId) {
		final String BASE_URL = IApiClient.SERVER+"/api/evidence/list/"+eventId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<EvidenceDTO>> typeRef = new ParameterizedTypeReference<List<EvidenceDTO>>() {};
		
		ResponseEntity<List<EvidenceDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

}
