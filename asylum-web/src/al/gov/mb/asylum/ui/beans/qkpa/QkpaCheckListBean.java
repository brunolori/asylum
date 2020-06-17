package al.gov.mb.asylum.ui.beans.qkpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.models.FeedbackDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.FeedbackService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.services.TransferService;
import al.gov.mb.asylum.ui.utils.Messages;


@ManagedBean
@ViewScoped
public class QkpaCheckListBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	List<SelectionDTO> selections;
		
	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}	
	
	public List<SelectionDTO> getSelections() {
		return selections;
	}
	public void setSelections(List<SelectionDTO> selections) {
		this.selections = selections;
	}
	
	
	
	@PostConstruct
	public void load()
	{				
		getSelectionsNotGone();		
	}
	
	
	public void getSelectionsNotGone()
	{
		try {
			
			this.selections = new SelectionService().getSelectionsNotGoneFromQkpa();
			if(selections == null || selections.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka te parregullt",2);
			}
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public void onSelectionSelect(SelectionDTO t)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(t.getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	
	public void registerGone(SelectionDTO s)
	{
		try {
			
			new TransferService().registerGoneSelection(s);
			
			FeedbackDTO feedback = new FeedbackDTO();
			feedback.setSelection(s);
			String message = "LARGUAR nga Q.K.P.A: ";
			feedback.setNotes(message);
			new FeedbackService().registerFeedback(feedback);
	

			Messages.throwFacesMessage("Ngjarja u regjistrua me sukses! ["+s.getPerson().getName()+" "+s.getPerson().getSurname()+"]",1);
			
			this.selections.remove(s);
			if(selections == null || selections.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka te parregullt",2);
			}
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	

}
