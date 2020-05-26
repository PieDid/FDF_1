package com.intiformation.fdf1.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Classe Entité Personne
 * 
 * Liaisons : 
 * 
 * Personne (porteur FK) 1---------1 Adresse
 * 
 * 
 * @author IN-DF-028
 *
 */
@Entity(name = "personne")
@Table(name = "personnes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne")
public class Personne implements Serializable{

	/*_________________ props ________________*/
	
	/**
	 * Pour enlever le warning
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_personne")
	private int idPersonne;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "motDePasse")
	private String motDePasse;
	
	/**
	 * Liaison  1<-->1 avec adresse
	 */
	@OneToOne(fetch= FetchType.EAGER, cascade= CascadeType.MERGE)
	@JsonIgnore
	@JoinColumn(name = "adresse_id", referencedColumnName="id_adresse", foreignKey = @ForeignKey(name = "FK_personne_adresse"))
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
	public Personne(String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse) {
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
	public Personne(int idPersonne, String nom, String prenom, String telephone, String email, String motDePasse,
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
} // end class
