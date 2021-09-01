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

import fr.moha.myApp.model.ExperienceProfessionnelle;
import fr.moha.myApp.repository.ExperienceProfessionnelleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienceProfessionnelleController {
	
	@Autowired
	private ExperienceProfessionnelleRepository experienceProfessionnelleRepository;
	
	@GetMapping("/expPros")
	public List<ExperienceProfessionnelle> getExpPros(){
		
		return experienceProfessionnelleRepository.findAll();
	}

	@PostMapping("/expPros")
	public void addExpPro(@RequestBody ExperienceProfessionnelle exp) {
		experienceProfessionnelleRepository.save(exp);
	}
	@GetMapping("/expPros/{id}")
	public Optional<ExperienceProfessionnelle>  findExp(@PathVariable Long id) {
		return experienceProfessionnelleRepository.findById(id);
	}
	
	
	
	@PutMapping("/expPros/{id}")
	public ExperienceProfessionnelle updateExperienceProfessionnelle(@PathVariable Long id,
			@RequestBody ExperienceProfessionnelle exp ) {
		exp.setId(id);
		return experienceProfessionnelleRepository.save(exp);
	}
	
	@DeleteMapping("/expPros/{id}")
	public void deleteExpPro(@PathVariable Long id) {
		
		experienceProfessionnelleRepository.deleteById(id);
	}
}
