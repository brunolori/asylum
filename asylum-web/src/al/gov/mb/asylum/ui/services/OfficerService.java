package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.OfficerClient;
import al.gov.mb.asylum.ui.forms.OfficerSx;
import al.gov.mb.asylum.ui.jdbc.RimsDAO;
import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.utils.StringUtil;

public class OfficerService {
	
	
	public List<OfficerDTO> getEventOfficers(Integer eventId)
	{
		return new OfficerClient().getEventOfficers(eventId);
	}
	
	public List<OfficerDTO> searchOfficer(OfficerSx req)
	{
		String rimsId = null;
		String name = null;
		String surname = null;
		
		if(StringUtil.isValid(req.getRimsNo()))
		{
			rimsId = req.getRimsNo();
		}
		else if(StringUtil.isValid(req.getFullname()))
		{
			if(req.getFullname().length()<3)
			{
				return null;
			}
			String[] val = req.getFullname().split(" ", -1);
			if(val != null)
			{
				name=val[0]+"%";
				if(val.length>1)
				{
					surname=val[1]+"%";
				}
			}			
		}
		else
		{
			if(StringUtil.isValid(req.getName()))
			{
				name = req.getName();
			}
			if(StringUtil.isValid(req.getSurname()))
			{
				surname = req.getSurname();
			}
		}
		
		return new RimsDAO().searchOfficer(rimsId, name, surname);
	}

	public OfficerDTO findOfficerById(String value) {
		OfficerSx req = new OfficerSx();
		
		req.setRimsNo(value);
		
		List<OfficerDTO> list = searchOfficer(req);
		
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}
	

}
