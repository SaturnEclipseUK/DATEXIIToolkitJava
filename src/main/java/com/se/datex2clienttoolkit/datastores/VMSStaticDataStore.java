package com.se.datex2clienttoolkit.datastores;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.se.datex2clienttoolkit.datastores.data.DataObject;
import com.se.datex2clienttoolkit.datastores.data.VMSStaticData;

@Component
public class VMSStaticDataStore extends DataStore{

	public VMSStaticDataStore(){
		super();
	}
		
	public synchronized void updateData(DataObject data){
		VMSStaticData vmsStaticData = (VMSStaticData)data; 
		String vmsStaticIdentifier=vmsStaticData.getVMSStaticIdentifier(); 
		if (dataMap.containsKey(vmsStaticIdentifier)){
			dataMap.remove(vmsStaticIdentifier);
			dataMap.put(vmsStaticIdentifier, vmsStaticData);
		}else{
			dataMap.put(vmsStaticIdentifier, vmsStaticData);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized LinkedList<VMSStaticData> getAllVMSStaticData(){
		return new LinkedList(dataMap.values());
	}
	
	public synchronized void removeData(String vmsStaticIdentifier){
		if (dataMap.containsKey(vmsStaticIdentifier)){
			dataMap.remove(vmsStaticIdentifier);
		}
	}
}
