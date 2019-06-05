package al.gov.mb.asylum.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class BiometricDAO {
	
	@PersistenceContext
	EntityManager em;

	
	public boolean exists(String uniqueNo)
	{
		return ((long)em.createQuery("SELECT COUNT(b) FROM Biometric b WHERE b.uniqueNumber=:un")
				.setParameter("un", uniqueNo).getSingleResult())>0;
	}
	
	
	
}
