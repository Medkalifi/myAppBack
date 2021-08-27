package fr.moha.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.moha.myApp.model.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long>{

}
