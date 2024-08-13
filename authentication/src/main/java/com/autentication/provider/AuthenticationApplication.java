package com.autentication.provider;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationApplication {

	public static void main(String[] args) throws IOException {
		initializeFirebase();
		SpringApplication.run(AuthenticationApplication.class, args);
	}



	public static void initializeFirebase() throws IOException {
		if (FirebaseApp.getApps().isEmpty()) {
			FileInputStream serviceAccount =
					new FileInputStream("D:\\MICROSERVICE\\microservices\\authentication\\src\\main\\resources");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();

			FirebaseApp.initializeApp(options);

		}
	}
}
