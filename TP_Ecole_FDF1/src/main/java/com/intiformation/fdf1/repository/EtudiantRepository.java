package com.intiformation.fdf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.fdf1.domain.Etudiant;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

	/* Méthodes de bases de Jparepository */
	
	
	/* Méthodes de requêtes */
	@Query("SELECT e FROM etudiant e WHERE e.idPersonne = ?1")
	public Etudiant findById(int idPersonne);
	
	@Query("SELECT e FROM etudiant e WHERE e.nom = ?1")
	public List<Etudiant> findByNom(String nom);
	
	@Query("SELECT e FROM etudiant e WHERE e.prenom = ?1")
	public List<Etudiant> findByPrenom(String prenom);
	
	@Query("SELECT e FROM etudiant e WHERE e.telephone = ?1")
	public Etudiant findByTel(String telephone);
	
	@Query("SELECT e FROM etudiant e WHERE e.email = ?1")
	public Etudiant findByEmail(String email);
	
	@Query("SELECT e FROM etudiant e WHERE e.promotion = ?1")
	public List<Etudiant> findByPromotion(int promotion);
	
	@Query("SELECT e FROM etudiant e WHERE e.adresse.idAdresse = ?1")
	public Etudiant findByIdAdresse(int idAdresse);
	
	@Query("SELECT e FROM etudiant e WHERE e.adresse.ville = ?1")
	public List<Etudiant> findByVille(String ville);
	
	@Query("SELECT e FROM etudiant e WHERE e.adresse.rue = ?1")
	public List<Etudiant> findByRue(String rue);
	
	@Query("SELECT e FROM etudiant e WHERE e.adresse.codePostal = ?1")
	public List<Etudiant> findByCodePostal(String codePostal);
	
	
}
