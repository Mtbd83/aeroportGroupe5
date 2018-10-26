package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 1, allocationSize = 10)
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "id_client", length = 50)
	private Integer clientId;

	@Column(name = "nom_client", length = 100)
	private String clientName;

	@Column(name = "numero_tel", length = 100)
	private Integer numeroTel;

	@Column(name = "numero_fax", length = 100)
	private Integer numeroFax;

	@Column(name = "mail_client", length = 100)
	private String mail;

	@Column(name = "type_client", length = 100)
	private Integer typeClient;

	@Column(name = "titre_client", length = 100)
	private Titre titre;

//	@Embedded
//	@AttributeOverrides({ @AttributeOverride(name = "idAdresse", column = @Column(name = "id_adresse", length = 50)),
//			@AttributeOverride(name = "adresse", column = @Column(name = "adresse", length = 200)),
//			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal", length = 20)),
//			@AttributeOverride(name = "ville", column = @Column(name = "ville", length = 80)),
//			@AttributeOverride(name = "pays", column = @Column(name = "pays", length = 80)), })
	@Transient
	private Adresse adresse;

	@Version
	private int version;
	
//	@Transient
//	private Reservation reservation;

	public Client() {
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Integer getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Integer getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(Integer typeClient) {
		this.typeClient = typeClient;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

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
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
		Client other = (Client) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		return true;
	}

}
