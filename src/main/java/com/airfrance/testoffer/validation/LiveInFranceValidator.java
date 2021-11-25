package com.airfrance.testoffer.validation;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LiveInFranceValidator implements ConstraintValidator<LiveInFrance, String> {
  private static final String PAYS = "france";


  @Override
  public boolean isValid(String address, ConstraintValidatorContext constraintValidatorContext) {
    return address.trim().toLowerCase().contains(PAYS);
  }

}
