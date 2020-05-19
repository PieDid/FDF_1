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

import com.intiformation.fdf1.domain.Adresse;
import com.intiformation.fdf1.repository.AdresseRepository;

@RestController
@RequestMapping("/adresse-rest")
public class AdresseRest {

	@Autowired
	private AdresseRepository adresseRepository;

	public void setAdresseRepository(AdresseRepository adresseRepository) {
		this.adresseRepository = adresseRepository;
	}

	@RequestMapping(value = "/adresseList", method = RequestMethod.GET)
	public List<Adresse> listeAdresse() {
		return adresseRepository.findAll();
	}

	@RequestMapping(value = "/adresse/{idAdresse}", method = RequestMethod.GET)
	public Adresse getAdresse(@PathVariable("idAdresse") int pIdAdresse) {
		return adresseRepository.findById(pIdAdresse);
	}

	@RequestMapping(value = "/adresseAdd", method = RequestMethod.POST)
	public void saveAdresse(@RequestBody Adresse pAdresse) {
		adresseRepository.save(pAdresse);
	}

	@RequestMapping(value = "/adresseUpdate/{idAdresse}", method = RequestMethod.PUT)
	public void updateAdresse(@PathVariable("idAdresse") int pIdAdresse, @RequestBody Adresse pAdresse) {
		adresseRepository.saveAndFlush(pAdresse);
	}

	@RequestMapping(value = "/adresseDelete/{idAdresse}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAdresse(@PathVariable("idAdresse") int pIdAdresse) {
		adresseRepository.deleteById(pIdAdresse);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/adresse/rue/{rue}", method = RequestMethod.GET)
	public List<Adresse> getAdresseByRue(@PathVariable("rue") String pRue) {
		return adresseRepository.findByRue(pRue);
	}
	
	@RequestMapping(value = "/adresse/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<Adresse> getListeAdresseByCodePostal(@PathVariable("codePostal") String pCodePostal) {
		return adresseRepository.findByCodePostal(pCodePostal);
	}
	
	@RequestMapping(value = "/adresse/ville/{ville}", method = RequestMethod.GET)
	public List<Adresse> getListeAdresseByVille(@PathVariable("ville") String pVille) {
		return adresseRepository.findByVille(pVille);
	}
	
	
}
