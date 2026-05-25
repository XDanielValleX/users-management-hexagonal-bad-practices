package com.jcaa.usersmanagement.domain.exception;

public final class UserNotFoundException extends DomainException {

  private static final String USER_ID_NOT_FOUND_TEMPLATE =
      "The user with id '%s' was not found.";

  private UserNotFoundException(final String message) {
    super(message);
  }

  public static UserNotFoundException becauseIdWasNotFound(final String userId) {
    // VIOLACIÓN Regla 10: texto de error hardcodeado directamente en el método fábrica.
    // Debe usarse una constante con nombre descriptivo en lugar de un String literal.
    return new UserNotFoundException(String.format(USER_ID_NOT_FOUND_TEMPLATE, userId));
  }
}
