package com.airfrance.testoffer.exception;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

@Data
public class ApiException {

  private final String message;

  private final HttpStatus httpStatus;

  private final ZonedDateTime timestamp;

}


