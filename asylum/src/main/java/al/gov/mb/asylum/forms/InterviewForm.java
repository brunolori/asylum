package al.gov.mb.asylum.forms;

import java.util.List;

import al.gov.mb.asylum.dto.InterviewDTO;
import al.gov.mb.asylum.dto.InterviewQuestionDTO;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InterviewForm {
	
	
	InterviewDTO interview;
	List<InterviewQuestionDTO> questions;
	
	
	
	public void validate()
	{
		
		if(!StringUtil.isValid(interview.getLanguage()))
		{
			throw new ValidationException("Plotesoni Gjuhen e Intervistimit");
		}
		if(!StringUtil.isValid(interview.getTranslator()))
		{
			throw new ValidationException("Plotesoni Perkthyesin");
		}
		if(!StringUtil.isValid(interview.getNotes()))
		{
			throw new ValidationException("Plotesoni Shenimet e Intervistes");
		}
		if(questions == null || questions.isEmpty())
		{
			throw new ValidationException("Plotesoni Pyetjet");
		}
		/*
		int i = 1;
		for(InterviewQuestionDTO iq : questions)
		{
			if(!StringUtil.isValid(iq.getAnswer()))
			{
				throw new ValidationException("Plotesoni Pergjigjen e Pyetjes NR."+i);
			}
			i++;
		}
		*/
	}

}
