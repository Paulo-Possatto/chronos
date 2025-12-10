package com.ppossatto.chronos.mapper;

import com.ppossatto.chronos.dto.domain.AppointmentDto;
import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.model.entity.AppointmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for Appointment objects using MapStruct.
 */
@Mapper(
   componentModel = MappingConstants.ComponentModel.SPRING
)
@Component
public interface AppointmentMapper extends BaseMapper {

   /**
    * Maps the entity ORM to a domain object.
    *
    * @param entity the Entity ORM. Check {@link AppointmentEntity}
    * @return a mapped domain object. Check {@link AppointmentDto}
    */
   @Mapping(
      target = "appointmentLocation",
      source = "location"
   )
   AppointmentDto fromEntityToDomain(AppointmentEntity entity);

   /**
    * Maps the domain object to a response DTO.
    *
    * @param domain the domain appointment object. Check {@link AppointmentDto}
    * @return the response DTO object. Check {@link AppointmentResponse}
    */
   @Mapping(
      target = "appointmentTitle",
      source = "title"
   )
   @Mapping(
      target = "appointmentStatus",
      expression = "java(convertStatusEnumToString(domain.appointmentStatus()))"
   )
   @Mapping(
      target = "appointmentObservations",
      source = "observations"
   )
   @Mapping(
      target = "appointmentStartDateTime",
      expression = "java(fromLocalDateTimeToString(domain.appointmentDateTime()))"
   )
   @Mapping(
      target = "appointmentEndDateTime",
      expression = "java(calculateAppointmentEndDate(domain.appointmentDateTime(), domain.appointmentDuration()))"
   )
   @Mapping(
      target = "appointmentDescription",
      source = "description"
   )
   @Mapping(
      target = "appointmentId",
      expression = "java(fromUuidToString(domain.id()))"
   )
   AppointmentResponse fromDomainToResponse(AppointmentDto domain);
}
