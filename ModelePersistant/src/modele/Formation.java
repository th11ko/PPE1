package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Formation {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idformation;
	@Column(nullable = false, unique = true)
	private String code;
	@Column(nullable = false)
	private String intitule;
	@Column(nullable = false, length = 2000)
	private String presentation;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(nullable = false)
	private String lieu;
	@Column(nullable = false)
	private int duree;
	@Enumerated(EnumType.STRING)
	private ProfilMetier profilMetier;
	@Column(nullable = false)
	private int nombrePlacesPrevues;
	private int nombreInscrits = 0;
	@OneToMany(mappedBy = "formation")
	private List<Inscription> inscriptions = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "PREREQUIS_FK")
	private Formation prerequis;
	@OneToMany
	@JoinColumn(name = "FORMATION_FK", nullable = false)
	private List<Avis> avis = new ArrayList<>();

	public Formation() {
		super();
	}

	public Formation(String code, String intitule, String presentation, Date date, String lieu, int duree, Formation prerequis,
			ProfilMetier profilMetier, int nombrePlacesPrevues) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.presentation = presentation;
		this.date = date;
		this.lieu = lieu;
		this.duree = duree;
		this.prerequis = prerequis;
		this.profilMetier = profilMetier;
		this.nombrePlacesPrevues = nombrePlacesPrevues;
	}
	
	public void ajouterInscription(Inscription inscription) {
		inscriptions.add(inscription);
		inscription.setFormation(this);
	}
	
	public void miseAjourNombreInscrits() {
		nombreInscrits++;
	}
	
	public boolean isComplete() {
		return (nombreInscrits == nombrePlacesPrevues);
	}

	public int getIdformation() {
		return idformation;
	}

	public void setIdformation(int idformation) {
		this.idformation = idformation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public ProfilMetier getProfilMetier() {
		return profilMetier;
	}

	public void setProfilMetier(ProfilMetier profilMetier) {
		this.profilMetier = profilMetier;
	}

	public int getNombrePlacesPrevues() {
		return nombrePlacesPrevues;
	}

	public void setNombrePlacesPrevues(int nombrePlacesPrevues) {
		this.nombrePlacesPrevues = nombrePlacesPrevues;
	}

	public int getNombreInscrits() {
		return nombreInscrits;
	}

	public void setNombreInscrits(int nombreInscrits) {
		this.nombreInscrits = nombreInscrits;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Formation getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(Formation prerequis) {
		this.prerequis = prerequis;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	@Override
	public String toString() {
		return "Formation [idformation=" + idformation + ", code=" + code + ", intitule=" + intitule + ", presentation="
				+ presentation + ", date=" + date + ", lieu=" + lieu + ", duree=" + duree + ", profilMetier="
				+ profilMetier + ", nombrePlacesPrevues=" + nombrePlacesPrevues + ", nombreInscrits=" + nombreInscrits
				+ ", inscriptions=" + inscriptions + ", prerequis=" + prerequis + ", avis=" + avis + "]";
	}

}