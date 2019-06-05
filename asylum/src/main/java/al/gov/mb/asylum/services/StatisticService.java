package al.gov.mb.asylum.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.gov.mb.asylum.dao.StatisticDAO;
import al.gov.mb.asylum.models.KeyValue;

@Service
public class StatisticService {
	
	
	@Autowired
	StatisticDAO statisticDAO;
	
	
	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to)
	{
		return statisticDAO.registeredSelectionsByPeriod(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to)
	{
		return statisticDAO.registeredSelectionsByOrganization(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByState(Date from, Date to)
	{
		return statisticDAO.registeredSelectionsByState(from, to);
	}
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to)
	{
		return statisticDAO.registeredSelectionsByGender(from, to);
	}
	
	public long childCountByPeriod(Date from, Date to)
	{
		return statisticDAO.childCountByPeriod(from, to);
	}
	
	public long unaccompainedChildCountByPeriod(Date from, Date to)
	{
		return statisticDAO.unaccompainedChildCountByPeriod(from, to);
	}
	
	public long personsInNeedCountByPeriod(Date from, Date to)
	{
		return statisticDAO.personsInNeedCountByPeriod(from, to);
	}
	
	public long gonePersonsCountByPeriod(Date from, Date to)
	{
		return statisticDAO.gonePersonsCountByPeriod(from, to);
	}
	
	public long refugeeCountByPeriod(Date from, Date to)
	{
		return statisticDAO.refugeeCountByPeriod(from, to);
	}

	public long countAll(Date fromDate, Date toDate) {
		return statisticDAO.countAll(fromDate, toDate);
	}

	public long temporaryProtectionCountByPeriod(Date from, Date to) {
		return statisticDAO.temporaryProtectionCountByPeriod(from, to);
	}

	public long internationalProtectionCountByPeriod(Date from, Date to) {
		return statisticDAO.internationalProtectionCountByPeriod(from, to);
	}

	public long extraProtectionCountByPeriod(Date from, Date to) {
		return statisticDAO.extraProtectionCountByPeriod(from, to);
	}

	public long returnedPersonsCountByPeriod(Date from, Date to) {
		return statisticDAO.returnedPersonsCountByPeriod(from, to);
	}
	
	
	
}
