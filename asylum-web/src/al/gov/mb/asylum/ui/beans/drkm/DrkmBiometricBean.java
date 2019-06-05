package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.BiometricDTO;
import al.gov.mb.asylum.ui.models.EvidenceDTO;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.BiometricService;
import al.gov.mb.asylum.ui.services.EvidenceService;
import al.gov.mb.asylum.ui.services.OfficerService;
import al.gov.mb.asylum.ui.services.SelectionService;
import al.gov.mb.asylum.ui.utils.CalculatorUtil;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class DrkmBiometricBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	String uniqueNo;
	
	
	List<SelectionDTO> selections;
	SelectionDTO selection;
	List<OfficerDTO> eventOfficers;
	List<EvidenceDTO> eventEvidences;
	SelectionDTO selectedSelection;
	
	
	BiometricDTO biometric;
	private String file;
	
	
	
	
	
	
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

	public SelectionDTO drkmBiometricBean() {
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

	public BiometricDTO getBiometric() {
		return biometric;
	}

	public void setBiometric(BiometricDTO biometric) {
		this.biometric = biometric;
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
	

	public SelectionDTO getSelection() {
		return selection;
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
			
			this.selection = new SelectionService().getSelectionByUniqueNo(uniqueNo);
			if(selection == null)
			{
				Messages.throwFacesMessage("Perzgjedhja me Nr Unik: "+uniqueNo+" nuk u gjet",3);
				return;
			}
			this.eventEvidences = new EvidenceService().getEventEvidences(selection.getEvent().getId());
			this.eventOfficers = new OfficerService().getEventOfficers(selection.getEvent().getId());
			prepareBiometricForm();
									
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
		prepareBiometricForm();
	}

	private void prepareBiometricForm() {
		this.biometric = new BiometricDTO();
		this.file = null;
	}
	
	
	public void onSelectionSelect()
	{
		this.selection = selectedSelection;
		this.eventEvidences = new EvidenceService().getEventEvidences(selection.getEvent().getId());
		this.eventOfficers = new OfficerService().getEventOfficers(selection.getEvent().getId());
		prepareBiometricForm();
		this.uniqueNo = selection.getEvent().getUniqurNumber();		
	}
	
	
	
	
	public void handleFileUpload(FileUploadEvent event)
	{
		this.file = CalculatorUtil.encodeBASE64(event.getFile().getContents());
		Messages.throwFacesMessage("Ngarkimi u krye me sukses!",1);
		register();
	}
	
	
	public void clear()
	{
		searchSelection();
		clearUniqueNo();
	}
	
	public void register()
	{
		
		try {
			
			this.biometric.setEventId(this.selectedSelection.getEvent().getId());
			this.biometric.setPhoto(file);
			
			new BiometricService().registerBiometric(biometric);
			
			prepareBiometricForm();
			Messages.throwFacesMessage("Regjistrimi u krye me sukses!",1);
			
		}catch(Exception e) {Messages.throwFacesMessage(e);}
	}
	
	
	
	
	
	
	

}
