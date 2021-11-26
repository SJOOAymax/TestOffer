package com.airfrance.testoffer.entities;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Entity of User
 *
 * @author Seifeddine.joo
 */

@Document(collection = "users")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class User implements Serializable {

  private static final long serialVersionUID = 8827486299823969L;


  @Transient
  public static final String SEQUENCE_NAME = "users_sequence";


  @Id
  @Field("id_user")
  private String id;

  @Field("first_name")
  private String firstName;

  @Field("last_name")
  private String lastName;

  @Field("birth_date")
  private LocalDate birthDate;

  @Field("email")
  private String email;

  @Field("address")
  private String address;

  @Field("isActive_user")
  private Boolean isActive;

}
