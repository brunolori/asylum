package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.InstitutionOpinionClient;
import al.gov.mb.asylum.ui.models.InstitutionOpinionDTO;

public class InstitutionOpinionService {
	
	
	public InstitutionOpinionDTO registerInstitutionOpinion(InstitutionOpinionDTO dto)
	{
		return new InstitutionOpinionClient().registerInstitutionOpinion(dto);
	}
	

	
	public List<InstitutionOpinionDTO> getSelectionInstitutionOpinions(Integer eventId)
	{
		return new InstitutionOpinionClient().getSelectionInstitutionOpinions(eventId);
	}
	
	
	
	
}
