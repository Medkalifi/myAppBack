package fr.moha.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.moha.myApp.model.Utilisateur;
import fr.moha.myApp.service.UtilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("/users")
	public List<Utilisateur> getUtilisateurs(){
		
		return utilisateurService.getUtilisateurs();
	}

	@PostMapping("/users/adduser")
	public void addUser(@RequestBody Utilisateur utilisateur) {
		utilisateurService.addUser(utilisateur);
	}
	@GetMapping("/users/{id}")
	public Utilisateur findUser(@PathVariable Long id) {
		return utilisateurService.findUserById(id);
	}
	
	@GetMapping("/users/byNom")
	public List<Utilisateur> findUserByKeyword( String  mc) {
		return utilisateurService.searchByKeyword(mc);
	}
	
	@PutMapping("/users/{id}")
	public Utilisateur updateUser(@PathVariable Long id, @RequestBody Utilisateur u ) {
		u.setId(id);
		return utilisateurService.updateUser(id, u);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		
		utilisateurService.deleteUser(id);
	}
}
