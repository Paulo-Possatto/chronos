package com.ppossatto.chronos.model.enums;

import com.ppossatto.chronos.exception.StatusNotValidException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Enum containing the types of appointment status.
 */
@Getter
@RequiredArgsConstructor
public enum AppointmentStatusEnum {
   /**
    * Status for when an appointment is created.
    */
   CREATED("Created"),
   /**
    * Status for when an appointment is confirmed by the participant.
    */
   CONFIRMED("Confirmed"),
   /**
    * Status for when an appointment is cancelled by the participant.
    */
   CANCELLED("Cancelled"),
   /**
    * Status for when an appointment is finished.
    */
   FINISHED("Finished"),
   /**
    * Status for when an appointment is occurring at the moment.
    */
   IN_PROGRESS("In progress");

   private final String status;

   /**
    * Static method for converting a string to status type enum.
    *
    * @param status the status string value.
    * @return the corresponding enum type for the string.
    */
   public static AppointmentStatusEnum toEnum(String status){
      return Arrays.stream(AppointmentStatusEnum.values())
         .filter(
            appointmentStatus -> appointmentStatus.getStatus().equalsIgnoreCase(status)
         )
         .findFirst()
         .orElseThrow(
            () -> new StatusNotValidException(status)
         );
   }
}


