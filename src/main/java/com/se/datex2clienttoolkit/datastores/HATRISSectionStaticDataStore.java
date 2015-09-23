package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.HATRISSectionStaticData;

@Component
public class HATRISSectionStaticDataStore extends DataStore{

	public HATRISSectionStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		HATRISSectionStaticData hatrisSectionStaticData = (HATRISSectionStaticData)data; 
		String hatrisSectionStaticIdentifier=hatrisSectionStaticData.getHATRISSectionStaticIdentifier(); 
		if (dataMap.containsKey(hatrisSectionStaticIdentifier)){
			dataMap.remove(hatrisSectionStaticIdentifier);
			dataMap.put(hatrisSectionStaticIdentifier, hatrisSectionStaticData);
		}else{
			dataMap.put(hatrisSectionStaticIdentifier, hatrisSectionStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<HATRISSectionStaticData> getAllHATRISSectionStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String hatrisSectionStaticIdentifier){
		if (dataMap.containsKey(hatrisSectionStaticIdentifier)){
			dataMap.remove(hatrisSectionStaticIdentifier);
		}
	}
}
