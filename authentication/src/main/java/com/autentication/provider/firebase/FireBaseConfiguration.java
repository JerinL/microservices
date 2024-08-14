package com.autentication.provider.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FireBaseConfiguration {

    @PostConstruct
    public void firebaseConnect() throws IOException {
        //File file = ResourceUtils.getFile("classpath: resources/future-synapse-429515-a1-firebase-adminsdk-3rp7x-d2fb905544.json");
        FileInputStream serviceAccount =
                new FileInputStream("D:\\MICROSERVICE\\microservices\\authentication\\src\\main\\resources\\future-synapse-429515-a1-firebase-adminsdk-3rp7x-d2fb905544.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }
}
