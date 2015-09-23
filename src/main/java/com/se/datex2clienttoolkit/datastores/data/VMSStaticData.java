package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.VmsUnitRecord;

public class VMSStaticData implements DataObject {

	private String vmsStaticIdentifier;
	private Date publicationTime;
	private VmsUnitRecord vmsStaticData;
	
	public VMSStaticData() {
	}
	
	public VMSStaticData(String vmsStaticIdentifier, Date publicationTime, VmsUnitRecord vmsStaticData) {
		super();
		this.vmsStaticIdentifier = vmsStaticIdentifier;
		this.vmsStaticData = vmsStaticData;
	}

	public String getVMSStaticIdentifier() {
		return vmsStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public VmsUnitRecord getVMSStaticData() {
		return vmsStaticData;
	}
	
}
