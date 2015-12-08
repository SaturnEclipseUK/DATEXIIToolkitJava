package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.PredefinedLocation;

public class ANPRRouteStaticData implements DataObject {

	private String anprRouteStaticIdentifier;
	private Date publicationTime;
	private PredefinedLocation anprRouteStaticData;
	
	public ANPRRouteStaticData() {
	}
	
	public ANPRRouteStaticData(String anprRouteStaticIdentifier, Date publicationTime, PredefinedLocation anprRouteStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.anprRouteStaticIdentifier = anprRouteStaticIdentifier;
		this.anprRouteStaticData = anprRouteStaticData;
	}

	public String getANPRRouteStaticIdentifier() {
		return anprRouteStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public PredefinedLocation getANPRRouteStaticData() {
		return anprRouteStaticData;
	}
	
}
