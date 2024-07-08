package com.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/users")
    public List<String> getUsers(){
        List<String> userStrn  =Arrays.asList("jerin","jack","ben");
        return userStrn;
    }
}
