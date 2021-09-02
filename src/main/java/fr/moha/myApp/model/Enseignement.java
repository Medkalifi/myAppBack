package fr.moha.myApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enseignement {
	@Id
	private Long id;
	private String cursus;
	private Format Format;
	private Integer VolumeHoraire;
	private String contenu;
	private String lieu;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCursus() {
		return cursus;
	}
	public void setCursus(String cursus) {
		this.cursus = cursus;
	}
	public Format getFormat() {
		return Format;
	}
	public void setFormat(Format format) {
		Format = format;
	}
	public Integer getVolumeHoraire() {
		return VolumeHoraire;
	}
	public void setVolumeHoraire(Integer volumeHoraire) {
		VolumeHoraire = volumeHoraire;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
	

}
