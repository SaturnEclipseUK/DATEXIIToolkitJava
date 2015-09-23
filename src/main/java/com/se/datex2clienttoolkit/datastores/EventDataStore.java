package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.EventData;

@Component
public class EventDataStore extends DataStore{

	public EventDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		EventData eventData = (EventData)data;
		String eventIdentifier=eventData.getEventIdentifier(); 
		if (dataMap.containsKey(eventIdentifier)){
			dataMap.remove(eventIdentifier);
			dataMap.put(eventIdentifier, eventData);
		}else{
			dataMap.put(eventIdentifier, eventData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<EventData> getAllEventData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String eventIdentifier){
		if (dataMap.containsKey(eventIdentifier)){
			dataMap.remove(eventIdentifier);
		}
	}
}
