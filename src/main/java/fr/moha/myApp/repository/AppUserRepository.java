package fr.moha.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.moha.myApp.model.UserApp;
@Repository
public interface AppUserRepository  extends JpaRepository<UserApp, Long>{
	public UserApp findByUserName(String username);

}
