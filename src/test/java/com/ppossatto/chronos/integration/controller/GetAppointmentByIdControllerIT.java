package com.ppossatto.chronos.integration.controller;

import com.ppossatto.chronos.config.TestcontainersConfiguration;
import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.dto.response.ErrorResponse;
import com.ppossatto.chronos.integration.AppointmentResponseMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_ID;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Integration test class for the {@link com.ppossatto.chronos.controller.GetAppointmentByIdController}
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Testcontainers(disabledWithoutDocker = true)
@ActiveProfiles("test")
@Import(TestcontainersConfiguration.class)
class GetAppointmentByIdControllerIT {

   @LocalServerPort
   private Integer port;

   @Autowired
   private TestRestTemplate restTemplate;

   private static final String GET_APPOINTMENT_BY_ID_PATH = "http://localhost:%d//api/v1/appointments/%s";

   private static final String APPOINTMENT_NOT_FOUND_MESSAGE =
      String.format("Appointment with ID '%s' was not found", APPOINTMENT_ID);

   @Test
   @DisplayName("""
      GIVEN an appointment id
      WHEN the given id is from an appointment stored in the database
      THEN should return the appointment with the given id
      """)
   @Sql(
      scripts = "/db_scripts/prepare_get_appointment_by_id_200.sql",
      executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
   )
   @Sql(
      scripts = "/db_scripts/clean_up.sql",
      executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
   )
   void givenGetAppointmentById_whenHasAppointmentWithGivenId_thenValidateResponseReturned(){
      String getAppointmentPath = String.format(GET_APPOINTMENT_BY_ID_PATH, port, APPOINTMENT_ID);

      ResponseEntity<AppointmentResponse> response = assertDoesNotThrow(
         () -> restTemplate.getForEntity(getAppointmentPath, AppointmentResponse.class)
      );

      assertNotNull(
         response
      );
      assertEquals(
         HttpStatus.OK,
         response.getStatusCode()
      );
      assertNotNull(
         response.getBody()
      );
      assertEquals(
         AppointmentResponseMother.createdAppointmentResponseStub(),
         response.getBody()
      );
   }

   @Test
   @DisplayName("""
      GIVEN an appointment id
      WHEN the given id is not from an appointment stored in the database
      AND has others appointments stored in the database
      THEN should throw AppointmentNotFoundException
      """)
   @Sql(
      scripts = "/db_scripts/prepare_get_appointment_by_id_404.sql",
      executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
   )
   @Sql(
      scripts = "/db_scripts/clean_up.sql",
      executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
   )
   void givenGetAppointmentById_whenHasNoAppointmentWithGivenId_thenValidateClientErrorException(){
      String getAppointmentPath = String.format(GET_APPOINTMENT_BY_ID_PATH, port, APPOINTMENT_ID);

      ResponseEntity<ErrorResponse> response = assertDoesNotThrow(
         () -> restTemplate.getForEntity(getAppointmentPath, ErrorResponse.class)
      );

      assertNotNull(response);
      assertEquals(
         HttpStatus.NOT_FOUND,
         response.getStatusCode()
      );
      assertNotNull(response.getBody());
      assertEquals(
         APPOINTMENT_NOT_FOUND_MESSAGE,
         response.getBody().message()
      );
      System.out.println(response);
   }

   @Test
   @DisplayName("""
      GIVEN an appointment id
      WHEN the given id is from an appointment stored in the database
      AND the appointment has deletion date
      THEN should return a 204 response code
      AND no response body
      """)
   @Sql(
      scripts = "/db_scripts/prepare_get_appointment_by_id_204.sql",
      executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
   )
   @Sql(
      scripts = "/db_scripts/clean_up.sql",
      executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
   )
   void givenGetAppointmentById_whenTheAppointmentHasBeenDeleted_thenValidateNoContentHttpStatus(){
      String getAppointmentPath = String.format(GET_APPOINTMENT_BY_ID_PATH, port, APPOINTMENT_ID);

      ResponseEntity<AppointmentResponse> response = assertDoesNotThrow(
         () -> restTemplate.getForEntity(getAppointmentPath, AppointmentResponse.class)
      );

      assertNotNull(response);
      assertEquals(
         HttpStatus.NO_CONTENT,
         response.getStatusCode()
      );
      assertNull(response.getBody());
   }
}
