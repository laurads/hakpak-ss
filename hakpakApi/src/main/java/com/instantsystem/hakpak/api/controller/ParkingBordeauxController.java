package com.instantsystem.hakpak.api.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instantsystem.hakpak.api.exception.ParkingNotfoundException;
import com.instantsystem.hakpak.api.service.impl.ParkingBordeauxService;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDataDto;

//@Api(value = "Parking", tags = { "Parking" })
@RestController
@RequestMapping(value = "/rest/parking/bordeaux")
public class ParkingBordeauxController {
	private final static String VILLE = "bordeaux";

	@Autowired
	private ParkingBordeauxService service;

	@GetMapping(value = "/all", produces = { "application/json" })
	public ParkingDataDto getParkingList() {
		ParkingDataDto data = service.getParkingData(VILLE);
		if (CollectionUtils.isEmpty(data.getParkings())) {
			throw new ParkingNotfoundException();
		}
		return data;
	}

	@GetMapping(value = "/all/around/{lat}/{lng}/{dist}", produces = { "application/json" })
	public ParkingDataDto getParkingList(@PathVariable Double lat, @PathVariable Double lng,
			@PathVariable Double dist) {
		ParkingDataDto data = service.getAroundParkingData(VILLE, lat, lng, dist);
		if (CollectionUtils.isEmpty(data.getParkings())) {
			throw new ParkingNotfoundException();
		}
		return data;
	}

}
