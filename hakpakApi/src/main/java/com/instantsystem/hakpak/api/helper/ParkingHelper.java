package com.instantsystem.hakpak.api.helper;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

import com.instantsystem.hakpak.commons.dto.parking.ParkingDataDto;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDto;
import com.instantsystem.hakpak.commons.helper.GpsHelper;

public class ParkingHelper {

	public static ParkingDataDto getAroundParkingData(ParkingDataDto parkingData, double lat, double lng, double dist) {
		ParkingDataDto aroundParkingData = (ParkingDataDto) SerializationUtils.clone(parkingData);

		List<ParkingDto> parkings = aroundParkingData.getParkings();

		Predicate<ParkingDto> aroundTo = parking -> GpsHelper.isAroundTo(lat, lng, parking.getLatitude(),
				parking.getLongitude(), dist);

		aroundParkingData.setParkings(parkings.stream().filter(aroundTo).collect(Collectors.toList()));

		return aroundParkingData;
	}

}
