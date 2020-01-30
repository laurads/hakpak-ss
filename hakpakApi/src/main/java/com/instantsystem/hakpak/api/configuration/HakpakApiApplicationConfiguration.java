package com.instantsystem.hakpak.api.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.instantsystem.hakpak.api.mapper.ParkingBordeauxMapper;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.instantsystem.hakpak.commons.dto.parking", "com.instantsystem.hakpak.api" })
@PropertySource("classpath:application.properties")
public class HakpakApiApplicationConfiguration {

	public ParkingBordeauxMapper parkingBordeauxMapper() {
		return null;
	}
}
