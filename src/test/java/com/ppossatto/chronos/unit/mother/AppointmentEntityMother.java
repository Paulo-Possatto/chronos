package com.ppossatto.chronos.unit.mother;

import com.ppossatto.chronos.model.entity.AppointmentEntity;
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
 * Class for creating stubs for the {@link AppointmentEntity} ORM class.
 */
public class AppointmentEntityMother {

   /**
    * Stub entity object for unit testing for when the appointment is deleted.
    *
    * @return the ORM stub.
    */
   public static AppointmentEntity deletedAppointmentStub(){
      return new AppointmentEntity(
         APPOINTMENT_ID,
         TITLE,
         DESCRIPTION,
         APPOINTMENT_DATE_TIME,
         APPOINTMENT_DURATION,
         APPOINTMENT_LOCATION,
         AppointmentStatusEnum.CANCELLED,
         APPLICANT_ID,
         APPLICANT_NAME,
         PARTICIPANT_ID,
         PARTICIPANT_NAME,
         OBSERVATIONS,
         DELETED_AT,
         CREATED_AT,
         UPDATED_AT,
         APPLICANT_NAME,
         APPLICANT_NAME
      );
   }

   /**
    * Stub entity object for unit testing for when the appointment is created.
    *
    * @return the ORM stub.
    */
   public static AppointmentEntity createdAppointmentStub(){
      return new AppointmentEntity(
         APPOINTMENT_ID,
         TITLE,
         DESCRIPTION,
         APPOINTMENT_DATE_TIME,
         APPOINTMENT_DURATION,
         APPOINTMENT_LOCATION,
         AppointmentStatusEnum.CREATED,
         APPLICANT_ID,
         APPLICANT_NAME,
         PARTICIPANT_ID,
         PARTICIPANT_NAME,
         OBSERVATIONS,
         null,
         CREATED_AT,
         UPDATED_AT,
         APPLICANT_NAME,
         APPLICANT_NAME
      );
   }
}
