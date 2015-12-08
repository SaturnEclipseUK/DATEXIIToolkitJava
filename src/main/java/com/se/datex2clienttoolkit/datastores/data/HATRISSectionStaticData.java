package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.PredefinedLocation;

public class HATRISSectionStaticData implements DataObject {

	private String hatrisSectionStaticIdentifier;
	private Date publicationTime;
	private PredefinedLocation hatrisSectionStaticData;
	
	public HATRISSectionStaticData() {
	}
	
	public HATRISSectionStaticData(String hatrisSectionStaticIdentifier, Date publicationTime, PredefinedLocation hatrisSectionStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.hatrisSectionStaticIdentifier = hatrisSectionStaticIdentifier;
		this.hatrisSectionStaticData = hatrisSectionStaticData;
	}

	public String getHATRISSectionStaticIdentifier() {
		return hatrisSectionStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public PredefinedLocation getHATRISSectionStaticData() {
		return hatrisSectionStaticData;
	}
	
}
