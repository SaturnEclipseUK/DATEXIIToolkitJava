package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.ElaboratedData;

public class FusedSensorOnlyData implements DataObject {

	private String fusedSensorOnlyIdentifier;
	private Date publicationTime;
	private Date timeDefault;
	private ElaboratedData elaboratedData;
	
	public FusedSensorOnlyData() {
	}

	public FusedSensorOnlyData(String fusedSensorOnlyIdentifier, Date publicationTime, Date timeDefault,
			ElaboratedData elaboratedData) {
		super();
		this.fusedSensorOnlyIdentifier = fusedSensorOnlyIdentifier;
		this.publicationTime = publicationTime;
		this.timeDefault = timeDefault;
		this.elaboratedData = elaboratedData;
	}

	public String getFusedSensorOnlyIdentifier() {
		return fusedSensorOnlyIdentifier;
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
