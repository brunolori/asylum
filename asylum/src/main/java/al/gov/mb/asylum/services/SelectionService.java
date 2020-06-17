package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IIrStatus;
import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.SelectionDAO;
import al.gov.mb.asylum.dto.OtherDocumentDTO;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.AsylantStage;
import al.gov.mb.asylum.entities.AsylantStatus;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.Document;
import al.gov.mb.asylum.entities.tims.DocumentPK;
import al.gov.mb.asylum.entities.tims.HandedOver;
import al.gov.mb.asylum.entities.tims.IrStatus;
import al.gov.mb.asylum.entities.tims.IrregularEvent;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.OtherDocument;
import al.gov.mb.asylum.entities.tims.OtherDocumentPK;
import al.gov.mb.asylum.entities.tims.Person;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.SelectionForm;
import al.gov.mb.asylum.forms.SelectionSx;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class SelectionService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired SelectionDAO selectionDAO;
	
	
	@Transactional
	public Selection registerSelection(SelectionForm form, String uname)
	{
		
		form.validate();
		
		
		SelectionDTO dto = form.getSelection();
		User user = crudDAO.findById(User.class, uname);
		Organization org = user.getOrganization();
		IrregularEvent event = crudDAO.findById(IrregularEvent.class, dto.getEvent().getId());
		
		Selection selection = new Selection();
		
		if(dto.getIrStatus().getId().equals(IIrStatus.AZILANT))
		{
			AsylantDetails details = new AsylantDetails();
			details.setAcceleratedProcess(dto.getAsylantDetails().getAcceleratedProcess());
			if(dto.getAsylantDetails().getAsylantStage() != null) {
				   details.setAsylantStage(crudDAO.findById(AsylantStage.class, dto.getAsylantDetails().getAsylantStage().getId()));
				}else
				{
					details.setAsylantStage(null);
				}
				if(dto.getAsylantDetails().getAsylantStatus() != null)
				{
				   details.setAsylantStatus(crudDAO.findById(AsylantStatus.class, dto.getAsylantDetails().getAsylantStatus().getId()));
				}else 
				{
					details.setAsylantStatus(null);
				}
			details.setCurrentLocation(org);
			details.setEventId(event.getId());
			details.setHearingCnt(0);
			details.setIncomes(dto.getAsylantDetails().getIncomes());
			details.setInNeed(dto.getAsylantDetails().getInNeed());
			details.setInterviewCnt(0);
			details.setUnaccompainedChild(dto.getAsylantDetails().getUnaccompainedChild());
			details.setNeeds(dto.getAsylantDetails().getNeeds());
			details.setWithIncomes(dto.getAsylantDetails().getWithIncomes());
			
			details = crudDAO.create(details);
			selection.setAsylantDetails(details);
		}
		
		Person person = new Person();
		person.setCodeCityBirth(dto.getPerson().getCodeCityBirth());
		person.setCodeCivilStatus(dto.getPerson().getCodeCivilStatus());
		person.setCodeNationality(dto.getPerson().getCodeNationality());
		person.setCodeOS(dto.getPerson().getCodeOS());
		person.setCodeStateBirth(dto.getPerson().getCodeStateBirth());
		person.setDob(dto.getPerson().getDob());
		person.setFatherName(dto.getPerson().getFatherName());
		person.setGender(dto.getPerson().getGender());
		person.setMidleName(dto.getPerson().getMidleName());
		person.setMotherName(dto.getPerson().getMotherName());
		person.setName(dto.getPerson().getName());
		person.setName1(dto.getPerson().getName1());
		person.setNid(dto.getPerson().getNid());
		person.setPersonTimsId(dto.getPerson().getPersonTimsId());
		person.setProfesion(dto.getPerson().getProfesion());
		person.setRecordDate(Calendar.getInstance().getTime());
		person.setRecordUser(uname);
		person.setReligion(dto.getPerson().getReligion());
		person.setSurname(dto.getPerson().getSurname());
		person.setSurname1(dto.getPerson().getSurname1());
		
		person = crudDAO.create(person);
		
		selection.setAlbAddress(dto.getAlbAddress());
		selection.setEntryMode(dto.getEntryMode());
		
		selection.setEntryPlace(dto.getEntryPlace());
		selection.setEvent(event);
		selection.setFleeingReason(dto.getFleeingReason());
		if(dto.getHanded() != null) {
			selection.setHanded(crudDAO.findById(HandedOver.class, dto.getHanded().getId()));
		}
		selection.setInterviewer(dto.getInterviewer());
		selection.setIrStatus(crudDAO.findById(IrStatus.class, dto.getIrStatus().getId()));
		selection.setItinerary(dto.getItinerary());
		selection.setNotes(dto.getNotes());
		selection.setPerson(person);
		selection.setReason(dto.getReason());
		selection.setRecordDate(Calendar.getInstance().getTime());
		selection.setRecordUser(uname);
		selection.setSelectionDate(dto.getSelectionDate());
		selection.setTransLang(dto.getTransLang());
		selection.setTranslator(dto.getTranslator());
		selection.setInterviewer(uname);

		selection = crudDAO.create(selection);
		
		if(form.isFilledDoc())
		{
			
			Document d = new Document();
			d.setDateOfExpiration(form.getDocument().getDateOfExpiration());
			d.setDateOfExtension(form.getDocument().getDateOfExtension());
			d.setDateOfIssue(form.getDocument().getDateOfIssue());
			d.setIdPK(new DocumentPK(form.getDocument().getCodeState(), form.getDocument().getCodeTypeTravelDoc(),
					form.getDocument().getTravelDocNo(), event.getId()));
			d.setPersonId(person.getId());
			d.setRecordDate(Calendar.getInstance().getTime());
			d.setRecordUser(uname);
			crudDAO.create(d);
				
		}
		
		if(form.getOtherDocuments() != null && !form.getOtherDocuments().isEmpty())
		{
			int i = 1;
			for(OtherDocumentDTO d : form.getOtherDocuments())
			{
				if(!StringUtil.isValid(d.getDocType()))
				{
					throw new ValidationException("Plotesoni Tipin e Dokumentit per 'Dokumentin Tjeter' nr "+1);
				}
				if(!StringUtil.isValid(d.getDocumentNo()))
				{
					throw new ValidationException("Plotesoni Numrin e Dokumentit per 'Dokumentin Tjeter' nr "+1);
				}
				if(!StringUtil.isValid(d.getState()))
				{
					throw new ValidationException("Plotesoni Shtetin e Dokumentit per 'Dokumentin Tjeter' nr "+1);
				}
				
				OtherDocument od = new OtherDocument();
				od.setDocType(d.getDocType());
				od.setDocumentNo(d.getDocumentNo());
				od.setIdPK(new OtherDocumentPK(i,event.getId()));
				od.setRecordDate(Calendar.getInstance().getTime());
				od.setRecordUser(uname);
				od.setState(d.getState());
				crudDAO.create(od);
				
				i++;
			}
		}
		
		return selection;
		
	}
	
	@Transactional
	public Selection modifySelection(SelectionDTO dto, String uname)
	{
		
		if(dto.getEvent() == null)
		{
			throw new ValidationException("Zgjidhni konstatimin");
		}
	
		
		if(!StringUtil.isValid(dto.getPerson().getName()))
		{
			throw new ValidationException("Plotesoni Emrin");
		}
		if(!StringUtil.isValid(dto.getPerson().getSurname()))
		{
			throw new ValidationException("Plotesoni Mbiemrin");
		}
		if(!StringUtil.isValid(dto.getPerson().getCodeNationality()))
		{
			throw new ValidationException("Plotesoni Nacionalitetin");
		}
		if(dto.getPerson().getDob() == null)
		{
			throw new ValidationException("Plotesoni Datelindjen");
		}
		
		if(dto.getIrStatus() == null)
		{
			throw new ValidationException("Zgjidhni statusin e te parregulltit");
		}
				
		
		if(!StringUtil.isValid(dto.getEntryPlace()))
		{
			throw new ValidationException("Plotesoni Vendin e Hyrjes");
		}
		if(!StringUtil.isValid(dto.getEntryMode()))
		{
			throw new ValidationException("Plotesoni Menyren e Kalimit Kufitar");
		}
		if(!StringUtil.isValid(dto.getItinerary()))
		{
			throw new ValidationException("Plotesoni Itinerarin");
		}
		if(!StringUtil.isValid(dto.getFleeingReason()))
		{
			throw new ValidationException("Plotesoni Arsyen e Largimit");
		}
		
		if(!StringUtil.isValid(dto.getTranslator()))
		{
			throw new ValidationException("Plotesoni Perkthyesin");
		}
		if(!StringUtil.isValid(dto.getTransLang()))
		{
			throw new ValidationException("Plotesoni Gjuhen e Intervistimit");
		}
		if(dto.getSelectionDate() == null)
		{
			throw new ValidationException("Plotesoni Daten e perpilimit");
		}
		
		Selection selection = crudDAO.findById(Selection.class, dto.getEvent().getId());
		
		if(dto.getIrStatus().getId().equals(IIrStatus.AZILANT))
		{
			AsylantDetails details = selection.getAsylantDetails();
			details.setAcceleratedProcess(dto.getAsylantDetails().getAcceleratedProcess());
			if(dto.getAsylantDetails().getAsylantStage() != null) {
			   details.setAsylantStage(crudDAO.findById(AsylantStage.class, dto.getAsylantDetails().getAsylantStage().getId()));
			}else
			{
				details.setAsylantStage(null);
			}
			if(dto.getAsylantDetails().getAsylantStatus() != null)
			{
			   details.setAsylantStatus(crudDAO.findById(AsylantStatus.class, dto.getAsylantDetails().getAsylantStatus().getId()));
			}else 
			{
				details.setAsylantStatus(null);
			}
			if(dto.getAsylantDetails().getCurrentLocation() != null) {
		    	details.setCurrentLocation(crudDAO.findById(Organization.class, dto.getAsylantDetails().getCurrentLocation().getId()));
			}
			else {
				details.setCurrentLocation(null);
			}
			
			details.setHearingCnt(dto.getAsylantDetails().getHearingCnt());
			details.setIncomes(dto.getAsylantDetails().getIncomes());
			details.setInNeed(dto.getAsylantDetails().getInNeed());
			details.setInterviewCnt(dto.getAsylantDetails().getInterviewCnt());
			details.setUnaccompainedChild(dto.getAsylantDetails().getUnaccompainedChild());
			details.setNeeds(dto.getAsylantDetails().getNeeds());
			details.setWithIncomes(dto.getAsylantDetails().getWithIncomes());
			
			details = crudDAO.update(details);
			selection.setAsylantDetails(details);
		}
		
		Person person = selection.getPerson();
		person.setCodeCityBirth(dto.getPerson().getCodeCityBirth());
		person.setCodeCivilStatus(dto.getPerson().getCodeCivilStatus());
		person.setCodeNationality(dto.getPerson().getCodeNationality());
		person.setCodeOS(dto.getPerson().getCodeOS());
		person.setCodeStateBirth(dto.getPerson().getCodeStateBirth());
		person.setDob(dto.getPerson().getDob());
		person.setFatherName(dto.getPerson().getFatherName());
		person.setGender(dto.getPerson().getGender());
		person.setMidleName(dto.getPerson().getMidleName());
		person.setMotherName(dto.getPerson().getMotherName());
		person.setName(dto.getPerson().getName());
		person.setName1(dto.getPerson().getName1());
		person.setNid(dto.getPerson().getNid());
		person.setPersonTimsId(dto.getPerson().getPersonTimsId());
		person.setProfesion(dto.getPerson().getProfesion());
		person.setReligion(dto.getPerson().getReligion());
		person.setSurname(dto.getPerson().getSurname());
		person.setSurname1(dto.getPerson().getSurname1());
		
		person = crudDAO.update(person);
		
		selection.setAlbAddress(dto.getAlbAddress());
		selection.setEntryMode(dto.getEntryMode());
		
		selection.setEntryPlace(dto.getEntryPlace());
		selection.setFleeingReason(dto.getFleeingReason());
		if(dto.getHanded() != null) {
			selection.setHanded(crudDAO.findById(HandedOver.class, dto.getHanded().getId()));
		}
		selection.setInterviewer(dto.getInterviewer());
		selection.setIrStatus(crudDAO.findById(IrStatus.class, dto.getIrStatus().getId()));
		selection.setItinerary(dto.getItinerary());
		selection.setNotes(dto.getNotes());
		selection.setPerson(person);
		selection.setReason(dto.getReason());
		selection.setSelectionDate(dto.getSelectionDate());
		selection.setTransLang(dto.getTransLang());
		selection.setTranslator(dto.getTranslator());
		selection.setModifUser(uname);
		selection = crudDAO.update(selection);
		
		
		
		return selection;
		
	}
	
	
	
	public List<Selection> searchSelection(SelectionSx req, String uname)
	{
		User u = crudDAO.findById(User.class, uname);
		if(u.getRole().equals(IRole.DRKM))
		{
			if(u.getOrganization().getCentral() != IOrganization.CENTRAL)
			{
				req.setOrganizationId(u.getOrganization().getId());
			}
		}
		selectionDAO.addMissingDetails();
		return selectionDAO.searchSelection(req);
	}
	
	public Selection findByUniqueNo(String uniqueNo, String uname)
	{
		SelectionSx req = new SelectionSx();
		req.setUniqueNo(uniqueNo);
		req.setMaxResult(1);
		User u = crudDAO.findById(User.class, uname);
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				req.setOrganizationId(u.getOrganization().getId());
			}
		}
		
		List<Selection> list = selectionDAO.searchSelection(req);
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}

	public Selection findByEventId(Integer eventId, String uname) {

			return crudDAO.findById(Selection.class, eventId);
	}

	public List<Selection> notGoneFromQkpa(String uname) {
		
		selectionDAO.addMissingDetails();
		
		return selectionDAO.notGoneFromQkpa();
	}
	

}
