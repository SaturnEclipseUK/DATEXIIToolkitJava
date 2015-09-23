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
import com.se.datex2clienttoolkit.datastores.FusedFVDAndSensorDataStore;
import com.se.datex2clienttoolkit.datastores.data.FusedFVDAndSensorData;

@Service
public class DATEXIIFusedFVDAndSensorProcessService extends
		DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIIFusedFVDAndSensorProcessService.class);
	
	private FusedFVDAndSensorDataStore fusedFVDAndSensorDataStore;
	
	@Autowired
	public DATEXIIFusedFVDAndSensorProcessService(FusedFVDAndSensorDataStore fusedFVDAndSensorDataStore){
		super();
		this.fusedFVDAndSensorDataStore = fusedFVDAndSensorDataStore;
	}
	
	public DATEXIIFusedFVDAndSensorProcessService(){
		super();
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		if (log.isDebugEnabled()){
            log.debug("FusedFVDAndSensorData Update");
        }
        
		fusedFVDAndSensorDataStore.clearDataStore();
		
        ElaboratedDataPublication elaboratedDataPublication = (ElaboratedDataPublication)d2LogicalModel.getPayloadPublication();
 
        if (elaboratedDataPublication != null) {
        	Date publicationTime = elaboratedDataPublication.getPublicationTime().toGregorianCalendar().getTime();
            Date timeDefault = elaboratedDataPublication.getTimeDefault().toGregorianCalendar().getTime();
            List<ElaboratedData> elaboratedDataList = elaboratedDataPublication.getElaboratedData();
            Iterator<ElaboratedData> iterator = elaboratedDataList.iterator();
            
    		if (log.isDebugEnabled()){
                log.debug("FusedFVDAndSensorData Update("+ elaboratedDataList.size() + " objects)");
            }
    		
            while (iterator.hasNext()){
            	ElaboratedData elaboratedData = iterator.next();
                processSituation(elaboratedData, publicationTime, timeDefault);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("FusedFVDAndSensorData Update Complete");
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
			linkIdentifier = basicData.getClass().getSimpleName() + locationByReference.getPredefinedLocationReference().getId();
			
			if (log.isTraceEnabled()){
				log.trace("Processing Fused FVD And Sensor Identifier("+linkIdentifier+")");
			}
			
			FusedFVDAndSensorData fusedFVDAndSensorData = new FusedFVDAndSensorData(linkIdentifier, publicationTime, timeDefault, elaboratedData);
			fusedFVDAndSensorDataStore.updateData(fusedFVDAndSensorData);
		}else{
			this.log.error("Failed to Process elaboratedData, " + elaboratedData.toString());
		}
	}
	

}
