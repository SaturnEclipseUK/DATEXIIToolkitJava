package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.MeasurementSiteRecord;

public class TMUStaticData implements DataObject {

	private String tmuStaticIdentifier;
	private Date publicationTime;
	private MeasurementSiteRecord tmuStaticData;
	
	public TMUStaticData() {
	}
	
	public TMUStaticData(String tmuStaticIdentifier, Date publicationTime, MeasurementSiteRecord tmuStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.tmuStaticIdentifier = tmuStaticIdentifier;
		this.tmuStaticData = tmuStaticData;
	}

	public String getTMUStaticIdentifier() {
		return tmuStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public MeasurementSiteRecord getTMUStaticData() {
		return tmuStaticData;
	}
	
}
