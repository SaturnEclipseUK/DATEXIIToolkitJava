package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.TMUStaticData;

/**
 * 
 * This data store contains the TMUStatic data indexed by measurement site record ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class TMUStaticDataStore extends DataStore{

	public TMUStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		TMUStaticData measurementSiteStaticData = (TMUStaticData)data; 
		String measurementSiteStaticIdentifier=measurementSiteStaticData.getTMUStaticIdentifier(); 
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}else{
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<TMUStaticData> getAllTMUStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String measurementSiteStaticIdentifier){
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
		}
	}
}
