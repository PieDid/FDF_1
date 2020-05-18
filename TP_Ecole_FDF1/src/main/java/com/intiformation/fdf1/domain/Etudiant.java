package com.intiformation.fdf1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity(name="etudiant")
@DiscriminatorValue("Etudiant")
public class Etudiant extends Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*_________________ props ________________*/
	@Column(name="promotion")
	int promotion;

	
	
	/*_________________ ctors ________________*/
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(int promotion, String nom, String prenom, double telephone, String email, String motDePasse, Adresse adresse) {
		super(nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
	}
	
	public Etudiant(int promotion, int idPersonne, String nom, String prenom, double telephone, String email, String motDePasse, Adresse adresse) {
		super(idPersonne, nom, prenom, telephone, email, motDePasse, adresse);
		this.promotion = promotion;
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
	
	
	
}
