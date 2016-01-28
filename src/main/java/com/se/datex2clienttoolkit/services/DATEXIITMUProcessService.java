package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.MeasuredDataPublication;
import com.se.datex2.schema.SiteMeasurements;
import com.se.datex2clienttoolkit.datastores.TMUDataStore;
import com.se.datex2clienttoolkit.datastores.data.TMUData;

/**
 * 
 * This service processes TMU DATEX II v2 messages (D2LogicalModel).
 * The payloads are inserted into the TMU data store.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIITMUProcessService extends DATEXIIProcessService {

	final Logger log = LoggerFactory.getLogger(DATEXIITMUProcessService.class);
	
	private TMUDataStore tmuDataStore;
	
	@Autowired
	public DATEXIITMUProcessService(TMUDataStore tmuDataStore){
		super();
		this.tmuDataStore = tmuDataStore;
	}
	
	public DATEXIITMUProcessService(){
		super();
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		if (log.isDebugEnabled()){
            log.debug("TMU Update");
        }
        		
		MeasuredDataPublication measuredDataPublication = (MeasuredDataPublication)d2LogicalModel.getPayloadPublication();
 
        if (measuredDataPublication != null) {
        	Date publicationTime = measuredDataPublication.getPublicationTime().toGregorianCalendar().getTime();
            
            List<SiteMeasurements> siteMeasurementsList = measuredDataPublication.getSiteMeasurements();
            Iterator<SiteMeasurements> iterator = siteMeasurementsList.iterator();
            
    		if (log.isDebugEnabled()){
                log.debug("TMU Update("+ siteMeasurementsList.size() + " objects)");
            }
    		
    		Map<String, List<SiteMeasurements>> siteMeasurementsIndex = 
    				new HashMap<String, List<SiteMeasurements>>();
    		
            while (iterator.hasNext()){
            	SiteMeasurements siteMeasurements = iterator.next();
                processSituation(siteMeasurements, publicationTime, siteMeasurementsIndex);
            }
            
            for (String tmuIdentifier : siteMeasurementsIndex.keySet()){
            	TMUData tmuData = new TMUData(tmuIdentifier, publicationTime, siteMeasurementsIndex.get(tmuIdentifier));
    		
            	tmuDataStore.updateData(tmuData);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("TMU Update Complete");
        }
	}
	
	private void processSituation(SiteMeasurements siteMeasurements, Date publicationTime, 
			Map<String, List<SiteMeasurements>> siteMeasurementsIndex) {
		String tmuIdentifier = siteMeasurements.getMeasurementSiteReference().getId();

		if (log.isTraceEnabled()){
			log.trace("Processing TMU Identifier("+tmuIdentifier+")"); 
		}
		
		List<SiteMeasurements> siteMeasurementsList;
		if (siteMeasurementsIndex.containsKey(tmuIdentifier)){
			siteMeasurementsList = siteMeasurementsIndex.get(tmuIdentifier);
		} else {
			siteMeasurementsList = new LinkedList<SiteMeasurements>();
			siteMeasurementsIndex.put(tmuIdentifier, siteMeasurementsList);
		}
		siteMeasurementsList.add(siteMeasurements);
		
	}


}
