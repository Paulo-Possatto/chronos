package com.ppossatto.chronos.exception;

/**
 * Exception for when status string is not valid.
 */
public class StatusNotValidException extends RuntimeException {
   /**
    * The constructor for the exception class.
    *
    * @param status the not valid status.
    */
   public StatusNotValidException(String status) {
      super(String.format("'%s' is not a valid status type", status));
   }
}
