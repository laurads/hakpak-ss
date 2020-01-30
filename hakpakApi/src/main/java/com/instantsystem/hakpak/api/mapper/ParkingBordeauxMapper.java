package com.instantsystem.hakpak.api.mapper;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.instantsystem.hakpak.api.parking.bordeaux.ParkingBordeaux;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDto;

@Component
public class ParkingBordeauxMapper {

	public ParkingDto asParkingDto(ParkingBordeaux source) {
		ParkingDto result = new ParkingDto();
		result.setNom(source.getNom());
		result.setNbPlacesLibres(source.getNbPlacesLibres());
		result.setNbPlacesTotal(source.getNbTotalPlaces());
		String position = source.getGeometry().getPoint().getPosition();
		String[] gps = StringUtils.split(position, " ");
		result.setLatitude(Double.parseDouble(gps[0].trim()));
		result.setLongitude(Double.parseDouble(gps[1].trim()));
		return result;
	}
}
