package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Inscription {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idinscription;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(nullable = false)
	private boolean acceptee = false;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<MotifRefus> motifsRefus = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "FORMATION_FK", nullable = false)
	private Formation formation;
	@ManyToOne
	@JoinColumn(name = "SALARIE_FK", nullable = false)
	private Salarie salarie;

	public Inscription() {
		super();
	}

	public Inscription(Date date) {
		super();
		this.date = date;
	}

	public int getIdinscription() {
		return idinscription;
	}

	public void setIdinscription(int idinscription) {
		this.idinscription = idinscription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isAcceptee() {
		return acceptee;
	}

	public void setAcceptee(boolean acceptee) {
		this.acceptee = acceptee;
	}	

	public List<MotifRefus> getMotifsRefus() {
		return motifsRefus;
	}

	public void setMotifsRefus(List<MotifRefus> motifsRefus) {
		this.motifsRefus = motifsRefus;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Salarie getSalarie() {
		return salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}

	@Override
	public String toString() {
		return "Inscription [idinscription=" + idinscription + ", date=" + date + ", acceptee=" + acceptee
				+ ", motifRefus=" + motifsRefus + ", formation=" + formation + ", salarie=" + salarie + "]";
	}

}