package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.forms.TransferSx;
import al.gov.mb.asylum.ui.models.Param;
import al.gov.mb.asylum.ui.models.TransferDTO;
import al.gov.mb.asylum.ui.models.TransferStatusDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.TransferService;

@ManagedBean
@ViewScoped
public class DrkmTransferBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	TransferSx req;
	List<TransferDTO> transfers;
	TransferDTO selectedTransfer;
	List<TransferStatusDTO> transferStatuses;
	
	
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


	public TransferDTO getSelectedTransfer() {
		return selectedTransfer;
	}


	public void setSelectedTransfer(TransferDTO selectedTransfer) {
		this.selectedTransfer = selectedTransfer;
	}	
	

	public List<TransferStatusDTO> getTransferStatuses() {
		return transferStatuses;
	}


	public void setTransferStatuses(List<TransferStatusDTO> transferStatuses) {
		this.transferStatuses = transferStatuses;
	}
	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}

	
	

	@PostConstruct
	public void load()
	{
		this.transferStatuses = new HelperService().listTransferStatus();
		this.req= new TransferSx();
		req.setMaxResult(50);
		this.transfers = new TransferService().searchTransfer(req);
	}
	
	
	public void clear()
	{
		this.req = new TransferSx();
		this.transfers = null;
		this.selectedTransfer = null;
	}
	
	public void search()
	{
		this.transfers = new TransferService().searchTransfer(req);
		this.selectedTransfer = null;
	}
	
	public void onSelectionSelect(TransferDTO t)
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("event_id", String.valueOf(t.getSelection().getEvent().getId())));
		nav.navigate("selection_view", params);
	}
	

}
