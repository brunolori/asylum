package al.gov.mb.asylum.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.Organization;



@Repository
@SuppressWarnings("unchecked")
public class UserDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	
	public User findByUsername(String uname)
	{
		
		User u = em.find(User.class, uname);
		if(u != null){
			return u;
		}
		
		List<Object[]> portals = em.createNativeQuery("select t.username,o.forename,o.surname, o.org_structure_id,t.active " + 
				"from TIMSPORTAL.USERS t " + 
				"join timsportal.officer o on t.officer_id=o.id join timsportal.org_structure s on o.org_structure_id=s.id " + 
				"where upper(t.username) = '"+uname.trim().toUpperCase()+"' " + 
				"and t.id in (select ur.user_id from TIMSPORTAL.user_role ur join timsportal.role r on ur.role_id=r.id where r.module_id = 3)")
				.getResultList();
				
		
		if(portals != null && !portals.isEmpty())
		{
			Object[] o = portals.get(0);
			if(o != null && o.length>0)
			{
			    u = new User();
				u.setUsername((String)o[0]);
				u.setName((String) o[1]);
				u.setSurname((String) o[2]);
				Organization org = em.find(Organization.class, ((BigDecimal)o[3]).intValue());
				u.setOrganization(org);
				u.setStatus(((BigDecimal)o[4]).intValue());
				u.setRole(IRole.DRKM);
				
				return u;
			}
		}
		
		return null;
	}
	
	

}
