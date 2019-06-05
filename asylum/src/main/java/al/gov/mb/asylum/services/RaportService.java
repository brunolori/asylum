package al.gov.mb.asylum.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.gov.mb.asylum.constants.IIrStatus;
import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.RaportDAO;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.models.KeyValue;



@Service
public class RaportService {
	
	@Autowired RaportDAO raportDAO;
	@Autowired CrudDAO crudDAO;
	
	
	
	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{				
				organizationId = u.getOrganization().getId();
			}
		}
		
		
		return raportDAO.registeredSelectionsByPeriod(from, to, organizationId);
	}
	
	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to)
	{
		return raportDAO.registeredSelectionsByOrganization(from, to);
	}
			
	public List<KeyValue> registeredSelectionsByState(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.registeredSelectionsByState(from, to, organizationId);
	}
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.registeredSelectionsByGender(from, to, organizationId);
	}
	
	public long childCountByPeriod(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.childCountByPeriod(from, to, organizationId);
		
	}
		
	public long countAll(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.countAll(from, to, organizationId);
		
		
	}
	
	public long countAllAsylants(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.countAllByIrStatus(from, to, IIrStatus.AZILANT, organizationId);
		
		
	}
	
	public long countAllTrafficVictims(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.countAllByIrStatus(from, to, IIrStatus.TRAFFIC_VICTIM, organizationId);
		
		
	}
	
	public long countAllIrregularImigrants(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.countAllByIrStatus(from, to, IIrStatus.IRREGULAR_IMIGRANT, organizationId);
		
	}
				
	public List<KeyValue> registeredSelectionsByPlaceType(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.registeredSelectionsByPlaceType(from, to, organizationId);
	}
	
	public List<KeyValue> registeredDecisionsByType(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.registeredDecisionsByType(from, to, organizationId);
	}
	
	public long gonePersonsCountByPeriod(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.gonePersonsCountByPeriod(from, to, organizationId);
	}
	
	public long returnedPersonsCountByPeriod(Date from, Date to, Integer organizationId, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				organizationId = u.getOrganization().getId();
			}
		}
		
		return raportDAO.returnedPersonsCountByPeriod(from, to, organizationId);
		
		
	}
	

}
