package fr.moha.myApp.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.moha.myApp.batch.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
