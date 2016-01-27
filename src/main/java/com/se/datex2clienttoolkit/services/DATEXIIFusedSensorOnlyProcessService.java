package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.BasicData;
import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.ElaboratedData;
import com.se.datex2.schema.ElaboratedDataPublication;
import com.se.datex2.schema.LocationByReference;
import com.se.datex2.schema.TrafficConcentration;
import com.se.datex2.schema.TrafficFlow;
import com.se.datex2.schema.TrafficHeadway;
import com.se.datex2.schema.TrafficSpeed;
import com.se.datex2.schema.TravelTimeData;
import com.se.datex2clienttoolkit.datastores.FusedSensorOnlyDataStore;
import com.se.datex2clienttoolkit.datastores.data.FusedSensorOnlyData;

/**
 * 
 * This service processes FusedSensorOnly DATEX II v2 messages (D2LogicalModel).
 * The payloads are inserted into the FusedSensorOnly data store.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIIFusedSensorOnlyProcessService extends DATEXIIProcessService {

	final Logger log = LoggerFactory.getLogger(DATEXIIFusedSensorOnlyProcessService.class);
	
	private FusedSensorOnlyDataStore fusedSensorOnlyDataStore;
	
	@Autowired
	public DATEXIIFusedSensorOnlyProcessService(FusedSensorOnlyDataStore fusedSensorOnlyDataStore){
		super();
		this.fusedSensorOnlyDataStore = fusedSensorOnlyDataStore;
	}
	
	public DATEXIIFusedSensorOnlyProcessService(){
		super();
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		if (log.isDebugEnabled()){
            log.debug("FusedSensorOnlyData Update");
        }
        
		fusedSensorOnlyDataStore.clearDataStore();
		
        ElaboratedDataPublication elaboratedDataPublication = (ElaboratedDataPublication)d2LogicalModel.getPayloadPublication();
 
        if (elaboratedDataPublication != null) {
        	Date publicationTime = elaboratedDataPublication.getPublicationTime().toGregorianCalendar().getTime();
            Date timeDefault = elaboratedDataPublication.getTimeDefault().toGregorianCalendar().getTime();
            List<ElaboratedData> elaboratedDataList = elaboratedDataPublication.getElaboratedData();
            Iterator<ElaboratedData> iterator = elaboratedDataList.iterator();
            
    		if (log.isDebugEnabled()){
                log.debug("FusedSensorOnlyData Update("+ elaboratedDataList.size() + " objects)");
            }
    		
            while (iterator.hasNext()){
            	ElaboratedData elaboratedData = iterator.next();
                processSituation(elaboratedData, publicationTime, timeDefault);
            }
        }
        
		if (log.isTraceEnabled()){
            log.trace("FusedSensorOnlyData Update Complete");
        }
	}
	
	private void processSituation(ElaboratedData elaboratedData, Date publicationTime, Date timeDefault) {
		
		LocationByReference locationByReference = null;
		BasicData basicData = elaboratedData.getBasicData();
		if (basicData instanceof TrafficHeadway){
			TrafficHeadway data = (TrafficHeadway)basicData;
			locationByReference = (LocationByReference)data.getPertinentLocation();
		}else if (basicData instanceof TrafficFlow){
			TrafficFlow data = (TrafficFlow)basicData;
			locationByReference = (LocationByReference)data.getPertinentLocation();
		}else if (basicData instanceof TrafficConcentration){
			TrafficConcentration data = (TrafficConcentration)basicData;
			locationByReference = (LocationByReference)data.getPertinentLocation();
		}else if (basicData instanceof TrafficSpeed){
			TrafficSpeed data = (TrafficSpeed)basicData;
			locationByReference = (LocationByReference)data.getPertinentLocation();
		}else if (basicData instanceof TravelTimeData){
			TravelTimeData data = (TravelTimeData)basicData;
			locationByReference = (LocationByReference)data.getPertinentLocation();
		}else{
			log.warn("basicData instance of -" + basicData.getClass().getSimpleName());
		}
		
		String linkIdentifier=null;
		if (locationByReference != null){
			linkIdentifier = basicData.getClass().getSimpleName() +locationByReference.getPredefinedLocationReference().getId();
			
			if (log.isTraceEnabled()){
				log.trace("Processing Fused Sensor Only Identifier("+ linkIdentifier+")");
			}
			
			FusedSensorOnlyData fusedSensorOnlyData = new FusedSensorOnlyData(linkIdentifier, publicationTime, timeDefault, elaboratedData);
			fusedSensorOnlyDataStore.updateData(fusedSensorOnlyData);
		}else{
			this.log.error("Failed to Process elaboratedData, " + elaboratedData.toString());
		}
	}
	

}
