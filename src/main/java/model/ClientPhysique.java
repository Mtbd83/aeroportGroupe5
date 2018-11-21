package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class ClientPhysique extends Client {
	@Column
	private String titrePhysique;
	@Column
	private String String;
	public ClientPhysique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitrePhysique() {
		return titrePhysique;
	}
	public void setTitrePhysique(String titrePhysique) {
		this.titrePhysique = titrePhysique;
	}
	public String getString() {
		return String;
	}
	public void setString(String string) {
		String = string;
	}

	
}
