package al.gov.mb.asylum.ui.beans.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import al.gov.mb.asylum.ui.forms.OfficerSx;
import al.gov.mb.asylum.ui.models.AsylantStageDTO;
import al.gov.mb.asylum.ui.models.AsylantStatusDTO;
import al.gov.mb.asylum.ui.models.IrStatusDTO;
import al.gov.mb.asylum.ui.models.KeyValue;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.PlaceTypeDTO;
import al.gov.mb.asylum.ui.models.StateDTO;
import al.gov.mb.asylum.ui.models.TimsDocumentDTO;
import al.gov.mb.asylum.ui.services.DocumentService;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.OfficerService;
import al.gov.mb.asylum.ui.utils.StringUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;


@ManagedBean
@ApplicationScoped
public class CacheBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	List<AsylantStageDTO> asylantStages;
	List<AsylantStatusDTO> asylantStatuses;
	List<PlaceTypeDTO> placeTypes;
	List<IrStatusDTO> irStatuses;
	List<KeyValue> civilStatuses;
	Map<String,String> states;
	
	
	@PostConstruct
	public void load()
	{
		
		List<StateDTO> statesList = new HelperService().listStates("_");
		this.states = new HashMap<>();
		if(statesList != null && !statesList.isEmpty())
		{
			for(StateDTO s : statesList)
			{
				states.put(s.getCode(), s.getTag());
			}
		}
		this.civilStatuses = new ArrayList<>();
		civilStatuses.add(new KeyValue(1, "Beqar/e"));
		civilStatuses.add(new KeyValue(2, "Martuar"));
		civilStatuses.add(new KeyValue(3, "Divorcuar"));
		civilStatuses.add(new KeyValue(4, "i/e Ve"));
		this.asylantStages = new HelperService().listAsylantStage();
		this.asylantStatuses = new HelperService().listAsylantStatus();
		this.placeTypes = new HelperService().listPlaceType();
		this.irStatuses = new HelperService().listIrStatus();
	}
	
	
	
	
	
	
	public List<IrStatusDTO> getIrStatuses() {
		return irStatuses;
	}

	public void setIrStatuses(List<IrStatusDTO> irStatuses) {
		this.irStatuses = irStatuses;
	}

	public List<AsylantStageDTO> getAsylantStages() {
		return asylantStages;
	}
	public void setAsylantStages(List<AsylantStageDTO> asylantStages) {
		this.asylantStages = asylantStages;
	}

	public List<AsylantStatusDTO> getAsylantStatuses() {
		return asylantStatuses;
	}

	public void setAsylantStatuses(List<AsylantStatusDTO> asylantStatuses) {
		this.asylantStatuses = asylantStatuses;
	}

	public List<PlaceTypeDTO> getPlaceTypes() {
		return placeTypes;
	}

	public void setPlaceTypes(List<PlaceTypeDTO> placeTypes) {
		this.placeTypes = placeTypes;
	}

	public List<KeyValue> getCivilStatuses() {
		return civilStatuses;
	}

	public void setCivilStatuses(List<KeyValue> civilStatuses) {
		this.civilStatuses = civilStatuses;
	}

	public Map<String, String> getStates() {
		return states;
	}

	public void setStates(Map<String, String> states) {
		this.states = states;
	}

	
	
	
	
	
	
	
	public String stateName(String code)
	{
		if(!StringUtil.isValid(code)) return "Pa deklaruar";
		return states.get(code);
	}
	
	

	public List<OfficerDTO> searchOfficer(String query)
	{
		OfficerSx req = new OfficerSx();
		req.setFullname(query);
		return new OfficerService().searchOfficer(req);
	}
	
	public List<TimsDocumentDTO> searchTimsDocument(String query)
	{
		return new DocumentService().getTimsDocument(query);
	}
	
	public List<StateDTO> searchState(String query)
	{
		return new HelperService().listStates(query);
	}

    public String civilStatus(Character i)
    {
    	if(i == null) return "-";
    	switch(i)
    	{
	    	case '1' : return "Beqar/e";
	    	case '2' : return "Martuar";
	    	case '3' : return "Divorcuar";
	    	case '4' : return "i/e Ve";
    	}
    	
    	return "-";
	}
	
	
	
	
	
	
	
	
	
	
	

}	
