package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IAsylumDecisionType;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.AsylumDecisionDAO;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dto.AsylumDecisionDTO;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.AsylantStage;
import al.gov.mb.asylum.entities.AsylantStatus;
import al.gov.mb.asylum.entities.AsylumDecision;
import al.gov.mb.asylum.entities.AsylumDecisionType;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.AsylumDecisionSx;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class AsylumDecisionService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired AsylumDecisionDAO asylumDecisionDAO;

	
	
	
	@Transactional
	public AsylumDecision register(AsylumDecisionDTO dto, String uname)
	{
		
		if(dto == null)
		{
			throw new ValidationException("Te dhenat jane paplotesuar");
		}
		
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		
		if(dto.getOrderDate() == null)
		{
			throw new ValidationException("Plotesoni Daten e Urdherit");
		}
		
		if(!StringUtil.isValid(dto.getOrderNo()))
		{
			throw new ValidationException("Plotesoni Numrin e Urdherit");
		}
		
		if(dto.getNewStatus() == null)
		{
			throw new ValidationException("Plotesoni statusin e ri");
		}
		
		if(dto.getNewStage() == null)
		{
			throw new ValidationException("Plotesoni fazen e statusit te ri");
		}
		
		Selection selection = crudDAO.findById(Selection.class, dto.getSelection().getEvent().getId());
		if(selection.getAsylantDetails().getAsylantStage() != null) {
			if(selection.getAsylantDetails().getAsylantStage().getId() == dto.getNewStage().getId() && selection.getAsylantDetails().getAsylantStatus().getId() == dto.getNewStatus().getId())
			{
				throw new ValidationException("Ju nuk keni bere ndryshim statusi ose faze");
			}
		}
		AsylantStatus newStatus = crudDAO.findById(AsylantStatus.class, dto.getNewStatus().getId());
		AsylantStage newStage = crudDAO.findById(AsylantStage.class, dto.getNewStage().getId());
		
		AsylumDecision ad = new AsylumDecision();
		ad.setArticle(dto.getArticle());
		ad.setDecisionTime(Calendar.getInstance().getTime());
		ad.setDecisionType(crudDAO.findById(AsylumDecisionType.class, IAsylumDecisionType.STATUS_CHANGE));
		ad.setDecisionUser(uname);
		ad.setNewStage(newStage);
		ad.setNewStatus(newStatus);
		ad.setNotes(dto.getNotes());
		ad.setOldStage(selection.getAsylantDetails().getAsylantStage());
		ad.setOldStatus(selection.getAsylantDetails().getAsylantStatus());
		ad.setOrderDate(dto.getOrderDate());
		ad.setOrderNo(dto.getOrderNo());
		ad.setSelection(selection);
		ad.setStatus(IStatus.ACTIVE);
		
		ad = crudDAO.create(ad);
		
		AsylantDetails details = selection.getAsylantDetails();
		
		details.setAsylantStage(ad.getNewStage());
		details.setAsylantStatus(ad.getNewStatus());

		crudDAO.update(details);
		
		
		return ad;
	}
	
	
	public List<AsylumDecision> searchAsylumDecision(AsylumDecisionSx req, String uname)
	{
		return asylumDecisionDAO.searchAsylumDecision(req);
	}
	
	
	
	
	
	
	
	

}
