package com.instantsystem.hakpak.commons.dto.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingDataDto {

	private List<ParkingDto> parkings;

	public List<ParkingDto> getParkings() {
		if (parkings == null) {
			parkings = new ArrayList<>();
		}
		return parkings;
	}

	public void setParkings(List<ParkingDto> parkings) {
		this.parkings = parkings;
	}

}
