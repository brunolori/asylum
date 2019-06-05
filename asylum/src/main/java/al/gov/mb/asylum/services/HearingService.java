package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IHearingStatus;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.HearingDAO;
import al.gov.mb.asylum.dto.HearingDTO;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.Hearing;
import al.gov.mb.asylum.entities.HearingStatus;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.HearingSx;
import al.gov.mb.asylum.utils.StringUtil;


@Service
public class HearingService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired HearingDAO hearingDAO;
	
	
	@Transactional
	public Hearing selectForHearing(HearingDTO hearing, String uname)
	{
		
		SelectionDTO dto = hearing.getSelection();
		if(dto == null)
		{
			throw new ValidationException("I Perzgjedhuri i papercaktuar");
		}
		if(hearing.getPredictedHearingDate() == null)
		{
			throw new ValidationException("Zgjidhni daten e degjimit");
		}
		
		Selection selection = crudDAO.findById(Selection.class, dto.getEvent().getId());
		AsylantDetails details = selection.getAsylantDetails();
		if(details.getLastHearingStatus() != null && details.getLastHearingStatus().getId() == IHearingStatus.SELECTED)
		{
			throw new ValidationException("I Perzgjedhuri eshte ne pritje per Degjese");
		}
		
		HearingStatus status = crudDAO.findById(HearingStatus.class, IHearingStatus.SELECTED);
		Hearing i = new Hearing();
		i.setHearingStatus(status);
		i.setSelection(selection);
		i.setSelectionTime(Calendar.getInstance().getTime());
		i.setSelectionUser(uname);
		i.setStatus(IStatus.ACTIVE);
		i.setSelectionNotes(hearing.getSelectionNotes());
		i.setPredictedHearingDate(hearing.getPredictedHearingDate());
		i = crudDAO.create(i);
		
		
		details.setLastHearingStatus(status);
		crudDAO.update(details);
		
		return i;
		
	}
	
	@Transactional
	public Hearing registerHearing(HearingDTO dto, String uname)
	{
		
		
		if(!StringUtil.isValid(dto.getLanguage()))
		{
			throw new ValidationException("Plotesoni Gjuhen e Intervistimit");
		}
		if(!StringUtil.isValid(dto.getTranslator()))
		{
			throw new ValidationException("Plotesoni Perkthyesin");
		}
		if(!StringUtil.isValid(dto.getNotes()))
		{
			throw new ValidationException("Plotesoni Shenimet e Degjeses");
		}
		
		
		Hearing i = crudDAO.findById(Hearing.class, dto.getId());
		AsylantDetails details = i.getSelection().getAsylantDetails();
		HearingStatus status = crudDAO.findById(HearingStatus.class, IHearingStatus.COMPLETED);
		
		i.setListener(uname);
		i.setHearingStatus(status);
		i.setHearingTime(Calendar.getInstance().getTime());
		i.setHearingUser(uname);
		i.setLanguage(dto.getLanguage());
		i.setNotes(dto.getNotes());
		i.setTranslator(dto.getTranslator());
		
		i = crudDAO.update(i);
		
		int cnt = details.getHearingCnt()==null?0:details.getHearingCnt();
		cnt++;
		details.setHearingCnt(cnt);
		details.setLastHearingStatus(status);
				
		
		return i;
	}	
	
		
	public List<Hearing> searchHearing(HearingSx req, String uname)
	{
		return hearingDAO.searchHearing(req);
	}
	
	
	
	

}
