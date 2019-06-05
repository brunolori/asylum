package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import al.gov.mb.asylum.ui.constants.IOrganization;
import al.gov.mb.asylum.ui.forms.TransferForm;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.services.TransferService;
import al.gov.mb.asylum.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class DrkmTransferRegBean implements Serializable {

	private static final long serialVersionUID = 1L;
			
	TransferForm form;
	
	DualListModel<SelectionDTO> selectionModel;
	
	
	

	public TransferForm getForm() {
		return form;
	}
	public void setForm(TransferForm form) {
		this.form = form;
	}
	public DualListModel<SelectionDTO> getSelectionModel() {
		return selectionModel;
	}
	public void setSelectionModel(DualListModel<SelectionDTO> selectionModel) {
		this.selectionModel = selectionModel;
	}


	
	
	@PostConstruct
    public void init() {

        clear();
                  
    }
	
	
	public void clear()
	{
		this.form = new TransferForm();
		
		List<SelectionDTO> selectionSource = new ArrayList<>();
        List<SelectionDTO> selectionTarget = new ArrayList<>();
                 
        selectionSource = new TransferService().getDrkmSelectionsForTransfer();
        
        if(selectionSource == null)
        {
        	selectionSource = new ArrayList<>();
        	Messages.throwFacesMessage("Nuk ka azilante per transferim",1);
        }
         
        selectionModel = new DualListModel<>(selectionSource, selectionTarget);
	}
	

	public void register()
	{
		if(selectionModel.getTarget().isEmpty())
		{
			Messages.throwFacesMessage("Zgjidhni personat per transferim",2);
			return;
		}
		form.setSelections(selectionModel.getTarget());
		form.setDestinationOrgId(IOrganization.QKPA_ID);
		
		try {
			new TransferService().registerCheckOut(form);
			clear();
			Messages.throwFacesMessage("Transferimi u krye me sukses",1);
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	
}
