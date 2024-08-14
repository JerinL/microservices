package com.autentication.provider.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Service
public class FireBaseConfiguration {

//    @Value("classpath:config/future-synapse-429515-a1-firebase-adminsdk-3rp7x-382966d070.json")
//    private Resource firebaseConfigPath;


    @PostConstruct
    public void firebaseConnect() throws IOException {
        // Load the resource from the classpath
        Resource resource = new ClassPathResource("config/future-synapse-429515-a1-firebase-adminsdk-3rp7x-382966d070.json");

        // Access the file as an InputStream
        try (InputStream inputStream = resource.getInputStream()) {
            // Initialize Firebase with the credentials
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .build();

            FirebaseApp.initializeApp(options);

            System.out.println("Firebase initialized successfully.");
        } catch (IOException e) {
            System.err.println("Failed to initialize Firebase: " + e.getMessage());
            throw e;
        }
    }
}
