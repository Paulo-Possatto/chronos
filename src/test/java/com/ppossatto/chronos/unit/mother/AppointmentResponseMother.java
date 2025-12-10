package com.ppossatto.chronos.unit.mother;

import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.model.enums.AppointmentStatusEnum;

import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPLICANT_NAME;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_DATE_TIME_STRING;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_END_DATE_TIME_STRING;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_ID_STRING;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_LOCATION;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.DESCRIPTION;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.OBSERVATIONS;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.PARTICIPANT_NAME;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.TITLE;

/**
 * Mother class for {@link AppointmentResponse} stubs.
 */
public class AppointmentResponseMother {

   /**
    * Stub for a {@link AppointmentResponse} where the appointment is created.
    *
    * @return the stub object.
    */
   public static AppointmentResponse createdAppointmentResponse(){
      return AppointmentResponse.builder()
         .appointmentId(APPOINTMENT_ID_STRING)
         .appointmentTitle(TITLE)
         .appointmentDescription(DESCRIPTION)
         .appointmentStartDateTime(APPOINTMENT_DATE_TIME_STRING)
         .appointmentEndDateTime(APPOINTMENT_END_DATE_TIME_STRING)
         .appointmentLocation(APPOINTMENT_LOCATION)
         .appointmentStatus(AppointmentStatusEnum.CREATED.getStatus())
         .applicantName(APPLICANT_NAME)
         .participantName(PARTICIPANT_NAME)
         .appointmentObservations(OBSERVATIONS)
         .build();
   }
}
