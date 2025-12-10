package com.ppossatto.chronos.controller;

import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.service.GetAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller class for getting a specific appointment.
 */
@RestController
@RequestMapping(path = "/api/v1/appointments")
@RequiredArgsConstructor
public class GetAppointmentByIdController {

   private final GetAppointmentService service;

   /**
    * Endpoint for getting a specific appointment.
    *
    * @param appointmentId the appointment UUID.
    * @return the {@link AppointmentResponse} information.
    */
   @GetMapping(path = "/{appointmentId}")
   public ResponseEntity<AppointmentResponse> getAppointmentById(
      @PathVariable("appointmentId")UUID appointmentId
   ){
      Optional<AppointmentResponse> appointment =
         Optional.ofNullable(service.getAppointmentById(appointmentId));

      return appointment
         .map(ResponseEntity::ok)
         .orElseGet(
            () -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()
         );
   }
}
