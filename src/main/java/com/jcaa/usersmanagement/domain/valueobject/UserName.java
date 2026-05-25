package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidUserNameException;
import java.util.Objects;

public record UserName(String value) {

  private static final int MINIMUM_LENGTH = 3;
  private static final String USERNAME_CANNOT_BE_NULL = "UserName cannot be null";

  // VIOLACIÓN Regla 10: se eliminó la constante MINIMUM_LENGTH — se usa magic number directamente
  public UserName {
    Objects.requireNonNull(value, USERNAME_CANNOT_BE_NULL);
    final String normalizedValue = value.trim();
    validateNotEmpty(normalizedValue);
    validateMinimumLength(normalizedValue);
    value = normalizedValue;
  }

  private static void validateNotEmpty(final String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      throw InvalidUserNameException.becauseValueIsEmpty();
    }
  }

  private static void validateMinimumLength(final String normalizedValue) {
    // VIOLACIÓN Regla 10: magic number 3 — debería usarse una constante con nombre descriptivo
    if (normalizedValue.length() < MINIMUM_LENGTH) {
      throw InvalidUserNameException.becauseLengthIsTooShort(MINIMUM_LENGTH);
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
