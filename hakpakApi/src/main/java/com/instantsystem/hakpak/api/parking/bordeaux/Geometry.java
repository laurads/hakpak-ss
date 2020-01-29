package com.instantsystem.hakpak.api.parking.bordeaux;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "geometry", namespace = "http://data.bordeaux-metropole.fr/wfs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Geometry {

	@XmlElement(name = "Point", namespace = "http://www.opengis.net/gml", required = true)
	protected Point point;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
