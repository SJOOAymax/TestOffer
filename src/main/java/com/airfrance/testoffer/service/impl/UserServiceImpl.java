package com.airfrance.testoffer.service.impl;

import com.airfrance.testoffer.dao.UserRepository;
import com.airfrance.testoffer.dto.UserDTO;
import com.airfrance.testoffer.entities.User;
import com.airfrance.testoffer.service.Sequence.SequenceGeneratorService;
import com.airfrance.testoffer.service.UserService;
import com.airfrance.testoffer.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


  private UserRepository userRepository;

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;

  @Autowired
  public UserServiceImpl(
      UserRepository userRepository) {
    this.userRepository = userRepository;

  }


  @Override
  public UserDTO createUser(User user, Boolean isActive) {

    user.setId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));
    user.setIsActive(isActive);
    userRepository.save(user);
    UserDTO result = ObjectMapper.map(user, UserDTO.class);
    return result;
  }

  @Override
  public UserDTO getUserById(String id) {
    User user = userRepository.findById(id).orElse(null);;
      return ObjectMapper.map(user, UserDTO.class);
  }
}
