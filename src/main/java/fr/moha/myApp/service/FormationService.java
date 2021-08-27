package fr.moha.myApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.moha.myApp.model.Formation;
import fr.moha.myApp.model.Utilisateur;
import fr.moha.myApp.repository.FormationRepository;
import fr.moha.myApp.repository.UtilisateurRepository;

@Service
public class FormationService {
	@Autowired
	private FormationRepository formationRepository;
	
public List<Formation> getFormations(){
		return formationRepository.findAll();
	}
public Formation findFormationById(Long id) {
	return formationRepository.findById(id).get();
}

public void addFormation( Formation formation) {
	formationRepository.save(formation);
}
public Formation updateFormation(@PathVariable Long id, @RequestBody Formation f ) {
	f.setId(id);
	return formationRepository.save(f);
}
public void deleteFormation( Long id) {
	
	formationRepository.deleteById(id);
}

//public List<Formation> searchByKeyword(String mc){
//	return formationRepository.findByIntituleContains(mc);
//}
}
