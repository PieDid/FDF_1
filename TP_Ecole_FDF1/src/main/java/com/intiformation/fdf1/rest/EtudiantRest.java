package com.intiformation.fdf1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.fdf1.domain.Etudiant;
import com.intiformation.fdf1.repository.EtudiantRepository;

/**
 * WS REST de l'etudiant
 * @author IN-DF-028
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/etudiant-rest")
public class EtudiantRest {

	@Autowired
	private EtudiantRepository etudiantRepository;

	/**
	 * @param etudiantRepository the etudiantRepository to set
	 */
	public void setEtudiantRepository(EtudiantRepository etudiantRepository) {
		this.etudiantRepository = etudiantRepository;
	}
	
	/*_________ CRUD ___________*/
	
	@RequestMapping(value = "/etudiantList", method = RequestMethod.GET)
	public List<Etudiant> listeEtudiant(){
		return etudiantRepository.findAll();
	}
	
	@RequestMapping(value = "/etudiant/{idEtudiant}", method = RequestMethod.GET)
	public Etudiant getEtudiant(@PathVariable("idEtudiant") int pIdEtudiant) {
		return etudiantRepository.findById(pIdEtudiant);
	}
	
	@RequestMapping(value = "/etudiantAdd", method = RequestMethod.POST)
	public void saveEtudiant(@RequestBody Etudiant pEtudiant) {
		etudiantRepository.save(pEtudiant);
	}
	
	@RequestMapping(value = "/etudiantUpdate/{idEtudiant}", method = RequestMethod.PUT)
	public void updateEtudiant(@PathVariable("idEtudiant") int pIdEtudiant, @RequestBody Etudiant pEtudiant) {
		etudiantRepository.saveAndFlush(pEtudiant);
	}

	@RequestMapping(value = "/etudiantDelete/{idEtudiant}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteEtudiant(@PathVariable("idEtudiant") int pIdEtudiant) {
		etudiantRepository.deleteById(pIdEtudiant);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
	
	/*________ methodes spécifiques _______________*/
	
	@RequestMapping(value = "/etudiant/nom/{nom}", method = RequestMethod.GET)
	public List<Etudiant> getEtudiantByNom(@PathVariable("nom") String pNom){
		return etudiantRepository.findByNom(pNom);
	} 
	
	@RequestMapping(value = "/etudiant/prenom/{prenom}", method = RequestMethod.GET)
	public List<Etudiant> getEtudiantByPrenom(@PathVariable("prenom") String pPrenom){
		return etudiantRepository.findByPrenom(pPrenom);
	} 
	
	@RequestMapping(value = "/etudiant/telephone/{telephone}", method = RequestMethod.GET)
	public Etudiant getEtudiantByTelephone(@PathVariable("telephone") String pTelephone){
		return etudiantRepository.findByTel(pTelephone);
	} 
	
	@RequestMapping(value = "/etudiant/email/{email}", method = RequestMethod.GET)
	public Etudiant getEtudiantByEmail(@PathVariable("email") String pEmail){
		return etudiantRepository.findByEmail(pEmail);
	} 
	
	@RequestMapping(value = "/etudiant/promotion/{promotion}", method = RequestMethod.GET)
	public List<Etudiant> getEtudiantByPromotion(@PathVariable("promotion") int pPromotion){
		return etudiantRepository.findByPromotion(pPromotion);
	} 
	
	@RequestMapping(value = "/etudiant/adresse/{adresse}", method = RequestMethod.GET)
	public Etudiant getEtudiantByIdAdresse(@PathVariable("adresse") int pIdAdresse){
		return etudiantRepository.findByIdAdresse(pIdAdresse);
	} 
	
	@RequestMapping(value = "/etudiant/ville/{ville}", method = RequestMethod.GET)
	public List<Etudiant> getEtudiantByVille(@PathVariable("ville") String pVille){
		return etudiantRepository.findByVille(pVille);
	} 
	
	@RequestMapping(value = "/etudiant/rue/{rue}", method = RequestMethod.GET)
	public List<Etudiant> getEtudiantByRue(@PathVariable("rue") String pRue){
		return etudiantRepository.findByRue(pRue);
	} 
	
	@RequestMapping(value = "/etudiant/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<Etudiant> getEtudiantBycodePostal(@PathVariable("codePostal") String pCodePostal){
		return etudiantRepository.findByCodePostal(pCodePostal);
	} 
	
	
}
