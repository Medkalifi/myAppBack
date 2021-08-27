package fr.moha.myApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.moha.myApp.model.RoleApp;
@Repository
public interface AppRoleRepository extends JpaRepository<RoleApp, Long>{
	public RoleApp findByRole( String role);

}
