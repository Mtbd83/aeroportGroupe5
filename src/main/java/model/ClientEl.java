package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("El")
public class ClientEl extends Client{
private String titrePhysique;
private String prenom;
	public ClientEl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitrePhysique() {
		return titrePhysique;
	}
	public void setTitrePhysique(String titrePhysique) {
		this.titrePhysique = titrePhysique;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
