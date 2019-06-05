package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.FeedbackSx;
import al.gov.mb.asylum.ui.models.FeedbackDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.services.FeedbackService;

@ManagedBean
@ViewScoped
public class DrkmFeedbackBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	FeedbackSx req;
	List<FeedbackDTO> feedbacks;

	public FeedbackSx getReq() {
		return req;
	}
	public void setReq(FeedbackSx req) {
		this.req = req;
	}
	public List<FeedbackDTO> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<FeedbackDTO> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}
	
	
	
	@PostConstruct
	public void load()
	{
		this.req = new FeedbackSx();
		req.setMaxResult(30);
		this.feedbacks = new FeedbackService().searchFeedback(req);
	}
	
	public void searchFeedback()
	{
		this.feedbacks = new FeedbackService().searchFeedback(req);
	}
	
	public void clear()
	{
		this.req = new FeedbackSx();
		this.feedbacks = null;
	}
	
	public void onSelectionSelect(FeedbackDTO f)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(f.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	

}
