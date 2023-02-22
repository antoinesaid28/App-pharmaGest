package GestionPharmacie;

import java.text.ParsePosition;

public class Pharmacien {

	Integer idPharmacien;
	private String nom;
	private String prenom;
	private String fonction;
	private String adresse;
	private String telephone;
	private String mail;
	private String password;

	public Pharmacien() {
		// TODO Auto-generated constructor stub
	}

	// ╔═► Colones (ﾉ*ФωФ)ﾉ
	public Pharmacien(int idPharmacien, String nom, String prenom, String fonction, String adresse, String telephone,
			String mail, String password) {
		this.idPharmacien = idPharmacien;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
		this.password = password;

	}

	/**
	 * @return String return the idPharmacien
	 */
	public int getIdpharmacien() {
		return idPharmacien;
	}

	/**
	 * @param idPharmacien the idPharmacien to set
	 */
	public void setIdPharmacien(int idPharmacien) {
		this.idPharmacien = idPharmacien;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return String return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pharmacien[");
		sb.append("idpharmacien:" + this.idPharmacien);
		sb.append(",nom:" + this.nom);
		sb.append(",prenom:" + this.prenom);
		sb.append(",fonction:" + this.fonction);
		sb.append(",address:" + this.adresse);
		sb.append(",telephone:" + this.telephone);
		sb.append(",mail:" + this.mail);
		sb.append(",password:" + this.password);
		sb.append("]");
		return sb.toString();
	}

}

// sb.append("Increment Id:"+this.incid);