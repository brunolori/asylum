package al.gov.mb.asylum.ui.beans.qkpa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.ITransferStatus;
import al.gov.mb.asylum.ui.forms.TransferSx;
import al.gov.mb.asylum.ui.models.TransferDTO;
import al.gov.mb.asylum.ui.models.TransferStatusDTO;
import al.gov.mb.asylum.ui.services.TransferService;
import al.gov.mb.asylum.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class QkpaCheckInBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	List<TransferDTO> transfers;
	
	
	
	public NavBean getNav() {
		return nav;
	}

	public void setNav(NavBean nav) {
		this.nav = nav;
	}

	public List<TransferDTO> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<TransferDTO> transfers) {
		this.transfers = transfers;
	}

	
	
	@PostConstruct
	public void load()
	{
		loadCheckIn();
	}
	
	public void loadCheckIn()
	{
		TransferSx req = new TransferSx();
		req.setTransferStatusId(ITransferStatus.DEPARTED);
		this.transfers = new TransferService().searchTransfer(req);
	}
	
	public void checkIn(TransferDTO dto)
	{
		try {
			dto.setTransferStatus(new TransferStatusDTO(ITransferStatus.ARRIVED));
			new TransferService().completeCheckIn(dto);
			loadCheckIn();
			Messages.throwFacesMessage("Regjistrimi u krye me sekses!",1);
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	public void reject(TransferDTO dto)
	{
		try {
			dto.setTransferStatus(new TransferStatusDTO(ITransferStatus.REJECTED));
			new TransferService().completeCheckIn(dto);
			loadCheckIn();
			Messages.throwFacesMessage("Azilanti u refuzua",3);
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	
	
	

}
