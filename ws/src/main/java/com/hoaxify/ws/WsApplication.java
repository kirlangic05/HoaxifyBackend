package com.hoaxify.ws;

import com.hoaxify.ws.model.User;
import com.hoaxify.ws.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //bütün endpointleri securelamasın diye yazdık.
public class WsApplication {									  //reacttan istek gelmesini engelliyordu

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}


	@Bean
	CommandLineRunner createInitialUsers(UserService userService){
		return args -> {
			User user = new User();
			user.setUsername("user1");
			user.setDisplayName("display1");
			user.setPassword("Password1");
			userService.save(user);
		};
	}

}

