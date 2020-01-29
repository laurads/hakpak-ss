package com.instantsystem.hakpak.api.parking.bordeaux;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "featureMember", namespace = "http://www.opengis.net/gml")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeatureMember {

	@XmlElement(name = "ST_PARK_P", namespace = "http://data.bordeaux-metropole.fr/wfs", required = true)
	protected ParkingBordeaux parking;

	@XmlElement(name = "geometry", namespace = "http://data.bordeaux-metropole.fr/wfs", required = true)
	protected ParkingBordeaux parkgeometry;

	public ParkingBordeaux getParking() {
		return parking;
	}

	public void setParking(ParkingBordeaux parking) {
		this.parking = parking;
	}

}
