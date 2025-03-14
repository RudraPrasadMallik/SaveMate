package com.savemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SaveMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveMateApplication.class, args);
//		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	        String rawPassword = "admin123";
//	        String encodedPassword = encoder.encode(rawPassword);
//	        System.out.println("Encoded Password: " + encodedPassword);
	}

}
