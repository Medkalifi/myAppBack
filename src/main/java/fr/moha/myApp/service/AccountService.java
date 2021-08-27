package fr.moha.myApp.service;

import fr.moha.myApp.model.RoleApp;
import fr.moha.myApp.model.UserApp;

public interface AccountService {
	
	public UserApp saveUser(String username, String password, String confirmedPass);

	public RoleApp save(RoleApp role);

	public UserApp loadUserByUserName(String username);

	public void addRoleToUser(String username, String rolename);
}
