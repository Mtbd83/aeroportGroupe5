package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EscaleKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_vol")
	private Vol vol;
	@ManyToOne
	@JoinColumn(name = "id_aeroport")
	private Aeroport aeroport;

	public EscaleKey() {

	}	

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
}
