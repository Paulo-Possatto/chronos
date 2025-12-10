package com.ppossatto.chronos.integration;

import com.ppossatto.chronos.dto.response.AppointmentResponse;

import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPLICANT_NAME;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_DESCRIPTION;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_END_DATE;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_ID;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_LOCATION;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_OBSERVATIONS;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_START_DATE;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_STATUS_CREATED;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.APPOINTMENT_TITLE;
import static com.ppossatto.chronos.integration.IntegrationConstantsMother.PARTICIPANT_NAME;

/**
 * Mother class for using the {@link AppointmentResponse} in integration tests.
 */
public class AppointmentResponseMother {

   /**
    * Stub for a created appointment response for integration tests.
    *
    * @return the stub for the created appointment response.
    */
   public static AppointmentResponse createdAppointmentResponseStub(){
      return AppointmentResponse.builder()
         .appointmentId(APPOINTMENT_ID)
         .appointmentTitle(APPOINTMENT_TITLE)
         .appointmentDescription(APPOINTMENT_DESCRIPTION)
         .appointmentStartDateTime(APPOINTMENT_START_DATE)
         .appointmentEndDateTime(APPOINTMENT_END_DATE)
         .appointmentLocation(APPOINTMENT_LOCATION)
         .appointmentStatus(APPOINTMENT_STATUS_CREATED)
         .applicantName(APPLICANT_NAME)
         .participantName(PARTICIPANT_NAME)
         .appointmentObservations(APPOINTMENT_OBSERVATIONS)
         .build();
   }
}
