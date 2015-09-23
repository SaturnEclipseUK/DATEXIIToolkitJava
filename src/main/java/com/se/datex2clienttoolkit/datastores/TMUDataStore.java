package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.TMUData;

@Component
public class TMUDataStore extends DataStore {
	public TMUDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		TMUData tmuData = (TMUData)data;
		String tmuIdentifier=tmuData.getTMUIdentifier(); 
		if (dataMap.containsKey(tmuIdentifier)){
			dataMap.remove(tmuIdentifier);
			dataMap.put(tmuIdentifier, tmuData);
		}else{
			dataMap.put(tmuIdentifier, tmuData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<TMUData> getAllTMUData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String tmuIdentifier){
		if (dataMap.containsKey(tmuIdentifier)){
			dataMap.remove(tmuIdentifier);
		}
	}
}
