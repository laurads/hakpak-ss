package com.instantsystem.hakpak.api.mapper;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.instantsystem.hakpak.api.parking.bordeaux.ParkingBordeaux;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDto;

@Component
public class ParkingBordeauxInterceptor {

	public void interceptParkingPositionToLatitudeAndLogitude(ParkingBordeaux parkingBordeaux, ParkingDto parkingDto) {
		String position = parkingBordeaux.getGeometry().getPoint().getPosition();
		String[] gps = StringUtils.split(position, " ");
		parkingDto.setLatitude(Double.parseDouble(gps[0].trim()));
		parkingDto.setLongitude(Double.parseDouble(gps[1].trim()));
	}
}
