package com.ppossatto.chronos.service.impl;

import com.ppossatto.chronos.dto.domain.AppointmentDto;
import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.exception.AppointmentNotFoundException;
import com.ppossatto.chronos.mapper.AppointmentMapper;
import com.ppossatto.chronos.repository.AppointmentRepository;
import com.ppossatto.chronos.service.GetAppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementation class for the {@link GetAppointmentService} interface.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetAppointmentServiceImpl implements GetAppointmentService {

   private final AppointmentMapper mapper;
   private final AppointmentRepository repository;

   @Override
   public AppointmentResponse getAppointmentById(UUID id) {
      var appointment = repository
         .findById(id)
         .map(mapper::fromEntityToDomain)
         .orElseThrow(
            () -> new AppointmentNotFoundException(id.toString())
         );

      return Optional.of(appointment)
         .filter(this::isAppointmentNotActive)
         .map(mapper::fromDomainToResponse)
         .orElse(null);
   }

   private boolean isAppointmentNotActive(AppointmentDto dto){
      return dto.deletedAt() == null;
   }
}
