package com.instantsystem.hakpak.api.service;

import com.instantsystem.hakpak.commons.dto.parking.ParkingDataDto;

public interface ParkingService {

	ParkingDataDto getParkingData(String ville);

	ParkingDataDto getAroundParkingData(String ville, double lat, double lng, double dist);
}
