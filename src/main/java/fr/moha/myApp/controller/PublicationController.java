package fr.moha.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.moha.myApp.batch.model.Publication;
import fr.moha.myApp.batch.repository.PublicationRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PublicationController {
	@Autowired
	private PublicationRepository publicationRepository;
	
	@GetMapping("/publications")
	public List<Publication> getAllPublications() {
		return publicationRepository.findAll();
		
	}

}
