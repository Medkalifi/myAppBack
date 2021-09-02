package fr.moha.myApp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Formation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate anneeDebut;
	private LocalDate anneeFin;
	private String lieu; 
	private String intitule;
	
	
	
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
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	} 
	

}
