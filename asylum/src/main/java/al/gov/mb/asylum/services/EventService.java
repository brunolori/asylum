package al.gov.mb.asylum.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.EventDAO;
import al.gov.mb.asylum.dto.EventDTO;
import al.gov.mb.asylum.dto.EvidenceDTO;
import al.gov.mb.asylum.dto.OfficerDTO;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.Evidence;
import al.gov.mb.asylum.entities.tims.EvidencePK;
import al.gov.mb.asylum.entities.tims.IrregularEvent;
import al.gov.mb.asylum.entities.tims.Officer;
import al.gov.mb.asylum.entities.tims.OfficerPK;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.PlaceType;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.EventForm;
import al.gov.mb.asylum.forms.EventSx;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class EventService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired EventDAO eventDAO;
	
	
	private String generateUniqueNo()
	{
		
		String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		date = "B"+date.substring(1);
		String cnt;
		long count = eventDAO.getTodayCount();
		count++;
		
		if(count < 10)
		{
			cnt = "00"+count;
		}
		else if(count<100)
		{
			cnt = "0"+count;
		}
		else
		{
			cnt = count+"";
		}
		return (date+cnt);
	}
	
	@Transactional
	public IrregularEvent registerEvent(EventForm form, String uname)
	{
		
		form.validate();
		
		User user = crudDAO.findById(User.class, uname);
		Organization org = user.getOrganization();
		
		
		EventDTO dto = form.getEvent();
		PlaceType placeType = crudDAO.findById(PlaceType.class, dto.getPlaceType().getId());
		
		IrregularEvent event = new IrregularEvent();
		event.setDescription(dto.getDescription());
		event.setEventDate(dto.getEventDate());
		event.setOrganization(org);
		event.setPlace(dto.getPlace());
		event.setPlaceType(placeType);
		event.setRecordDate(Calendar.getInstance().getTime());
		event.setRecordUser(uname);
		event.setModifUser(uname);
		event.setUniqurNumber(generateUniqueNo());
		
		event = crudDAO.create(event);
		if(form.getOfficers() != null && !form.getOfficers().isEmpty()) {
			for(OfficerDTO o : form.getOfficers())
			{
				Officer officer = new Officer();
				officer.setGrade(o.getGrade());
				officer.setIdPK(new OfficerPK(o.getOfficerId(), event.getId()));
				officer.setName(o.getName());
				officer.setOrganization(o.getOrganization());
				officer.setRecordDate(Calendar.getInstance().getTime());
				officer.setRecordUser(uname);
				officer.setModifUser(uname);
				officer.setSurname(o.getSurname());
				
				crudDAO.create(officer);
			}
		}
		
		if(form.getEvidences() != null && !form.getEvidences().isEmpty()) {
	     	int i=1;
			for(EvidenceDTO e : form.getEvidences())
			{
				if(!StringUtil.isValid(e.getName()))
				{
					throw new ValidationException("Plotesoni Emrin e Proves nr "+i);
				}
				if(!StringUtil.isValid(e.getDescription()))
				{
					throw new ValidationException("Plotesoni Pershkrimin e Proves nr "+i);
				}
				Evidence evidence = new Evidence();
				evidence.setDescription(e.getDescription());
				evidence.setEvent(event);
				evidence.setIdPK(new EvidencePK(i,event.getId()));
				evidence.setName(e.getName());
				evidence.setRecordDate(Calendar.getInstance().getTime());
				evidence.setRecordUser(uname);
				evidence.setModifUser(uname);
				crudDAO.create(evidence);
				i++;
			}
		}
		
		return event;
		
	}
	
	
	public List<IrregularEvent> searchEvent(EventSx req, String uname)
	{
		User u = crudDAO.findById(User.class, uname);
		if(u.getRole().equals(IRole.DRKM))
		{
			req.setOrganizationId(u.getOrganization().getId());
		}
		
		return eventDAO.searchEvent(req);
	}
	
	public IrregularEvent findByUniqueNo(String uniqueNo, String uname)
	{
		EventSx req = new EventSx();
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
		
		List<IrregularEvent> list = eventDAO.searchEvent(req);
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}

	public IrregularEvent updateEvent(EventForm form, String uname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
