package com.se.datex2clienttoolkit.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.se.datex2.common.FeedType;
import com.se.datex2.schema.D2LogicalModel;

@Component
public class DATEXIIUpdateService {
	final Logger logger = LoggerFactory.getLogger(DATEXIIUpdateService.class);
	
	@Autowired
	private JAXBService jaxbService;
	
	@Autowired
	private DATEXIIProcessServiceFactory datexiiProcessServiceFactory;
	
	private ConcurrentLinkedQueue<String> messageQueue;
	
	public DATEXIIUpdateService(){
		messageQueue = new ConcurrentLinkedQueue<String>();
	}
	
	public void addToMessageQueue(String xml){
		if (xml != null){
			messageQueue.add(xml);
		}
	}
	
	@Scheduled(fixedRate = 1000)
	public void processDATEXIIUpdateXML(){
		
		if (logger.isTraceEnabled()){
			logger.trace("Polling for messages");
		}
		String xml = messageQueue.poll();
		while (xml != null){
			try {
				Unmarshaller unmarshaller = jaxbService.createUnmarshaller();
				InputStream inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
				@SuppressWarnings("unchecked")
				JAXBElement<D2LogicalModel> root = (JAXBElement<D2LogicalModel>) unmarshaller.unmarshal(inputStream);
				D2LogicalModel d2lm = root.getValue();
				
				FeedType feedType= getFeedType(d2lm);
				DATEXIIProcessService datexiiProcessService = datexiiProcessServiceFactory.getDATEXIIProcessService(feedType);
				if (datexiiProcessService != null){
					datexiiProcessService.processMessage(d2lm);
				}
				
			} catch (JAXBException e) {
				logger.error("Failed to process XML", e);
			}
			xml = messageQueue.poll();
		}
	}

	private FeedType getFeedType(D2LogicalModel d2lm){
		String feedType=d2lm.getPayloadPublication().getFeedType();
		return FeedType.getFeedType(feedType);
	}
}
