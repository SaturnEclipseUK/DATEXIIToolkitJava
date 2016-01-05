package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.ANPRStaticData;

/**
 * 
 * This data store contains the ANPRStatic data indexed by measurement site record ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class ANPRStaticDataStore extends DataStore{

	public ANPRStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		ANPRStaticData measurementSiteStaticData = (ANPRStaticData)data; 
		String measurementSiteStaticIdentifier=measurementSiteStaticData.getANPRStaticIdentifier(); 
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}else{
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<ANPRStaticData> getAllANPRStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String measurementSiteStaticIdentifier){
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
		}
	}
}
