package com.se.datex2clienttoolkit.datastores.data;

import java.util.Date;

import com.se.datex2.schema.VmsUnitRecord;

public class MatrixSignalStaticData implements DataObject {

	private String matrixSignalStaticIdentifier;
	private Date publicationTime;
	private VmsUnitRecord matrixSignalStaticData;
	
	public MatrixSignalStaticData() {
	}
	
	public MatrixSignalStaticData(String matrixSignalStaticIdentifier, Date publicationTime, VmsUnitRecord matrixSignalStaticData) {
		super();
		this.publicationTime = publicationTime;
		this.matrixSignalStaticIdentifier = matrixSignalStaticIdentifier;
		this.matrixSignalStaticData = matrixSignalStaticData;
	}

	public String getMatrixSignalStaticIdentifier() {
		return matrixSignalStaticIdentifier;
	}
	
	public Date getPublicationTime() {
		return publicationTime;
	}

	public VmsUnitRecord getMatrixSignalStaticData() {
		return matrixSignalStaticData;
	}
	
}
