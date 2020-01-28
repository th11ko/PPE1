package modele;

public enum ProfilMetier {
	
	ADMINISTRATIF("les métiers administratifs"), 
	COMMUNICATION("les métiers de la communication"), 
	GESTION("les métiers de la gestion"), 
	NUMERIQUE("les métiers du numérique"), 
	RESSOURCES_HUMAINES("les métiers des ressources humaines"),
	PAS_DE_PROFIL("pas de profil métier exigé");

	ProfilMetier(String libelle) {
		this.libelle = libelle;
	}

	private String libelle;

	public String getLibelle() {
		return libelle;
	}

}
