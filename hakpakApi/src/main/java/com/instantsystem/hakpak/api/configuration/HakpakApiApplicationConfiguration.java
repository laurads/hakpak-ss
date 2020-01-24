package com.instantsystem.hakpak.api.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
// @EnableWebSecurity
@PropertySource("classpath:application.properties")
public class HakpakApiApplicationConfiguration {

}
