package com.user.service.feign;

import com.user.service.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("AUTHENTICATION-SERVICE")
public interface FeignInterface {

    @PostMapping("/auth/v1/signup")
    public ResponseEntity<User> register(@RequestBody User user);


    @GetMapping("/auth/v1/users")
    public ResponseEntity<List<User>> getUsers();
}
