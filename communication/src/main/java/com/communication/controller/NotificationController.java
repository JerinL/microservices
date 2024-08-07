package com.communication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotificationController {

    @PostMapping("/push-notify")
    public String pushNotification(){
        return "message";
    }


    @GetMapping("/test")
    public String getNotification(){
        return "message";
    }
}
