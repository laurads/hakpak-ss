package com.instantsystem.hakpak.api.service.impl;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ParkingBordeauxRestTemplate extends RestTemplate {

	public ParkingBordeauxRestTemplate(int connectionTimeout, int readTimeout) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(connectionTimeout);
		clientHttpRequestFactory.setReadTimeout(readTimeout);
		super.setRequestFactory(clientHttpRequestFactory);
	}

	@Override
	protected <T> T doExecute(URI url, org.springframework.http.HttpMethod method, RequestCallback callback,
			final ResponseExtractor<T> responseExtractor) throws RestClientException {
		return super.doExecute(url, method, callback, response -> {
			String contentType = response.getHeaders().getFirst("Content-Type");
			if (contentType.startsWith("text/xml"))
				response.getHeaders().setContentType(MediaType.TEXT_XML);
			return responseExtractor.extractData(response);
		});
	}
}