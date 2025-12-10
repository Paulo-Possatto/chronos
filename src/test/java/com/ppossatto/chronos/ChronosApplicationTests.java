package com.ppossatto.chronos;

import com.ppossatto.chronos.config.TestcontainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ChronosApplicationTests {

   @Autowired
   private TestRestTemplate restTemplate;

	@Test
   @DisplayName("Validation for: Actuator")
	void contextLoads() {
      var actuatorResponse = restTemplate.getForEntity("/actuator", Void.class);
      assertEquals(HttpStatus.OK, actuatorResponse.getStatusCode());
	}

}
