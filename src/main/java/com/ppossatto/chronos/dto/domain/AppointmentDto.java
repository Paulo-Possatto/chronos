package com.ppossatto.chronos.dto.domain;

import com.ppossatto.chronos.model.enums.AppointmentStatusEnum;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Domain-level DTO for processing data without using the entity ORM.
 *
 * @param id the appointment UUID
 * @param title the appointment title
 * @param description the appointment description
 * @param appointmentDateTime the appointment date time
 * @param appointmentDuration how long the appointment will be (in minutes)
 * @param appointmentLocation where the appointment will take place
 * @param appointmentStatus the appointment status following, look {@link AppointmentStatusEnum}
 * @param applicantId the ID of the person requesting the appointment.
 * @param applicantName the name of the person requesting the appointment.
 * @param participantId the ID of the person who will participate at the appointment.
 * @param participantName the name of the appointment's participant.
 * @param observations some additional observations about the appointment.
 * @param deletedAt when the appointment was deleted (null if it was not)
 * @param createdAt when the appointment was created
 * @param updatedAt when the appointment was updated
 * @param createdBy who created the appointment
 * @param updatedBy who updated the appointment
 */
@Builder
public record AppointmentDto(
   UUID id,
   String title,
   String description,
   LocalDateTime appointmentDateTime,
   Integer appointmentDuration,
   String appointmentLocation,
   AppointmentStatusEnum appointmentStatus,
   UUID applicantId,
   String applicantName,
   UUID participantId,
   String participantName,
   String observations,
   LocalDateTime deletedAt,
   LocalDateTime createdAt,
   LocalDateTime updatedAt,
   String createdBy,
   String updatedBy
   ) {
}
