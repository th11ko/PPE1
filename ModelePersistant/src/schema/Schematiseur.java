package schema;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Schematiseur {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schema");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
