package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.AlternateRouteStaticData;

@Component
public class AlternateRouteStaticDataStore extends DataStore{

	public AlternateRouteStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		AlternateRouteStaticData alternateRouteStaticData = (AlternateRouteStaticData)data; 
		String alternateRouteStaticIdentifier=alternateRouteStaticData.getAlternateRouteStaticIdentifier(); 
		if (dataMap.containsKey(alternateRouteStaticIdentifier)){
			dataMap.remove(alternateRouteStaticIdentifier);
			dataMap.put(alternateRouteStaticIdentifier, alternateRouteStaticData);
		}else{
			dataMap.put(alternateRouteStaticIdentifier, alternateRouteStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<AlternateRouteStaticData> getAllAlternateRouteStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String alternateRouteStaticIdentifier){
		if (dataMap.containsKey(alternateRouteStaticIdentifier)){
			dataMap.remove(alternateRouteStaticIdentifier);
		}
	}
}
