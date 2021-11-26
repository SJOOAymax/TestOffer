package com.airfrance.testoffer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.airfrance.testoffer.controller.UserController;
import com.airfrance.testoffer.dao.UserRepository;
import com.airfrance.testoffer.dto.UserDTO;
import com.airfrance.testoffer.entities.User;
import com.airfrance.testoffer.service.Sequence.SequenceGeneratorService;
import com.airfrance.testoffer.service.UserService;
import com.airfrance.testoffer.service.impl.UserServiceImpl;
import com.airfrance.testoffer.util.ObjectMapper;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;



@SpringBootTest
class TestOfferApplicationTests {


  @Mock
  private UserRepository userRepository;
  @Mock
  private UserService userServiceInterface;
  @Mock
  private SequenceGeneratorService sequenceGeneratorService;

  @InjectMocks
  private UserServiceImpl userService = new UserServiceImpl(userRepository);
  @InjectMocks
  private UserController userController = new UserController();

  User user = new User();
  UserDTO userDTO = new UserDTO();

  @BeforeEach
  public void setUp() throws ParseException {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    MockitoAnnotations.initMocks(this);
    user.setId("19");
    user.setFirstName("seif");
    user.setLastName("joo");
    user.setBirthDate(LocalDate.parse("1992-09-05",dateFormat));
    user.setEmail("seif.joo@gmail.com");
    user.setAddress("courbevoie, paris France");
    user.setIsActive(false);

    userDTO.setId("20");
    userDTO.setFirstName("seifeddine");
    userDTO.setLastName("joo");
    userDTO.setBirthDate(LocalDate.parse("1992-09-06",dateFormat));
    userDTO.setEmail("seif.joo@gmail.com");
    userDTO.setAddress("courbevoie, paris France");
    userDTO.setIsActive(false);
  }

  @Test
  public void createUserController() throws Exception {
    when(userServiceInterface.createUser(any(), any())).thenReturn(userDTO);
    ResponseEntity<UserDTO> responseEntity = userController.createUser(userDTO, true);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), 200);
  }

  @Test
  public void createUser() throws ParseException {
    when(sequenceGeneratorService.getSequenceNumber(any())).thenReturn(User.SEQUENCE_NAME);
    when(userRepository.save(any())).thenReturn(user);
    Assert.assertNotNull(userService.createUser(user, false));
  }

  @Test
  public void getUserById() throws ParseException {
    when(userRepository.findById(any())).thenReturn(Optional.of(user));
    Assert.assertEquals(userService.getUserById(user.getId()).getId(), user.getId());
  }




}
