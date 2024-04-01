package com.example.testKeycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SecurityScheme(
//		name="keycloak",
//		openIdConnectUrl = "http://localhost:8080/realms/demo/.well-known/openid-configuration",
//		scheme = "bearer",
//		type= SecuritySchemeType.OPENIDCONNECT,
//		in= SecuritySchemeIn.HEADER
//)
public class TestKeycloakApplication {

//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return  new BCryptPasswordEncoder();
//	}


	public static void main(String[] args) {
		SpringApplication.run(TestKeycloakApplication.class, args);
	}

}
