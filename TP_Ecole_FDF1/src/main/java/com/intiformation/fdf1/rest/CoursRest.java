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

import com.intiformation.fdf1.domain.Cours;
import com.intiformation.fdf1.repository.CoursRepository;

/**
 * WS REST du Cours
 * @author IN-DF-028
 *
 */
@RestController
@RequestMapping("/cours-rest")
public class CoursRest {
	
	@Autowired
	private CoursRepository coursRepository;

	/**
	 * @param coursRepository the coursRepository to set
	 */
	public void setCoursRepository(CoursRepository coursRepository) {
		this.coursRepository = coursRepository;
	}
	
	/*_________ CRUD ___________*/

	@RequestMapping(value = "/coursList", method = RequestMethod.GET)
	public List<Cours> listeCours() {
		return coursRepository.findAll();
	}

	@RequestMapping(value = "/cours/{idCours}", method = RequestMethod.GET)
	public Cours getCours(@PathVariable("idCours") int pIdCours) {
		return coursRepository.findById(pIdCours);
	}

	@RequestMapping(value = "/coursAdd", method = RequestMethod.POST)
	public void saveCours(@RequestBody Cours pCours) {
		coursRepository.save(pCours);
	}

	@RequestMapping(value = "/coursUpdate/{idCours}", method = RequestMethod.PUT)
	public void updateCours(@PathVariable("idCours") int pIdCours, @RequestBody Cours pCours) {
		coursRepository.saveAndFlush(pCours);
	}

	@RequestMapping(value = "/coursDelete/{idCours}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteCours(@PathVariable("idCours") int pIdCours) {
		coursRepository.deleteById(pIdCours);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
	
	/*________ methodes spécifiques _______________*/
	
	@RequestMapping(value = "/cours/libelle/{libelle}", method=RequestMethod.GET)
	public List<Cours> getCoursByLibelle(@PathVariable("libelle") String pLibelle ){
		return coursRepository.findByLibelle(pLibelle);
	}
	
} // end class
