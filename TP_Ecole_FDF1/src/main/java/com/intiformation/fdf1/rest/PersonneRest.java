package com.intiformation.fdf1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.fdf1.domain.Personne;
import com.intiformation.fdf1.repository.PersonneRepository;

@RestController
@RequestMapping("/personne-rest")
public class PersonneRest {

	@Autowired
	private PersonneRepository personneRepository;

	/**
	 * @param personneRepository the personneRepository to set
	 */
	public void setPersonneRepository(PersonneRepository personneRepository) {
		this.personneRepository = personneRepository;
	}
	
	/*_________ CRUD ___________*/
	
	@RequestMapping(value = "/personneList", method = RequestMethod.GET)
	public List<Personne> listePersonne(){
		return personneRepository.findAll();
	}
	
	@RequestMapping(value = "/personne/{idPersonne}", method = RequestMethod.GET)
	public Personne getPersonne(@PathVariable("idPersonne") int pIdPersonne) {
		return personneRepository.findById(pIdPersonne);
	}
	
	@RequestMapping(value = "/personneAdd", method = RequestMethod.POST)
	public void savePersonne(@RequestBody Personne pPersonne) {
		personneRepository.save(pPersonne);
	}
	
	@RequestMapping(value = "/personneUpdate/{idPersonne}", method = RequestMethod.PUT)
	public void updatePersonne(@PathVariable("idPersonne") int pIdPersonne, @RequestBody Personne pPersonne) {
		personneRepository.saveAndFlush(pPersonne);
	}

	@RequestMapping(value = "/personneDelete/{idPersonne}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deletePersonne(@PathVariable("idPersonne") int pIdPersonne) {
		personneRepository.deleteById(pIdPersonne);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
	
	/*________ methodes spécifiques _______________*/
	
	@RequestMapping(value = "/personne/nom/{nom}", method = RequestMethod.GET)
	public List<Personne> getPersonneByNom(@PathVariable("nom") String pNom){
		return personneRepository.findByNom(pNom);
	} 
	
	@RequestMapping(value = "/personne/prenom/{prenom}", method = RequestMethod.GET)
	public List<Personne> getPersonneByPrenom(@PathVariable("prenom") String pPrenom){
		return personneRepository.findByPrenom(pPrenom);
	} 
	
	@RequestMapping(value = "/personne/telephone/{telephone}", method = RequestMethod.GET)
	public Personne getPersonneByTelephone(@PathVariable("telephone") String pTelephone){
		return personneRepository.findByTel(pTelephone);
	} 
	
	@RequestMapping(value = "/personne/email/{email}", method = RequestMethod.GET)
	public Personne getPersonneByEmail(@PathVariable("email") String pEmail){
		return personneRepository.findByEmail(pEmail);
	} 
	
	@RequestMapping(value = "/personne/adresse/{adresse}", method = RequestMethod.GET)
	public Personne getPersonneByIdAdresse(@PathVariable("adresse") int pIdAdresse){
		return personneRepository.findByIdAdresse(pIdAdresse);
	} 
	
	@RequestMapping(value = "/personne/ville/{ville}", method = RequestMethod.GET)
	public List<Personne> getPersonneByVille(@PathVariable("ville") String pVille){
		return personneRepository.findByVille(pVille);
	} 
	
	@RequestMapping(value = "/personne/rue/{rue}", method = RequestMethod.GET)
	public List<Personne> getPersonneByRue(@PathVariable("rue") String pRue){
		return personneRepository.findByRue(pRue);
	} 
	
	@RequestMapping(value = "/personne/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<Personne> getPersonneBycodePostal(@PathVariable("codePostal") String pCodePostal){
		return personneRepository.findByCodePostal(pCodePostal);
	} 
	
} // end class
