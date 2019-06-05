package al.gov.mb.asylum.ui.services;

import java.util.Date;
import java.util.List;

import al.gov.mb.asylum.ui.api.clients.StatisticClient;
import al.gov.mb.asylum.ui.models.KeyValue;


public class StatisticService {
	
	
	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to)
	{
		return new StatisticClient().registeredSelectionsByPeriod(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to)
	{
		return new StatisticClient().registeredSelectionsByOrganization(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByState(Date from, Date to)
	{
		return new StatisticClient().registeredSelectionsByState(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to)
	{
		return new StatisticClient().registeredSelectionsByGender(from, to);
	}
	
	public long childCountByPeriod(Date from, Date to)
	{
		return new StatisticClient().childCountByPeriod(from, to);
	}
	
	public long unaccompainedChildCountByPeriod(Date from, Date to)
	{
		return new StatisticClient().unaccompainedChildCountByPeriod(from, to);
	}
	
	public long personsInNeedCountByPeriod(Date from, Date to)
	{
		return new StatisticClient().personsInNeedCountByPeriod(from, to);
	}
	
	public long gonePersonsCountByPeriod(Date from, Date to)
	{
		return new StatisticClient().gonePersonsCountByPeriod(from, to);
	}
	
	public long refugeeCountByPeriod(Date from, Date to)
	{
		return new StatisticClient().refugeeCountByPeriod(from, to);
	}

	public long countAll(Date fromDate, Date toDate) {
		return new StatisticClient().countAll(fromDate, toDate);
	}

	public long extraProtectionCountByPeriod(Date from, Date to) {
		return new StatisticClient().extraProtectionCountByPeriod(from, to);
	}

	public long internationalProtectionCountByPeriod(Date from, Date to) {
		return new StatisticClient().internationalProtectionCountByPeriod(from, to);
	}

	public long temporaryProtectionCountByPeriod(Date from, Date to) {
		return new StatisticClient().temporaryProtectionCountByPeriod(from, to);
	}
	
	
	
	

}
