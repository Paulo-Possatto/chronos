package com.ppossatto.chronos.service;

import com.ppossatto.chronos.dto.response.AppointmentResponse;

import java.util.UUID;

/**
 * Interface for the Get Appointment endpoint.
 */
public interface GetAppointmentService {

   /**
    * Get individual appointment by id.
    *
    * @param id the appointment UUID.
    * @return the appointment details for given UUID.
    */
   AppointmentResponse getAppointmentById(UUID id);
}
