package al.gov.mb.asylum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.gov.mb.asylum.dao.EvidenceDAO;
import al.gov.mb.asylum.entities.tims.Evidence;

@Service
public class EvidenceService {
	
	
	@Autowired EvidenceDAO evidenceDAO;
	
	public List<Evidence> getEventEvidences(Integer eventId)
	{
		return evidenceDAO.getEventEvidences(eventId);
	}
	
	

}
