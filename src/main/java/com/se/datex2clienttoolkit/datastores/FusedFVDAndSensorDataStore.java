package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.FusedFVDAndSensorData;

@Component
public class FusedFVDAndSensorDataStore extends DataStore{

	public FusedFVDAndSensorDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		FusedFVDAndSensorData fusedFVDAndSensorData = (FusedFVDAndSensorData)data;
		String linkIdentifier=fusedFVDAndSensorData.getFusedFVDSensorIdentifier(); 
		if (dataMap.containsKey(linkIdentifier)){
			dataMap.remove(linkIdentifier);
			dataMap.put(linkIdentifier, fusedFVDAndSensorData);
		}else{
			dataMap.put(linkIdentifier, fusedFVDAndSensorData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<FusedFVDAndSensorData> getAllFusedFVDAndSensorData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String linkIdentifier){
		if (dataMap.containsKey(linkIdentifier)){
			dataMap.remove(linkIdentifier);
		}
	}
}
