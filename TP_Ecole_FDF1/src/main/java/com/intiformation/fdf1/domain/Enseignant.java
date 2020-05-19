package com.intiformation.fdf1.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="enseignant")
@DiscriminatorValue("Enseignant")
public class Enseignant extends Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*_________________ props ________________*/
	@Column(name="matiere")
	private String matiere;

	
	
	
	/*_____________ associations _____________*/
	//Enseignant - Cours
	@OneToMany(mappedBy="enseignant", cascade= CascadeType.ALL)
	private Cours cours;

	
	
	
	/*_________________ ctors ________________*/
	public Enseignant() {
		super();
	}

	public Enseignant(String matiere, String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse) {
		super(nom, prenom, telephone, email, motDePasse, adresse);
		this.matiere = matiere;
	}
	
	public Enseignant(String matiere, String nom, String prenom, String telephone, String email, String motDePasse, Adresse adresse, Cours cours) {
		super(nom, prenom, telephone, email, motDePasse, adresse);
		this.matiere = matiere;
		this.cours = cours;
	}

	
	
	
	/*____________ Getters/Setters ___________*/
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
