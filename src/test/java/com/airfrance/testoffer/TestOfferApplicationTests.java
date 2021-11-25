package com.airfrance.testoffer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.airfrance.testoffer.controller.UserController;
import com.airfrance.testoffer.dao.UserRepository;
import com.airfrance.testoffer.dto.UserDTO;
import com.airfrance.testoffer.entities.User;
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
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;



@SpringBootTest
class TestOfferApplicationTests {


  @Mock
  private UserRepository userRepository;
  @Mock
  private UserService userServiceInterface;

  @InjectMocks
  private UserServiceImpl userService = new UserServiceImpl(userRepository);
  @InjectMocks
  private UserController userController = new UserController();

  User user = new User();
  UserDTO userDTO = new UserDTO();

  @Before
  public void setUp() throws ParseException {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    MockitoAnnotations.initMocks(this);
    user.setId("60c74e32a938a71945c7e092");
    user.setFirstName("seif");
    user.setLastName("joo");
    userDTO.setBirthDate(LocalDate.parse("1992-09-05",dateFormat));
    user.setAddress("courbevoie, paris France");
    user.setIsActive(false);

    userDTO.setId("60c74e32a938a71945c");
    userDTO.setFirstName("seifeddine");
    userDTO.setLastName("joo");
    userDTO.setBirthDate(LocalDate.parse("1992-09-06",dateFormat));
    userDTO.setAddress("courbevoie, paris France");
    userDTO.setIsActive(false);
  }


  @Test
  public void getUserById() throws ParseException {
    when(userRepository.findById(any())).thenReturn(Optional.of(user));
    Assert.assertEquals(userService.getUserById(user.getId()).getId(), user.getId());
  }

  @Test
  public void createUser() throws ParseException {
    when(userRepository.save(any())).thenReturn(ObjectMapper.map(userDTO, User.class));
    Assert.assertNotNull(userService.createUser(user, false));
  }

  @Test
  public void createUserController() throws Exception {
    when(userServiceInterface.createUser(any(), any())).thenReturn(userDTO);
    ResponseEntity<UserDTO> responseEntity = userController.createUser(userDTO, true);
    Assert.assertEquals(responseEntity.getStatusCodeValue(), 200);
  }
}
