package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.AsylumDecisionClient;
import al.gov.mb.asylum.ui.forms.AsylumDecisionSx;
import al.gov.mb.asylum.ui.models.AsylumDecisionDTO;

public class AsylumDecisionService {

	public AsylumDecisionDTO registerDecision(AsylumDecisionDTO dto) {

		return new AsylumDecisionClient().registerDecision(dto);
		
	}

	public List<AsylumDecisionDTO> searchAsylumDecision(AsylumDecisionSx req) {

		return new AsylumDecisionClient().search(req);
		
	}

}
