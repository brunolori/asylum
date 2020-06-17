package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.SelectionClient;
import al.gov.mb.asylum.ui.forms.SelectionForm;
import al.gov.mb.asylum.ui.forms.SelectionSx;
import al.gov.mb.asylum.ui.models.SelectionDTO;

public class SelectionService {

	
	public SelectionDTO registerSelection(SelectionForm form)
	{
		return new SelectionClient().registerSelection(form);
	}
	
	public List<SelectionDTO> searchSelection(SelectionSx req)
	{
		return new SelectionClient().searchSelection(req);
	}
	
	public SelectionDTO getSelectionByUniqueNo(String uniqueNo)
	{
		return new SelectionClient().getSelectionByUniqueNo(uniqueNo);
	}
	
	public SelectionDTO getSelectionByEventId(Integer eventId)
	{
		return new SelectionClient().getSelectionByEventId(eventId);
	}

	public SelectionDTO modifySelection(SelectionDTO selection) {
		return new SelectionClient().modifySelection(selection);
	}
	
	public List<SelectionDTO> getSelectionsNotGoneFromQkpa()
	{
		return new SelectionClient().getSelectionsNotGoneFromQkpa();
	}
	
	
	
}
