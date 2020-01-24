package com.instantsystem.hakpak.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/rest/parking")
@Controller
public class ParkingController {

	@GetMapping("/")
	// @PreAuthorize("hasAnyRole('P_ASTRID_BASIC_CONSULTATION')")
	public ResponseEntity<String> getParkingist() {
		System.out.println("Demarrage des services OK .....");
		return new ResponseEntity<String>("Reponse du serveur: " + HttpStatus.OK.name(), HttpStatus.OK);
	}
}
