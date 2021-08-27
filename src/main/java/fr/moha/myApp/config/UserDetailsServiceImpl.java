package fr.moha.myApp.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.moha.myApp.model.UserApp;
import fr.moha.myApp.service.AccountService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username != null && !username.isEmpty() ) {
			UserApp userApp = accountService.loadUserByUserName(username);
			Collection<GrantedAuthority> autthorities = new ArrayList<GrantedAuthority>();
			userApp.getRoles().forEach(r->{
				autthorities.add(new SimpleGrantedAuthority(r.getRoleName()));
			});
			return new User(userApp.getUserName(), userApp.getPassword(), autthorities);
		}else {
			throw new UsernameNotFoundException("utilisateur non trouvé");
			
		}
		
		
	}

}
