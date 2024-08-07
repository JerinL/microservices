package com.user.service.controller;

import com.user.service.configuration.ApiProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private RestTemplate restTemplate;
    private ApiProperties apiProperties;

    @Autowired
    public Controller(RestTemplate restTemplate, ApiProperties apiProperties) {
        this.restTemplate = restTemplate;
        this.apiProperties = apiProperties;
    }

    @GetMapping("/users")
    public Map<String,Object> getUsers(){
        System.out.println("Test"+apiProperties.getUser());
        System.out.println("Test"+apiProperties.getNotification());
        ResponseEntity<List> user = restTemplate.exchange(apiProperties.getUser(), HttpMethod.GET, null, List.class);
        ResponseEntity<String> notify = restTemplate.exchange(apiProperties.getNotification(), HttpMethod.GET, null, String.class);

        Map<String,Object> result = new HashMap<>();
        result.put("users",user.getBody());
        result.put("notify",notify.getBody());
        return result;

    }
}
