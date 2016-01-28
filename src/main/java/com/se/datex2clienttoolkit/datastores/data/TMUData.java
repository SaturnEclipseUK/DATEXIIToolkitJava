package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;
import java.util.List;

import com.se.datex2.schema.SiteMeasurements;

public class TMUData implements DataObject {
	private String tmuIdentifier;
	private Date publicationTime;
	private List<SiteMeasurements> tmuData;
	
	public TMUData() {
	}
	
	public TMUData(String tmuIdentifier, Date publicationTime,
			List<SiteMeasurements> tmuData) {
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

	public List<SiteMeasurements> getTMUData() {
		return tmuData;
	}
	
}
