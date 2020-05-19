package com.intiformation.fdf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.fdf1.domain.Enseignant;

@RepositoryRestResource
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{

	/* Méthodes de bases de Jparepository */
	
	
	/* Méthodes de requêtes */
	@Query("SELECT e FROM enseignant e WHERE e.idPersonne = ?1")
	public Enseignant findById(int idPersonne);
	
	@Query("SELECT e FROM enseignant e WHERE e.nom = ?1")
	public List<Enseignant> findByNom(String nom);
	
	@Query("SELECT e FROM enseignant e WHERE e.prenom = ?1")
	public List<Enseignant> findByPrenom(String prenom);
	
	@Query("SELECT e FROM enseignant e WHERE e.telephone = ?1")
	public Enseignant findByTel(String telephone);
	
	@Query("SELECT e FROM enseignant e WHERE e.email = ?1")
	public Enseignant findByEmail(String email);
	
	@Query("SELECT e FROM enseignant e WHERE e.matiere = ?1")
	public List<Enseignant> findByMatiere(int matiere);
	
	
}
