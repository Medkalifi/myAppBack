package fr.moha.myApp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.moha.myApp.model.RoleApp;
import fr.moha.myApp.model.UserApp;
import fr.moha.myApp.repository.AppRoleRepository;
import fr.moha.myApp.repository.AppUserRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository userAppRepository;
	@Autowired
	private AppRoleRepository roleAppRepository;
	@Autowired
	private BCryptPasswordEncoder crypt;

	@Override
	public UserApp saveUser(String username, String password, String confirmedPass) {
		UserApp user = userAppRepository.findByUserName(username);
		if (user != null) {
			throw new RuntimeException("l'utilisateur existe déjà");
		}
		if (!password.equals(confirmedPass)) {
			throw new RuntimeException("mots de passe différents");
		}
		UserApp userApp = new UserApp();
		userApp.setUserName(username);
		userApp.setActivated(true);
		userApp.setPassword(crypt.encode(password));
		userAppRepository.save(userApp);
		addRoleToUser(username, "USER");

		return userApp;
	}

	@Override
	public RoleApp save(RoleApp role) {

		return roleAppRepository.save(role);
	}

	@Override
	public UserApp loadUserByUserName(String username) {
		return userAppRepository.findByUserName(username);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		UserApp userApp = userAppRepository.findByUserName(username);
		RoleApp roleApp = roleAppRepository.findByRole(rolename);
		userApp.getRoles().add(roleApp);

	}

}
