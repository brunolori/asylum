package al.gov.mb.asylum.ui.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import al.gov.mb.asylum.ui.models.OfficerDTO;
import al.gov.mb.asylum.ui.utils.StringUtil;




public class RimsDAO {

	public List<OfficerDTO> searchOfficer(String rimsId, String name, String surname){ 
		
		
		Connection con = null;
		try{  

			
			
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        TimeZone.setDefault(timeZone);
        con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.3:1521:prod", "apps", "apps");
                
        String sql = "select "
                + "t.employee_number as \"id_officer\", "
                + "t.first_name as \"name\", "
                + "t.last_name as \"surname\", "
                + "o.organization_id as \"org_id\", "
                + "o.name as \"org_name\", "
                + "g.name as \"grade\" "
                + "from "
                + "hr.PER_ALL_PEOPLE_F t, "
                + "hr.per_all_assignments_f a, "
                + "HR_ALL_ORGANIZATION_UNITS_TL o, "
                + "hr.PER_GRADES g "
                + "where "
                + "a.person_id=t.person_id and a.grade_id=g.grade_id "
                + "and a.organization_id=o.organization_id and o.language='SQ' "
                + "and t.effective_end_date>sysdate and a.effective_end_date>sysdate ";
        
        if(StringUtil.isValid(rimsId)) 
        {
          sql+="and UPPER(t.employee_number) like '"+rimsId.trim().toUpperCase()+"' ";
        }
        if(StringUtil.isValid(name)) 
        {
          sql+="and UPPER(t.first_name) like '"+name.trim().toUpperCase()+"' ";
        }
        if(StringUtil.isValid(surname))
        {
        	sql+="and UPPER(t.last_name) like '"+surname.trim().toUpperCase()+"' ";
        }
        
		  
		Statement stmt=con.createStatement();  
		  
		ResultSet rs=stmt.executeQuery(sql);  
		
		List<OfficerDTO> list = new ArrayList<>();
		
		while(rs.next())  
		{
			
			OfficerDTO officer = new OfficerDTO();
			officer.setOfficerId(rs.getString("id_officer"));
			officer.setGrade(rs.getString("grade"));
			officer.setName(rs.getString("name"));
			officer.setSurname(rs.getString("surname"));
			officer.setOrganization(rs.getString("org_name"));
			
			list.add(officer);
		}
		  
		
		con.close();  
		  
		return list;
		
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
		
		return null;
	
	}
	
	
	
}
