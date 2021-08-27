package fr.moha.myApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Cours {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Float volumeHoraire;
	@ManyToOne
	private Cursus cursus; 
	private String contenu;
	
	

}
