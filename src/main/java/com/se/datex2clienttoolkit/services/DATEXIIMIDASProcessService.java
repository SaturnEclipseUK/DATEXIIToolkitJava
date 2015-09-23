package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.MeasuredDataPublication;
import com.se.datex2.schema.SiteMeasurements;
import com.se.datex2clienttoolkit.datastores.MIDASDataStore;
import com.se.datex2clienttoolkit.datastores.data.MIDASData;

@Service
public class DATEXIIMIDASProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIIMIDASProcessService.class);
	
	private MIDASDataStore midasDataStore;
	
	@Autowired
	public DATEXIIMIDASProcessService(MIDASDataStore midasDataStore){
		super();
		this.midasDataStore = midasDataStore;
	}
	
	public DATEXIIMIDASProcessService(){
		super();
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		if (log.isDebugEnabled()){
            log.debug("MIDAS Update");
        }
        
		midasDataStore.clearDataStore();
		
		MeasuredDataPublication measuredDataPublication = (MeasuredDataPublication)d2LogicalModel.getPayloadPublication();
 
        if (measuredDataPublication != null) {
        	Date publicationTime = measuredDataPublication.getPublicationTime().toGregorianCalendar().getTime();
            
            List<SiteMeasurements> siteMeasurementsList = measuredDataPublication.getSiteMeasurements();
            
    		if (log.isDebugEnabled()){
                log.debug("MIDAS Update("+ siteMeasurementsList.size() + " objects)");
            }
    		
            Iterator<SiteMeasurements> iterator = siteMeasurementsList.iterator();
            while (iterator.hasNext()){
            	SiteMeasurements siteMeasurements = iterator.next();
                processSituation(siteMeasurements, publicationTime);
            }
        }
        
        if (log.isDebugEnabled()){
            log.debug("MIDAS Update Complete");
        }
	}
	
	private void processSituation(SiteMeasurements siteMeasurements, Date publicationTime) {
		String midasIdentifier = siteMeasurements.getMeasurementSiteReference().getId();

		if (log.isTraceEnabled()){
			log.trace("Processing MIDAS Identifier("+midasIdentifier+")");
		}
		
		MIDASData midasData = new MIDASData(midasIdentifier, publicationTime, siteMeasurements);
		
		midasDataStore.updateData(midasData);
	}

}
