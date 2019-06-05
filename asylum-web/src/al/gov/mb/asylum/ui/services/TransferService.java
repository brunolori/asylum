package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.TransferClient;
import al.gov.mb.asylum.ui.forms.TransferForm;
import al.gov.mb.asylum.ui.forms.TransferSx;
import al.gov.mb.asylum.ui.models.SelectionDTO;
import al.gov.mb.asylum.ui.models.TransferDTO;

public class TransferService {
	
	
	public TransferDTO registerGoneSelection(SelectionDTO dto)
	{
		return new TransferClient().registerGoneSelection(dto);
	}
	
	public TransferDTO registerCheckOut(TransferDTO dto)
	{
		return new TransferClient().registerCheckOut(dto);
	}
	
	public void registerCheckOut(TransferForm dto)
	{
		 new TransferClient().registerCheckOut(dto);
	}
	
	public TransferDTO completeCheckIn(TransferDTO dto)
	{
		return new TransferClient().completeCheckIn(dto);
	}
	
	public List<TransferDTO> searchTransfer(TransferSx req)
	{
		return new TransferClient().searchTransfer(req);
	}
	
	public List<TransferDTO> getSelectionTransfers(Integer eventId)
	{
		return new TransferClient().getSelectionTransfers(eventId);
	}
	
	
	public List<SelectionDTO> getDrkmSelectionsForTransfer()
	{
		return new TransferClient().getDrkmSelectionsForTransfer();
	}
	
	public List<TransferDTO> searchGone(TransferSx req)
	{
		return new TransferClient().searchGone(req);
	}
	
	

}
