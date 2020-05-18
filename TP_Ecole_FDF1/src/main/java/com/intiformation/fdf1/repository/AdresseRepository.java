package com.intiformation.fdf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.fdf1.domain.Adresse;

@RepositoryRestResource
public interface AdresseRepository extends JpaRepository<Adresse, Integer>{

	/* Méthodes de bases de Jparepository */
	
	
	/* Méthodes de requêtes */
	@Query("SELECT a FROM adresse a WHERE a.idAdresse = ?1")
	public Adresse findById(int idAdresse);
	
	@Query("SELECT a FROM adresse a WHERE a.rue = ?1")
	public List<Adresse> findByRue(String rue);
	
	@Query("SELECT a FROM adresse a WHERE a.codePostal = ?1")
	public List<Adresse> findByCodePostal(String codePostal);
	
	@Query("SELECT a FROM adresse a WHERE a.ville = ?1")
	public List<Adresse> findByVille(String ville);
	
	
}
