package com.se.datex2clienttoolkit.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.GenericPublication;
import com.se.datex2.schema.NtisModelVersionInformation;

@Service
public class DATEXIIModelUpdateNotificationProcessService extends DATEXIIProcessService {

	final Logger log = LoggerFactory.getLogger(DATEXIIModelUpdateNotificationProcessService.class);
	
	@Autowired
	DATEXIINetworkModelUpdateService datexiiNetworkModelUpdateService;
	
	@Value("${ntisNwkModelBaseUrl}")
	private String url;
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		
		GenericPublication genericPublication = (GenericPublication)d2LogicalModel.getPayloadPublication();
		NtisModelVersionInformation ntisModelVersionInformation = genericPublication.getGenericPublicationExtension().getNtisModelVersionInformation();
		
		Date publicationTime = ntisModelVersionInformation.getModelPublicationTime().toGregorianCalendar().getTime();
		String modelVersion = ntisModelVersionInformation.getModelVersion();
		String modelFilename = ntisModelVersionInformation.getModelFilename();
		
		if (url != null){
			datexiiNetworkModelUpdateService.updateNetworkModel(url+modelFilename);	
		} else {
			log.error("NTIS_NETWORK_MODEL_BASE_URL is not set in application.properties file");
		}
	}

}
