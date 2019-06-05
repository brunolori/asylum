package al.gov.mb.asylum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.gov.mb.asylum.dao.OfficerDAO;
import al.gov.mb.asylum.entities.tims.Officer;
import al.gov.mb.asylum.forms.OfficerSx;

@Service
public class OfficerService {
	
	
	@Autowired OfficerDAO officerDAO;
	
	public List<Officer> getEventOfficers(Integer eventId)
	{
		return officerDAO.getEventOfficers(eventId);
				
	}

	
	
	public List<Officer> searchOfficerRims(OfficerSx req)
	{
		return null;
	}
	
	
}
