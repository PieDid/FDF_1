package com.intiformation.fdf1.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Classe Entité Personne
 * 
 * Liaisons : 
 * 
 * Personne 1---------1 Adresse
 * 
 * 
 * @author IN-DF-028
 *
 */
@Entity(name = "personne")
@Table(name = "personnes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne")
public class Personne {

	/*_________________ props ________________*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_personne")
	private int idPersonne;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "telephone")
	private double telephone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "motDePasse")
	private String motDePasse;
	
	/**
	 * Liaison  1<-->1 avec adresse
	 */
	private Adresse adresse;


	/*_________________ ctors ________________*/
	
	/**
	 * ctor vide pour injection du bean spring
	 */
	public Personne() {}
	
	/**
	 * ctor sans ID
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param email
	 * @param motDePasse
	 * @param adresse
	 */
	public Personne(String nom, String prenom, double telephone, String email, String motDePasse, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
	}

	/**
	 * ctor avec ID
	 * @param idPersonne
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param email
	 * @param motDePasse
	 * @param adresse
	 */
	public Personne(int idPersonne, String nom, String prenom, double telephone, String email, String motDePasse,
			Adresse adresse) {
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
	}

	

	/*_________________ meths ________________*/
	
	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", email=" + email + ", motDePasse=" + motDePasse + ", adresse=" + adresse + "]";
	}

	
	/*__________________ G/S _________________*/
	
	
	/**
	 * @return the idPersonne
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne the idPersonne to set
	 */
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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
	 * @return the telephone
	 */
	public double getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
} // end class
