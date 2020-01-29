package com.instantsystem.hakpak.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.instantsystem.hakpak.api.exception.ParkingNotfoundException;

@ControllerAdvice
public class ParkingExceptionController {

	@ExceptionHandler(value = ParkingNotfoundException.class)
	public ResponseEntity<Object> exception(ParkingNotfoundException exception) {
		return new ResponseEntity<>("Parking not found", HttpStatus.NOT_FOUND);
	}
}
