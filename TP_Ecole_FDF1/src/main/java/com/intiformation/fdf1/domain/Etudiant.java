package com.intiformation.fdf1.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


/**
 * Classe Entité Etudiant
 * 
 * Liaisons : 
 * 
 * Etudiant *---------* Cours 
 * 
 * 
 * @author IN-DF-028
 *
 */
@Entity(name="etudiant")
@DiscriminatorValue("Etudiant")
public class Etudiant extends Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*_________________ props ________________*/
	@Column(name="promotion")
	int promotion;
	
	
	
	
	/*_____________ associations _____________*/
	//Etudiant - Cours
	@ManyToMany(mappedBy="listeEtudiants")
	List<Cours> listeCours;
	
	
	
	/*_________________ ctors ________________*/
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(int promotion, String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse) {
		super(nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
	}
	
	public Etudiant(int promotion, int idPersonne, String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse) {
		super(idPersonne, nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
	}
	
	

	public Etudiant(String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse,
			int promotion) {
		super(nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
	}

	
	
	public Etudiant(int idPersonne, String nom, String prenom, String telephone, String email, String motDePasse,
			Adresse adresse, int promotion) {
		super(idPersonne, nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
	}
	
	

	public Etudiant(String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse,
			int promotion, List<Cours> listeCours) {
		super(nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
		this.listeCours = listeCours;
	}
	
	

	public Etudiant(int idPersonne, String nom, String prenom, String telephone, String email, String motDePasse,
			Adresse adresse, int promotion, List<Cours> listeCours) {
		super(idPersonne, nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
		this.listeCours = listeCours;
	}

	/*____________ Getters/Setters ___________*/
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the listeCours
	 */
	public List<Cours> getListeCours() {
		return listeCours;
	}

	/**
	 * @param listeCours the listeCours to set
	 */
	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}
	
	
	
}
