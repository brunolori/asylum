package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.EventForm;
import al.gov.mb.asylum.ui.models.EventDTO;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.PlaceTypeDTO;
import al.gov.mb.asylum.ui.services.EventService;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;



@ManagedBean
@ViewScoped
public class DrkmEventBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	EventDTO event;
	List<PlaceTypeDTO> placeTypes;
	EvidenceDTO evidence;
	List<EvidenceDTO> evidences;
	OfficerDTO officer;
	List<OfficerDTO> officers;
	
	boolean fixedData;
	
	
	

	public NavBean getNav() {
		return nav;
	}

	public void setNav(NavBean nav) {
		this.nav = nav;
	}

	public EventDTO getEvent() {
		return event;
	}

	public void setEvent(EventDTO event) {
		this.event = event;
	}

	public List<PlaceTypeDTO> getPlaceTypes() {
		return placeTypes;
	}

	public void setPlaceTypes(List<PlaceTypeDTO> placeTypes) {
		this.placeTypes = placeTypes;
	}

	public List<EvidenceDTO> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<EvidenceDTO> evidences) {
		this.evidences = evidences;
	}

	public List<OfficerDTO> getOfficers() {
		return officers;
	}

	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
	}

	public boolean isFixedData() {
		return fixedData;
	}

	public void setFixedData(boolean fixedData) {
		this.fixedData = fixedData;
	}
	
	public EvidenceDTO getEvidence() {
		return evidence;
	}

	public void setEvidence(EvidenceDTO evidence) {
		this.evidence = evidence;
	}

	public OfficerDTO getOfficer() {
		return officer;
	}

	public void setOfficer(OfficerDTO officer) {
		this.officer = officer;
	}
	
	
	

	@PostConstruct
	public void load()
	{
		this.placeTypes = new HelperService().listPlaceType();
		init();
	}
	
	private void init()
	{
		String data = null;
		if(fixedData)
		{			
			data = event.getDescription();
		}
		
		this.event = new EventDTO();
		event.setEventDate(Calendar.getInstance().getTime());
		event.setDescription(data);
		clearEvidence();
		this.evidences = new ArrayList<>();
		this.officers = new ArrayList<>();
		
	}
	
	
	public void clear()
	{
		init();
	}
	
	public void addEvidence()
	{
		if(!StringUtil.isValid(this.evidence.getName()))
		{
			Messages.throwFacesMessage("Plotesoni Emrin e proves",2);
			return ;
		}
		
		if(!StringUtil.isValid(this.evidence.getDescription()))
		{
			Messages.throwFacesMessage("Plotesoni Pershkrimin e proves",2);
			return ;
		}
		
		this.evidences.add(evidence);
		clearEvidence();
	}
	
	public void clearEvidence()
	{
		this.evidence = new EvidenceDTO();
	}
	
	public void removeEvidence(EvidenceDTO e)
	{
		evidences.remove(e);
	}
	
	public void onOfficerSelect(SelectEvent event)
	{
		this.officer = (OfficerDTO) event.getObject();
		
		if(officer != null) {
			officers.add(officer);
			this.officer = null;
		}
	}
	
	public void removeOfficer(OfficerDTO o)
	{
		officers.remove(o);
	}
	
	public void register()
	{
		try {
			
			EventForm form = new EventForm();
			form.setEvent(event);
			form.setEvidences(evidences);
			form.setOfficers(officers);
			System.out.println(form.getEvent().getDescription());
			EventDTO e = new EventService().registerEvent(form);
			init();
			Messages.throwFacesMessage("Regjistrimi u krye me sukses! NR UNIK: "+e.getUniqurNumber(),1);
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	public void registerAndPrint()
	{
		EventForm form = new EventForm();
		form.setEvent(event);
		form.setEvidences(evidences);
		form.setOfficers(officers);
		EventDTO e = new EventService().registerEvent(form);
		init();
		
		Messages.throwFacesMessage("Regjistrimi u krye me sukses! NR UNIK: "+e.getUniqurNumber(),1);
	}
	
	public void registerAndSelect()
	{
		
		try {
			
			EventForm form = new EventForm();
			form.setEvent(event);
			form.setEvidences(evidences);
			form.setOfficers(officers);
			EventDTO e = new EventService().registerEvent(form);
			init();
			
			List<Param> params = new ArrayList<>();
			params.add(new Param("unique_no", e.getUniqurNumber()));
			nav.navigate("selection",params);
			
			Messages.throwFacesMessage("Regjistrimi u krye me sukses! NR UNIK: "+e.getUniqurNumber(),1);
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
		
		
		
	}
	
	

}
