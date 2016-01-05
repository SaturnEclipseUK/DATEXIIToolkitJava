package com.se.datex2clienttoolkit.services;

import java.util.Date;
import java.util.Iterator; 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;
import com.se.datex2.schema.VmsTablePublication;
import com.se.datex2.schema.VmsUnitRecord;
import com.se.datex2.schema.VmsUnitTable;
import com.se.datex2clienttoolkit.datastores.MatrixSignalStaticDataStore;
import com.se.datex2clienttoolkit.datastores.VMSStaticDataStore;
import com.se.datex2clienttoolkit.datastores.data.MatrixSignalStaticData;
import com.se.datex2clienttoolkit.datastores.data.VMSStaticData;

/**
 * 
 * This service processes VMS DATEX II v2 messages (D2LogicalModel).
 * The payloads are inserted into the MatrixSignalStatic and VMSStatic data stores.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIINTISModelVMSProcessService extends DATEXIIProcessService {
	final Logger log = LoggerFactory.getLogger(DATEXIINTISModelVMSProcessService.class);
	
	private VMSStaticDataStore vmsStaticDataStore;
	private MatrixSignalStaticDataStore matrixSignalStaticDataStore;
	
	@Autowired
	public DATEXIINTISModelVMSProcessService(VMSStaticDataStore vmsStaticDataStore, MatrixSignalStaticDataStore matrixSignalStaticDataStore){
		super();
		this.vmsStaticDataStore = vmsStaticDataStore;
		this.matrixSignalStaticDataStore = matrixSignalStaticDataStore;
	}
	
	@Override
	public void processMessage(D2LogicalModel d2LogicalModel) {
		
		if (log.isDebugEnabled()){
            log.debug("NTIS Model VMS Tables Update");
        }
        
		vmsStaticDataStore.clearDataStore();
		matrixSignalStaticDataStore.clearDataStore();
		
		VmsTablePublication vmsTablePublication = (VmsTablePublication)d2LogicalModel.getPayloadPublication();        
        if (vmsTablePublication != null) {
        	Date publicationTime = vmsTablePublication.getPublicationTime().toGregorianCalendar().getTime();
        	
            List<VmsUnitTable> vmsUnitTableList = vmsTablePublication.getVmsUnitTable();
            
            Iterator<VmsUnitTable> iterator = vmsUnitTableList.iterator();
            while (iterator.hasNext()){
            	VmsUnitTable vmsUnitTable = iterator.next();
                processVmsUnitTable(vmsUnitTable, publicationTime);
            }
        }
        
		if (log.isDebugEnabled()){
            log.debug("NTIS Model VMS Tables Update Complete");
        }
	}
	
	private void processVmsUnitTable(VmsUnitTable vmsUnitTable, Date publicationTime) {
		String vmsUnitTableId = vmsUnitTable.getId();
		
		if (log.isDebugEnabled()){
            log.debug("NTIS Model VMS Tables Update("+ vmsUnitTableId + ")");
        }
		
		List<VmsUnitRecord> vmsUnitRecordList = vmsUnitTable.getVmsUnitRecord();
		
		Iterator<VmsUnitRecord> iterator = vmsUnitRecordList.iterator();
        while (iterator.hasNext()){
        	VmsUnitRecord vmsUnitRecord = iterator.next();
        	processVmsUnitRecord(vmsUnitRecord, publicationTime, vmsUnitTableId);
        }
	}
	
	private void processVmsUnitRecord(VmsUnitRecord vmsUnitRecord, Date publicationTime, String vmsUnitTableId){
		String vmsUnitIdentifier = vmsUnitRecord.getId();
		
		if (log.isTraceEnabled()){
			log.trace("Processing VMS Identifier("+vmsUnitIdentifier+")");
		}
				
		switch (vmsUnitTableId){
		case "NTIS_Matrix_Units":
			MatrixSignalStaticData matrixSignalStaticData = new MatrixSignalStaticData(vmsUnitIdentifier, publicationTime, vmsUnitRecord);
			matrixSignalStaticDataStore.updateData(matrixSignalStaticData);
			break;
		case "NTIS_VMS_Units":			
			VMSStaticData vmsStaticData = new VMSStaticData(vmsUnitIdentifier, publicationTime, vmsUnitRecord);
			vmsStaticDataStore.updateData(vmsStaticData);
			break;
		default:
			log.error("VMS Unit Table Id not implemented: "+vmsUnitTableId);			
		}		
	}

}
