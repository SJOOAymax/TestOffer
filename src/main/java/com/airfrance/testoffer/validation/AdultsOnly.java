package com.airfrance.testoffer.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AdultsOnlyValidator.class)
public @interface AdultsOnly {
  String message() default "only adults can be registered";
  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };
}
