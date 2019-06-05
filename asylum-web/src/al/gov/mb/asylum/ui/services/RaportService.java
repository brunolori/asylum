package al.gov.mb.asylum.ui.services;

import java.util.Date;
import java.util.List;

import al.gov.mb.asylum.ui.api.clients.RaportClient;
import al.gov.mb.asylum.ui.models.KeyValue;

public class RaportService {
	
	
	public long countAll(Date fromDate, Date toDate, Integer organizationId)
	{
		return new RaportClient().countAll(fromDate, toDate, organizationId);
	}
	
	public long childCountByPeriod(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().childCountByPeriod(from, to, organizationId);
	}
	
	public long gonePersonsCountByPeriod(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().gonePersonsCountByPeriod(from, to, organizationId);
	}
	
	public long returnedPersonsCountByPeriod(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().returnedPersonsCountByPeriod(from, to, organizationId);
	}
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().registeredSelectionsByGender(from, to, organizationId);
	}		
	
	public List<KeyValue> registeredSelectionsByState(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().registeredSelectionsByState(from, to, organizationId);
	}
	
	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to)
	{
		return new RaportClient().registeredSelectionsByOrganization(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().registeredSelectionsByPeriod(from, to, organizationId);
	}
	
	public long countAllAsylants(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().countAllAsylants(from, to, organizationId);
	}
	
	public long countAllTrafficVictims(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().countAllTrafficVictims(from, to, organizationId);
	}
	
	public long countAllIrregularImigrants(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().countAllIrregularImigrants(from, to, organizationId);
	}
	
	public List<KeyValue> registeredSelectionsByPlaceType(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().registeredSelectionsByPlaceType(from, to, organizationId);
	}
	
	public List<KeyValue> registeredDecisionsByType(Date from, Date to, Integer organizationId)
	{
		return new RaportClient().registeredDecisionsByType(from, to, organizationId);
	}
	
}
