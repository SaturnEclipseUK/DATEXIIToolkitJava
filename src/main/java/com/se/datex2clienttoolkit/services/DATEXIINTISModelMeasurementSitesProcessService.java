package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator; 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.MeasurementSiteRecord;
import com.se.datex2.schema.MeasurementSiteTable;
import com.se.datex2.schema.MeasurementSiteTablePublication;
import com.se.datex2clienttoolkit.datastores.ANPRStaticDataStore;
import com.se.datex2clienttoolkit.datastores.MIDASStaticDataStore;
import com.se.datex2clienttoolkit.datastores.TAMEStaticDataStore;
import com.se.datex2clienttoolkit.datastores.TMUStaticDataStore;
import com.se.datex2clienttoolkit.datastores.data.ANPRStaticData;
import com.se.datex2clienttoolkit.datastores.data.MIDASStaticData;
import com.se.datex2clienttoolkit.datastores.data.TAMEStaticData;
import com.se.datex2clienttoolkit.datastores.data.TMUStaticData;

@Service
public class DATEXIINTISModelMeasurementSitesProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIINTISModelMeasurementSitesProcessService.class);
	
	private TAMEStaticDataStore tameStaticDataStore;	
	private MIDASStaticDataStore midasStaticDataStore;	
	private ANPRStaticDataStore anprStaticDataStore;	
	private TMUStaticDataStore tmuStaticDataStore;	
	
	@Autowired
	public DATEXIINTISModelMeasurementSitesProcessService(
			TAMEStaticDataStore tameStaticDataStore, MIDASStaticDataStore midasStaticDataStore,
			ANPRStaticDataStore anprStaticDataStore, TMUStaticDataStore tmuStaticDataStore){
		super();
		this.tameStaticDataStore = tameStaticDataStore;
		this.midasStaticDataStore = midasStaticDataStore;
		this.anprStaticDataStore = anprStaticDataStore;
		this.tmuStaticDataStore = tmuStaticDataStore;
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		
		if (log.isDebugEnabled()){
            log.debug("NTIS Model Measurement Site Tables Update");
        }
        
		tameStaticDataStore.clearDataStore();		
		midasStaticDataStore.clearDataStore();
		anprStaticDataStore.clearDataStore();
		tmuStaticDataStore.clearDataStore();
		
		MeasurementSiteTablePublication measurementSiteTablePublication = (MeasurementSiteTablePublication)d2LogicalModel.getPayloadPublication();        
        if (measurementSiteTablePublication != null) {
        	Date publicationTime = measurementSiteTablePublication.getPublicationTime().toGregorianCalendar().getTime();
        	
            List<MeasurementSiteTable> measurementSiteTableList = measurementSiteTablePublication.getMeasurementSiteTable();
            
            Iterator<MeasurementSiteTable> iterator = measurementSiteTableList.iterator();
            while (iterator.hasNext()){
            	MeasurementSiteTable measurementSiteTable = iterator.next();
                processMeasurementSiteTable(measurementSiteTable, publicationTime);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("NTIS Model Measurement Site Tables Update Complete");
        }
	}
	
	private void processMeasurementSiteTable(MeasurementSiteTable measurementSiteTable, Date publicationTime) {
		String measurementSiteTableId = measurementSiteTable.getId();
		
		if (log.isDebugEnabled()){
            log.debug("NTIS Model Measurement Site Tables Update("+ measurementSiteTableId + ")");
        }
		
		List<MeasurementSiteRecord> measurementSiteRecordList = measurementSiteTable.getMeasurementSiteRecord();
		
		Iterator<MeasurementSiteRecord> iterator = measurementSiteRecordList.iterator();
        while (iterator.hasNext()){
        	MeasurementSiteRecord measurementSiteRecord = iterator.next();
        	processMeasurementSiteRecord(measurementSiteRecord, publicationTime, measurementSiteTableId);
        }
	}
	
	private void processMeasurementSiteRecord(MeasurementSiteRecord measurementSiteRecord, Date publicationTime, String measurementSiteTableId){
		String measurementSiteRecordIdentifier = measurementSiteRecord.getId();
		
		if (log.isTraceEnabled()){
			log.trace("Processing Measurement Site Identifier("+measurementSiteRecordIdentifier+")");
		}
			
		switch (measurementSiteTableId){
		case "NTIS_TAME_Measurement_Sites":
			TAMEStaticData tameStaticData = new TAMEStaticData(measurementSiteRecordIdentifier, publicationTime, measurementSiteRecord);
			tameStaticDataStore.updateData(tameStaticData);
			break;
		case "NTIS_MIDAS_Measurement_Sites":			
			MIDASStaticData midasStaticData = new MIDASStaticData(measurementSiteRecordIdentifier, publicationTime, measurementSiteRecord);
			midasStaticDataStore.updateData(midasStaticData);
			break;
		case "NTIS_ANPR_Measurement_Sites":			
			ANPRStaticData anprStaticData = new ANPRStaticData(measurementSiteRecordIdentifier, publicationTime, measurementSiteRecord);
			anprStaticDataStore.updateData(anprStaticData);
			break;
		case "NTIS_TMU_Measurement_Sites":			
			TMUStaticData tmuStaticData = new TMUStaticData(measurementSiteRecordIdentifier, publicationTime, measurementSiteRecord);
			tmuStaticDataStore.updateData(tmuStaticData);
			break;
		default:
			log.error("VMS Unit Table Id not implemented: "+measurementSiteTableId);			
		}		
		
	}

}
