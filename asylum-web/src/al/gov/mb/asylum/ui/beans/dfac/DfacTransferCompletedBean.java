package al.gov.mb.asylum.ui.beans.dfac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.ITransferStatus;
import al.gov.mb.asylum.ui.forms.TransferSx;
import al.gov.mb.asylum.ui.models.OrganizationDTO;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.models.TransferDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.TransferService;
import al.gov.mb.asylum.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class DfacTransferCompletedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	TransferSx req;
	List<TransferDTO> transfers;
	List<OrganizationDTO> organizations;
	
	
	
	
	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}
	public TransferSx getReq() {
		return req;
	}
	public void setReq(TransferSx req) {
		this.req = req;
	}
	public List<TransferDTO> getTransfers() {
		return transfers;
	}
	public void setTransfers(List<TransferDTO> transfers) {
		this.transfers = transfers;
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
		this.organizations = new HelperService().listOrganization();
		req = new TransferSx();
		req.setTransferStatusId(ITransferStatus.ARRIVED);
		
		search();
		
	}
	
	
	public void search()
	{
		try {
			
			this.transfers = new TransferService().searchTransfer(req);
			if(transfers == null || transfers.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka transferime te kryera",2);
			}
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public void clear()
	{
		req = new TransferSx();
		req.setTransferStatusId(ITransferStatus.ARRIVED);
		this.transfers = null;
	}
	
	
	
	public void onSelectionSelect(TransferDTO t)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(t.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	
	
	
	

}
