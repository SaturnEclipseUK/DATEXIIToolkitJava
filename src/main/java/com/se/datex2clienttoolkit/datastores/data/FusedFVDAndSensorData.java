package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.ElaboratedData;

public class FusedFVDAndSensorData implements DataObject {

	private String fusedFVDSensorIdentifier;
	private Date publicationTime;
	private Date timeDefault;
	private ElaboratedData elaboratedData;
	
	public FusedFVDAndSensorData() {
	}

	public FusedFVDAndSensorData(String fusedFVDSensorIdentifier, Date publicationTime, Date timeDefault,
			ElaboratedData elaboratedData) {
		super();
		this.fusedFVDSensorIdentifier = fusedFVDSensorIdentifier;
		this.publicationTime = publicationTime;
		this.timeDefault = timeDefault;
		this.elaboratedData = elaboratedData;
	}

	public String getFusedFVDSensorIdentifier() {
		return fusedFVDSensorIdentifier;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public Date getTimeDefault() {
		return timeDefault;
	}
	
	public ElaboratedData getElaboratedData() {
		return elaboratedData;
	}
	
}
