package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.InterviewClient;
import al.gov.mb.asylum.ui.forms.InterviewForm;
import al.gov.mb.asylum.ui.forms.InterviewSx;
import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.InterviewQuestionDTO;

public class InterviewService {

	
	public InterviewDTO selectForInterview(InterviewDTO dto)
	{
		return new InterviewClient().selectForInterview(dto);
	}
	
	public InterviewDTO registerInterview(InterviewForm form)
	{
		return new InterviewClient().registerInterview(form);
	}
	
	public List<InterviewDTO> searchInterview(InterviewSx req)
	{
		return new InterviewClient().searchInterview(req);
	}
	
	public List<InterviewQuestionDTO> getInterviewQuestions(Integer interviewId)
	{
		return new InterviewClient().getInterviewQuestions(interviewId);
	}
	
	
	
	
	
}
