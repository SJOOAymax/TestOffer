package com.airfrance.testoffer.controller;

import com.airfrance.testoffer.dto.UserDTO;
import com.airfrance.testoffer.entities.User;
import com.airfrance.testoffer.exception.ApiRequestException;
import com.airfrance.testoffer.service.UserService;
import com.airfrance.testoffer.util.ObjectMapper;
import java.util.Objects;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller manages all requests on user
 *
 * @author Seifeddine.joo
 */

@RestController
@RequestMapping("/users")
public class UserController {

  private final Logger LOG = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;


  @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser( @Valid @RequestBody UserDTO userDTO ,
        @RequestParam(defaultValue = "false") Boolean isActive) {

      LOG.info("createUser input : "+userDTO);

      long start = System.currentTimeMillis();

      User user = ObjectMapper.map(userDTO, User.class);

      UserDTO result = userService.createUser(user, isActive);

      LOG.info("createUser output : "+result);

      LOG.info("createUser processing time : "+ (System.currentTimeMillis()-start) +" ms");

      return new ResponseEntity<>(result, HttpStatus.OK);
    }


  @GetMapping("/getUser/{id}")
  public User getUserById(@PathVariable String id) {

    LOG.info(" getUserById input : "+id);

    long start = System.currentTimeMillis();

    UserDTO userDTO = userService.getUserById(id);
    User user = ObjectMapper.map(userDTO, User.class);

    if(Objects.isNull(userDTO)) throw new ApiRequestException("User not found !");

    LOG.info("getUserById output : "+userDTO);

    LOG.info("Method getUserById processing time :"+ (System.currentTimeMillis()-start) + " ms");

    return user;

  }

}

