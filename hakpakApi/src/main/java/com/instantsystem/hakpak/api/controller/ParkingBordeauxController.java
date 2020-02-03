package com.instantsystem.hakpak.api.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instantsystem.hakpak.api.exception.ParkingNotfoundException;
import com.instantsystem.hakpak.api.helper.ParkingHelper;
import com.instantsystem.hakpak.api.service.ParkingService;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDataDto;

//@Api(value = "Parking", tags = { "Parking" })
@RestController
@RequestMapping(value = "/rest/parking/bordeaux")
public class ParkingBordeauxController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingBordeauxController.class);

	private static final String CITY = "Bordeaux";

	@Autowired
	private ParkingService service;

	@GetMapping(value = "/all", produces = { "application/json" })
	public ParkingDataDto getParkingList() {

		LOGGER.debug("Reception of an all-parking request city of {}", CITY);

		ParkingDataDto data = service.getParkingData();

		if (CollectionUtils.isEmpty(data.getParkings())) {
			LOGGER.warn("No parking found city of {}", CITY);
			throw new ParkingNotfoundException();
		}
		return data;
	}

	@GetMapping(value = "/all/around/{lat}/{lng}/{dist}", produces = { "application/json" })
	public ParkingDataDto getParkingList(@PathVariable Double lat, @PathVariable Double lng,
			@PathVariable Double dist) {

		LOGGER.debug("Reception of an around-parking request city of {}: latitude={}, longitude={}, distance={}", CITY,
				lat, lng, dist);

		ParkingDataDto data = service.getParkingData();
		data = ParkingHelper.getAroundParkingData(data, lat, lng, dist);

		if (CollectionUtils.isEmpty(data.getParkings())) {
			LOGGER.debug("No parking found for city of {} and for location [{}, {}] and within {}m radius", CITY, lat,
					lng, dist);
			throw new ParkingNotfoundException();
		}
		return data;
	}

}
