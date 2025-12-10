package com.ppossatto.chronos.unit.controller.advice;

import com.ppossatto.chronos.controller.advice.GlobalExceptionHandler;
import com.ppossatto.chronos.dto.response.ErrorResponse;
import com.ppossatto.chronos.exception.AppointmentNotFoundException;
import com.ppossatto.chronos.exception.StatusNotValidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test class for the {@link com.ppossatto.chronos.controller.advice.GlobalExceptionHandler} class.
 */
@SpringBootTest
@ActiveProfiles("test")
class GlobalExceptionHandlerTest {

   private static final String INVALID_STATUS = "Invalid";

   private static final String INVALID_STATUS_MESSAGE =
      String.format("'%s' is not a valid status type", INVALID_STATUS);

   private static final String ID_NOT_FOUND = "ab08f335-8230-4cd6-bd5b-0ce88f8d6479";

   private static final String ID_NOT_FOUND_MESSAGE =
      String.format("Appointment with ID '%s' was not found", ID_NOT_FOUND);

   @Autowired
   private GlobalExceptionHandler exceptionHandler;

   @Test
   @DisplayName("""
      GIVEN a StatusNotValidException
      WHEN handler method handleStatusNotValidException is invoked
      THEN validate response entity for given exception
      """)
   void givenStatusNotValidException_whenHandlerMethodIsCalled_thenValidateResponseEntity(){
      // Arrange
      StatusNotValidException exception = new StatusNotValidException(INVALID_STATUS);

      // Act
      ResponseEntity<ErrorResponse> response = exceptionHandler.handleStatusNotValidException(exception);

      // Assert
      assertNotNull(response);
      assertEquals(
         HttpStatus.BAD_REQUEST,
         response.getStatusCode()
      );
      assertNotNull(response.getBody());
      assertEquals(
         INVALID_STATUS_MESSAGE,
         response.getBody().message()
      );
   }

   @Test
   @DisplayName("""
      GIVEN an AppointmentNotFoundException
      WHEN handler method handleAppointmentNotFoundException is invoked
      THEN validate response entity for given exception
      """)
   void givenAppointmentNotFoundException_whenHandlerIsInvoked_thenValidateResponseEntity(){
      // Arrange
      AppointmentNotFoundException exception = new AppointmentNotFoundException(ID_NOT_FOUND);

      // Act
      ResponseEntity<ErrorResponse> response = exceptionHandler.handleAppointmentNotFoundException(exception);

      // Assert
      assertNotNull(response);
      assertEquals(
         HttpStatus.NOT_FOUND,
         response.getStatusCode()
      );
      assertNotNull(response.getBody());
      assertEquals(
         ID_NOT_FOUND_MESSAGE,
         response.getBody().message()
      );
   }
}
