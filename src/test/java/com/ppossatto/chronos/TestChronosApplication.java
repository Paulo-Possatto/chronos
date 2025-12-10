package com.ppossatto.chronos;

import com.ppossatto.chronos.config.TestcontainersConfiguration;
import org.springframework.boot.SpringApplication;

public class TestChronosApplication {

	public static void main(String[] args) {
		SpringApplication.from(ChronosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
