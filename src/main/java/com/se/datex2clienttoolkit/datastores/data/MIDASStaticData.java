package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.MeasurementSiteRecord;

public class MIDASStaticData implements DataObject {

	private String midasStaticIdentifier;
	private Date publicationTime;
	private MeasurementSiteRecord midasStaticData;
	
	public MIDASStaticData() {
	}
	
	public MIDASStaticData(String midasStaticIdentifier, Date publicationTime, MeasurementSiteRecord midasStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.midasStaticIdentifier = midasStaticIdentifier;
		this.midasStaticData = midasStaticData;
	}

	public String getMIDASStaticIdentifier() {
		return midasStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public MeasurementSiteRecord getMIDASStaticData() {
		return midasStaticData;
	}
	
}
