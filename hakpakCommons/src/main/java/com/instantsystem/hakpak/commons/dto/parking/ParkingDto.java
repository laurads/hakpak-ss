package com.instantsystem.hakpak.commons.dto.parking;

public class ParkingDto {
	private String nom;
	private double latitude;
	private double longitude;
	private String nbPlacesTotal;
	private String nbPlacesLibres;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getNbPlacesTotal() {
		return nbPlacesTotal;
	}

	public void setNbPlacesTotal(String nbPlacesTotal) {
		this.nbPlacesTotal = nbPlacesTotal;
	}

	public String getNbPlacesLibres() {
		return nbPlacesLibres;
	}

	public void setNbPlacesLibres(String nbPlacesLibres) {
		this.nbPlacesLibres = nbPlacesLibres;
	}

}
