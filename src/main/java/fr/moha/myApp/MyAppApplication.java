package fr.moha.myApp;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.moha.myApp.model.RoleApp;
import fr.moha.myApp.service.AccountService;

@SpringBootApplication
public class MyAppApplication  implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(MyAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.save(new RoleApp(null, "USER"));
			accountService.save(new RoleApp(null, "ADMIN"));
			Stream.of("user1", "user2", "user3", "admin").forEach(un -> {
				accountService.saveUser(un, "1234", "1234");
			});

			accountService.addRoleToUser("admin", "ADMIN");
			accountService.addRoleToUser("admin", "USER");
			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("user2", "USER");
			accountService.addRoleToUser("user3", "USER");

		};
	}

	public BCryptPasswordEncoder getBPE() {
		return new BCryptPasswordEncoder();
	}


}
