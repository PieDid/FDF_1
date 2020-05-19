package com.intiformation.fdf1.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Classe Entité Cours
 * 
 * Liaisons : 
 * 
 * Cours *---------* Etudiant 
 * Cours *---------1 Enseignant 
 * 
 * 
 * @author IN-DF-028
 *
 */
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
	
	@ManyToMany
	@JoinTable(name = "Etudiant_Cours", 
			 joinColumns = @JoinColumn(name="cours_id"),
			 inverseJoinColumns = @JoinColumn(name="etudiant_id"))
	List<Etudiant> listeEtudiants;
	
	
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
	
	public Cours(String libelle, Enseignant enseignant) {
		super();
		this.libelle = libelle;
		this.enseignant = enseignant;
	}
	
	public Cours(int idCours, String libelle, Enseignant enseignant) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.enseignant = enseignant;
	}


	public Cours(String libelle, List<Etudiant> listeEtudiants, Enseignant enseignant) {
		super();
		this.libelle = libelle;
		this.listeEtudiants = listeEtudiants;
		this.enseignant = enseignant;
	}


	public Cours(int idCours, String libelle, List<Etudiant> listeEtudiants, Enseignant enseignant) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.listeEtudiants = listeEtudiants;
		this.enseignant = enseignant;
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


	/**
	 * @return the listeEtudiants
	 */
	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}


	/**
	 * @param listeEtudiants the listeEtudiants to set
	 */
	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}


	/**
	 * @return the enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}


	/**
	 * @param enseignant the enseignant to set
	 */
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
	
}
