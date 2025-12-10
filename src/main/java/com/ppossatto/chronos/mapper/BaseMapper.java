package com.ppossatto.chronos.mapper;

import com.ppossatto.chronos.model.enums.AppointmentStatusEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Base interface to be used by the mapper interfaces for mapping logic.
 */
public interface BaseMapper {

   /**
    * The date-time format for String to LocalDateTime and vice versa.
    */
   DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

   /**
    * Converts a UUID to a String.
    *
    * @param id the UUID value.
    * @return the String value.
    */
   default String fromUuidToString(UUID id){
      return id.toString();
   }

   /**
    * Converts a LocalDateTime to a String with the correct format.
    *
    * @param localDateTime the LocalDateTime object.
    * @return the string with yyyy-MM-dd HH:mm:ss format.
    */
   default String fromLocalDateTimeToString(LocalDateTime localDateTime){
      return localDateTime.format(FORMATTER);
   }

   /**
    * Calculates the appointmentEndDate based on the appointmentStartDate and the period (in minutes).
    *
    * @param startDate the appointmentStartDate.
    * @param period how long the appointment will take.
    * @return the formatted date-time in String.
    */
   default String calculateAppointmentEndDate(LocalDateTime startDate, int period){
      LocalDateTime finalDateTime = startDate.plusMinutes(period);
      return finalDateTime.format(FORMATTER);
   }

   /**
    * Converts the {@link AppointmentStatusEnum} to a respective string.
    *
    * @param statusEnum the appointment status enum.
    * @return the respective string.
    */
   default String convertStatusEnumToString(AppointmentStatusEnum statusEnum){
      return statusEnum.getStatus();
   }
}
