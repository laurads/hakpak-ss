package com.instantsystem.hakpak.api.parking.bordeaux;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Point", namespace = "http://www.opengis.net/gml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Point {

	@XmlElement(name = "pos", namespace = "http://www.opengis.net/gml", required = true)
	protected String position;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
