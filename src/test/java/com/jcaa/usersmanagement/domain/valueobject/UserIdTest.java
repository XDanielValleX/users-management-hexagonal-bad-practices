package com.jcaa.usersmanagement.domain.valueobject;

import static org.junit.jupiter.api.Assertions.*;

import com.jcaa.usersmanagement.domain.exception.InvalidUserIdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("UserId")
class UserIdTest {

  @ParameterizedTest
  @ValueSource(strings = {" user123 ", "  user123  ", "user123\t"})
  @DisplayName("trims whitespace when creating a UserId")
  void shouldCreateUserIdWithTrimmedValue(String input) {
    final String correctUserId = "user123";
    final UserId userId = new UserId(input);
    assertEquals(correctUserId, userId.toString());
  }

  @Test
  @DisplayName("throws NullPointerException when value is null")
  void shouldThrowNullPointerExceptionWhenUserIdIsNull() {
    assertThrows(NullPointerException.class, () -> new UserId(null));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "   ", "\t", "\n", "\r", "\f", "\b"})
  @DisplayName("throws InvalidUserIdException when value is blank")
  void shouldThrowIllegalArgumentExceptionWhenUserIdIsEmpty(String input) {
    assertThrows(InvalidUserIdException.class, () -> new UserId(input));
  }
}
