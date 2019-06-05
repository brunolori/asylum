package al.gov.mb.asylum.ui.models;

import java.io.Serializable;




public class InterviewQuestionDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	    private int id;
	    private String question;
	    private String answer;
	    private boolean status;
	    private InterviewDTO interview;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public InterviewDTO getInterview() {
			return interview;
		}
		public void setInterview(InterviewDTO interview) {
			this.interview = interview;
		}
	    
	    
		

}
