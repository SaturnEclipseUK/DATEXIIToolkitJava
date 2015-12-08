package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.MeasurementSiteRecord;

public class TAMEStaticData implements DataObject {

	private String tameStaticIdentifier;
	private Date publicationTime;
	private MeasurementSiteRecord tameStaticData;
	
	public TAMEStaticData() {
	}
	
	public TAMEStaticData(String tameStaticIdentifier, Date publicationTime, MeasurementSiteRecord tameStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.tameStaticIdentifier = tameStaticIdentifier;
		this.tameStaticData = tameStaticData;
	}

	public String getTAMEStaticIdentifier() {
		return tameStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public MeasurementSiteRecord getTAMEStaticData() {
		return tameStaticData;
	}
	
}
