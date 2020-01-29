package com.instantsystem.hakpak.api.parking.bordeaux;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FeatureCollection", namespace = "http://www.opengis.net/wfs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParkingBordeauxData {

	@XmlElement(name = "featureMember", namespace = "http://www.opengis.net/gml", required = true)
	protected List<FeatureMember> featureMembers;

	public List<FeatureMember> getFeatureMembers() {
		return featureMembers;
	}

	public void setFeatureMembers(List<FeatureMember> featureMembers) {
		this.featureMembers = featureMembers;
	}

}
