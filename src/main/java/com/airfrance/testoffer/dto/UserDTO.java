package com.airfrance.testoffer.dto;

import com.airfrance.testoffer.validation.AdultsOnly;
import com.airfrance.testoffer.validation.LiveInFrance;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO implements Serializable {

  private static final long serialVersionUID = -4419852632366723620L;

  public String id;

  @NotNull(message = "Firstname is required")
  @NotBlank(message = "Firstname cannot be empty")
  public String firstName;

  @NotNull(message = "Lastname is required")
  @NotBlank(message = "Lastname cannot be empty")
  public String lastName;

  @NotNull(message = "Birth date is required")
  @AdultsOnly(message = "minimum age is 18")
  public LocalDate birthDate;

  @NotNull(message = "email is required")
  @NotBlank(message = "email cannot be empty")
  private String email;

  @NotNull(message = "Address is required")
  @NotBlank(message = "Address cannot be empty")
  @LiveInFrance(message = "Address must be in France")
  public String address;

  public Boolean isActive;

}
