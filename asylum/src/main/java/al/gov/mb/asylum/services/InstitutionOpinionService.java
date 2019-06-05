package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.InstitutionOpinionDAO;
import al.gov.mb.asylum.dto.InstitutionOpinionDTO;
import al.gov.mb.asylum.entities.InstitutionOpinion;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class InstitutionOpinionService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired InstitutionOpinionDAO opinionDAO;
	
	
	
	@Transactional
	public InstitutionOpinion registerOpinion(InstitutionOpinionDTO dto, String uname)
	{
		
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I Perzgjedhuri i papercaktuar");
		}
		if(!StringUtil.isValid(dto.getInstitution()))
		{
			throw new ValidationException("Plotesoni Institucionin");
		}		

		if(!StringUtil.isValid(dto.getNotes()))
		{
			throw new ValidationException("Plotesoni Shenimet e institucionit");
		}
		
		InstitutionOpinion a = new InstitutionOpinion();
		a.setInstitution(dto.getInstitution());
		a.setOpinionTime(Calendar.getInstance().getTime());
		a.setOpinionUser(uname);
		a.setNotes(dto.getNotes());
		a.setStatus(IStatus.ACTIVE);
		a.setSelection(crudDAO.findById(Selection.class, dto.getSelection().getEvent().getId()));
		
		
		return crudDAO.create(a);
		
		
	}
	
	public List<InstitutionOpinion> getSelectionOpinions(Integer eventId)
	{
		return opinionDAO.getSelectionOpinions(eventId);
	}
	
	

}
