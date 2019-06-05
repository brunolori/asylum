package al.gov.mb.asylum.ui.beans.dfac;

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
public class DfacHearedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
    List<HearingDTO> hearings;
    HearingDTO selectedHearing;
	
	HearingSx req;

	
	
	
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

	public HearingSx getReq() {
		return req;
	}

	public void setReq(HearingSx req) {
		this.req = req;
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
		req = new HearingSx();
		req.setHearingStatus(IHearingStatus.COMPLETED);
		req.setMaxResult(100);

		search();
		
	}
	
	
	
	public void search()
	{
		try {
			
			this.selectedHearing = null;
			this.hearings = new HearingService().searchHearing(req);
			
			if(hearings == null || hearings.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka degjime",1);
			}
			
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	public void clear()
	{
		req = new HearingSx();
		req.setHearingStatus(IHearingStatus.COMPLETED);
		
		this.selectedHearing = null;
		this.hearings = null;
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
