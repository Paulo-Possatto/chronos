package com.ppossatto.chronos.unit.model.enums;

import com.ppossatto.chronos.exception.StatusNotValidException;
import com.ppossatto.chronos.model.enums.AppointmentStatusEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

/**
 * Unit test class for the {@link com.ppossatto.chronos.model.enums.AppointmentStatusEnum} enum.
 */
class AppointmentStatusEnumTest {

   private static final String EXCEPTION_MESSAGE = "'%s' is not a valid status type";

   private static final List<String> CREATED_LIST = Arrays.asList("Created", "CREATED", "created", "cReAtEd");

   private static final List<String> CONFIRMED_LIST = Arrays.asList("Confirmed", "CONFIRMED", "confirmed", "cOnFiRmEd");

   private static final List<String> CANCELLED_LIST = Arrays.asList("Cancelled", "CANCELLED", "cancelled", "cAnCeLlEd");

   private static final List<String> FINISHED_LIST = Arrays.asList("Finished", "FINISHED", "finished", "fInIsHeD");

   private static final List<String> IN_PROGRESS_LIST =
      Arrays.asList("In Progress", "in progress", "In progress", "in Progress", "IN PROGRESS", "iN pRoGrEsS");

   private static final List<String> INVALIDS_LIST = Arrays.asList("invalid", "Not valid", "In_Progress", "NoTwOrKiNg");

   @ParameterizedTest
   @FieldSource("CREATED_LIST")
   @DisplayName("""
      GIVEN a list of Created strings
      WHEN the toEnum method is called
      THEN should return the correct enum value
      """)
   void whenToEnumForCreatedString_thenValidateCorrectEnum(String created){
      AppointmentStatusEnum status = AppointmentStatusEnum.toEnum(created);
      assertEquals(
         AppointmentStatusEnum.CREATED,
         status
      );
   }

   @ParameterizedTest
   @FieldSource("CONFIRMED_LIST")
   @DisplayName("""
      GIVEN a list of Confirmed strings
      WHEN the toEnum method is called
      THEN should return the correct enum value
      """)
   void whenToEnumForConfirmedString_thenValidateCorrectEnum(String confirmed){
      AppointmentStatusEnum status = AppointmentStatusEnum.toEnum(confirmed);
      assertEquals(
         AppointmentStatusEnum.CONFIRMED,
         status
      );
   }

   @ParameterizedTest
   @FieldSource("CANCELLED_LIST")
   @DisplayName("""
      GIVEN a list of Cancelled strings
      WHEN the toEnum method is called
      THEN should return the correct enum value
      """)
   void whenToEnumForCancelledString_thenValidateCorrectEnum(String cancelled){
      AppointmentStatusEnum status = AppointmentStatusEnum.toEnum(cancelled);
      assertEquals(
         AppointmentStatusEnum.CANCELLED,
         status
      );
   }

   @ParameterizedTest
   @FieldSource("FINISHED_LIST")
   @DisplayName("""
      GIVEN a list of Finished strings
      WHEN the toEnum method is called
      THEN should return the correct enum value
      """)
   void whenToEnumForFinishedString_thenValidateCorrectEnum(String finished){
      AppointmentStatusEnum status = AppointmentStatusEnum.toEnum(finished);
      assertEquals(
         AppointmentStatusEnum.FINISHED,
         status
      );
   }

   @ParameterizedTest
   @FieldSource("IN_PROGRESS_LIST")
   @DisplayName("""
      GIVEN a list of In Progress strings
      WHEN the toEnum method is called
      THEN should return the correct enum value
      """)
   void whenToEnumForInProgressString_thenValidateCorrectEnum(String inProgress){
      AppointmentStatusEnum status = AppointmentStatusEnum.toEnum(inProgress);
      assertEquals(
         AppointmentStatusEnum.IN_PROGRESS,
         status
      );
   }

   @ParameterizedTest
   @FieldSource("INVALIDS_LIST")
   @DisplayName("""
      GIVEN a list of Invalid strings
      WHEN the toEnum method is called
      THEN should throw StatusNotValidException
      """)
   void whenToEnumForInvalidString_thenValidateCorrectEnum(String invalid){
      StatusNotValidException exception = assertThrowsExactly(
         StatusNotValidException.class,
         () -> AppointmentStatusEnum.toEnum(invalid)
      );
      String exceptionMessage = String.format(EXCEPTION_MESSAGE, invalid);
      assertEquals(
         exceptionMessage,
         exception.getMessage()
      );
   }
}
