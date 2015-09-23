package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.SiteMeasurements;

public class MIDASData implements DataObject {
	private String midasIdentifier;
	private Date publicationTime;
	private SiteMeasurements midasData;
	
	public MIDASData() {
	}
	
	public MIDASData(String midasIdentifier, Date publicationTime,
			SiteMeasurements midasData) {
		super();
		this.midasIdentifier = midasIdentifier;
		this.publicationTime = publicationTime;
		this.midasData = midasData;
	}

	public String getMIDASIdentifier() {
		return midasIdentifier;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public SiteMeasurements getMIDASData() {
		return midasData;
	}	
}
