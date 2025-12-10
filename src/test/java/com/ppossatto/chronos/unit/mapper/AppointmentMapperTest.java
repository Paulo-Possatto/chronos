package com.ppossatto.chronos.unit.mapper;

import com.ppossatto.chronos.dto.domain.AppointmentDto;
import com.ppossatto.chronos.dto.response.AppointmentResponse;
import com.ppossatto.chronos.mapper.AppointmentMapper;
import com.ppossatto.chronos.model.entity.AppointmentEntity;
import com.ppossatto.chronos.unit.mother.AppointmentDtoMother;
import com.ppossatto.chronos.unit.mother.AppointmentEntityMother;
import com.ppossatto.chronos.unit.mother.AppointmentResponseMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test class for the {@link AppointmentMapper} interface.
 */
@SpringBootTest
@ActiveProfiles("test")
class AppointmentMapperTest {

   @Autowired
   private AppointmentMapper mapper;

   @Test
   @DisplayName("""
      GIVEN an Entity ORM
      WHEN the method fromEntityToDomain from the mapper is called
      THEN should map the entity correctly
      """)
   void givenEntity_whenMapEntityToDomain_thenValidateMappedObject(){
      // Arrange
      AppointmentEntity entity = AppointmentEntityMother.createdAppointmentStub();

      // Act
      AppointmentDto response = mapper.fromEntityToDomain(entity);

      // Assert
      assertNotNull(response);
      assertEquals(
         AppointmentDtoMother.createdAppointmentStub(),
         response
      );
   }

   @Test
   @DisplayName("""
      GIVEN a domain DTO
      WHEN the method fromDomainToResponse from the mapper is called
      THEN should map the DTO to Response correctly
      """)
   void givenDomainObject_whenDomainToResponse_thenValidateMappedObject(){
      // Arrange
      AppointmentDto dto = AppointmentDtoMother.createdAppointmentStub();

      // Act
      AppointmentResponse response = mapper.fromDomainToResponse(dto);

      // Assert
      assertNotNull(response);
      assertEquals(
         AppointmentResponseMother.createdAppointmentResponse(),
         response
      );
   }
}
