package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.DecisionDTO;
import al.gov.mb.asylum.ui.models.DecisionReasonDTO;
import al.gov.mb.asylum.ui.models.DecisionStatusDTO;
import al.gov.mb.asylum.ui.models.DecisionTypeDTO;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.DecisionService;
import al.gov.mb.asylum.ui.services.EvidenceService;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.OfficerService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;



@ManagedBean
@ViewScoped
public class DrkmDecisionBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	String uniqueNo;
	
	
	List<SelectionDTO> selections;
	SelectionDTO selection;
	List<OfficerDTO> eventOfficers;
	List<EvidenceDTO> eventEvidences;
	SelectionDTO selectedSelection;
	
	DecisionDTO decision;
	
	
	List<DecisionTypeDTO> decisionTypes;
	List<DecisionStatusDTO> decisionStatuses;
	List<DecisionReasonDTO> decisionReasons;
	
	
	
	
	
	
	
	
	
	public NavBean getNav() {
		return nav;
	}


	public void setNav(NavBean nav) {
		this.nav = nav;
	}


	public String getUniqueNo() {
		return uniqueNo;
	}


	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}


	public List<SelectionDTO> getSelections() {
		return selections;
	}


	public void setSelections(List<SelectionDTO> selections) {
		this.selections = selections;
	}


	public SelectionDTO getSelection() {
		return selection;
	}


	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}


	public SelectionDTO getSelectedSelection() {
		return selectedSelection;
	}


	public void setSelectedSelection(SelectionDTO selectedSelection) {
		this.selectedSelection = selectedSelection;
	}


	public DecisionDTO getDecision() {
		return decision;
	}


	public void setDecision(DecisionDTO decision) {
		this.decision = decision;
	}


	public List<DecisionTypeDTO> getDecisionTypes() {
		return decisionTypes;
	}


	public void setDecisionTypes(List<DecisionTypeDTO> decisionTypes) {
		this.decisionTypes = decisionTypes;
	}


	public List<DecisionStatusDTO> getDecisionStatuses() {
		return decisionStatuses;
	}


	public void setDecisionStatuses(List<DecisionStatusDTO> decisionStatuses) {
		this.decisionStatuses = decisionStatuses;
	}


	public List<DecisionReasonDTO> getDecisionReasons() {
		return decisionReasons;
	}


	public void setDecisionReasons(List<DecisionReasonDTO> decisionReasons) {
		this.decisionReasons = decisionReasons;
	}

	public List<OfficerDTO> getEventOfficers() {
		return eventOfficers;
	}


	public void setEventOfficers(List<OfficerDTO> eventOfficers) {
		this.eventOfficers = eventOfficers;
	}


	public List<EvidenceDTO> getEventEvidences() {
		return eventEvidences;
	}


	public void setEventEvidences(List<EvidenceDTO> eventEvidences) {
		this.eventEvidences = eventEvidences;
	}


	
	
	
	@PostConstruct
	public void load()
	{
		this.decisionTypes = new HelperService().listDecisionType();
		this.decisionStatuses = new HelperService().listDecisionStatus();
	}
	
	
	public void init()
	{
				
		this.uniqueNo = nav.getParam("unique_no");
		
		if(StringUtil.isValid(uniqueNo)){
			
			searchSelection();			
		}
		else{
			clearUniqueNo();
		}
		
	}
	
	public void searchSelection()
	{
		try {
			
			if(!StringUtil.isValid(uniqueNo))
			{
				Messages.throwFacesMessage("Plotesoni Numrin Unik",3);
				return;
			}
			if(selection == null)
			{
				Messages.throwFacesMessage("Perzgjedhja me Nr Unik: "+uniqueNo+" nuk u gjet",3);
				return;
			}
			
			this.selection = new SelectionService().getSelectionByUniqueNo(uniqueNo);
			this.eventEvidences = new EvidenceService().getEventEvidences(selection.getEvent().getId());
			this.eventOfficers = new OfficerService().getEventOfficers(selection.getEvent().getId());
			prepareDecisionForm();
						
			
			
		}catch(Exception e) {
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public void clearUniqueNo()
	{
		this.uniqueNo = null;
		SelectionSx req = new SelectionSx();
		req.setMaxResult(10);
		this.selections = new SelectionService().searchSelection(req);
		this.selection = null;
		this.eventEvidences = null;
		this.eventOfficers = null;
		this.selectedSelection = null;
		prepareDecisionForm();
	}

	private void prepareDecisionForm() {
		this.decision = new DecisionDTO();
	}
	
	
	public void onSelectionSelect()
	{
		this.selection = selectedSelection;
		this.eventEvidences = new EvidenceService().getEventEvidences(selection.getEvent().getId());
		this.eventOfficers = new OfficerService().getEventOfficers(selection.getEvent().getId());
		prepareDecisionForm();
		this.uniqueNo = selection.getEvent().getUniqurNumber();		
	}
	
	public void onDecisionTypeSelect()
	{
		

		if(decision.getDecisionType() == null)
		{
			this.decisionReasons = null;
		}
		else {
			this.decisionReasons = new HelperService().listDecisionReason(decision.getDecisionType().getId());
		}
	}
	
	
	public void clear()
	{
		searchSelection();
		clearUniqueNo();
	}
	
	public void register()
	{
		
		try {
			
			this.decision.setSelection(selection);
			new DecisionService().registerDecision(decision);
			prepareDecisionForm();
			Messages.throwFacesMessage("Regjistrimi u krye me sukses!",1);
			
		}catch(Exception e) {Messages.throwFacesMessage(e);}
	}
	
	
	
	
	

}
