package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.List;

import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.InterviewQuestionDTO;



public class InterviewForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	InterviewDTO interview;
	List<InterviewQuestionDTO> questions;
	
	
	public InterviewDTO getInterview() {
		return interview;
	}
	public void setInterview(InterviewDTO interview) {
		this.interview = interview;
	}
	public List<InterviewQuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<InterviewQuestionDTO> questions) {
		this.questions = questions;
	}
	
	
	
	
}
