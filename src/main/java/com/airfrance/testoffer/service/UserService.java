package com.airfrance.testoffer.service;

import com.airfrance.testoffer.dto.UserDTO;
import com.airfrance.testoffer.entities.User;


/**
 * Declaration of method to use in User Service
 *
 * @author Seifeddine.joo
 */

public interface UserService {

  public UserDTO createUser(User user,  Boolean isActive);

  public UserDTO getUserById(String id);
}
