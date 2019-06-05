package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IInterviewStatus;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.InterviewDAO;
import al.gov.mb.asylum.dto.InterviewDTO;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.Interview;
import al.gov.mb.asylum.entities.InterviewQuestion;
import al.gov.mb.asylum.entities.InterviewStatus;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.InterviewForm;
import al.gov.mb.asylum.forms.InterviewSx;

@Service
public class InterviewService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired InterviewDAO interviewDAO;
	
	
	@Transactional
	public Interview selectForInterview(InterviewDTO interview, String uname)
	{
		SelectionDTO dto = interview.getSelection();
		
		if(dto == null)
		{
			throw new ValidationException("I Perzgjedhuri i papercaktuar");
		}
		if(interview.getPredictedInterviewDate() == null)
		{
			throw new ValidationException("Zgjidhni daten e intervistes");
		}
		
		Selection selection = crudDAO.findById(Selection.class, dto.getEvent().getId());
		AsylantDetails details = selection.getAsylantDetails();
		if(details.getLastInterviewStatus() != null && details.getLastInterviewStatus().getId() == IInterviewStatus.SELECTED)
		{
			throw new ValidationException("I Perzgjedhuri eshte ne pritje per Intervistim");
		}
		
		InterviewStatus status = crudDAO.findById(InterviewStatus.class, IInterviewStatus.SELECTED);
		Interview i = new Interview();
		i.setInterviewStatus(status);
		i.setSelection(selection);
		i.setSelectionTime(Calendar.getInstance().getTime());
		i.setSelectionUser(uname);
		i.setStatus(IStatus.ACTIVE);
		i.setPredictedInteviewDate(interview.getPredictedInterviewDate());
		i.setSelectionNotes(interview.getSelectionNotes());
		i = crudDAO.create(i);
		
		
		details.setLastInterviewStatus(status);
		crudDAO.update(details);
		
		return i;
		
	}
	
	@Transactional
	public Interview registerInterview(InterviewForm form, String uname)
	{
		
		form.validate();
		
		Interview i = crudDAO.findById(Interview.class, form.getInterview().getId());
		AsylantDetails details = i.getSelection().getAsylantDetails();
		InterviewStatus status = crudDAO.findById(InterviewStatus.class, IInterviewStatus.COMPLETED);
		
		i.setInterviewer(uname);
		i.setInterviewStatus(status);
		i.setInterviewTime(Calendar.getInstance().getTime());
		i.setInterviewUser(uname);
		i.setLanguage(form.getInterview().getLanguage());
		i.setNotes(form.getInterview().getNotes());
		i.setTranslator(form.getInterview().getTranslator());
		
		i = crudDAO.update(i);
		
		int cnt = details.getInterviewCnt()==null?0:details.getInterviewCnt();
		cnt++;
		details.setInterviewCnt(cnt);
		details.setLastInterviewStatus(status);
		/*
		for(InterviewQuestionDTO q : form.getQuestions())
		{
			InterviewQuestion iq = new InterviewQuestion();
			iq.setAnswer(q.getAnswer());
			iq.setQuestion(q.getQuestion());
			iq.setInterview(i);
			iq.setStatus(IStatus.ACTIVE);
			
			crudDAO.create(iq);
		}
		*/
		return i;
	}
	

	public List<InterviewQuestion> getInterviewQuestions(Integer interviewId)
	{
		return interviewDAO.getInterviewQuestions(interviewId);
	}
	
		
	public List<Interview> searchInterview(InterviewSx req, String uname)
	{
		return interviewDAO.searchInterview(req);
	}
	
	
	
	
	
	
}
