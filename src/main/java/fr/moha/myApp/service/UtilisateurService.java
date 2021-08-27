package fr.moha.myApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.moha.myApp.model.Utilisateur;
import fr.moha.myApp.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
public List<Utilisateur> getUtilisateurs(){
		return utilisateurRepository.findAll();
	}
public Utilisateur findUserById(Long id) {
	return utilisateurRepository.findById(id).get();
}

public void addUser( Utilisateur utilisateur) {
	utilisateurRepository.save(utilisateur);
}
public Utilisateur updateUser(@PathVariable Long id, @RequestBody Utilisateur u ) {
	u.setId(id);
	return utilisateurRepository.save(u);
}
public void deleteUser( Long id) {
	
	utilisateurRepository.deleteById(id);
}

public List<Utilisateur> searchByKeyword(String mc){
	return utilisateurRepository.findByNomContains(mc);
}
}
