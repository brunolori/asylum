package al.gov.mb.asylum.ui.beans.qkpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.IIrStatus;
import al.gov.mb.asylum.ui.constants.IOrganization;
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class QkpaShelteredBean implements Serializable {

	
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
		search();		
	}
	
	
	public void search()
	{
		try {
			SelectionSx req = new SelectionSx();
			req.setActualLocationId(IOrganization.QKPA_ID);
			req.setIrStatusCode(IIrStatus.AZILANT);
			this.selections = new SelectionService().searchSelection(req);
			if(selections == null || selections.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka te strehuar",2);
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
	
	
	

}
