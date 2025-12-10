package com.ppossatto.chronos.model.entity;

import com.ppossatto.chronos.model.enums.AppointmentStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The entity class (ORM) for the Appointment table
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class AppointmentEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @Column(name = "title", length = 100, nullable = false)
   private String title;

   @Column(name = "description", nullable = false, columnDefinition = "TEXT")
   private String description;

   @Column(name = "date_time", nullable = false)
   private LocalDateTime appointmentDateTime;

   @Column(name = "duration", nullable = false)
   private Integer appointmentDuration;

   @Column(name = "location", nullable = false)
   private String location;

   @Enumerated(EnumType.STRING)
   @Column(name = "status", length = 50, nullable = false)
   private AppointmentStatusEnum appointmentStatus;

   @Column(name = "applicant_id", nullable = false)
   private UUID applicantId;

   @Column(name = "applicant_name", nullable = false)
   private String applicantName;

   @Column(name = "participant_id", nullable = false)
   private UUID participantId;

   @Column(name = "participant_name", nullable = false)
   private String participantName;

   @Column(name = "observations", columnDefinition = "TEXT")
   private String observations;

   @Column(name = "deleted_at")
   private LocalDateTime deletedAt;

   @CreatedDate
   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @LastModifiedDate
   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;

   @CreatedBy
   @Column(name = "created_by")
   private String createdBy;

   @LastModifiedBy
   @Column(name = "updated_by")
   private String updatedBy;
}
