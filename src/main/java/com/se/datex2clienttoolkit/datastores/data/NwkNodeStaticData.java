package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.PredefinedLocation;

public class NwkNodeStaticData implements DataObject {

	private String nwkNodeStaticIdentifier;
	private Date publicationTime;
	private PredefinedLocation nwkNodeStaticData;
	
	public NwkNodeStaticData() {
	}
	
	public NwkNodeStaticData(String nwkNodeStaticIdentifier, Date publicationTime, PredefinedLocation nwkNodeStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.nwkNodeStaticIdentifier = nwkNodeStaticIdentifier;
		this.nwkNodeStaticData = nwkNodeStaticData;
	}

	public String getNwkNodeStaticIdentifier() {
		return nwkNodeStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public PredefinedLocation getNwkNodeStaticData() {
		return nwkNodeStaticData;
	}
	
}
