package com.ppossatto.chronos.repository;

import com.ppossatto.chronos.model.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * JPA repository interface for the Appointment Entity.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
}
