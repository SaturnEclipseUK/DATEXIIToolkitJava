package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.PredefinedLocation;

public class AlternateRouteStaticData implements DataObject {

	private String alternateRouteStaticIdentifier;
	private Date publicationTime;
	private PredefinedLocation alternateRouteStaticData;
	
	public AlternateRouteStaticData() {
	}
	
	public AlternateRouteStaticData(String alternateRouteStaticIdentifier, Date publicationTime, PredefinedLocation alternateRouteStaticData) {
		super();
		this.alternateRouteStaticIdentifier = alternateRouteStaticIdentifier;
		this.alternateRouteStaticData = alternateRouteStaticData;
	}

	public String getAlternateRouteStaticIdentifier() {
		return alternateRouteStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public PredefinedLocation getAlternateRouteStaticData() {
		return alternateRouteStaticData;
	}
	
}
