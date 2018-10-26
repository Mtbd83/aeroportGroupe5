package model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="seqIdvol",sequenceName="seq_id_vol", initialValue=50,allocationSize=1)
public class Vol {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqIdvol")
	@Column(name="id_vol",length =100)
	private Integer idVol;
	@Column(name="date_depart",length =100)
	private Date dateDepart;
	@Column(name="date_arrivee",length =100)
	private Date dateArrivee;
	@Column(name="heure_depart",length =100)
	private Time heureDepart;
	@Column(name="heure_arrivee",length =100)
	private Time heureArrivee;
//	@OneToMany(mappedBy="key.vol")
//	@Column(name="compagnie",length =100)
//	private CompagnieVol compagnieVol;
//	@ManyToOne
//	@JoinColumn(name="id_aeroport_depart")
//	@Column(name="aeroport_depart",length =100)
//	private Aeroport aeroportDepart;
//	@ManyToOne
//	@JoinColumn(name="id_aeroport_arrivee")
//	@Column(name="aeroport_arrivee",length =100)
//	private Aeroport aeroportArrivee;
	@Version
	@Column(name="version",length =10)
	private int version;
	
	public Vol() {
		
	}

	public Integer getIdVol() {
		return idVol;
	}

	public void setIdVol(Integer idVol) {
		this.idVol = idVol;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Time getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

//	public Compagnie getCompagnie() {
//		return compagnie;
//	}
//
//	public void setCompagnie(Compagnie compagnie) {
//		this.compagnie = compagnie;
//	}
//
//	public Aeroport getAeroportDepart() {
//		return aeroportDepart;
//	}
//
//	public void setAeroportDepart(Aeroport aeroportDepart) {
//		this.aeroportDepart = aeroportDepart;
//	}
//
//	public Aeroport getAeroportArrivee() {
//		return aeroportArrivee;
//	}
//
//	public void setAeroportArrivee(Aeroport aeroportArrivee) {
//		this.aeroportArrivee = aeroportArrivee;
//	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVol == null) ? 0 : idVol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vol other = (Vol) obj;
		if (idVol == null) {
			if (other.idVol != null)
				return false;
		} else if (!idVol.equals(other.idVol))
			return false;
		return true;
	}

	
	


}
