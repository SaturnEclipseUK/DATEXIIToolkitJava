package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.MatrixSignalStaticData;

/**
 * 
 * This data store contains the MatrixSignalStatic data indexed by VMS unit record ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class MatrixSignalStaticDataStore extends DataStore{

	public MatrixSignalStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		MatrixSignalStaticData matrixSignalStaticData = (MatrixSignalStaticData)data; 
		String matrixSignalIdentifier=matrixSignalStaticData.getMatrixSignalStaticIdentifier(); 
		if (dataMap.containsKey(matrixSignalIdentifier)){
			dataMap.remove(matrixSignalIdentifier);
			dataMap.put(matrixSignalIdentifier, matrixSignalStaticData);
		}else{
			dataMap.put(matrixSignalIdentifier, matrixSignalStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<MatrixSignalStaticData> getAllMatrixSignalStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String matrixSignalIdentifier){
		if (dataMap.containsKey(matrixSignalIdentifier)){
			dataMap.remove(matrixSignalIdentifier);
		}
	}
}
