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

import com.intiformation.fdf1.domain.Enseignant;
import com.intiformation.fdf1.repository.EnseignantRepository;

/**
 * WS REST de l'enseignant
 * @author IN-DF-028
 *
 */
@RestController
@RequestMapping("/enseignant-rest")
public class EnseignantRest {

	@Autowired
	private EnseignantRepository enseignantRepository;

	/**
	 * @param enseignantRepository the enseignantRepository to set
	 */
	public void setEnseignantRepository(EnseignantRepository enseignantRepository) {
		this.enseignantRepository = enseignantRepository;
	}
	
	/*_________ CRUD ___________*/
	
	@RequestMapping(value = "/enseignantList", method = RequestMethod.GET)
	public List<Enseignant> listeEnseignant(){
		return enseignantRepository.findAll();
	}
	
	@RequestMapping(value = "/enseignant/{idEnseignant}", method = RequestMethod.GET)
	public Enseignant getEnseignant(@PathVariable("idEnseignant") int pIdEnseignant) {
		return enseignantRepository.findById(pIdEnseignant);
	}
	
	@RequestMapping(value = "/enseignantAdd", method = RequestMethod.POST)
	public void saveEnseignant(@RequestBody Enseignant pEnseignant) {
		enseignantRepository.save(pEnseignant);
	}
	
	@RequestMapping(value = "/enseignantUpdate/{idEnseignant}", method = RequestMethod.PUT)
	public void updateEnseignant(@PathVariable("idEnseignant") int pIdEnseignant, @RequestBody Enseignant pEnseignant) {
		enseignantRepository.saveAndFlush(pEnseignant);
	}

	@RequestMapping(value = "/enseignantDelete/{idEnseignant}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteEnseignant(@PathVariable("idEnseignant") int pIdEnseignant) {
		enseignantRepository.deleteById(pIdEnseignant);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
	
	/*________ methodes spécifiques _______________*/
	
	@RequestMapping(value = "/enseignant/nom/{nom}", method = RequestMethod.GET)
	public List<Enseignant> getEnseignantByNom(@PathVariable("nom") String pNom){
		return enseignantRepository.findByNom(pNom);
	} 
	
	@RequestMapping(value = "/enseignant/prenom/{prenom}", method = RequestMethod.GET)
	public List<Enseignant> getEnseignantByPrenom(@PathVariable("prenom") String pPrenom){
		return enseignantRepository.findByPrenom(pPrenom);
	} 
	
	@RequestMapping(value = "/enseignant/telephone/{telephone}", method = RequestMethod.GET)
	public Enseignant getEnseignantByTelephone(@PathVariable("telephone") String pTelephone){
		return enseignantRepository.findByTel(pTelephone);
	} 
	
	@RequestMapping(value = "/enseignant/email/{email}", method = RequestMethod.GET)
	public Enseignant getEnseignantByEmail(@PathVariable("email") String pEmail){
		return enseignantRepository.findByEmail(pEmail);
	} 
	
	@RequestMapping(value = "/enseignant/matiere/{matiere}", method = RequestMethod.GET)
	public List<Enseignant> getEnseignantByMatiere(@PathVariable("matiere") String pMatiere){
		return enseignantRepository.findByMatiere(pMatiere);
	} 
	
	@RequestMapping(value = "/enseignant/adresse/{adresse}", method = RequestMethod.GET)
	public Enseignant getEnseignantByIdAdresse(@PathVariable("adresse") int pIdAdresse){
		return enseignantRepository.findByIdAdresse(pIdAdresse);
	} 
	
	@RequestMapping(value = "/enseignant/ville/{ville}", method = RequestMethod.GET)
	public List<Enseignant> getEnseignantByVille(@PathVariable("ville") String pVille){
		return enseignantRepository.findByVille(pVille);
	} 
	
	@RequestMapping(value = "/enseignant/rue/{rue}", method = RequestMethod.GET)
	public List<Enseignant> getEnseignantByRue(@PathVariable("rue") String pRue){
		return enseignantRepository.findByRue(pRue);
	} 
	
	@RequestMapping(value = "/enseignant/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<Enseignant> getEnseignantBycodePostal(@PathVariable("codePostal") String pCodePostal){
		return enseignantRepository.findByCodePostal(pCodePostal);
	} 
	
	
}
