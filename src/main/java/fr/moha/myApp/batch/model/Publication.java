package fr.moha.myApp.batch.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Publication {
	@Id
	public Long id;
	public String titre;
	public String journal;
	public LocalDate anneePublication;
	@Transient
	public String anneePublicationStr;
	public String auteur;
	public int volume;
	public int pageDebut;
	public int pageFin;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public LocalDate getAnneePublication() {
		return anneePublication;
	}
	public void setAnneePublication(LocalDate anneePublication) {
		this.anneePublication = anneePublication;
	}
	public String getAnneePublicationStr() {
		return anneePublicationStr;
	}
	public void setAnneePublicationStr(String anneePublicationStr) {
		this.anneePublicationStr = anneePublicationStr;
	}
	
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getPageDebut() {
		return pageDebut;
	}
	public void setPageDebut(int pageDebut) {
		this.pageDebut = pageDebut;
	}
	public int getPageFin() {
		return pageFin;
	}
	public void setPageFin(int pageFin) {
		this.pageFin = pageFin;
	}
	
	
	

}
