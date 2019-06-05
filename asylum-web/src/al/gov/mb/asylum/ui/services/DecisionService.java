package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.DecisionClient;
import al.gov.mb.asylum.ui.models.DecisionDTO;

public class DecisionService {

	
	
	public DecisionDTO registerDecision(DecisionDTO dto)
	{
		return new DecisionClient().registerDecision(dto);
	}
	
	public DecisionDTO updateDecision(DecisionDTO dto)
	{
		return new DecisionClient().updateDecision(dto);
	}
	
	public List<DecisionDTO> getSelectionDecisions(Integer eventId)
	{
		return new DecisionClient().getSelectionDecisions(eventId);
	}
	
	
}
