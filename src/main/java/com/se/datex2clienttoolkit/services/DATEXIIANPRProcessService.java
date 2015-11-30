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
import com.se.datex2clienttoolkit.datastores.ANPRDataStore;
import com.se.datex2clienttoolkit.datastores.data.ANPRData;

@Service
public class DATEXIIANPRProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIIANPRProcessService.class);
	
	private ANPRDataStore anprDataStore;
	
	@Autowired
	public DATEXIIANPRProcessService(ANPRDataStore anprDataStore){
		super();
		this.anprDataStore = anprDataStore;
	}
	
	public DATEXIIANPRProcessService(){
		super();
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		if (log.isDebugEnabled()){
            log.debug("ANPR Update");
        }
		anprDataStore.clearDataStore();
        
        MeasuredDataPublication measuredDataPublication = (MeasuredDataPublication)d2LogicalModel.getPayloadPublication();
 
        if (measuredDataPublication != null) {
        	Date publicationTime = measuredDataPublication.getPublicationTime().toGregorianCalendar().getTime();
            
            List<SiteMeasurements> siteMeasurementsList = measuredDataPublication.getSiteMeasurements();
            
    		if (log.isDebugEnabled()){
                log.debug("ANPR Update("+ siteMeasurementsList.size() + " objects)");
            }
    		
            Iterator<SiteMeasurements> iterator = siteMeasurementsList.iterator();
            while (iterator.hasNext()){
            	SiteMeasurements siteMeasurements = iterator.next();
                processSituation(siteMeasurements, publicationTime);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("ANPR Update Complete");
        }
	}
	
	private void processSituation(SiteMeasurements siteMeasurements, Date publicationTime) {
		String anprIdentifier = siteMeasurements.getMeasurementTimeDefault().toGregorianCalendar().getTime().getTime() + siteMeasurements.getMeasurementSiteReference().getId();

		if (log.isTraceEnabled()){
			log.trace("Processing ANPR Identifier("+anprIdentifier+")");
		}
		
		ANPRData anprData = new ANPRData(anprIdentifier, publicationTime, siteMeasurements);
		anprDataStore.updateData(anprData);
	}
}
