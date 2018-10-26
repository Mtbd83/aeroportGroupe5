package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 1, allocationSize = 1)
public class Passager {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@Column(name = "id_passager", length = 50)
	private Integer idPassager;
	
	@Column(name = "nom_passager", length = 100)
	private String nom;
	
	@Column(name = "prenom_passager", length = 100)
	private String prenom;
	
	//@Column(name = "adresse_passager", length = 100)
	@Transient
	private Adresse adresse;
	
	public Passager() {
		
	}

	public Integer getIdPassager() {
		return idPassager;
	}

	public void setIdPassager(Integer idPassager) {
		this.idPassager = idPassager;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassager == null) ? 0 : idPassager.hashCode());
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
		Passager other = (Passager) obj;
		if (idPassager == null) {
			if (other.idPassager != null)
				return false;
		} else if (!idPassager.equals(other.idPassager))
			return false;
		return true;
	}
	
	
	
	
}
