package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.ANPRData;
import com.se.datex2clienttoolkit.datastores.data.DataObject;

@Component
public class ANPRDataStore extends DataStore {
	public ANPRDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		ANPRData anprData = (ANPRData)data;
		String anprIdentifier=anprData.getAnprIdentifier(); 
		if (dataMap.containsKey(anprIdentifier)){
			dataMap.remove(anprIdentifier);
			dataMap.put(anprIdentifier, anprData);
		}else{
			dataMap.put(anprIdentifier, anprData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<ANPRData> getAllANPRData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String anprIdentifier){
		if (dataMap.containsKey(anprIdentifier)){
			dataMap.remove(anprIdentifier);
		}
	}
}
