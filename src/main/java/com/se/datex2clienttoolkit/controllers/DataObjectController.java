package com.se.datex2clienttoolkit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.datex2clienttoolkit.datastores.ANPRDataStore;
import com.se.datex2clienttoolkit.datastores.ANPRRouteStaticDataStore;
import com.se.datex2clienttoolkit.datastores.ANPRStaticDataStore;
import com.se.datex2clienttoolkit.datastores.AlternateRouteStaticDataStore;
import com.se.datex2clienttoolkit.datastores.EventDataStore;
import com.se.datex2clienttoolkit.datastores.FusedFVDAndSensorDataStore;
import com.se.datex2clienttoolkit.datastores.FusedSensorOnlyDataStore;
import com.se.datex2clienttoolkit.datastores.HATRISSectionStaticDataStore;
import com.se.datex2clienttoolkit.datastores.LinkShapeStaticDataStore;
import com.se.datex2clienttoolkit.datastores.MIDASDataStore;
import com.se.datex2clienttoolkit.datastores.MIDASStaticDataStore;
import com.se.datex2clienttoolkit.datastores.MatrixSignalStaticDataStore;
import com.se.datex2clienttoolkit.datastores.NwkLinkStaticDataStore;
import com.se.datex2clienttoolkit.datastores.NwkNodeStaticDataStore;
import com.se.datex2clienttoolkit.datastores.TAMEStaticDataStore;
import com.se.datex2clienttoolkit.datastores.TMUDataStore;
import com.se.datex2clienttoolkit.datastores.TMUStaticDataStore;
import com.se.datex2clienttoolkit.datastores.VMSDataStore;
import com.se.datex2clienttoolkit.datastores.VMSStaticDataStore;
import com.se.datex2clienttoolkit.datastores.data.ANPRData;
import com.se.datex2clienttoolkit.datastores.data.ANPRRouteStaticData;
import com.se.datex2clienttoolkit.datastores.data.ANPRStaticData;
import com.se.datex2clienttoolkit.datastores.data.AlternateRouteStaticData;
import com.se.datex2clienttoolkit.datastores.data.EventData;
import com.se.datex2clienttoolkit.datastores.data.FusedFVDAndSensorData;
import com.se.datex2clienttoolkit.datastores.data.FusedSensorOnlyData;
import com.se.datex2clienttoolkit.datastores.data.HATRISSectionStaticData;
import com.se.datex2clienttoolkit.datastores.data.LinkShapeStaticData;
import com.se.datex2clienttoolkit.datastores.data.MIDASData;
import com.se.datex2clienttoolkit.datastores.data.MIDASStaticData;
import com.se.datex2clienttoolkit.datastores.data.MatrixSignalStaticData;
import com.se.datex2clienttoolkit.datastores.data.NwkLinkStaticData;
import com.se.datex2clienttoolkit.datastores.data.NwkNodeStaticData;
import com.se.datex2clienttoolkit.datastores.data.TAMEStaticData;
import com.se.datex2clienttoolkit.datastores.data.TMUData;
import com.se.datex2clienttoolkit.datastores.data.TMUStaticData;
import com.se.datex2clienttoolkit.datastores.data.VMSData;
import com.se.datex2clienttoolkit.datastores.data.VMSStaticData;

@RestController
@RequestMapping("/api")
public class DataObjectController {

	@Autowired
	VMSDataStore vmsDataStore;
	
	@Autowired
	EventDataStore eventDataStore;
	
	@Autowired
	ANPRDataStore anprDataStore;
	
	@Autowired
	FusedFVDAndSensorDataStore fusedFVDAndSensorDataStore;
	
	@Autowired
	FusedSensorOnlyDataStore fusedSensorOnlyDataStore;
	
	@Autowired
	MIDASDataStore midasDataStore;
	
	@Autowired
	TMUDataStore tmuDataStore;
	
	@Autowired
	VMSStaticDataStore vmsStaticDataStore;
	
	@Autowired
	MatrixSignalStaticDataStore matrixSignalStaticDataStore;
	
	@Autowired
	TAMEStaticDataStore tameStaticDataStore;

	@Autowired
	MIDASStaticDataStore midasStaticDataStore;

	@Autowired
	ANPRStaticDataStore anprStaticDataStore;

	@Autowired
	TMUStaticDataStore tmuStaticDataStore;

	@Autowired
	LinkShapeStaticDataStore linkShapeStaticDataStore;

	@Autowired
	NwkLinkStaticDataStore nwkLinkStaticDataStore;

	@Autowired
	ANPRRouteStaticDataStore anprRouteStaticDataStore;

	@Autowired
	HATRISSectionStaticDataStore hatrisSectionStaticDataStore;

	@Autowired
	NwkNodeStaticDataStore nwkNodeStaticDataStore;

	@Autowired
	AlternateRouteStaticDataStore alternateRouteStaticDataStore;

	@RequestMapping("/vms")	
    public VMSData vmsData(@RequestParam(value="id") String id) {
		return (VMSData) vmsDataStore.getData(id);
    }
	
	@RequestMapping("/vms/all")
	public List<VMSData> vmsDataAll(){
		return vmsDataStore.getAllVMSData();
	}
	
	@RequestMapping("/vms/count")
	public int vmsDataCount(){
		return vmsDataStore.getAllVMSData().size();
	}
	
	@RequestMapping("/event")
    public EventData eventData(@RequestParam(value="id") String id) {
		return (EventData) eventDataStore.getData(id);
    }
	
	@RequestMapping("/event/all")
	public List<EventData> eventDataAll(){
		return eventDataStore.getAllEventData();
	}
	
	@RequestMapping("/event/count")
	public int eventDataCount(){
		return eventDataStore.getAllEventData().size();
	}
	
	@RequestMapping("/anpr")
    public ANPRData anprData(@RequestParam(value="id") String id) {
		return (ANPRData) anprDataStore.getData(id);
    }
	
	@RequestMapping("/anpr/all")
	public List<ANPRData> anprDataAll(){
		return anprDataStore.getAllANPRData();
	}
	
	@RequestMapping("/anpr/count")
	public int anprDataCount(){
		return anprDataStore.getAllANPRData().size();
	}
	
	@RequestMapping("/fusedFVDAndSensor")
    public FusedFVDAndSensorData fusedFVDAndSensorData(@RequestParam(value="id") String id) {
		return (FusedFVDAndSensorData) fusedFVDAndSensorDataStore.getData(id);
    }
	
	@RequestMapping("/fusedFVDAndSensor/all")
	public List<FusedFVDAndSensorData> fusedFVDAndSensorDataAll(){
		return fusedFVDAndSensorDataStore.getAllFusedFVDAndSensorData();
	}
	
	@RequestMapping("/fusedFVDAndSensor/count")
	public int fusedFVDAndSensorDataCount(){
		return fusedFVDAndSensorDataStore.getAllFusedFVDAndSensorData().size();
	}
	
	@RequestMapping("/fusedSensorOnly")
    public FusedSensorOnlyData fusedSensorOnlyData(@RequestParam(value="id") String id) {
		return (FusedSensorOnlyData) fusedSensorOnlyDataStore.getData(id);
    }
	
	@RequestMapping("/fusedSensorOnly/all")
	public List<FusedSensorOnlyData> fusedSensorOnlyDataAll(){
		return fusedSensorOnlyDataStore.getAllFusedSensorOnlyData();
	}
	
	@RequestMapping("/fusedSensorOnly/count")
	public int fusedSensorOnlyDataCount(){
		return fusedSensorOnlyDataStore.getAllFusedSensorOnlyData().size();
	}
	
	@RequestMapping("/midas")
    public MIDASData midasData(@RequestParam(value="id") String id) {
		return (MIDASData) midasDataStore.getData(id);
    }
	
	@RequestMapping("/midas/all")
	public List<MIDASData> midasDataAll(){
		return midasDataStore.getAllMIDASData();
	}
	
	@RequestMapping("/midas/count")
	public int midasDataCount(){
		return midasDataStore.getAllMIDASData().size();
	}
	
	@RequestMapping("/tmu")
    public TMUData tmuData(@RequestParam(value="id") String id) {
		return (TMUData) tmuDataStore.getData(id);
    }
	
	@RequestMapping("/tmu/all")
	public List<TMUData> tmuDataAll(){
		return tmuDataStore.getAllTMUData();
	}
	
	@RequestMapping("/tmu/count")
	public int tmuDataCount(){
		return tmuDataStore.getAllTMUData().size();
	}
	
	@RequestMapping("/vmsStatic")
    public VMSStaticData vmsStaticData(@RequestParam(value="id") String id) {
		return (VMSStaticData) vmsStaticDataStore.getData(id);
    }
	
	@RequestMapping("/vmsStatic/all")
	public List<VMSStaticData> vmsStaticDataAll(){
		return vmsStaticDataStore.getAllVMSStaticData();
	}
	
	@RequestMapping("/vmsStatic/count")
	public int vmsStaticDataCount(){
		return vmsStaticDataStore.getAllVMSStaticData().size();
	}
	
	@RequestMapping("/matrixSignalStatic")
    public MatrixSignalStaticData matrixSignalStaticData(@RequestParam(value="id") String id) {
		return (MatrixSignalStaticData) matrixSignalStaticDataStore.getData(id);
    }
	
	@RequestMapping("/matrixSignalStatic/all")
	public List<MatrixSignalStaticData> matrixSignalStaticDataAll(){
		return matrixSignalStaticDataStore.getAllMatrixSignalStaticData();
	}
	
	@RequestMapping("/matrixSignalStatic/count")
	public int matrixSignalStaticDataCount(){
		return matrixSignalStaticDataStore.getAllMatrixSignalStaticData().size();
	}
	
	@RequestMapping("/tameStatic")
	public TAMEStaticData tameStaticData(@RequestParam(value="id") String id) {
		return (TAMEStaticData) tameStaticDataStore.getData(id);
	}

	@RequestMapping("/tameStatic/all")
	public List<TAMEStaticData> tameStaticDataAll(){
		return tameStaticDataStore.getAllTAMEStaticData();
	}

	@RequestMapping("/tameStatic/count")
	public int tameStaticDataCount(){
		return tameStaticDataStore.getAllTAMEStaticData().size();
	}

	@RequestMapping("/midasStatic")
	public MIDASStaticData midasStaticData(@RequestParam(value="id") String id) {
		return (MIDASStaticData) midasStaticDataStore.getData(id);
	}

	@RequestMapping("/midasStatic/all")
	public List<MIDASStaticData> midasStaticDataAll(){
		return midasStaticDataStore.getAllMIDASStaticData();
	}

	@RequestMapping("/midasStatic/count")
	public int midasStaticDataCount(){
		return midasStaticDataStore.getAllMIDASStaticData().size();
	}

	@RequestMapping("/anprStatic")
	public ANPRStaticData anprStaticData(@RequestParam(value="id") String id) {
		return (ANPRStaticData) anprStaticDataStore.getData(id);
	}

	@RequestMapping("/anprStatic/all")
	public List<ANPRStaticData> anprStaticDataAll(){
		return anprStaticDataStore.getAllANPRStaticData();
	}

	@RequestMapping("/anprStatic/count")
	public int anprStaticDataCount(){
		return anprStaticDataStore.getAllANPRStaticData().size();
	}
	
	@RequestMapping("/tmuStatic")
	public TMUStaticData tmuStaticData(@RequestParam(value="id") String id) {
		return (TMUStaticData) tmuStaticDataStore.getData(id);
	}

	@RequestMapping("/tmuStatic/all")
	public List<TMUStaticData> tmuStaticDataAll(){
		return tmuStaticDataStore.getAllTMUStaticData();
	}
	
	@RequestMapping("/tmuStatic/count")
	public int tmuStaticDataCount(){
		return tmuStaticDataStore.getAllTMUStaticData().size();
	}

	@RequestMapping("/linkShapeStatic")
	public LinkShapeStaticData linkShapeStaticData(@RequestParam(value="id") String id) {
		return (LinkShapeStaticData) linkShapeStaticDataStore.getData(id);
	}

	@RequestMapping("/linkShapeStatic/all")
	public List<LinkShapeStaticData> linkShapeStaticDataAll(){
		return linkShapeStaticDataStore.getAllLinkShapeStaticData();
	}

	@RequestMapping("/linkShapeStatic/count")
	public int linkShapeStaticDataCount(){
		return linkShapeStaticDataStore.getAllLinkShapeStaticData().size();
	}

	@RequestMapping("/nwkLinkStatic")
	public NwkLinkStaticData nwkLinkStaticData(@RequestParam(value="id") String id) {
		return (NwkLinkStaticData) nwkLinkStaticDataStore.getData(id);
	}

	@RequestMapping("/nwkLinkStatic/all")
	public List<NwkLinkStaticData> nwkLinkStaticDataAll(){
		return nwkLinkStaticDataStore.getAllNwkLinkStaticData();
	}

	@RequestMapping("/nwkLinkStatic/count")
	public int nwkLinkStaticDataCount(){
		return nwkLinkStaticDataStore.getAllNwkLinkStaticData().size();
	}

	@RequestMapping("/anprRouteStatic")
	public ANPRRouteStaticData anprRouteStaticData(@RequestParam(value="id") String id) {
		return (ANPRRouteStaticData) anprRouteStaticDataStore.getData(id);
	}

	@RequestMapping("/anprRouteStatic/all")
	public List<ANPRRouteStaticData> anprRouteStaticDataAll(){
		return anprRouteStaticDataStore.getAllANPRRouteStaticData();
	}

	@RequestMapping("/anprRouteStatic/count")
	public int anprRouteStaticDataCount(){
		return anprRouteStaticDataStore.getAllANPRRouteStaticData().size();
	}
	
	@RequestMapping("/hatrisSectionStatic")
	public HATRISSectionStaticData hatrisSectionStaticData(@RequestParam(value="id") String id) {
		return (HATRISSectionStaticData) hatrisSectionStaticDataStore.getData(id);
	}

	@RequestMapping("/hatrisSectionStatic/all")
	public List<HATRISSectionStaticData> hatrisSectionStaticDataAll(){
		return hatrisSectionStaticDataStore.getAllHATRISSectionStaticData();
	}

	@RequestMapping("/hatrisSectionStatic/count")
	public int hatrisSectionStaticDataCount(){
		return hatrisSectionStaticDataStore.getAllHATRISSectionStaticData().size();
	}

	@RequestMapping("/nwkNodeStatic")
	public NwkNodeStaticData nwkNodeStaticData(@RequestParam(value="id") String id) {
		return (NwkNodeStaticData) nwkNodeStaticDataStore.getData(id);
	}

	@RequestMapping("/nwkNodeStatic/all")
	public List<NwkNodeStaticData> nwkNodeStaticDataAll(){
		return nwkNodeStaticDataStore.getAllNwkNodeStaticData();
	}

	@RequestMapping("/nwkNodeStatic/count")
	public int nwkNodeStaticDataCount(){
		return nwkNodeStaticDataStore.getAllNwkNodeStaticData().size();
	}

	@RequestMapping("/alternateRouteStatic")
	public AlternateRouteStaticData alternateRouteStaticData(@RequestParam(value="id") String id) {
		return (AlternateRouteStaticData) alternateRouteStaticDataStore.getData(id);
	}

	@RequestMapping("/alternateRouteStatic/all")
	public List<AlternateRouteStaticData> alternateRouteStaticDataAll(){
		return alternateRouteStaticDataStore.getAllAlternateRouteStaticData();
	}
	
	@RequestMapping("/alternateRouteStatic/count")
	public int alternateRouteStaticDataCount(){
		return alternateRouteStaticDataStore.getAllAlternateRouteStaticData().size();
	}
}