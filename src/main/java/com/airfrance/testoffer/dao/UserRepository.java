package com.airfrance.testoffer.dao;

import com.airfrance.testoffer.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository to manage calls between our application and database
 *
 * @author Seifeddine.joo
 */

public interface UserRepository extends MongoRepository<User,String> {

}
