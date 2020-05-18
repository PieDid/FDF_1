package com.intiformation.fdf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.fdf1.domain.Personne;

@RepositoryRestResource
public interface PersonneRepository<Personne> extends JpaRepository<Personne, Integer>{

	/* Méthodes de bases de Jparepository */
	
	
	/* Méthodes de requêtes */
	@Query("SELECT p FROM personne p WHERE p.idPersonne = ?1")
	public Personne findById(int idPersonne);
	
	@Query("SELECT p FROM personne p WHERE p.nom = ?1")
	public List<Personne> findByNom(String nom);
	
	@Query("SELECT p FROM personne p WHERE p.prenom = ?1")
	public List<Personne> findByPrenom(String prenom);
	
	@Query("SELECT p FROM personne p WHERE p.telephone = ?1")
	public Personne findByTel(String telephone);
	
	@Query("SELECT p FROM personne p WHERE p.email = ?1")
	public Personne findByEmail(String email);
	
	
}
