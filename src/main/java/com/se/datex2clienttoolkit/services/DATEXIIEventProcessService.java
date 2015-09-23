package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator; 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.Situation;
import com.se.datex2.schema.SituationPublication;
import com.se.datex2clienttoolkit.datastores.EventDataStore;
import com.se.datex2clienttoolkit.datastores.data.EventData;

@Service
public class DATEXIIEventProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIIEventProcessService.class);
	
	final static private CharSequence fullRefreshText = "full refresh";
	
	private EventDataStore eventDataStore;
	
	@Autowired
	public DATEXIIEventProcessService(EventDataStore eventDataStore){
		super();
		this.eventDataStore = eventDataStore;
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		
		if (log.isDebugEnabled()){
            log.debug("Event Update");
        }
        
        boolean fullRefresh = false;
        String feedType = d2LogicalModel.getPayloadPublication().getFeedType();
        if (feedType.toLowerCase().contains(fullRefreshText)) {
            log.info("Event Full Refresh received");
            fullRefresh=true;
            eventDataStore.clearDataStore();
        }
		
        SituationPublication situationPublication = (SituationPublication)d2LogicalModel.getPayloadPublication();
        Date publicationTime = situationPublication.getPublicationTime().toGregorianCalendar().getTime();
        if (situationPublication != null) {
        	
            List<Situation> situationList = situationPublication.getSituation();
            
            if (log.isDebugEnabled()){
                log.debug("Event Update("+ situationList.size() + " objects)");
            }
            
            Iterator<Situation> iterator = situationList.iterator();
            while (iterator.hasNext()){
            	Situation situation = iterator.next();
                processSituation(situation, publicationTime, fullRefresh);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("Event Update Complete");
        }
	}
	
	private void processSituation(Situation situation, Date publicationTime, boolean fullRefresh) {
		String eventIdentifier = situation.getSituationRecord().get(0).getSituationRecordCreationReference();

		if (log.isTraceEnabled()){
			log.trace("Processing Event Identifier("+eventIdentifier+")");
		}
		
		EventData eventData = new EventData(eventIdentifier, publicationTime, situation);
		
		eventDataStore.updateData(eventData);
	}

}
