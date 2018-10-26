package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VilleAeroportKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_ville")
	private Ville ville;
	@ManyToOne
	@JoinColumn(name = "id_aeroport")
	private Aeroport aeroport;

	public VilleAeroportKey() {

	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
}
