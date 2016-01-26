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

/**
 * 
 * This service processes ANPR DATEX II v2 messages (D2LogicalModel).
 * The payloads are inserted into the ANPR data store.
 * 
 * @author Saturn Eclipse Limited
 *
 */
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
		String anprIdentifier = siteMeasurements.getMeasurementSiteReference().getId();

		if (log.isTraceEnabled()){
			log.trace("Processing ANPR Identifier("+anprIdentifier+")");
		}
		
		ANPRData anprData = (ANPRData)anprDataStore.getData(anprIdentifier);
		if (anprData == null){
			anprData = new ANPRData(anprIdentifier, publicationTime);
		}
		anprData.addSiteMeasurements(siteMeasurements);
		
		anprDataStore.updateData(anprData);
	}
}
