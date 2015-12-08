package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.PredefinedLocation;

public class LinkShapeStaticData implements DataObject {

	private String linkShapeStaticIdentifier;
	private Date publicationTime;
	private PredefinedLocation linkShapeStaticData;
	
	public LinkShapeStaticData() {
	}
	
	public LinkShapeStaticData(String linkShapeStaticIdentifier, Date publicationTime, PredefinedLocation linkShapeStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.linkShapeStaticIdentifier = linkShapeStaticIdentifier;
		this.linkShapeStaticData = linkShapeStaticData;
	}

	public String getLinkShapeStaticIdentifier() {
		return linkShapeStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public PredefinedLocation getLinkShapeStaticData() {
		return linkShapeStaticData;
	}
	
}
