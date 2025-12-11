package com.ppossatto.chronos.controller;

import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.dto.response.ErrorResponse;
import com.ppossatto.chronos.service.GetAppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
   @Tag(name = "Appointment")
   @Operation(
      summary = "Get an appointment by its ID",
      description = "Controller that returns an appointment data based on the appointment ID sent as a path parameter",
      operationId = "getAppointmentById"
   )
   @ApiResponses(
      value = {
         @ApiResponse(
            responseCode = "200",
            description = "The query found an appointment and its data is processed and returned correctly",
            content = @Content(
               mediaType = MediaType.APPLICATION_JSON_VALUE,
               schema = @Schema(
                  name = "AppointmentResponse",
                  description = "The processed appointment data returned after the query",
                  type = "object",
                  implementation = AppointmentResponse.class
               )
            )
         ),
         @ApiResponse(
            responseCode = "204",
            description = "The query found an appointment based on the given ID, but the appointment has been cancelled",
            content = @Content(
               schema = @Schema()
            )
         ),
         @ApiResponse(
            responseCode = "404",
            description = "The query did not found any appointment with the given ID",
            content = @Content(
               mediaType = MediaType.APPLICATION_JSON_VALUE,
               schema = @Schema(
                  name = "ErrorResponse",
                  description = "The information about the error",
                  type = "object",
                  implementation = ErrorResponse.class,
                  example = """
                     {
                        "timestamp": "2025-12-04T12:33:42.698546",
                        "status": 404,
                        "error": "Not Found",
                        "message": "Appointment with ID '5de38331-9f47-4c38-bf9e-f88f9ef1929d' was not found"
                     }
                     """
               )
            )
         )
      }
   )
   public ResponseEntity<AppointmentResponse> getAppointmentById(
      @Parameter(
         name = "appointmentId",
         description = "The appointment identification stored in the database",
         in = ParameterIn.PATH,
         required = true
      )
      @PathVariable("appointmentId") UUID appointmentId
   ) {
      Optional<AppointmentResponse> appointment =
         Optional.ofNullable(service.getAppointmentById(appointmentId));

      return appointment
         .map(ResponseEntity::ok)
         .orElseGet(
            () -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()
         );
   }
}
