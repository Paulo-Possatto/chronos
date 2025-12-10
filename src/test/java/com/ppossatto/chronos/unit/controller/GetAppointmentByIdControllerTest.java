package com.ppossatto.chronos.unit.controller;

import com.ppossatto.chronos.controller.GetAppointmentByIdController;
import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.service.GetAppointmentService;
import com.ppossatto.chronos.unit.mother.AppointmentResponseMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_ID;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Unit test class for the {@link GetAppointmentByIdController} class.
 */
@ExtendWith(MockitoExtension.class)
class GetAppointmentByIdControllerTest {

   @InjectMocks
   private GetAppointmentByIdController controller;

   @Mock
   private GetAppointmentService service;

   @Test
   @DisplayName("""
      GIVEN an appointment ID
      WHEN the service implementation returns null
      THEN validate NO_CONTENT status
      AND validate service injection
      """)
   void whenServiceReturnsNull_thenValidateResponseEntity(){
      // Arrange
      when(service.getAppointmentById(APPOINTMENT_ID)).thenReturn(null);

      // Act && Assert
      ResponseEntity<AppointmentResponse> response =
         assertDoesNotThrow(
            () -> controller.getAppointmentById(APPOINTMENT_ID)
         );

      assertNotNull(response);
      assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
      verify(service, times(1)).getAppointmentById(APPOINTMENT_ID);
      verifyNoMoreInteractions(service);
   }

   @Test
   @DisplayName("""
      GIVEN an appointment ID
      WHEN the service implementation returns a response object
      THEN validate OK status
      AND validate response
      AND validate service injection
      """)
   void whenServiceReturnsResponseObject_thenValidateResponseEntity(){
      // Arrange
      AppointmentResponse appointmentResponse = AppointmentResponseMother.createdAppointmentResponse();

      when(service.getAppointmentById(APPOINTMENT_ID)).thenReturn(appointmentResponse);

      // Act && Assert
      ResponseEntity<AppointmentResponse> response =
         assertDoesNotThrow(
            () -> controller.getAppointmentById(APPOINTMENT_ID)
         );

      assertNotNull(response);
      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals(appointmentResponse, response.getBody());
      verify(service, times(1)).getAppointmentById(APPOINTMENT_ID);
      verifyNoMoreInteractions(service);
   }
}
