package al.gov.mb.asylum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IIrStatus;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.constants.ITransferStatus;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.forms.SelectionSx;
import al.gov.mb.asylum.utils.DateUtil;
import al.gov.mb.asylum.utils.StringUtil;

@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class SelectionDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	public void addMissingDetails()
	{
		Connection con = null;
		try{  

			
			
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        TimeZone.setDefault(timeZone);
        con = DriverManager.getConnection("jdbc:oracle:thin:@db-oracle-scan.asp.gov.al:1521/tims", "VEIZAJB", "VEIZAJB");
                
        String sql = "INSERT INTO asylum.asylant_details(event_id) SELECT event_id FROM fer.IR_SELECTION where event_id NOT IN (select event_id FROM asylum.asylant_details)";
       
		  
		Statement stmt=con.createStatement();  
		  
		stmt.execute(sql);   
		
		con.close();  
		  
		
		}catch(Exception e){ 
			e.printStackTrace();
		}finally{
			try {
	            if (con != null) {
	                if (!con.isClosed()) {
	                    con.close();
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
	
	
	}
	
	
	
	
	
	
	
	
	public List<Selection> searchSelection(SelectionSx req)
	{

		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Selection t WHERE 1=1 ";
		if(StringUtil.isValid(req.getDocNo()) || StringUtil.isValid(req.getDocTypeCode()))
		{
			sql = "SELECT t FROM Selection t JOIN Document d on t.event.id = d.idPK.eventId WHERE 1=1 ";
		}
		String order = "ORDER BY t.recordDate DESC";
		
		if(StringUtil.isValid(req.getUname()))
		{
			sql += "AND t.recordUser=:uname ";
			params.put("uname", req.getUname());
		}
		if(StringUtil.isValid(req.getUniqueNo()))
		{
			sql += "AND t.event.uniqurNumber=:unq ";
			params.put("unq", req.getUniqueNo().trim().toUpperCase());
		}
		
		if(StringUtil.isValid(req.getName()))
		{
			sql += "AND upper(t.person.name) like :name ";
			params.put("name", req.getName().trim().toUpperCase());
		}
		if(StringUtil.isValid(req.getSurname()))
		{
			sql += "AND upper(t.person.surname) like :surname ";
			params.put("surname", req.getSurname().trim().toUpperCase());
		}
		if(req.getDob() != null)
		{
			sql += "AND t.person.dob=:dob ";
			params.put("dob", req.getDob());
		}
		if(req.getGender() != null)
		{
			sql += "AND t.person.gender=:gender ";
			params.put("gender", req.getGender());
		}
		if(req.getFromAge() != null)
		{
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -1*req.getFromAge());
			
			sql += "AND t.person.dob<=:fage ";
			params.put("fage", cal.getTime());
		}
		if(req.getToAge() != null)
		{
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -1*req.getToAge());
			
			sql += "AND t.person.dob>=:tage ";
			params.put("tage", cal.getTime());
		}
		if(StringUtil.isValid(req.getNationalityCode()))
		{
			sql += "AND t.person.codeNationality=:nation ";
			params.put("nation", req.getNationalityCode());
		}
		if(req.getInNeed() != null)
		{
			sql += "AND t.asylantDetails.inNeed=:inNeed ";
			params.put("inNeed", req.getInNeed());
		}
		if(req.getReturned() != null)
		{
			sql += "AND t.asylantDetails.returned=:rtn ";
			params.put("rtn", req.getReturned());
		}
		if(req.getWithIncomes() != null)
		{
			sql += "AND t.asylantDetails.withIncomes=:withIncomes ";
			params.put("withIncomes", req.getWithIncomes());
		}
		if(req.getUnaccompainedChild() != null)
		{
			sql += "AND t.asylantDetails.unaccompainedChild=:unacc ";
			params.put("unacc", req.getUnaccompainedChild());
		}
		
		if(req.getAsylantStatusId() != null)
		{
			sql += "AND t.asylantDetails.asylantStatus.id=:ast ";
			params.put("ast", req.getAsylantStatusId());
		}
		if(req.getAsylantStageId() != null)
		{
			sql += "AND t.asylantDetails.asylantStage.id=:asg ";
			params.put("asg", req.getAsylantStageId());
		}
		
		if(req.getActualLocationId() != null)
		{
			sql += "AND t.asylantDetails.currentLocation.id=:cur_loc ";
			params.put("cur_loc", req.getActualLocationId());
		}
		
		if(req.getTransferStatusId() != null)
		{
			sql += "AND t.asylantDetails.transferStatus.id=:trans_stat ";
			params.put("trans_stat", req.getTransferStatusId());
		}
		
		if(StringUtil.isValid(req.getDocNo()))
		{
			sql += "AND upper(d.idPK.travelDocNo) like :dno ";
			params.put("dno", req.getDocNo().trim().toUpperCase());
		}
		
		if(StringUtil.isValid(req.getDocTypeCode()))
		{
			sql += "AND d.idPK.codeTypeTravelDoc = :td ";
			params.put("td", req.getDocTypeCode());
		}
		
		if(req.getOrganizationId() != null)
		{
			sql += "AND t.event.organization.id=:oid ";
			params.put("oid", req.getOrganizationId());
		}
		if(req.getHandedOverId() != null)
		{
			sql += "AND t.handedOver.id=:hoid ";
			params.put("hoid", req.getHandedOverId());
		}
		if(req.getFromDate() != null)
		{
			sql += "AND TRUNC(t.event.eventDate)>=:from ";
			params.put("from", req.getFromDate());
		}
		if(req.getToDate() != null)
		{
			sql += "AND TRUNC(t.event.eventDate)<=:to ";
			params.put("to", req.getToDate());
		}
		if(StringUtil.isValid(req.getIrStatusCode()))
		{
			sql += "AND t.irStatus.id=:irs ";
			params.put("irs", req.getIrStatusCode());
		}
		
		sql += order;
		
		EntityGraph eg = em.createEntityGraph(Selection.class);
		eg.addAttributeNodes("event");
		eg.addAttributeNodes("asylantDetails");
		eg.addAttributeNodes("person");
		eg.addAttributeNodes("handed");
		eg.addAttributeNodes("irStatus");
		
		Query q = em.createQuery(sql).setHint("javax.persistence.loadgraph", eg);
		Iterator it = params.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}
		
		
		if(req.getFirstResult() != null)
		{
			q.setFirstResult(req.getFirstResult());
		}
		
		if(req.getMaxResult() != null)
		{
			q.setMaxResults(req.getMaxResult());
		}
		
		
		
		return q.getResultList();
	}








	public List<Selection> notGoneFromQkpa() {

		
		
		EntityGraph eg = em.createEntityGraph(Selection.class);
		eg.addAttributeNodes("event");
		eg.addAttributeNodes("asylantDetails");
		eg.addAttributeNodes("person");
		eg.addAttributeNodes("handed");
		eg.addAttributeNodes("irStatus");
		
		Query q = em.createQuery("FROM Selection s LEFT JOIN s.event e WHERE s.irStatus.id=:irs AND s.selectionDate>=:sdt and s.event IS NOT NULL " 
				+ "AND s.id NOT IN (SELECT t.selection.id FROM Transfer t WHERE t.status=:tst AND t.transferStatus.id = :ts) "
				+ "ORDER BY s.selectionDate DESC")
				.setHint("javax.persistence.loadgraph", eg)
				.setParameter("sdt", DateUtil.formatStringToDate("01.10.2019"))
				.setParameter("irs", IIrStatus.AZILANT)
				.setParameter("tst", IStatus.ACTIVE)
				.setParameter("ts", ITransferStatus.GONE);
		
		return q.getResultList();
		
	}
	
	
	

}
