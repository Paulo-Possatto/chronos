package com.ppossatto.chronos.exception;

/**
 * Exception class for when an appointment is not found.
 */
public class AppointmentNotFoundException extends RuntimeException {
   /**
    * Constructor for when an appointment is not found.
    *
    * @param appointmentId the appointment UUID in String format.
    */
   public AppointmentNotFoundException(String appointmentId) {
      super(String.format(
         "Appointment with ID '%s' was not found", appointmentId
      ));
   }
}
