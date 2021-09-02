package fr.moha.myApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.moha.myApp.model.Recherche;
import fr.moha.myApp.repository.RechercheRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class RechercheController {
	
	@Autowired
	private RechercheRepository rechercheRepository;
	
	@GetMapping("/expPros")
	public List<Recherche> getExpPros(){
		
		return rechercheRepository.findAll();
	}

	@PostMapping("/expPros")
	public void addExpPro(@RequestBody Recherche exp) {
		rechercheRepository.save(exp);
	}
	@GetMapping("/expPros/{id}")
	public Optional<Recherche>  findExp(@PathVariable Long id) {
		return rechercheRepository.findById(id);
	}
	
	
	
	@PutMapping("/expPros/{id}")
	public Recherche updateRecherche(@PathVariable Long id,
			@RequestBody Recherche exp ) {
		exp.setId(id);
		return rechercheRepository.save(exp);
	}
	
	@DeleteMapping("/expPros/{id}")
	public void deleteExpPro(@PathVariable Long id) {
		
		rechercheRepository.deleteById(id);
	}
}
