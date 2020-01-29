package com.instantsystem.hakpak.api.service.impl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.instantsystem.hakpak.api.mapper.ParkingBordeauxMapper;
import com.instantsystem.hakpak.api.parking.bordeaux.ParkingBordeauxData;
import com.instantsystem.hakpak.api.service.ParkingService;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDataDto;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDto;
import com.instantsystem.hakpak.commons.helper.GpsHelper;

@Service
public class ParkingBordeauxService implements ParkingService {

	private ParkingBordeauxMapper parkingBordeauxMapper;

	public ParkingBordeauxService(ParkingBordeauxMapper parkingBordeauxMapper) {
		this.parkingBordeauxMapper = parkingBordeauxMapper;
	}

	@Override
	@Cacheable(value = "parkings", key = "#ville", unless = "#result.parkings==null")
	public ParkingDataDto getParkingData(String ville) {
		final ParkingDataDto parkingDataDto = new ParkingDataDto();
		getParkingBordeauxData().getFeatureMembers().forEach(f -> {
			parkingDataDto.getParkings().add(this.parkingBordeauxMapper.asParkingDto(f.getParking()));
		});
		return parkingDataDto;
	}

	@Override
	public ParkingDataDto getAroundParkingData(String ville, double lat, double lng, double dist) {
		ParkingDataDto result = getParkingData(ville);
		List<ParkingDto> parkings = result.getParkings();

		Predicate<ParkingDto> aroundTo = parking -> GpsHelper.isAroundTo(lat, lng, parking.getLatitude(),
				parking.getLongitude(), dist);

		result.setParkings(parkings.stream().filter(aroundTo).collect(Collectors.toList()));

		return result;
	}

	private ParkingBordeauxData getParkingBordeauxData() {
		ParkingBordeauxRestTemplate restTemplate = new ParkingBordeauxRestTemplate();
		final String url = "http://data.lacub.fr/wfs?key=9Y2RU3FTE8&SERVICE=WFS&VERSION=1.1.0&REQUEST=GetFeature&TYPENAME=ST_PARK_P&SRSNAME=EPSG:4326";
		return restTemplate.getForObject(url, ParkingBordeauxData.class);
	}
}
