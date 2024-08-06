package com.autentication.provider.entiry;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@ToString
@Data
public class User {

    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private long phoneNumber;

}