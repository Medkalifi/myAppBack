package fr.moha.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.moha.myApp.model.UserApp;
import fr.moha.myApp.model.UserForm;
import fr.moha.myApp.repository.AppUserRepository;
import fr.moha.myApp.service.AccountService;

@RestController
public class AppUserController {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AccountService accountService; 
	
	@GetMapping("/appUsers")
	public List<UserApp> getUtilisateurs(){
		
		return appUserRepository.findAll();
	}
	@PostMapping("/register")
	public UserApp  register(@RequestBody UserForm userForm){
	return accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	}
}
