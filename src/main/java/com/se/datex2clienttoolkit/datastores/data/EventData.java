package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.Situation;

public class EventData implements DataObject {

	private String eventIdentifier;
	private Date publicationTime;
	private Situation eventData;
	
	public EventData() {
	}
	
	public EventData(String eventIdentifier, Date publicationTime, Situation eventData) {
		super();
		this.eventIdentifier = eventIdentifier;
		this.eventData = eventData;
	}

	public String getEventIdentifier() {
		return eventIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public Situation getEventData() {
		return eventData;
	}
	
}
