package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.AppealDAO;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dto.AppealDTO;
import al.gov.mb.asylum.entities.Appeal;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class AppealService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired AppealDAO appealDAO;
	
	@Transactional
	public Appeal registerAppeal(AppealDTO dto, String uname)
	{
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I Perzgjedhuri i papercaktuar");
		}
		if(!StringUtil.isValid(dto.getDecisionNo()))
		{
			throw new ValidationException("Plotesoni Numrin e ankimimit");
		}		
		if(dto.getDecisionDate() == null)
		{
			throw new ValidationException("Plotesoni daten e ankimimit");
		}
		if(!StringUtil.isValid(dto.getNotes()))
		{
			throw new ValidationException("Plotesoni Shenimet e ankimimit");
		}
		
		Appeal a = new Appeal();
		a.setAppealUser(uname);
		a.setAppealTime(Calendar.getInstance().getTime());
		a.setDecisionDate(dto.getDecisionDate());
		a.setDecisionNo(dto.getDecisionNo());
		a.setNotes(dto.getNotes());
		a.setStatus(IStatus.ACTIVE);
		a.setSelection(crudDAO.findById(Selection.class, dto.getSelection().getEvent().getId()));
		
		
		return crudDAO.create(a);
		
	}
	
	
	public List<Appeal> getSelectionAppeals(Integer eventId)
	{
		return appealDAO.getSelectionAppeals(eventId);
	}
	
	
	
	
	
	
	

}
