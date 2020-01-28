package modele;

public enum MotifRefus {

	FORMATION_COMPLETE("la formation est complète"), 
	PROFIL_METIER("le profil métier n'est pas adapté"),
	COMPTE_PERSONNEL_DE_FORMATION("compte personnel de formation insuffisant ou épuisé"),
	ABSENCE_PREREQUIS("les prérequis ne sont pas respectés");

	private MotifRefus(String libelle) {
		this.libelle = libelle;
	}

	private String libelle;

	public String getLibelle() {
		return libelle;
	}

}
