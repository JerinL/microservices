package com.autentication.provider.repository;

import com.autentication.provider.entiry.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User,String> {


}
