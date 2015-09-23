package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.TAMEStaticData;

@Component
public class TAMEStaticDataStore extends DataStore{

	public TAMEStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		TAMEStaticData measurementSiteStaticData = (TAMEStaticData)data; 
		String measurementSiteStaticIdentifier=measurementSiteStaticData.getTAMEStaticIdentifier(); 
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}else{
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<TAMEStaticData> getAllTAMEStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String measurementSiteStaticIdentifier){
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
		}
	}
}
