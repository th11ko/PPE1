package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avis {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idavis;
	private int nombreEtoiles;
	@ManyToOne
	@JoinColumn(name = "SALARIE_FK", nullable = false)
	private Salarie salarie;

	public Avis() {
		super();
	}	

	public int getIdavis() {
		return idavis;
	}

	public void setIdavis(int idavis) {
		this.idavis = idavis;
	}

	public int getNombreEtoiles() {
		return nombreEtoiles;
	}

	public void setNombreEtoiles(int nombreEtoiles) {
		this.nombreEtoiles = nombreEtoiles;
	}

	public Salarie getSalarie() {
		return salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}
}
