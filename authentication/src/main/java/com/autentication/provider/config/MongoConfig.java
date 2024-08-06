package com.autentication.provider.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

//    @Bean
//    public MongoTemplate mongoTemplate() {
//        MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(), "yourDatabaseName");
//        mongoTemplate.setTypeMapper(new DefaultMongoTypeMapper(null)); // Disable _class field
//        return mongoTemplate;
//    }
}
