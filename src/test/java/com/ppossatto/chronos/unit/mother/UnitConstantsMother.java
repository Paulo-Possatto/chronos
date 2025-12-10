package com.ppossatto.chronos.unit.mother;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Constant values used for the unit tests.
 */
public class UnitConstantsMother {

   private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

   /**
    * The String value for the UUID mock.
    */
   public static final String APPOINTMENT_ID_STRING = "b535b178-2f31-43e8-aaa2-ec5f436070ca";

   /**
    * The UUID mock used for unit testing.
    */
   public static final UUID APPOINTMENT_ID = UUID.fromString(APPOINTMENT_ID_STRING);

   /**
    * The title mock used for unit testing.
    */
   public static final String TITLE = "Appointment test";

   /**
    * The description mock for unit testing.
    */
   public static final String DESCRIPTION = "Test description for validation";

   /**
    * The string value for the appointment date time mock used for unit testing.
    */
   public static final String APPOINTMENT_DATE_TIME_STRING = "2025-12-06 15:45:00";

   /**
    * The string value for the appointment end date used only for {@link com.ppossatto.chronos.dto.response.AppointmentResponse} stubs.
    */
   public static final String APPOINTMENT_END_DATE_TIME_STRING = "2025-12-06 16:15:00";

   /**
    * The stub for the location parameter for unit testing.
    */
   public static final String APPOINTMENT_LOCATION = "Location test";

   /**
    * The appointment date time mock for unit testing.
    */
   public static final LocalDateTime APPOINTMENT_DATE_TIME =
      LocalDateTime.parse(APPOINTMENT_DATE_TIME_STRING, FORMATTER);

   /**
    * The appointment duration (in minutes) mock for unit testing.
    */
   public static final int APPOINTMENT_DURATION = 30;

   /**
    * The applicant id string value for the UUID mock.
    */
   public static final String APPLICANT_ID_STRING = "6f115dc1-97d0-4101-a251-73bb362248a1";

   /**
    * The applicant id mock for unit testing.
    */
   public static final UUID APPLICANT_ID = UUID.fromString(APPLICANT_ID_STRING);

   /**
    * The applicant name mock for unit testing.
    */
   public static final String APPLICANT_NAME = "John Doe";

   /**
    * The participant id string value for the UUID mock.
    */
   public static final String PARTICIPANT_ID_STRING = "8ccd160f-bc30-4930-8e1f-1bd93ec52fd8";

   /**
    * The participant id mock for testing.
    */
   public static final UUID PARTICIPANT_ID = UUID.fromString(PARTICIPANT_ID_STRING);

   /**
    * The participant name mock for testing.
    */
   public static final String PARTICIPANT_NAME = "John Smith";

   /**
    * The observations mock for unit testing.
    */
   public static final String OBSERVATIONS = "Testing observations";

   /**
    * String value for the created at parameter for unit test.
    */
   public static final String CREATED_AT_STRING = "2025-11-24 13:37:00";

   /**
    * String value for the updated at parameter for unit test.
    */
   public static final String UPDATED_AT_STRING = "2025-11-28 15:41:00";

   /**
    * String value for the deleted at parameter for unit test.
    */
   public static final String DELETED_AT_STRING = "2025-11-28 15:41:00";

   /**
    * The mock value for the deleted at parameter for unit testing.
    */
   public static final LocalDateTime DELETED_AT = LocalDateTime.parse(DELETED_AT_STRING, FORMATTER);

   /**
    * The mock value for the created at parameter for unit testing.
    */
   public static final LocalDateTime CREATED_AT = LocalDateTime.parse(CREATED_AT_STRING, FORMATTER);

   /**
    * The mock value for the updated at parameter for unit testing.
    */
   public static final LocalDateTime UPDATED_AT = LocalDateTime.parse(UPDATED_AT_STRING, FORMATTER);

}
