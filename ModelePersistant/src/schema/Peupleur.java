package schema;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Catalogue;
import modele.Formation;
import modele.ProfilMetier;

public class Peupleur {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schema");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Catalogue catalogue = new Catalogue("2020");
		Formation f1 = new Formation("COM01", "Observer différemment et Mieux Communiquer", 
				"Intégrer les composantes de la communication\n" + 
				"Maîtriser la communication verbale et non-verbale\n" + 
				"Etre attentif au dit comme au non-dit\n" + 
				"Utiliser son intuition", 
				sdf.parse("14/01/2020"), "salle sf05", 1, null, ProfilMetier.PAS_DE_PROFIL, 10);
		
		Formation f2 = new Formation("NUM01", "Développement d'applications pour mobiles (niveau 1)", 
														"développer des applications mobiles Android\n" + 
														"avec le SDK \"Android Studio\" en maitrisant\n" + 
														"la structure d’une application",  
													    sdf.parse("25/01/2020"), "labo01", 2, null, ProfilMetier.NUMERIQUE, 8);
		
		Formation f3 = new Formation("NUM02", "Développement d'applications pour mobiles (niveau 2)", 
				"développer des applications mobiles Android\n" + 
				"avec le SDK \"Android Studio\" en maitrisant\n" + 
				"la structure d’une application",  
			    sdf.parse("15/02/2020"), "labo01", 3, f2, ProfilMetier.NUMERIQUE, 8);
		
		
		catalogue.ajouterFormation(f1);
		catalogue.ajouterFormation(f2);
		catalogue.ajouterFormation(f3);
		
		System.out.println(catalogue.rechercherAvecCode("NUM02").get().getIntitule());
		System.out.println("profil métier");
		catalogue.rechercherAvecProfilMetier(ProfilMetier.PAS_DE_PROFIL).stream().map(f -> f.get()).forEach(System.out::println);
		System.out.println("prérequis");
		catalogue.getListePrerequis(f3).stream().map(f -> f.getIntitule()).forEach(System.out::println);
		
		
		em.persist(catalogue);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
