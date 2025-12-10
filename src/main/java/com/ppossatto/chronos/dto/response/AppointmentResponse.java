package com.ppossatto.chronos.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * Response data transfer object for individual appointment.
 *
 * @param appointmentId the appointment identification.
 * @param appointmentTitle the appointment title.
 * @param appointmentDescription the appointment description.
 * @param appointmentStartDateTime when the appointment start (yyyy-MM-dd HH:mm:ss).
 * @param appointmentEndDateTime when the appointment end.
 * @param appointmentLocation where the appointment will take place.
 * @param appointmentStatus the appointment status. Check {@link com.ppossatto.chronos.model.enums.AppointmentStatusEnum}.
 * @param applicantName the name of the person who requested the appointment.
 * @param participantName the name of the person who will attend the applicant.
 * @param appointmentObservations additional optional information about the appointment.
 */
@Builder
@Schema(
   description = "Response object with the appointment details.",
   example = """
      {
         "appointmentId": "00000000-0000-0000-0000-000000000000",
         "appointmentTitle": "Customer Appointment",
         "appointmentDescription": "Customer appointment description",
         "appointmentStartDateTime": "2025-12-06 15:30:00",
         "appointmentEndDateTime": "2025-12-06 15:45:00",
         "appointmentLocation": "Appointment location",
         "appointmentStatus": "Confirmed",
         "applicantName": "John Doe",
         "participantName": "John Smith",
         "appointmentObservations": "Some more observations"
      }
      """
)
public record AppointmentResponse(
   @Schema(
      description = "Unique appointment ID",
      example = "00000000-0000-0000-0000-000000000000"
   )
   String appointmentId,
   @Schema(
      description = "The appointment title",
      example = "Professional meeting"
   )
   String appointmentTitle,
   @Schema(
      description = "A brief description about the appointment",
      example = "Meeting with the CTO of the company"
   )
   String appointmentDescription,
   @Schema(
      description = "The date and time of when the appointment will happen",
      example = "2025-12-06 15:30:00"
   )
   String appointmentStartDateTime,
   @Schema(
      description = "The date and time of when the appointment will finish",
      example = "2025-12-06 15:45:00"
   )
   String appointmentEndDateTime,
   @Schema(
      description = "Where the appointment will take place",
      example = "The company CTO office"
   )
   String appointmentLocation,
   @Schema(
      description = "The status of the appointment",
      example = "Confirmed",
      allowableValues = {"Created", "Confirmed", "Cancelled", "Finished", "In progress"}
   )
   String appointmentStatus,
   @Schema(
      description = "The name of the person requesting the appointment",
      example = "John Doe"
   )
   String applicantName,
   @Schema(
      description = "The name of the person who will participate the meeting",
      example = "John Smith"
   )
   String participantName,
   @Schema(
      description = "Additional information about the appointment",
      example = "Ask the receptionist where the CTO is located"
   )
   String appointmentObservations
) {
}
