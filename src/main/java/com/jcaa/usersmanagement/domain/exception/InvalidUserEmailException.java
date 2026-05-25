package com.jcaa.usersmanagement.domain.exception;

public final class InvalidUserEmailException extends DomainException {

  private static final String EMAIL_EMPTY_MESSAGE = "The user email must not be empty.";
  private static final String EMAIL_INVALID_FORMAT_TEMPLATE =
      "The user email format is invalid: '%s'.";

  private InvalidUserEmailException(final String message) {
    super(message);
  }

  public static InvalidUserEmailException becauseValueIsEmpty() {
    // VIOLACIÓN Regla 10: texto hardcodeado directamente — debe ser una constante.
    return new InvalidUserEmailException(EMAIL_EMPTY_MESSAGE);
  }

  public static InvalidUserEmailException becauseFormatIsInvalid(final String email) {
    // VIOLACIÓN Regla 10: texto hardcodeado directamente — debe ser una constante.
    return new InvalidUserEmailException(
        String.format(EMAIL_INVALID_FORMAT_TEMPLATE, email));
  }
}
