package com.intiformation.fdf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.fdf1.domain.Cours;

@RepositoryRestResource
public interface CoursRepository extends JpaRepository<Cours, Integer>{

	/* Méthodes de bases de Jparepository */
	
	
	/* Méthodes de requêtes */
	@Query("SELECT c FROM cours c WHERE c.idCours = ?1")
	public Cours findById(int idCours);
	
	@Query("SELECT c FROM cours c WHERE c.libelle = ?1")
	public List<Cours> findByLibelle(String libelle);
	
	
}
