package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.LinkShapeStaticData;

@Component
public class LinkShapeStaticDataStore extends DataStore{

	public LinkShapeStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		LinkShapeStaticData linkShapeStaticData = (LinkShapeStaticData)data; 
		String linkShapeStaticIdentifier=linkShapeStaticData.getLinkShapeStaticIdentifier(); 
		if (dataMap.containsKey(linkShapeStaticIdentifier)){
			dataMap.remove(linkShapeStaticIdentifier);
			dataMap.put(linkShapeStaticIdentifier, linkShapeStaticData);
		}else{
			dataMap.put(linkShapeStaticIdentifier, linkShapeStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<LinkShapeStaticData> getAllLinkShapeStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String linkShapeStaticIdentifier){
		if (dataMap.containsKey(linkShapeStaticIdentifier)){
			dataMap.remove(linkShapeStaticIdentifier);
		}
	}
}
