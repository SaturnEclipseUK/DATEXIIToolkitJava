package com.se.datex2clienttoolkit.services;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.GenericPublication;
import com.se.datex2.schema.NtisModelVersionInformation;

/**
 * 
 * This service processes ModelUpdateNotification DATEX II v2 messages (D2LogicalModel).
 * When a notification is received, the Network Model Update function is invoked.  
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIIModelUpdateNotificationProcessService extends DATEXIIProcessService {

	final Logger log = LoggerFactory.getLogger(DATEXIIModelUpdateNotificationProcessService.class);
	
	@Autowired
	DATEXIINetworkModelUpdateService datexiiNetworkModelUpdateService;
	
	@Value("${loadNwkModelOnStartup}")
	private Boolean loadNwkModelOnStartup;
	
	@Value("${ntisNwkModelBaseUrl}")
	private String url;
	
	@Value("${ntisNwkModelUsername}")
	private String username;
	
	@Value("${ntisNwkModelPassword}")
	private String password;
	
	@PostConstruct
	public void initialise(){
		if (loadNwkModelOnStartup && url != null){
			datexiiNetworkModelUpdateService.updateNetworkModel(url, username, password);	
		}
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		
		GenericPublication genericPublication = (GenericPublication)d2LogicalModel.getPayloadPublication();
		NtisModelVersionInformation ntisModelVersionInformation = genericPublication.getGenericPublicationExtension().getNtisModelVersionInformation();
		
		Date publicationTime = ntisModelVersionInformation.getModelPublicationTime().toGregorianCalendar().getTime();
		String modelVersion = ntisModelVersionInformation.getModelVersion();
		String modelFilename = ntisModelVersionInformation.getModelFilename();
		
		if (url != null){
			datexiiNetworkModelUpdateService.updateNetworkModel(url, username, password);	
		} else {
			log.error("NTIS_NETWORK_MODEL_BASE_URL is not set in application.properties file");
		}
	}

}
