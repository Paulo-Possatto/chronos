package com.ppossatto.chronos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

/**
 * Main application class for the Chronos project.
 */
@SpringBootApplication
@Slf4j
public class ChronosApplication {

   private static final int DASH_REPETITIONS = 100;

   /**
    * Main method for the application.
    *
    * @param args the program arguments if using CLI.
    */
	public static void main(String[] args) {

      Instant applicationStart = Instant.now();
		SpringApplication.run(ChronosApplication.class, args);
      Instant applicationReady = Instant.now();

      long periodToStartInMillis = applicationReady.toEpochMilli() - applicationStart.toEpochMilli();

      log.info("-".repeat(DASH_REPETITIONS));
      log.info("Chronos application started in {} ms", periodToStartInMillis);
      log.info("-".repeat(DASH_REPETITIONS));
	}

}
