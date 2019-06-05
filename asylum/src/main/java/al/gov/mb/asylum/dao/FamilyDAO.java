package al.gov.mb.asylum.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class FamilyDAO {
	
	@PersistenceContext
	EntityManager em;

}
