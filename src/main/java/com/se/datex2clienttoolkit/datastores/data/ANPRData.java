package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.se.datex2.schema.SiteMeasurements;

public class ANPRData implements DataObject {
	private String anprIdentifier;
	private Date publicationTime;
	private List<SiteMeasurements> anprData;
	
	public ANPRData() {
	}
	
	public ANPRData(String anprIdentifier, Date publicationTime) {
		super();
		this.anprIdentifier = anprIdentifier;
		this.publicationTime = publicationTime;
		this.anprData = new LinkedList<SiteMeasurements>();
	}

	public String getAnprIdentifier() {
		return anprIdentifier;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public List<SiteMeasurements> getAnprData() {
		return anprData;
	}
	
	public void addSiteMeasurements(SiteMeasurements siteMeasurements){
		anprData.add(siteMeasurements);
	}
	
}
