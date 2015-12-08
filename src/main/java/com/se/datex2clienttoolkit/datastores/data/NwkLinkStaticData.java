package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.PredefinedLocation;

public class NwkLinkStaticData implements DataObject {

	private String nwkLinkStaticIdentifier;
	private Date publicationTime;
	private PredefinedLocation nwkLinkStaticData;
	
	public NwkLinkStaticData() {
	}
	
	public NwkLinkStaticData(String nwkLinkStaticIdentifier, Date publicationTime, PredefinedLocation nwkLinkStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.nwkLinkStaticIdentifier = nwkLinkStaticIdentifier;
		this.nwkLinkStaticData = nwkLinkStaticData;
	}

	public String getNwkLinkStaticIdentifier() {
		return nwkLinkStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public PredefinedLocation getNwkLinkStaticData() {
		return nwkLinkStaticData;
	}
	
}
