package com.instantsystem.hakpak.api.controller;

import java.net.SocketTimeoutException;

import org.apache.http.conn.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.instantsystem.hakpak.api.exception.ParkingNotfoundException;

@ControllerAdvice
public class ParkingExceptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingExceptionController.class);

	@ExceptionHandler(ParkingNotfoundException.class)
	public ResponseEntity<Object> exception(ParkingNotfoundException exception) {
		return new ResponseEntity<>("Parking not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ ConnectTimeoutException.class, SocketTimeoutException.class })
	public ResponseEntity<Object> exception() {
		LOGGER.warn("A http timeout exception has been thrown");
		return new ResponseEntity<>("Service temporarily unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
