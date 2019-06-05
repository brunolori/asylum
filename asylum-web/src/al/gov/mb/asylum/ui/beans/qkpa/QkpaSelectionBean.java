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
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.SelectionService;

@ManagedBean
@ViewScoped
public class QkpaSelectionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	SelectionSx req;
	
	List<SelectionDTO> selections;
	SelectionDTO selectedSelection;
	
	
	
	
	
	
	
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




	
	@PostConstruct
	public void load()
	{
		this.req = new SelectionSx();
		req.setIrStatusCode(IIrStatus.AZILANT);
		req.setMaxResult(50);
		
		this.selections = new SelectionService().searchSelection(req);
	}
	
	public void search()
	{
		req.setMaxResult(1000);
		this.selections = new SelectionService().searchSelection(req);
		this.selectedSelection = null;
	}
	
	public void clear()
	{
		this.req = new SelectionSx();
		req.setIrStatusCode(IIrStatus.AZILANT);
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
