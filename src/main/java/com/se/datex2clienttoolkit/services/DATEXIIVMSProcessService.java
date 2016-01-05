package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.VmsPublication;
import com.se.datex2.schema.VmsUnit;
import com.se.datex2clienttoolkit.datastores.VMSDataStore;
import com.se.datex2clienttoolkit.datastores.data.VMSData;

/**
 * 
 * This service processes VMS DATEX II v2 messages (D2LogicalModel).
 * The payloads are inserted into the VMS data store.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIIVMSProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIIVMSProcessService.class);
	
	final static private CharSequence fullRefreshText = "full refresh";
	
	private VMSDataStore vMSDataStore;
	
	@Autowired
	public DATEXIIVMSProcessService(VMSDataStore vMSDataStore){
		super();
		this.vMSDataStore = vMSDataStore;
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		  
		if (log.isDebugEnabled()){
            log.debug("VMSAndMatrix Update");
        }
        
        boolean fullRefresh = false;
        String feedType = d2LogicalModel.getPayloadPublication().getFeedType();
        if (feedType.toLowerCase().contains(fullRefreshText)) {
            log.info("VMS Full Refresh received");
            fullRefresh=true;
            vMSDataStore.clearDataStore();
        }
		
        VmsPublication payloadPublication = (VmsPublication)d2LogicalModel.getPayloadPublication();
        Date publicationTime = payloadPublication.getPublicationTime().toGregorianCalendar().getTime();
        if (payloadPublication != null) {
            List<VmsUnit> vmsUnits = payloadPublication.getVmsUnit();
            
    		if (log.isDebugEnabled()){
                log.debug("VMS Update("+ vmsUnits.size() + " objects)");
            }
    		
            Iterator<VmsUnit> iterator = vmsUnits.iterator();
            while (iterator.hasNext()){
                VmsUnit vmsUnit = iterator.next();
                processVmsUnit(vmsUnit, publicationTime, fullRefresh);
            }
        }  
        
		if (log.isDebugEnabled()){
            log.debug("VMSAndMatrix Update Complete");
        }
	}
	
	private void processVmsUnit(VmsUnit vmsUnit, Date publicationTime,
			boolean fullRefresh) {
		String vmsIdentifier = vmsUnit.getVmsUnitReference().getId();
				
		if (log.isTraceEnabled()){
			log.trace("Processing VMSIdentifier("+vmsIdentifier+")");
		}
		
		VMSData vmsData = new VMSData(vmsIdentifier, publicationTime, vmsUnit);
		
		vMSDataStore.updateData(vmsData);
	}

}
