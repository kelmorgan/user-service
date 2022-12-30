package com.kelmorgan.userservice;

import com.kelmorgan.userservice.domain.Role;
import com.kelmorgan.userservice.domain.User;
import com.kelmorgan.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(UserService userService){
		return arg ->  {
			userService.saveRole(Role.builder().name("ROLE_USER").build());
			userService.saveRole(Role.builder().name("ROLE_MANAGER").build());
			userService.saveRole(Role.builder().name("ROLE_ADMIN").build());
			userService.saveRole(Role.builder().name("ROLE_SUPER_ADMIN").build());

			userService.saveUser(User.builder().userName("john").name("john t").password("1234").roles(new ArrayList<>()).build());
			userService.saveUser(User.builder().userName("mark").name("mark t").password("1234").roles(new ArrayList<>()).build());
			userService.saveUser(User.builder().userName("hope").name("hope t").password("1234").roles(new ArrayList<>()).build());
			userService.saveUser(User.builder().userName("helen").name("helen t").password("1234").roles(new ArrayList<>()).build());

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("mark","ROLE_ADMIN");
			userService.addRoleToUser("mark","ROLE_MANAGER");
			userService.addRoleToUser("hope","ROLE_USER");
			userService.addRoleToUser("helen","ROLE_SUPER_ADMIN");

		};
	}

}
