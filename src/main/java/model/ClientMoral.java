package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class ClientMoral extends Client{

	private String titreMoral;
	private String siret;
	public ClientMoral() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitreMoral() {
		return titreMoral;
	}
	public void setTitreMoral(String titreMoral) {
		this.titreMoral = titreMoral;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}

}
