package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.MIDASData;

@Component
public class MIDASDataStore extends DataStore {
	public MIDASDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		MIDASData midasData = (MIDASData)data;
		String midasIdentifier=midasData.getMIDASIdentifier(); 
		if (dataMap.containsKey(midasIdentifier)){
			dataMap.remove(midasIdentifier);
			dataMap.put(midasIdentifier, midasData);
		}else{
			dataMap.put(midasIdentifier, midasData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<MIDASData> getAllMIDASData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String midasIdentifier){
		if (dataMap.containsKey(midasIdentifier)){
			dataMap.remove(midasIdentifier);
		}
	}
}
