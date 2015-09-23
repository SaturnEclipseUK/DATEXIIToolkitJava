package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.SiteMeasurements;

public class TMUData implements DataObject {
	private String tmuIdentifier;
	private Date publicationTime;
	private SiteMeasurements tmuData;
	
	public TMUData() {
	}
	
	public TMUData(String tmuIdentifier, Date publicationTime,
			SiteMeasurements tmuData) {
		super();
		this.tmuIdentifier = tmuIdentifier;
		this.publicationTime = publicationTime;
		this.tmuData = tmuData;
	}

	public String getTMUIdentifier() {
		return tmuIdentifier;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public SiteMeasurements getTMUData() {
		return tmuData;
	}
	
}
