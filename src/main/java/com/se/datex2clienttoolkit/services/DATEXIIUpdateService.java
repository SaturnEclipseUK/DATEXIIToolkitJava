package com.se.datex2clienttoolkit.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

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
	
	private boolean working = false;
	
	public DATEXIIUpdateService(){
		messageQueue = new ConcurrentLinkedQueue<String>();
	}
	
	public void addToMessageQueue(String xml){
		if (xml != null){
			synchronized (messageQueue){
				messageQueue.add(xml);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Scheduled(fixedRate = 1000)
	public void processDATEXIIUpdateXML(){
		working = true;
		if (logger.isTraceEnabled()){
			logger.trace("Polling for messages");
		}
		String xml;
		synchronized (messageQueue){
			xml = messageQueue.poll();
		}
		while (xml != null){
			try {			
				byte[] bytes = xml.getBytes();
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
						
				XMLInputFactory xif = XMLInputFactory.newFactory();
				XMLStreamReader xsr = null;
				boolean foundBody = false;
				xsr = xif.createXMLStreamReader(bais);					
				while(!foundBody && xsr.hasNext()) {			
					if(xsr.next() == XMLStreamConstants.START_ELEMENT &&
						"http://schemas.xmlsoap.org/soap/envelope/".equals(xsr.getNamespaceURI()) &&
						"Body".equals(xsr.getLocalName())) {
							foundBody = true;
							xsr.next();
						}
				}			
				
				JAXBElement<D2LogicalModel> root;
				Unmarshaller unmarshaller = jaxbService.createUnmarshaller();
				if(foundBody) {						
					root = (JAXBElement<D2LogicalModel>)unmarshaller.unmarshal(xsr);
				} else {
					InputStream inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
					root = (JAXBElement<D2LogicalModel>)unmarshaller.unmarshal(inputStream);
				}
				D2LogicalModel d2lm = root.getValue();
				FeedType feedType= getFeedType(d2lm);
				DATEXIIProcessService datexiiProcessService = datexiiProcessServiceFactory.getDATEXIIProcessService(feedType);
				if (datexiiProcessService != null){
					datexiiProcessService.processMessage(d2lm);
				}
				
			} catch (JAXBException e) {
				logger.error("Failed to process XML", e);
			} catch (XMLStreamException e) {
				logger.error("XMLStreamException", e);				
			}	
			synchronized (messageQueue){
				xml = messageQueue.poll();
			}
		}
		working = false;
	}
	
	private FeedType getFeedType(D2LogicalModel d2lm){
		String feedType=d2lm.getPayloadPublication().getFeedType();
		return FeedType.getFeedType(feedType);
	}
	
	public boolean workPending(){
		synchronized (messageQueue){
			return messageQueue.isEmpty() && !working;
		}
	}
}
