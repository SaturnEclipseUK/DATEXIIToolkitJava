package com.se.datex2clienttoolkit.datastores;

import java.util.HashMap;
import java.util.Map;

import com.se.datex2clienttoolkit.datastores.data.DataObject;

public abstract class DataStore {

	Map<String, DataObject> dataMap;
	
	public DataStore(){
		dataMap = new HashMap<String, DataObject>();
	}

	public synchronized void clearDataStore(){
		dataMap.clear();
	}
	
	public abstract void updateData(DataObject data);
	
	public DataObject getData(String identifier){
		if (dataMap.containsKey(identifier)){
			return dataMap.get(identifier);
		}
		return null;
	}
	
	public synchronized void removeData(String identifier){
		if (dataMap.containsKey(identifier)){
			dataMap.remove(identifier);
		}
	}
}
