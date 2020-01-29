package com.instantsystem.hakpak.api.parking.bordeaux;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ST_PARK_P", namespace = "http://data.bordeaux-metropole.fr/wfs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParkingBordeaux {

	@XmlElement(name = "NOM", namespace = "http://data.bordeaux-metropole.fr/wfs", required = true)
	protected String nom;

	@XmlElement(name = "geometry", namespace = "http://data.bordeaux-metropole.fr/wfs", required = true)
	protected Geometry geometry;

	@XmlElement(name = "LIBRES", namespace = "http://data.bordeaux-metropole.fr/wfs", required = true)
	protected String nbPlacesLibres;

	@XmlElement(name = "TOTAL", namespace = "http://data.bordeaux-metropole.fr/wfs", required = true)
	protected String nbTotalPlaces;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getNbPlacesLibres() {
		return nbPlacesLibres;
	}

	public void setNbPlacesLibres(String nbPlacesLibres) {
		this.nbPlacesLibres = nbPlacesLibres;
	}

	public String getNbTotalPlaces() {
		return nbTotalPlaces;
	}

	public void setNbTotalPlaces(String nbTotalPlaces) {
		this.nbTotalPlaces = nbTotalPlaces;
	}

}
