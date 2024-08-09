package com.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private long phoneNumber;
}
