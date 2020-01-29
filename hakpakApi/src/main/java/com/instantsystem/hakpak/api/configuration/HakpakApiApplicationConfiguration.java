package com.instantsystem.hakpak.api.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.instantsystem.hakpak.commons.dto.parking" })
@PropertySource("classpath:application.properties")
public class HakpakApiApplicationConfiguration {

}
