package com.ppossatto.chronos.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * The object response for when an exception is thrown.
 *
 * @param timestamp the date and time of the exception.
 * @param status the HTTP status of the exception.
 * @param error what was the HTTP error.
 * @param message the detailed message about the error.
 */
@Builder
@Schema(
   description = "Response object for when an exception occurs",
   example = """
      {
         "timestamp": "2025-12-04T12:33:42.698546",
         "status": 400,
         "error": "Bad Request",
         "message": "'Abandoned' is not a valid status type"
      }
      """
)
public record ErrorResponse(
   @Schema(
      description = "The LocalDateTime of when the error occurred",
      example = "2025-12-04T12:33:42.698546"
   )
   LocalDateTime timestamp,
   @Schema(
      description = "The HTTP status of the error",
      example = "400"
   )
   Integer status,
   @Schema(
      description = "The HTTP reason phrase of the error",
      example = "Bad Request"
   )
   String error,
   @Schema(
      description = "A detailed message of the error",
      example = "'Abandoned' is not a valid status type"
   )
   String message
) {
}
