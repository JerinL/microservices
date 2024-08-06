package com.autentication.provider.controller;

import com.autentication.provider.entiry.User;
import com.autentication.provider.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class AccessController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user){
        System.out.println("Saved User: " + user);
        user.setUserId(String.valueOf(UUID.randomUUID()));
        User savedUser = usersRepository.save(user);
        System.out.println("Saved User: " + savedUser);
        return ResponseEntity.ok(savedUser);
    }



    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> savedUser = usersRepository.findAll();
        return ResponseEntity.ok(savedUser);
    }
}
