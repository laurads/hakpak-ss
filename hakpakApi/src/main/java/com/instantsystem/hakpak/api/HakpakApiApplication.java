package com.instantsystem.hakpak.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.instantsystem.hakpak.api.configuration.HakpakApiApplicationConfiguration;

@SpringBootApplication
@Import(HakpakApiApplicationConfiguration.class)
public class HakpakApiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HakpakApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HakpakApiApplication.class, args);
	}
}
