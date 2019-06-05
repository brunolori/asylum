package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.FeedbackDAO;
import al.gov.mb.asylum.dto.FeedbackDTO;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.Feedback;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.forms.FeedbackSx;

@Service
public class FeedbackService {
	
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired FeedbackDAO feedbackDAO;
	
	
	@Transactional
	public Feedback registerFeedback(FeedbackDTO dto, String uname)
	{
		
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		/*
		if(dto.getValue() == null)
		{
			throw new ValidationException("Plotesoni vleren e Feedback-ut");
		}
		
		AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getSelection().getEvent().getId());
		if(details.getFeedbackValue() != null)
		{
			throw new EntityExistsException("Feedback-u per te perzgjedhurin eshte dhene");
		}
		details.setFeedbackValue(dto.getValue());
		crudDAO.update(details);
		*/
		Selection selection = crudDAO.findById(Selection.class, dto.getSelection().getEvent().getId());
		Feedback f = new Feedback();
		f.setFeedbackTime(Calendar.getInstance().getTime());
		f.setFeedbackUser(uname);
		f.setNotes(dto.getNotes());
		f.setSelection(selection);
		f.setStatus(IStatus.ACTIVE);
		f.setValue(dto.getValue());

		f = crudDAO.create(f);
		
		
		
		return f;
		
	}
	
	@Transactional
	public Feedback modifyFeedback(FeedbackDTO dto, String uname)
	{
		
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		/*
		if(dto.getValue() == null)
		{
			throw new ValidationException("Plotesoni vleren e Feedback-ut");
		}
		*/
		Feedback f = crudDAO.findById(Feedback.class, dto.getId());
		f.setFeedbackTime(Calendar.getInstance().getTime());
		f.setFeedbackUser(uname);
		f.setNotes(dto.getNotes());
		f.setValue(dto.getValue());

		f = crudDAO.update(f);
		/*
		AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getSelection().getEvent().getId());
		details.setFeedbackValue(f.getValue());
		crudDAO.update(details);
		*/
		return f;
		
	}
	
	@Transactional
	public void deleteFeedback(FeedbackDTO dto, String uname)
	{				
		
		Feedback f = crudDAO.findById(Feedback.class, dto.getId());
		f.setStatus(IStatus.NOT_ACTIVE);
		f = crudDAO.update(f);
		
		AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getSelection().getEvent().getId());
		details.setFeedbackValue(null);
		crudDAO.update(details);
				
	}
	
	
	public List<Feedback> searchFeedback(FeedbackSx req, String uname)
	{
		User u = crudDAO.findById(User.class, uname);
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				req.setOrganizationId(u.getOrganization().getId());
			}
		}
		
		return feedbackDAO.search(req);
	}
	
	

}
