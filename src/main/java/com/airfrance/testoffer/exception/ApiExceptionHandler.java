package com.airfrance.testoffer.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Handler Exception
 *
 * @author Seifeddine.joo
 */

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler({ApiRequestException.class, MethodArgumentNotValidException.class})
  public ResponseEntity<Object> handleApiRequestException(Exception  e){
     HttpStatus badRequest = HttpStatus.BAD_REQUEST;
     ApiException apiException = new ApiException(
          e.getMessage(),
          badRequest,
          ZonedDateTime.now(ZoneId.of("Z"))
      );
    return new ResponseEntity<>(apiException, badRequest);
  }

}

