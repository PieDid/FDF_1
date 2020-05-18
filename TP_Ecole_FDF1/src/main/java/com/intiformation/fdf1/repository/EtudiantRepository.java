package com.intiformation.fdf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.fdf1.domain.Etudiant;

@RepositoryRestResource
public interface EtudiantRepository extends PersonneRepository<Etudiant>, JpaRepository<Etudiant, Integer>{

	/* Méthodes de bases de Jparepository */
	
	
	/* Méthodes de requêtes */
	@Query("SELECT e FROM etudiant e WHERE e.promotion = ?1")
	public List<Etudiant> findByPromotion(int promotion);
	
	
}
