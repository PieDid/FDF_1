package com.intiformation.fdf1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Classe Entité Adresse
 * 
 * Liaisons : 
 * 
 * Adresse 1---------1 Personne (porteur FK)
 * 
 * 
 * @author IN-DF-028
 *
 */
@Entity(name="adresse")
@Table(name="adresses")
public class Adresse implements Serializable{

	@Transient
	private static long serialVersionUID = 1L;
	
	/*_________________ props ________________*/

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment
	@Column(name="id_adresse")
	private int idAdresse;
	
	@Column(name="rue")
	private String rue;
	
	@Column(name="codePostal")
	private String codePostal;
	
	@Column(name="ville")
	private String ville;
	
	@OneToOne(mappedBy = "adresse")
	@JsonIgnore
	private Personne personne;
	
	
	/*_________________ ctors ________________*/
	public Adresse() {}

	public Adresse(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse(String rue, String codePostal, String ville, Personne personne) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.personne = personne;
	}
	
	

	/*_________________ methodes ________________*/
	@Override
	public String toString() {
		return "[idAdresse=" + idAdresse + "] " + rue + " " + codePostal + " " + ville;
	}



	/*____________ Getters/Setters ___________*/
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
