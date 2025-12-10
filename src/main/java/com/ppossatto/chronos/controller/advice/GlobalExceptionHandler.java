package com.ppossatto.chronos.controller.advice;

import com.ppossatto.chronos.dto.response.ErrorResponse;
import com.ppossatto.chronos.exception.AppointmentNotFoundException;
import com.ppossatto.chronos.exception.StatusNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Handler class for exceptions the application can throw.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

   /**
    * Handler for {@link StatusNotValidException} exception class.
    *
    * @param exception the {@link StatusNotValidException} exception class.
    * @return the response entity with information about the error.
    */
   @ExceptionHandler(StatusNotValidException.class)
   public ResponseEntity<ErrorResponse> handleStatusNotValidException(StatusNotValidException exception){
      return ResponseEntity
         .status(HttpStatus.BAD_REQUEST)
         .body(ErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
            .message(exception.getMessage())
            .build());
   }

   /**
    * Handler for {@link AppointmentNotFoundException} exception class.
    *
    * @param exception the {@link AppointmentNotFoundException} exception class.
    * @return the response entity with information about the error.
    */
   @ExceptionHandler(AppointmentNotFoundException.class)
   public ResponseEntity<ErrorResponse> handleAppointmentNotFoundException(AppointmentNotFoundException exception){
      return ResponseEntity
         .status(HttpStatus.NOT_FOUND)
         .body(
            ErrorResponse.builder()
               .timestamp(LocalDateTime.now())
               .status(HttpStatus.NOT_FOUND.value())
               .error(HttpStatus.NOT_FOUND.getReasonPhrase())
               .message(exception.getMessage())
               .build()
         );
   }
}
