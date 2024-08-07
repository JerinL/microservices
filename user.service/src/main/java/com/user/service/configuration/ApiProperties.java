package com.user.service.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api.url")
public class ApiProperties {

    private String user;
    private String notification;
//
//    public String getname(){
//        return user + user;
//    }
//    public static void main(String[] args) {
//        ApiProperties apiProperties = new ApiProperties();
//        System.out.println(apiProperties.getname());
//    }
}
