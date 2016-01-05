package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.NwkLinkStaticData;

/**
 * 
 * This data store contains the NwkLinkStatic data indexed by predefined location ID.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Component
public class NwkLinkStaticDataStore extends DataStore{

	public NwkLinkStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		NwkLinkStaticData nwkLinkStaticData = (NwkLinkStaticData)data; 
		String nwkLinkStaticIdentifier=nwkLinkStaticData.getNwkLinkStaticIdentifier(); 
		if (dataMap.containsKey(nwkLinkStaticIdentifier)){
			dataMap.remove(nwkLinkStaticIdentifier);
			dataMap.put(nwkLinkStaticIdentifier, nwkLinkStaticData);
		}else{
			dataMap.put(nwkLinkStaticIdentifier, nwkLinkStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<NwkLinkStaticData> getAllNwkLinkStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String nwkLinkStaticIdentifier){
		if (dataMap.containsKey(nwkLinkStaticIdentifier)){
			dataMap.remove(nwkLinkStaticIdentifier);
		}
	}
}
