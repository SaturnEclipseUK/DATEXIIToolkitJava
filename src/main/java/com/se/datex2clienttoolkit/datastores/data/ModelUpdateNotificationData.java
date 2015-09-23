package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.SiteMeasurements;

public class ModelUpdateNotificationData implements DataObject {
	private String anprIdentifier;
	private Date publicationTime;
	private SiteMeasurements anprData;
	
	public ModelUpdateNotificationData() {
	}
	
	public ModelUpdateNotificationData(String anprIdentifier, Date publicationTime,
			SiteMeasurements anprData) {
		super();
		this.anprIdentifier = anprIdentifier;
		this.publicationTime = publicationTime;
		this.anprData = anprData;
	}

	public String getAnprIdentifier() {
		return anprIdentifier;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public SiteMeasurements getAnprData() {
		return anprData;
	}
}
