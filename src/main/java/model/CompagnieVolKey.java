package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompagnieVolKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_compagnie")
	private Compagnie compagnie;
	@ManyToOne
	@JoinColumn(name = "id_compagnie")
	private Vol vol;

	public CompagnieVolKey() {

	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
}
