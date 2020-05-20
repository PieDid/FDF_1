package com.intiformation.fdf1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.fdf1.domain.Adresse;
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
	
} // end class
