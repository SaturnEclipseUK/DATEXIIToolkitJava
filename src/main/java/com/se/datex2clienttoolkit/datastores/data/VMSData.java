package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.VmsUnit;

public class VMSData implements DataObject {

	private String vmsIdentifier;
	private Date publicationTime;
	private VmsUnit vmsData;
	
	public VMSData() {
	}

	public VMSData(String vmsIdentifier, Date publicationTime, VmsUnit vmsData) {
		super();
		this.vmsIdentifier = vmsIdentifier;
		this.publicationTime = publicationTime;
		this.vmsData = vmsData;
	}

	public String getVmsIdentifier() {
		return vmsIdentifier;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public VmsUnit getVmsData() {
		return vmsData;
	}	
}
