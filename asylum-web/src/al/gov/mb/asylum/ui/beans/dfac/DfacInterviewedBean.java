package al.gov.mb.asylum.ui.beans.dfac;

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
public class DfacInterviewedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	List<InterviewDTO> interviews;
	InterviewDTO selectedInterview;
	
	InterviewSx req;
	
	

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
	public InterviewSx getReq() {
		return req;
	}
	public void setReq(InterviewSx req) {
		this.req = req;
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
		req = new InterviewSx();
		req.setInterviewStatus(IInterviewStatus.COMPLETED);
		req.setMaxResult(100);

		search();
		
	}
	
	
	
	public void search()
	{
		try {
			
			this.interviews = new InterviewService().searchInterview(req);
			this.selectedInterview = null;
			if(interviews == null || interviews.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka te intervistuar",1);
			}
			
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	public void clear()
	{
		req = new InterviewSx();
		req.setInterviewStatus(IInterviewStatus.COMPLETED);
		
		this.selectedInterview = null;
		this.interviews = null;
	}
	
	
	public void onSelectionSelect(InterviewDTO i)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(i.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	public void onInterviewSelect(InterviewDTO i)
	{
		this.selectedInterview = i;
	}
	
	
	

}
