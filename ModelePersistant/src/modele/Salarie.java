package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salarie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idsalarie;
	@Column(nullable = false, unique = true)
	private String matricule;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private int comptePersonnelDeFormation = 10;
	@Enumerated
	@Column(nullable = false)
	private ProfilMetier profilMetier;
	@OneToMany(mappedBy = "salarie")
	private List<Inscription> inscriptions = new ArrayList<>();

	public Salarie() {
		super();
	}

	public Salarie(String matricule, String nom, String prenom, int comptePersonnelDeFormation, ProfilMetier profilMetier) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.comptePersonnelDeFormation = comptePersonnelDeFormation;
		this.profilMetier = profilMetier;
	}

	public int getIdsalarie() {
		return idsalarie;
	}

	public void setIdsalarie(int idsalarie) {
		this.idsalarie = idsalarie;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getComptePersonnelDeFormation() {
		return comptePersonnelDeFormation;
	}

	public void setComptePersonnelDeFormation(int comptePersonnelDeFormation) {
		this.comptePersonnelDeFormation = comptePersonnelDeFormation;
	}

	public ProfilMetier getProfilMetier() {
		return profilMetier;
	}

	public void setProfilMetier(ProfilMetier profilMetier) {
		this.profilMetier = profilMetier;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

}
