package com.ppossatto.chronos.unit.mother;

import com.ppossatto.chronos.dto.domain.AppointmentDto;
import com.ppossatto.chronos.model.enums.AppointmentStatusEnum;

import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPLICANT_ID;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPLICANT_NAME;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_DATE_TIME;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_DURATION;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_ID;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_LOCATION;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.CREATED_AT;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.DELETED_AT;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.DESCRIPTION;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.OBSERVATIONS;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.PARTICIPANT_ID;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.PARTICIPANT_NAME;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.TITLE;
import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.UPDATED_AT;

/**
 * Class for creating stubs for the {@link AppointmentDto} object.
 */
public class AppointmentDtoMother {

   /**
    * Stub for an {@link AppointmentDto} with deletedAt parameter not null.
    *
    * @return the DTO stub.
    */
   public static AppointmentDto deletedAppointmentStub(){
      return AppointmentDto.builder()
         .id(APPOINTMENT_ID)
         .title(TITLE)
         .description(DESCRIPTION)
         .appointmentDateTime(APPOINTMENT_DATE_TIME)
         .appointmentDuration(APPOINTMENT_DURATION)
         .appointmentLocation(APPOINTMENT_LOCATION)
         .appointmentStatus(AppointmentStatusEnum.CANCELLED)
         .applicantId(APPLICANT_ID)
         .applicantName(APPLICANT_NAME)
         .participantId(PARTICIPANT_ID)
         .participantName(PARTICIPANT_NAME)
         .observations(OBSERVATIONS)
         .deletedAt(DELETED_AT)
         .createdAt(CREATED_AT)
         .updatedAt(UPDATED_AT)
         .createdBy(APPLICANT_NAME)
         .updatedBy(APPLICANT_NAME)
         .build();
   }

   /**
    * Stub for an {@link AppointmentDto} for created appointments.
    *
    * @return the DTO stub.
    */
   public static AppointmentDto createdAppointmentStub(){
      return AppointmentDto.builder()
         .id(APPOINTMENT_ID)
         .title(TITLE)
         .description(DESCRIPTION)
         .appointmentDateTime(APPOINTMENT_DATE_TIME)
         .appointmentDuration(APPOINTMENT_DURATION)
         .appointmentLocation(APPOINTMENT_LOCATION)
         .appointmentStatus(AppointmentStatusEnum.CREATED)
         .applicantId(APPLICANT_ID)
         .applicantName(APPLICANT_NAME)
         .participantId(PARTICIPANT_ID)
         .participantName(PARTICIPANT_NAME)
         .observations(OBSERVATIONS)
         .createdAt(CREATED_AT)
         .updatedAt(UPDATED_AT)
         .createdBy(APPLICANT_NAME)
         .updatedBy(APPLICANT_NAME)
         .build();
   }
}
