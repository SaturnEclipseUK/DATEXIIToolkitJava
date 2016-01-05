package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.NwkNodeStaticData;

/**
 * 
 * This data store contains the NwkNodeStatic data indexed by predefined location ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class NwkNodeStaticDataStore extends DataStore{

	public NwkNodeStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		NwkNodeStaticData nwkNodeStaticData = (NwkNodeStaticData)data; 
		String nwkNodeStaticIdentifier=nwkNodeStaticData.getNwkNodeStaticIdentifier(); 
		if (dataMap.containsKey(nwkNodeStaticIdentifier)){
			dataMap.remove(nwkNodeStaticIdentifier);
			dataMap.put(nwkNodeStaticIdentifier, nwkNodeStaticData);
		}else{
			dataMap.put(nwkNodeStaticIdentifier, nwkNodeStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<NwkNodeStaticData> getAllNwkNodeStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String nwkNodeStaticIdentifier){
		if (dataMap.containsKey(nwkNodeStaticIdentifier)){
			dataMap.remove(nwkNodeStaticIdentifier);
		}
	}
}
