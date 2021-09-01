package fr.moha.myApp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ExperienceProfessionnelle {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate anneeDebut;
	private LocalDate anneeFin;
	private String lieu;
	private String client;
	private String nomProjet;
	private String Description;
	private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getAnneeDebut() {
		return anneeDebut;
	}
	public void setAnneeDebut(LocalDate anneeDebut) {
		this.anneeDebut = anneeDebut;
	}
	public LocalDate getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(LocalDate anneeFin) {
		this.anneeFin = anneeFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
