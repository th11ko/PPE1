package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Catalogue {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcatalogue;
	@Column(nullable = false)
	private String annee;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATALOGUE_FK", nullable = false)
	private List<Formation> formations = new ArrayList<>();

	public Catalogue() {
		super();
	}

	public Catalogue(String annee) {
		super();
		this.annee = annee;
	}
	
	public Optional<Formation> rechercherAvecCode(String code) {
		Optional<Formation> retour = Optional.empty();
		retour = formations.stream().filter(f -> f.getCode().equals(code)).findAny();
		return retour;
	}
	
	public Optional<Formation> rechercherAvecIntitule(String intitule) {
		Optional<Formation> retour = Optional.empty();
		retour = formations.stream().filter(f -> f.getIntitule().equals(intitule)).findAny();
		return retour;
	}
	
	public List<Optional<Formation>> rechercherAvecProfilMetier(ProfilMetier profil) {
		List<Optional<Formation>> retour = new ArrayList<>();
		retour = formations.stream().filter(f -> f.getProfilMetier().equals(profil)).map(f -> Optional.of(f)).collect(Collectors.toList());		
		return retour;
	}
	
	public List<Formation> getListePrerequis(Formation formation) {
		List<Formation> tousLesPrerequis = new ArrayList<>();
		Formation courante = formation.getPrerequis();
		while (courante != null) {
			tousLesPrerequis.add(courante);
			courante = courante.getPrerequis();	
		}		
		return tousLesPrerequis;
	}
	
	public List<Avis> getListeAvis(Formation formation) {
		return formation.getAvis();
	}
	
	public void ajouterFormation(Formation formation) {
		formations.add(formation);
	}

	public int getIdcatalogue() {
		return idcatalogue;
	}

	public void setIdcatalogue(int idcatalogue) {
		this.idcatalogue = idcatalogue;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Catalogue [idcatalogue=" + idcatalogue + ", annee=" + annee + ", formations=" + formations + "]";
	}

}
