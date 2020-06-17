package al.gov.mb.asylum.ui.beans.dfac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.AsylumDecisionSx;
import al.gov.mb.asylum.ui.models.AsylumDecisionDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.services.AsylumDecisionService;
import al.gov.mb.asylum.ui.utils.Messages;



@ManagedBean
@ViewScoped
public class DfacDecisionsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	AsylumDecisionSx req;
	
	List<AsylumDecisionDTO> decisions;
	AsylumDecisionDTO selectedDecision;
	
	
	

	
	public NavBean getNav() {
		return nav;
	}
	
	public void setNav(NavBean nav) {
		this.nav = nav;
	}

	public AsylumDecisionSx getReq() {
		return req;
	}

	public void setReq(AsylumDecisionSx req) {
		this.req = req;
	}

	public List<AsylumDecisionDTO> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<AsylumDecisionDTO> decisions) {
		this.decisions = decisions;
	}

	public AsylumDecisionDTO getSelectedDecision() {
		return selectedDecision;
	}

	public void setSelectedDecision(AsylumDecisionDTO selectedDecision) {
		this.selectedDecision = selectedDecision;
	}

	
	


	@PostConstruct
	public void load()
	{
		req = new AsylumDecisionSx();
		req.setMaxResult(100);

		search();
		
	}
	
	
	
	public void search()
	{
		try {
			
			this.decisions = new AsylumDecisionService().searchAsylumDecision(req);
			this.selectedDecision = null;
			if(decisions == null || decisions.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje vendim",1);
			}
			
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	public void clear()
	{
		req = new AsylumDecisionSx();
		
		this.selectedDecision = null;
		this.decisions = null;
	}
	
	
	public void onSelectionSelect(AsylumDecisionDTO d)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(d.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	public void onDecisionSelect(AsylumDecisionDTO d)
	{
		this.selectedDecision = d;
	}
	
	
	
	
	
	
	
	
	

}
