package com.ppossatto.chronos.unit.service;

import com.ppossatto.chronos.dto.domain.AppointmentDto;
import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.exception.AppointmentNotFoundException;
import com.ppossatto.chronos.mapper.AppointmentMapper;
import com.ppossatto.chronos.model.entity.AppointmentEntity;
import com.ppossatto.chronos.repository.AppointmentRepository;
import com.ppossatto.chronos.service.impl.GetAppointmentServiceImpl;
import com.ppossatto.chronos.unit.mother.AppointmentDtoMother;
import com.ppossatto.chronos.unit.mother.AppointmentEntityMother;
import com.ppossatto.chronos.unit.mother.AppointmentResponseMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.ppossatto.chronos.unit.mother.UnitConstantsMother.APPOINTMENT_ID;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Unit test class for the {@link com.ppossatto.chronos.service.impl.GetAppointmentServiceImpl}
 */
@ExtendWith(MockitoExtension.class)
class GetAppointmentServiceTest {

   @InjectMocks
   private GetAppointmentServiceImpl service;
   @Mock
   private AppointmentMapper mapper;
   @Mock
   private AppointmentRepository repository;

   private static final String APPOINTMENT_NOT_FOUND_EXCEPTION_MESSAGE =
      String.format("Appointment with ID '%s' was not found", APPOINTMENT_ID);

   @Test
   @DisplayName("""
      GIVEN an appointment ID
      WHEN the given ID has no appointment in the database
      THEN validate AppointmentNotFoundException was thrown
      AND validate injections used
      """)
   void whenAppointmentIdIsNotSavedInDatabase_thenValidateExceptionThrown(){
      // Arrange
      when(repository.findById(APPOINTMENT_ID)).thenReturn(Optional.empty());

      // Act && Assert
      AppointmentNotFoundException exception = assertThrowsExactly(
         AppointmentNotFoundException.class,
         () -> service.getAppointmentById(APPOINTMENT_ID)
      );

      assertNotNull(exception);
      assertEquals(
         APPOINTMENT_NOT_FOUND_EXCEPTION_MESSAGE,
         exception.getMessage()
      );

      verify(repository, times(1)).findById(APPOINTMENT_ID);
      verifyNoMoreInteractions(repository);
      verifyNoInteractions(mapper);
   }

   @Test
   @DisplayName("""
      GIVEN an appointment ID
      WHEN the given ID has an appointment in the database
      AND the returned appointment has a deletedAt date
      THEN validate null value was returned
      AND validate injections used
      """)
   void whenAppointmentHasDeletedAtDate_thenValidateNullResponse(){
      // Arrange
      AppointmentEntity entityStub = AppointmentEntityMother.deletedAppointmentStub();
      AppointmentDto dtoStub = AppointmentDtoMother.deletedAppointmentStub();

      when(repository.findById(APPOINTMENT_ID)).thenReturn(
         Optional.of(entityStub)
      );
      when(mapper.fromEntityToDomain(entityStub))
         .thenReturn(dtoStub);

      // Act && Assert
      AppointmentResponse response = assertDoesNotThrow(
         () -> service.getAppointmentById(APPOINTMENT_ID)
      );

      assertNull(response);
      verify(repository, times(1)).findById(APPOINTMENT_ID);
      verifyNoMoreInteractions(repository);
      verify(mapper, times(1))
         .fromEntityToDomain(entityStub);
      verifyNoMoreInteractions(mapper);
   }

   @Test
   @DisplayName("""
      GIVEN an appointment ID
      WHEN the given ID has an appointment in the database
      AND the returned appointment is valid
      THEN validate response returned
      AND validate injections used
      """)
   void whenAppointmentIsValid_thenValidateProcessedResponse(){
      // Arrange
      AppointmentEntity entityStub = AppointmentEntityMother.createdAppointmentStub();
      AppointmentDto dtoStub = AppointmentDtoMother.createdAppointmentStub();
      AppointmentResponse responseStub = AppointmentResponseMother.createdAppointmentResponse();

      when(repository.findById(APPOINTMENT_ID)).thenReturn(
         Optional.of(entityStub)
      );
      when(mapper.fromEntityToDomain(entityStub))
         .thenReturn(dtoStub);
      when(mapper.fromDomainToResponse(dtoStub))
         .thenReturn(responseStub);

      // Act && Assert
      AppointmentResponse response = assertDoesNotThrow(
         () -> service.getAppointmentById(APPOINTMENT_ID)
      );

      assertNotNull(response);
      assertEquals(responseStub, response);
      verify(repository, times(1)).findById(APPOINTMENT_ID);
      verifyNoMoreInteractions(repository);
      verify(mapper, times(1))
         .fromEntityToDomain(entityStub);
      verify(mapper, times(1))
         .fromDomainToResponse(dtoStub);
      verifyNoMoreInteractions(mapper);
   }
}
