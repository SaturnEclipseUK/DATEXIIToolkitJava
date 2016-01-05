package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.ANPRRouteStaticData;

/**
 * 
 * This data store contains the ANPRRouteStatic data indexed by predefined location ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class ANPRRouteStaticDataStore extends DataStore{

	public ANPRRouteStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		ANPRRouteStaticData anprRouteStaticData = (ANPRRouteStaticData)data; 
		String anprRouteStaticIdentifier=anprRouteStaticData.getANPRRouteStaticIdentifier(); 
		if (dataMap.containsKey(anprRouteStaticIdentifier)){
			dataMap.remove(anprRouteStaticIdentifier);
			dataMap.put(anprRouteStaticIdentifier, anprRouteStaticData);
		}else{
			dataMap.put(anprRouteStaticIdentifier, anprRouteStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<ANPRRouteStaticData> getAllANPRRouteStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String anprRouteStaticIdentifier){
		if (dataMap.containsKey(anprRouteStaticIdentifier)){
			dataMap.remove(anprRouteStaticIdentifier);
		}
	}
}
