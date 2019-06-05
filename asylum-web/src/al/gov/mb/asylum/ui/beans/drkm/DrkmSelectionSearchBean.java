package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.HandedOverDTO;
import al.gov.mb.asylum.ui.models.OrganizationDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.utils.Messages;



@ManagedBean
@ViewScoped
public class DrkmSelectionSearchBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	SelectionSx req;
	
	List<SelectionDTO> selections;
	SelectionDTO selectedSelection;
	List<HandedOverDTO> handedOvers;
	List<OrganizationDTO> organizations;
	
	
	
	public NavBean getNav() {
		return nav;
	}

	public void setNav(NavBean nav) {
		this.nav = nav;
	}

	public SelectionSx getReq() {
		return req;
	}

	public void setReq(SelectionSx req) {
		this.req = req;
	}

	public List<SelectionDTO> getSelections() {
		return selections;
	}

	public void setSelections(List<SelectionDTO> selections) {
		this.selections = selections;
	}

	public SelectionDTO getSelectedSelection() {
		return selectedSelection;
	}

	public void setSelectedSelection(SelectionDTO selectedSelection) {
		this.selectedSelection = selectedSelection;
	}

	public List<HandedOverDTO> getHandedOvers() {
		return handedOvers;
	}

	public void setHandedOvers(List<HandedOverDTO> handedOvers) {
		this.handedOvers = handedOvers;
	}

	public List<OrganizationDTO> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<OrganizationDTO> organizations) {
		this.organizations = organizations;
	}
	
	
	

	@PostConstruct
	public void load()
	{
		this.req = new SelectionSx();
		this.organizations = new HelperService().listOrganization();
		this.handedOvers = new HelperService().listHandedOver();
		search();
	}
	
	public void search()
	{
		req.setMaxResult(1000);
		this.selectedSelection = null;
		try {
			
			this.selections = new SelectionService().searchSelection(req);
			if(selections == null || selections.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka te parregullt",2);
			}
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	public void clear()
	{
		this.req = new SelectionSx();
		req.setMaxResult(1000);
		this.selectedSelection = null;
		this.selections = null;
	}
	
	
	public void onSelectionSelect()
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(selectedSelection.getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	

}
