package com.instantsystem.hakpak.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ApiSpringRestConfiguration {
	
	/**
     * Defines a multipart resolver.
     *
     * @return a multipart resolver.
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(500000);
        return commonsMultipartResolver;
    }

}
