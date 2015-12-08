package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.MeasurementSiteRecord;

public class ANPRStaticData implements DataObject {

	private String anprStaticIdentifier;
	private Date publicationTime;
	private MeasurementSiteRecord anprStaticData;
	
	public ANPRStaticData() {
	}
	
	public ANPRStaticData(String anprStaticIdentifier, Date publicationTime, MeasurementSiteRecord anprStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.anprStaticIdentifier = anprStaticIdentifier;
		this.anprStaticData = anprStaticData;
	}

	public String getANPRStaticIdentifier() {
		return anprStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public MeasurementSiteRecord getANPRStaticData() {
		return anprStaticData;
	}
	
}
