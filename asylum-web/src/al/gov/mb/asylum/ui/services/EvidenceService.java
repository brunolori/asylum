package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.EvidenceClient;
import al.gov.mb.asylum.ui.models.EvidenceDTO;

public class EvidenceService {

	public List<EvidenceDTO> getEventEvidences(Integer eventId) {

		return new EvidenceClient().getEventEvidences(eventId);
		
	}

}
