package fr.moha.myApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Profil {
	@Id
	private Long id;
	@OneToOne
	private UserApp userApp;
	@OneToMany
	private List<Formation> formations= new ArrayList<Formation>();
	@OneToMany
	private List<Enseignement> Enseignements = new ArrayList<Enseignement>();
	@OneToMany
	private List<Recherche> recherches = new ArrayList<Recherche>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserApp getUserApp() {
		return userApp;
	}
	public void setUserApp(UserApp userApp) {
		this.userApp = userApp;
	}
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public List<Enseignement> getEnseignements() {
		return Enseignements;
	}
	public void setEnseignements(List<Enseignement> enseignements) {
		Enseignements = enseignements;
	}
	public List<Recherche> getRecherches() {
		return recherches;
	}
	public void setRecherches(List<Recherche> recherches) {
		this.recherches = recherches;
	}
	

}
