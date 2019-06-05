package al.gov.mb.asylum.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import al.gov.mb.asylum.assemblers.Assembler;
import al.gov.mb.asylum.entities.AsylantStage;
import al.gov.mb.asylum.entities.AsylantStatus;
import al.gov.mb.asylum.entities.AsylumDecisionType;
import al.gov.mb.asylum.entities.FamilyUnionStatus;
import al.gov.mb.asylum.entities.HearingStatus;
import al.gov.mb.asylum.entities.InterviewStatus;
import al.gov.mb.asylum.entities.Question;
import al.gov.mb.asylum.entities.TransferStatus;
import al.gov.mb.asylum.entities.tims.DecisionReason;
import al.gov.mb.asylum.entities.tims.DecisionStatus;
import al.gov.mb.asylum.entities.tims.DecisionType;
import al.gov.mb.asylum.entities.tims.DocType;
import al.gov.mb.asylum.entities.tims.HandedOver;
import al.gov.mb.asylum.entities.tims.IrStatus;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.PlaceType;
import al.gov.mb.asylum.entities.tims.State;
import al.gov.mb.asylum.services.HelperService;


@RestController
@RequestMapping("/api/helper")
public class HelperAPI {

	@Autowired HelperService helperService;
	
	@RequestMapping(value="/list/decisionReason/{typeOrder}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listDecisionReason(@PathVariable String typeOrder)
	{
		
		List<DecisionReason> list = helperService.listDecisionReason(typeOrder);
				
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().decisionReasonListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/decisionStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listDecisionStatus()
	{
		
		List<DecisionStatus> list = helperService.listDecisionStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().decisionStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/state/{name}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listStates(@PathVariable String name)
	{
		
		List<State> list = helperService.listState(name);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().stateListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/decisionType", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listDecisionType()
	{
		
		List<DecisionType> list = helperService.listDecisionType();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().decisionTypeListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/handedOver", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listHandedOver()
	{
		
		List<HandedOver> list = helperService.listHandedOver();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().handedOverListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/irStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listIrStatus()
	{
		
		List<IrStatus> list = helperService.listIrStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().irStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/organization", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listOrganization()
	{
		
		List<Organization> list = helperService.listOrganization();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().organizationListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/placeType", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listPlaceType()
	{
		
		List<PlaceType> list = helperService.listPlaceType();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().placeTypeListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/asylantStage", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listAsylantStage()
	{
		
		List<AsylantStage> list = helperService.listAsylantStage();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().asylantStageListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/asylantStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listAsylantStatus()
	{
		
		List<AsylantStatus> list = helperService.listAsylantStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().asylantStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/asylumDecisionType", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listAsylumDecisionType()
	{
		
		List<AsylumDecisionType> list = helperService.listAsylumDecisionType();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().asylumDecisionTypeListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/familyUnionStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listFamilyUnionStatus()
	{
		
		List<FamilyUnionStatus> list = helperService.listFamilyUnionStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().familyUnionStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/hearingStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listHearingStatus()
	{
		
		List<HearingStatus> list = helperService.listHearingStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().hearingStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/interviewStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listInterviewStatus()
	{
		
		List<InterviewStatus> list = helperService.listInterviewStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().interviewStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/transferStatus", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listTransferStatus()
	{
		
		List<TransferStatus> list = helperService.listTransferStatus();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().transferStatusListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/question", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listQuestion()
	{
		
		List<Question> list = helperService.listQuestion();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().questiontListToDto(list),HttpStatus.OK);
	}
	
	@RequestMapping(value="/list/docType", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> listDocTypes()
	{
		
		List<DocType> list = helperService.listDocType();
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
				
		return new ResponseEntity<>(new Assembler().docTypeListToDto(list),HttpStatus.OK);
	}
	
	
	
	//*********   FIND BY ID   ********************
	
	
	
	@RequestMapping(value="/find/timsDocument/{docNo}/{docTypeCode}/{docStateCode}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findTimsDocument(@PathVariable String docNo, @PathVariable String docTypeCode, @PathVariable String docStateCode)
	{							
		return new ResponseEntity<>(new Assembler().toDto(helperService.findTravelDocumentById(docStateCode,docTypeCode,docNo)),HttpStatus.OK);
	}
	@RequestMapping(value="/find/decisionReason/{codeOrder}/{typeOrder}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findDecisionReason(@PathVariable String codeOrder, @PathVariable String typeOrder)
	{							
		return new ResponseEntity<>(new Assembler().toDto(helperService.findDecisionReasonById(codeOrder, typeOrder)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/decisionStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findDecisionStatus(@PathVariable String id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(DecisionStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/decisionType/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findDecisionType(@PathVariable String id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(DecisionType.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/handedOver/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findHandedOver(@PathVariable String id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(HandedOver.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/irStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findIrStatus(@PathVariable String id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(IrStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/organization/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findOrganization(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(Organization.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/placeType/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findPlaceType(@PathVariable String id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(PlaceType.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/asylantStage/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findAsylantStage(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(AsylantStage.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/asylantStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findAsylantStatus(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(AsylantStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/asylumDecisionType/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findAsylumDecisionType(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(AsylumDecisionType.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/familyUnionStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findFamilyUnionStatus(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(FamilyUnionStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/hearingStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findHearingStatus(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(HearingStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/interviewStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findInterviewStatus(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(InterviewStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/transferStatus/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findTransferStatus(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(TransferStatus.class, id)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/find/question/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findQuestion(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(Question.class, id)),HttpStatus.OK);
	}
	@RequestMapping(value="/find/docType/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findDocType(@PathVariable String id)
	{
		return new ResponseEntity<>(new Assembler().toDto(helperService.findById(DocType.class, id)),HttpStatus.OK);
	}
	
	
	
}
