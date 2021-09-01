package fr.moha.myApp.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.moha.myApp.impression.service.ExportPdfService;
import fr.moha.myApp.model.Formation;
import fr.moha.myApp.service.FormationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class FormationController {

	@Autowired
	private FormationService formationService;
	

	@GetMapping("/formations")
	public List<Formation> getFormations() {

		return formationService.getFormations();
	}

	@PostMapping("/formations")
	public void addFormation(@RequestBody Formation formation) {
		formationService.addFormation(formation);
	}

	@GetMapping("/formations/{id}")
	public Formation findFormation(@PathVariable Long id) {
		return formationService.findFormationById(id);
	}

	@PutMapping("/formations/{id}")
	public Formation updateFormation(@PathVariable Long id, @RequestBody Formation f) {
		f.setId(id);
		return formationService.updateFormation(id, f);
	}

	@DeleteMapping("/formations/{id}")
	public void deleteFormation(@PathVariable Long id) {

		formationService.deleteFormation(id);
	}

	
}
