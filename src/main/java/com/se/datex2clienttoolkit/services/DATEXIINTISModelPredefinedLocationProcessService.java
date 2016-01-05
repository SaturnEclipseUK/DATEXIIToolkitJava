package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator; 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.PredefinedItinerary;
import com.se.datex2.schema.PredefinedItineraryIndexPredefinedLocation;
import com.se.datex2.schema.PredefinedLocation;
import com.se.datex2.schema.PredefinedLocationContainer;
import com.se.datex2.schema.PredefinedLocationsPublication;
import com.se.datex2.schema.PredefinedNonOrderedLocationGroup;
import com.se.datex2clienttoolkit.datastores.ANPRRouteStaticDataStore;
import com.se.datex2clienttoolkit.datastores.AlternateRouteStaticDataStore;
import com.se.datex2clienttoolkit.datastores.HATRISSectionStaticDataStore;
import com.se.datex2clienttoolkit.datastores.LinkShapeStaticDataStore;
import com.se.datex2clienttoolkit.datastores.NwkLinkStaticDataStore;
import com.se.datex2clienttoolkit.datastores.NwkNodeStaticDataStore;
import com.se.datex2clienttoolkit.datastores.data.ANPRRouteStaticData;
import com.se.datex2clienttoolkit.datastores.data.AlternateRouteStaticData;
import com.se.datex2clienttoolkit.datastores.data.HATRISSectionStaticData;
import com.se.datex2clienttoolkit.datastores.data.LinkShapeStaticData;
import com.se.datex2clienttoolkit.datastores.data.NwkLinkStaticData;
import com.se.datex2clienttoolkit.datastores.data.NwkNodeStaticData;

/**
 * 
 * This service processes PredefinedLocation DATEX II v2 messages (D2LogicalModel).
 * The payloads are inserted into the NwkLinkStatic, NwkNodeStatic, NwkShapeStatic, 
 * ANPRRouteStatic, HATRISSectionStatic and AlternateRouteStatic data stores.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIINTISModelPredefinedLocationProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIINTISModelPredefinedLocationProcessService.class);
	
	LinkShapeStaticDataStore linkShapeStaticDataStore;
	NwkLinkStaticDataStore nwkLinkStaticDataStore;
	ANPRRouteStaticDataStore anprRouteStaticDataStore;
	HATRISSectionStaticDataStore hatrisSectionStaticDataStore;
	NwkNodeStaticDataStore nwkNodeStaticDataStore;
	AlternateRouteStaticDataStore alternateRouteStaticDataStore;
	
	@Autowired
	public DATEXIINTISModelPredefinedLocationProcessService(
			LinkShapeStaticDataStore linkShapeStaticDataStore,
			NwkLinkStaticDataStore nwkLinkStaticDataStore,
			ANPRRouteStaticDataStore anprRouteStaticDataStore,
			HATRISSectionStaticDataStore hatrisSectionStaticDataStore,
			NwkNodeStaticDataStore nwkNodeStaticDataStore,
			AlternateRouteStaticDataStore alternateRouteStaticDataStore){
		super();
		this.linkShapeStaticDataStore = linkShapeStaticDataStore;
		this.nwkLinkStaticDataStore = nwkLinkStaticDataStore;
		this.anprRouteStaticDataStore = anprRouteStaticDataStore;
		this.hatrisSectionStaticDataStore = hatrisSectionStaticDataStore;
		this.nwkNodeStaticDataStore = nwkNodeStaticDataStore;
		this.alternateRouteStaticDataStore = alternateRouteStaticDataStore;
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		
		if (log.isDebugEnabled()){
            log.debug("NTIS Model Predefined Location Update");
        }
        
		linkShapeStaticDataStore.clearDataStore();		
		nwkLinkStaticDataStore.clearDataStore();
		anprRouteStaticDataStore.clearDataStore();
		hatrisSectionStaticDataStore.clearDataStore();
		nwkNodeStaticDataStore.clearDataStore();
		alternateRouteStaticDataStore.clearDataStore();
		
		PredefinedLocationsPublication predefinedLocationsPublication = (PredefinedLocationsPublication)d2LogicalModel.getPayloadPublication();        
        if (predefinedLocationsPublication != null) {
        	
        	Date publicationTime = predefinedLocationsPublication.getPublicationTime().toGregorianCalendar().getTime();
        	        	
            List<PredefinedLocationContainer> predefinedLocationContainerList = predefinedLocationsPublication.getPredefinedLocationContainer();
            
            Iterator<PredefinedLocationContainer> iterator = predefinedLocationContainerList.iterator();
            while (iterator.hasNext()){
            	PredefinedLocationContainer predefinedLocationContainer = iterator.next();
                processPredefinedLocationContainer(predefinedLocationContainer, publicationTime);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("NTIS Model Predefined Location Update Complete");
        }
	}
	
	private void processPredefinedLocationContainer(PredefinedLocationContainer predefinedLocationContainer, Date publicationTime) {
		
		
		if (predefinedLocationContainer instanceof PredefinedItinerary){
			PredefinedItinerary predefinedItinerary = (PredefinedItinerary)predefinedLocationContainer;
			String predefinedLocationContainerId = predefinedItinerary.getId();			
			List<PredefinedItineraryIndexPredefinedLocation> predefinedLocationList = predefinedItinerary.getPredefinedLocation();			
			Iterator<PredefinedItineraryIndexPredefinedLocation> iterator = predefinedLocationList.iterator();
	        while (iterator.hasNext()){
	        	PredefinedItineraryIndexPredefinedLocation predefinedItineraryIndexPredefinedLocation = iterator.next();
	        	processPredefinedLocation(predefinedItineraryIndexPredefinedLocation.getPredefinedLocation(), publicationTime, predefinedLocationContainerId);
	        }
		} else if (predefinedLocationContainer instanceof PredefinedNonOrderedLocationGroup){
			PredefinedNonOrderedLocationGroup predefinedNonOrderedLocationGroup = (PredefinedNonOrderedLocationGroup)predefinedLocationContainer;
			String predefinedLocationContainerId = predefinedNonOrderedLocationGroup.getId();			
			List<PredefinedLocation> predefinedLocationList = predefinedNonOrderedLocationGroup.getPredefinedLocation();	
			Iterator<PredefinedLocation> iterator = predefinedLocationList.iterator();
	        while (iterator.hasNext()){
	        	PredefinedLocation predefinedLocation = iterator.next();
	        	processPredefinedLocation(predefinedLocation, publicationTime, predefinedLocationContainerId);
	        }
		} else {
			log.error("Unexpected data type for PredefinedLocationContainer: "+predefinedLocationContainer.getClass().getSimpleName());
			return;
		}		
	}
	
	private void processPredefinedLocation(PredefinedLocation predefinedLocation, Date publicationTime, String predefinedLocationContainerId){
		String predefinedLocationIdentifier = predefinedLocation.getId();
		
		if (log.isTraceEnabled()){
			log.trace("Processing Predefined Location Identifier("+predefinedLocationIdentifier+")");
		}
			
		if (predefinedLocationContainerId.equals("NTIS_Network_Links")){		
			NwkLinkStaticData nwkLinkStaticData = new NwkLinkStaticData(predefinedLocationIdentifier, publicationTime, predefinedLocation);
			nwkLinkStaticDataStore.updateData(nwkLinkStaticData);
		} else if (predefinedLocationContainerId.equals("NTIS_Network_Nodes")) {			
			NwkNodeStaticData nwkNodeStaticData = new NwkNodeStaticData(predefinedLocationIdentifier, publicationTime, predefinedLocation);
			nwkNodeStaticDataStore.updateData(nwkNodeStaticData);
		} else if (predefinedLocationContainerId.startsWith("NTIS_Link_Shape_")){
			LinkShapeStaticData linkShapeStaticData = new LinkShapeStaticData(predefinedLocationIdentifier, publicationTime, predefinedLocation);
			linkShapeStaticDataStore.updateData(linkShapeStaticData);
		} else if (predefinedLocationContainerId.startsWith("NTIS_ANPR_Route_")){		
			ANPRRouteStaticData anprRouteStaticData = new ANPRRouteStaticData(predefinedLocationIdentifier, publicationTime, predefinedLocation);
			anprRouteStaticDataStore.updateData(anprRouteStaticData);
		} else if (predefinedLocationContainerId.startsWith("NTIS_HATRIS_Section_")){
			HATRISSectionStaticData hatrisSectionStaticData = new HATRISSectionStaticData(predefinedLocationIdentifier, publicationTime, predefinedLocation);
			hatrisSectionStaticDataStore.updateData(hatrisSectionStaticData);
		} else if (predefinedLocationContainerId.startsWith("NTIS_Alternate_Route_")){
			AlternateRouteStaticData alternateRouteStaticData = new AlternateRouteStaticData(predefinedLocationIdentifier, publicationTime, predefinedLocation);
			alternateRouteStaticDataStore.updateData(alternateRouteStaticData);
		} else {
			log.error("Predefined Location Container not implemented: "+predefinedLocationContainerId);			
		}
	}

}
