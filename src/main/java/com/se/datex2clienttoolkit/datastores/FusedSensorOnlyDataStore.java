package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.FusedSensorOnlyData;

/**
 * 
 * This data store contains the FusedSensorOnly data indexed by link ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class FusedSensorOnlyDataStore extends DataStore{

	public FusedSensorOnlyDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		FusedSensorOnlyData fusedSensorOnlyData = (FusedSensorOnlyData)data;
		String linkIdentifier=fusedSensorOnlyData.getFusedSensorOnlyIdentifier(); 
		if (dataMap.containsKey(linkIdentifier)){
			dataMap.remove(linkIdentifier);
			dataMap.put(linkIdentifier, fusedSensorOnlyData);
		}else{
			dataMap.put(linkIdentifier, fusedSensorOnlyData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<FusedSensorOnlyData> getAllFusedSensorOnlyData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String linkIdentifier){
		if (dataMap.containsKey(linkIdentifier)){
			dataMap.remove(linkIdentifier);
		}
	}
}
