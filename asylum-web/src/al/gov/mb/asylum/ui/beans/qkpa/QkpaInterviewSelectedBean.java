package al.gov.mb.asylum.ui.beans.qkpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.IInterviewStatus;
import al.gov.mb.asylum.ui.forms.InterviewSx;
import al.gov.mb.asylum.ui.models.InterviewDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.services.InterviewService;
import al.gov.mb.asylum.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class QkpaInterviewSelectedBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	List<InterviewDTO> interviews;
	InterviewDTO selectedInterview;
	

	
	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}
	public List<InterviewDTO> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<InterviewDTO> interviews) {
		this.interviews = interviews;
	}
	public InterviewDTO getSelectedInterview() {
		return selectedInterview;
	}
	public void setSelectedInterview(InterviewDTO selectedInterview) {
		this.selectedInterview = selectedInterview;
	}
	
	
	
	@PostConstruct
	public void load()
	{
		InterviewSx req = new InterviewSx();
		req.setInterviewStatus(IInterviewStatus.SELECTED);

		this.interviews = new InterviewService().searchInterview(req);
		this.selectedInterview = null;
		
		if(interviews == null || interviews.isEmpty())
		{
			Messages.throwFacesMessage("Nuk ka te perzgjedhur per interviste",1);
		}
		
		
	}
	
	
	public void onInterviewSelect(InterviewDTO i)
	{
		this.selectedInterview = i;
	}
		
	
	public void onSelectionSelect(InterviewDTO i)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(i.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	
	
	
	
	
}
