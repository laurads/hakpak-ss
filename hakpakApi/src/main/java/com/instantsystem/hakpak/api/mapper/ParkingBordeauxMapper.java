package com.instantsystem.hakpak.api.mapper;

import com.instantsystem.hakpak.api.parking.bordeaux.ParkingBordeaux;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDto;

import fr.xebia.extras.selma.CollectionMappingStrategy;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withCollectionStrategy = CollectionMappingStrategy.ALLOW_GETTER, withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withIoCServiceName = "parkingBordeauxMapper")
public interface ParkingBordeauxMapper {

	@Maps(withCustom = ParkingBordeauxInterceptor.class, withCustomFields = {
			@Field({ "ParkingBordeaux.nom", "ParkingDto.nom" }),
			@Field({ "ParkingBordeaux.nbPlacesLibres", "ParkingDto.nbPlacesLibres" }),
			@Field({ "ParkingBordeaux.nbTotalPlaces", "ParkingDto.nbPlacesTotal" }) })
	ParkingDto asParkingDto(ParkingBordeaux source);
}
