package fr.moha.myApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.servlet.oauth2.resourceserver.JwtDsl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.formLogin();
		http.csrf().disable();
	
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
		http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
		http.authorizeRequests().antMatchers("/profil/formations/**" ).permitAll();
		http.authorizeRequests().antMatchers("/profil/expPros/**" ).permitAll();
		http.authorizeRequests().antMatchers("/startJob/**" ).permitAll();
		http.authorizeRequests().antMatchers("/file/upload/**" ).permitAll();
		http.authorizeRequests().antMatchers("/file/donwload/**" ).permitAll();
		http.authorizeRequests().antMatchers("/export/pdf/**").permitAll();
		
	//	http.authorizeRequests().antMatchers("/users/**" ).hasAnyAuthority("ADMIN");
		
		
		
	http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**" ).hasAuthority("ADMIN");
	 http.authorizeRequests().anyRequest().authenticated().and()
	 .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
