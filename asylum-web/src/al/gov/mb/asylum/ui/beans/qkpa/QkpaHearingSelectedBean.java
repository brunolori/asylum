package al.gov.mb.asylum.ui.beans.qkpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.IHearingStatus;
import al.gov.mb.asylum.ui.forms.HearingSx;
import al.gov.mb.asylum.ui.models.HearingDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.services.HearingService;
import al.gov.mb.asylum.ui.utils.Messages;


@ManagedBean
@ViewScoped
public class QkpaHearingSelectedBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	List<HearingDTO> hearings;
	HearingDTO selectedHearing;


	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}
	public List<HearingDTO> getHearings() {
		return hearings;
	}
	public void setHearings(List<HearingDTO> hearings) {
		this.hearings = hearings;
	}
	public HearingDTO getSelectedHearing() {
		return selectedHearing;
	}
	public void setSelectedHearing(HearingDTO selectedHearing) {
		this.selectedHearing = selectedHearing;
	}
	
	
	
	
	@PostConstruct
	public void load()
	{
		HearingSx req = new HearingSx();
		req.setHearingStatus(IHearingStatus.SELECTED);

		this.selectedHearing = null;
		this.hearings = new HearingService().searchHearing(req);
		
		if(hearings == null || hearings.isEmpty())
		{
			Messages.throwFacesMessage("Nuk ka te perzgjedhur per degjim",1);
		}
		
		
	}
	
	
	
	public void onSelectionSelect(HearingDTO h)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(h.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	
	public void onHearingSelect(HearingDTO h)
	{
		this.selectedHearing = h;
	}
	
	
	

}
