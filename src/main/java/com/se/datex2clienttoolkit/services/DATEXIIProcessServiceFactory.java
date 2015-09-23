package com.se.datex2clienttoolkit.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.common.FeedType;


@Service
public class DATEXIIProcessServiceFactory {
	final Logger log = LoggerFactory.getLogger(DATEXIIProcessServiceFactory.class);
	
	@Autowired
	private DATEXIIVMSProcessService datexiiVMSProcessService;
	
	@Autowired
	private DATEXIIANPRProcessService datexiiANPRProcessService;
	
	@Autowired
	private DATEXIIMIDASProcessService datexiiMIDASProcessService;
	
	@Autowired
	private DATEXIITMUProcessService datexiiTMUProcessService;
	
	@Autowired
	private DATEXIIFusedSensorOnlyProcessService datexiiFusedSensorOnlyProcessService;
	
	@Autowired
	private DATEXIIFusedFVDAndSensorProcessService datexiiFusedFVDAndSensorProcessService;
	
	@Autowired
	private DATEXIIModelUpdateNotificationProcessService datexiiModelUpdateNotificationProcessService;
	
	@Autowired
	private DATEXIIEventProcessService datexiiEventProcessService;
	
	@Autowired
	private DATEXIINTISModelVMSProcessService datexiiNTISModelVMSProcessService;
	
	@Autowired
	private DATEXIINTISModelMeasurementSitesProcessService datexiiNTISModelMeasurementSitesProcessService;
	
	@Autowired
	private DATEXIINTISModelPredefinedLocationProcessService datexiiNTISModelPredefinedLocationProcessService;
	
	public DATEXIIProcessService getDATEXIIProcessService(FeedType feedType){
		
		DATEXIIProcessService datexiiProcessService = null;
		switch(feedType){
		case VMS:
			datexiiProcessService = datexiiVMSProcessService;
			break;
		case ANPR:
			datexiiProcessService = datexiiANPRProcessService;
			break;
		case MIDAS:
			datexiiProcessService = datexiiMIDASProcessService;
			break;
		case TMU:
			datexiiProcessService = datexiiTMUProcessService;
			break;
		case FUSED_SENSOR_ONLY:
			datexiiProcessService = datexiiFusedSensorOnlyProcessService;
			break;
		case FUSED_FVD_AND_SENSOR_PTD:
			datexiiProcessService = datexiiFusedFVDAndSensorProcessService;
			break;
		case NTIS_MODEL_UPDATE_NOTIFICATION:
			datexiiProcessService = datexiiModelUpdateNotificationProcessService;
			break;
		case EVENT:
			datexiiProcessService = datexiiEventProcessService;
			break;
		case NTIS_MODEL_VMS_TABLES:
			datexiiProcessService = datexiiNTISModelVMSProcessService;
			break;
		case NTIS_MODEL_MEASUREMENT_SITES:
			datexiiProcessService = datexiiNTISModelMeasurementSitesProcessService;
			break;
		case NTIS_MODEL_PREDEFINED_LOCATIONS:
			datexiiProcessService = datexiiNTISModelPredefinedLocationProcessService;
			break;
		default:
			log.error("Unknown Feed Type Received");
		}
		return datexiiProcessService;
	}
}
