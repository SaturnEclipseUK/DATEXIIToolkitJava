package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.MIDASStaticData;

/**
 * 
 * This data store contains the MIDASStatic data indexed by measurement site record ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class MIDASStaticDataStore extends DataStore{

	public MIDASStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		MIDASStaticData measurementSiteStaticData = (MIDASStaticData)data; 
		String measurementSiteStaticIdentifier=measurementSiteStaticData.getMIDASStaticIdentifier(); 
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}else{
			dataMap.put(measurementSiteStaticIdentifier, measurementSiteStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<MIDASStaticData> getAllMIDASStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String measurementSiteStaticIdentifier){
		if (dataMap.containsKey(measurementSiteStaticIdentifier)){
			dataMap.remove(measurementSiteStaticIdentifier);
		}
	}
}
