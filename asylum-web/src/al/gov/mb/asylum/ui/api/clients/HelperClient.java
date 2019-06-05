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
import al.gov.mb.asylum.ui.models.AsylantStageDTO;
import al.gov.mb.asylum.ui.models.AsylantStatusDTO;
import al.gov.mb.asylum.ui.models.AsylumDecisionTypeDTO;
import al.gov.mb.asylum.ui.models.DecisionReasonDTO;
import al.gov.mb.asylum.ui.models.DecisionStatusDTO;
import al.gov.mb.asylum.ui.models.DecisionTypeDTO;
import al.gov.mb.asylum.ui.models.DocTypeDTO;
import al.gov.mb.asylum.ui.models.FamilyUnionStatusDTO;
import al.gov.mb.asylum.ui.models.HandedOverDTO;
import al.gov.mb.asylum.ui.models.HearingStatusDTO;
import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.InterviewStatusDTO;
import al.gov.mb.asylum.ui.models.IrStatusDTO;
import al.gov.mb.asylum.ui.models.OrganizationDTO;
import al.gov.mb.asylum.ui.models.PlaceTypeDTO;
import al.gov.mb.asylum.ui.models.QuestionDTO;
import al.gov.mb.asylum.ui.models.StateDTO;
import al.gov.mb.asylum.ui.models.TimsDocumentDTO;
import al.gov.mb.asylum.ui.models.TransferStatusDTO;



public class HelperClient {
	
	
	public List<DecisionReasonDTO> listDecisionReason(String typeOrder)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/decisionReason/"+typeOrder;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<DecisionReasonDTO>> typeRef = new ParameterizedTypeReference<List<DecisionReasonDTO>>() {};
		
		ResponseEntity<List<DecisionReasonDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<DecisionStatusDTO> listDecisionStatus()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/decisionStatus";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<DecisionStatusDTO>> typeRef = new ParameterizedTypeReference<List<DecisionStatusDTO>>() {};
		
		ResponseEntity<List<DecisionStatusDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<StateDTO> listStates(String name)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/state/"+name;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<StateDTO>> typeRef = new ParameterizedTypeReference<List<StateDTO>>() {};
		
		ResponseEntity<List<StateDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<DecisionTypeDTO> listDecisionType()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/decisionType";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<DecisionTypeDTO>> typeRef = new ParameterizedTypeReference<List<DecisionTypeDTO>>() {};
		
		ResponseEntity<List<DecisionTypeDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<HandedOverDTO> listHandedOver()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/handedOver";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<HandedOverDTO>> typeRef = new ParameterizedTypeReference<List<HandedOverDTO>>() {};
		
		ResponseEntity<List<HandedOverDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<IrStatusDTO> listIrStatus()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/irStatus";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<IrStatusDTO>> typeRef = new ParameterizedTypeReference<List<IrStatusDTO>>() {};
		
		ResponseEntity<List<IrStatusDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<OrganizationDTO> listOrganization()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/organization";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<OrganizationDTO>> typeRef = new ParameterizedTypeReference<List<OrganizationDTO>>() {};
		
		ResponseEntity<List<OrganizationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<PlaceTypeDTO> listPlaceType()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/placeType";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<PlaceTypeDTO>> typeRef = new ParameterizedTypeReference<List<PlaceTypeDTO>>() {};
		
		ResponseEntity<List<PlaceTypeDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<AsylantStageDTO> listAsylantStage()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/asylantStage";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AsylantStageDTO>> typeRef = new ParameterizedTypeReference<List<AsylantStageDTO>>() {};
		
		ResponseEntity<List<AsylantStageDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<AsylantStatusDTO> listAsylantStatus()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/asylantStatus";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AsylantStatusDTO>> typeRef = new ParameterizedTypeReference<List<AsylantStatusDTO>>() {};
		
		ResponseEntity<List<AsylantStatusDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<AsylumDecisionTypeDTO> listAsylumDecisionType()
	{
		return null;
	}
	
	public List<FamilyUnionStatusDTO> listFamilyUnionStatus()
	{
		return null;
	}
	
	public List<HearingStatusDTO> listHearingStatus()
	{
		return null;
	}
	
	
	public List<InterviewDTO> listInterviewStatus()
	{
		return null;
	}
	
	public List<TransferStatusDTO> listTransferStatus()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/transferStatus";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<TransferStatusDTO>> typeRef = new ParameterizedTypeReference<List<TransferStatusDTO>>() {};
		
		ResponseEntity<List<TransferStatusDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public List<QuestionDTO> listQuestion()
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/question";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<QuestionDTO>> typeRef = new ParameterizedTypeReference<List<QuestionDTO>>() {};
		
		ResponseEntity<List<QuestionDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	
	
	
	
	public DecisionReasonDTO findDecisionReason(String codeOrder, String typeOrder)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/decisionReason/"+codeOrder+"/"+typeOrder;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<DecisionReasonDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, DecisionReasonDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public DecisionStatusDTO findDecisionStatus(String id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/decisionStatus/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<DecisionStatusDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, DecisionStatusDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public DecisionTypeDTO findDecisionType(String id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/decisionType/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<DecisionTypeDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, DecisionTypeDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public HandedOverDTO findHandedOver(String id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/handedOver/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<HandedOverDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, HandedOverDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public IrStatusDTO findIrStatus(String id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/irStatus/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<IrStatusDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, IrStatusDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public OrganizationDTO findOrganization(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/organization/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<OrganizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, OrganizationDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public PlaceTypeDTO findPlaceType(String id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/placeType/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<PlaceTypeDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, PlaceTypeDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public AsylantStageDTO findAsylantStage(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/asylantStage/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<AsylantStageDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, AsylantStageDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public AsylantStatusDTO findAsylantStatus(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/asylantStatus/"+id;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<AsylantStatusDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, AsylantStatusDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	public AsylumDecisionTypeDTO findAsylumDecisionType(Integer id)
	{
		return null;
	}
	
	public FamilyUnionStatusDTO findFamilyUnionStatus(Integer id)
	{
		return null;
	}
	
	public HearingStatusDTO findHearingStatus(Integer id)
	{
		return null;
	}
	
	public InterviewStatusDTO findInterviewStatus(Integer id)
	{
		return null;
	}
	
	public TransferStatusDTO  findTransferStatus(Integer id)
	{
		return null;
	}
	
	public QuestionDTO findQuestion(Integer id)
	{
		return null;
	}

	public TimsDocumentDTO findTimsDocument(String docNo, String typeCode, String stateCode) {
		
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/timsDocument/"+docNo+"/"+typeCode+"/"+stateCode;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<TimsDocumentDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, TimsDocumentDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public List<DocTypeDTO> listDocType() {
		final String BASE_URL = IApiClient.SERVER+"/api/helper/list/docType";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<DocTypeDTO>> typeRef = new ParameterizedTypeReference<List<DocTypeDTO>>() {};
		
		ResponseEntity<List<DocTypeDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}

	public StateDTO findStateByCode(String value) {
		final String BASE_URL = IApiClient.SERVER+"/api/helper/find/state/"+value;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);	
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<StateDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, StateDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}
				
		return null;
	}
	
	
	
	
	

}
