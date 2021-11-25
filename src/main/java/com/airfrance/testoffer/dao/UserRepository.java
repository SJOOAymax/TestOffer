package com.airfrance.testoffer.dao;

import com.airfrance.testoffer.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {

}
