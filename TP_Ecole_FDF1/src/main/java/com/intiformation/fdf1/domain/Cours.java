package com.intiformation.fdf1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="cours")
@Table(name="cours")
public class Cours implements Serializable{

	private static final long serialVersionUID = 1L;

	/*_________________ props ________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cours")
	int idCours;
	
	@Column(name="libelle")
	String libelle;

	
	
	/*_____________ associations _____________*/
	//Cours - Etudiant
	@ManyToOne
	@JoinColumn(name="etudiant_id", referencedColumnName="id_etudiant")
	private Etudiant etudiant;
	
	
	//Cours - Enseignant
	@ManyToOne
	@JoinColumn(name="enseignant_id", referencedColumnName="id_enseignant")
	private Enseignant enseignant;
	
	
	
	/*_________________ ctors ________________*/
	public Cours() {}


	public Cours(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	
	/*____________ Méthodes ___________*/
	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", libelle=" + libelle + "]";
	}
	


	/*____________ Getters/Setters ___________*/
	public int getIdCours() {
		return idCours;
	}

	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
