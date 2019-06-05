package al.gov.mb.asylum.dao;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IAsylantStatus;
import al.gov.mb.asylum.constants.IIrStatus;
import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.models.KeyValue;


@Repository
@SuppressWarnings("unchecked")
public class StatisticDAO {
	
	
	@PersistenceContext
	EntityManager em;
	

	//******** AZILANTS ******************************
	public List<KeyValue> registeredSelectionsByPeriod(Date from, Date to)
	{
		return em.createQuery("SELECT new "+KeyValue.class.getName()+"(trunc(s.recordDate) as dt,count(s)) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to GROUP BY trunc(s.recordDate) ORDER BY dt")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.getResultList();
	}
	
	public List<KeyValue> registeredSelectionsByOrganization(Date from, Date to)
	{
		return em.createQuery("SELECT new "+KeyValue.class.getName()+"(s.event.organization.tag as org,count(s)) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to GROUP BY s.event.organization.tag ORDER BY org")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.getResultList();
	}
	
	public List<KeyValue> registeredSelectionsByState(Date from, Date to)
	{
		return em.createQuery("SELECT new "+KeyValue.class.getName()+"(s.person.codeNationality as state,count(s) as cnt) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to GROUP BY s.person.codeNationality ORDER BY cnt DESC,state")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.getResultList();
	}
	
	public List<KeyValue> registeredSelectionsByGender(Date from, Date to)
	{
		return em.createQuery("SELECT new "+KeyValue.class.getName()+"(s.person.gender as gender,count(s)) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to GROUP BY s.person.gender")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.getResultList();
	}
	
	public long childCountByPeriod(Date from, Date to)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18);
		cal.add(Calendar.DATE, -1);
		
		Date dob = cal.getTime();
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.person.dob >= :dob")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("dob", dob)
				.getSingleResult();
	}
	
	public long unaccompainedChildCountByPeriod(Date from, Date to)
	{
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.unaccompainedChild=:uac")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("uac", IStatus.YES)
				.getSingleResult();
	}
	
	public long personsInNeedCountByPeriod(Date from, Date to)
	{
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.inNeed=:inn")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("inn", IStatus.YES)
				.getSingleResult();
	}
	
	public long gonePersonsCountByPeriod(Date from, Date to)
	{
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.currentLocation.id=:clid")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("clid", IOrganization.GONE_ID)
				.getSingleResult();
	}
	
	public long returnedPersonsCountByPeriod(Date from, Date to)
	{
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.returned=:rtn")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("rtn", IStatus.YES)
				.getSingleResult();
	}
	
	
	public long refugeeCountByPeriod(Date from, Date to)
	{
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.asylantStatus.id=:ass")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("ass", IAsylantStatus.REFUGEE)
				.getSingleResult();
	}

	public long countAll(Date from, Date to) {
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.getSingleResult();
	}

	public long temporaryProtectionCountByPeriod(Date from, Date to) {
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.asylantStatus.id=:ass")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("ass", IAsylantStatus.TEMPORARY_PROTECTION)
				.getSingleResult();
	}

	public long internationalProtectionCountByPeriod(Date from, Date to) {
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.asylantStatus.id=:ass")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("ass", IAsylantStatus.INTERNATIONAL_PROTECTION)
				.getSingleResult();
	}

	public long extraProtectionCountByPeriod(Date from, Date to) {
		return (Long) em.createQuery("SELECT count(s) FROM Selection s "
				+ "WHERE s.irStatus.id=:irs AND TRUNC(s.recordDate)>=:from AND TRUNC(s.recordDate)<=:to and s.asylantDetails.asylantStatus.id=:ass")
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("ass", IAsylantStatus.SUBSIDIARY_PROTECTION)
				.getSingleResult();
	}
	
	//*************** ALL *********************
	
	
	
	
	
	
	
	
	

}
