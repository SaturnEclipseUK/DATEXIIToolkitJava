package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.VMSData;

@Component
public class VMSDataStore extends DataStore{

	public VMSDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		VMSData vmsData = (VMSData)data;
		String vmsIdentifier=vmsData.getVmsIdentifier(); 
		if (dataMap.containsKey(vmsIdentifier)){
			dataMap.remove(vmsIdentifier);
			dataMap.put(vmsIdentifier, vmsData);
		}else{
			dataMap.put(vmsIdentifier, vmsData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<VMSData> getAllVMSData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String vmsIdentifier){
		if (dataMap.containsKey(vmsIdentifier)){
			dataMap.remove(vmsIdentifier);
		}
	}
}
