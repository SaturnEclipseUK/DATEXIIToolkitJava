package com.se.datex2clienttoolkit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.datex2clienttoolkit.controllers.DATEXIIClientController;
import com.se.datex2clienttoolkit.controllers.DataObjectController;
import com.se.datex2clienttoolkit.services.DATEXIIUpdateService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Datex2ClientToolkitApplication.class)
@TestPropertySource(locations="classpath:test.properties")
@WebAppConfiguration
public class Datex2ClientToolkitApplicationTests {
	
	@Autowired
	DataObjectController dataObjectController;
	
	@Autowired
	DATEXIIClientController datexIIClientController;
	
	@Autowired
	DATEXIIUpdateService datexIIUpdateService;
	
	@Before
	public void setup(){
		URL url = null;
			url = this.getClass().getResource("/VMS_and_Matrix_Signal_Status_Data_-_Full_Refresh_3793697241479015.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/ANPR_Journey_Time_Data_3794915029662987.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/Event_Data_-_Full_Refresh_3794850927130403.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/Fused_FVD_and_Sensor_PTD_3793821203699073.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/Fused_Sensor-only_PTD_3793817774626104.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/MIDAS_Loop_Traffic_Data_3793828281116175.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/TMU_Loop_Traffic_Data_3793809993027605.xml");
	        uploadFile(url);
	        
	        url = this.getClass().getResource("/NTIS_Model_Update_Notification_3707368431094454.xml");
	        uploadFile(url);
	        
	}

	private void uploadFile(URL url){
		File vmsFile = new File(url.getFile());
	    
	    BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(vmsFile));
			
	    	String s=null;
	    	s=br.readLine();
	        while(br.read()!=-1)
	        {
	             s=br.readLine();
	        }
	        br.close();
	    	
	        datexIIClientController.update(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void processDataUpdate() {
		while (!datexIIUpdateService.workPending()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			
			// print the size of each data store
			System.out.println("ANPR Data Size = " + dataObjectController.anprDataAll().size());
			System.out.println("Event Data Size = " +dataObjectController.eventDataAll().size());
			System.out.println("VMS Data Size = " + dataObjectController.vmsDataAll().size());
			System.out.println("TMU Data Size = " + dataObjectController.tmuDataAll().size());
			System.out.println("MIDAS Data Size = " + dataObjectController.midasDataAll().size());
			System.out.println("Fused Sensor Only Data Size = " + dataObjectController.fusedSensorOnlyDataAll().size());
			System.out.println("Fused FVD and Sensor Data Size = " + dataObjectController.fusedFVDAndSensorDataAll().size());
			
			// print a single object from each data store 
			ObjectMapper mapper = new ObjectMapper();

			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.tmuData("C6E971CAD2DC789BE0433CC411ACCCEA")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.midasData("7D6CAF49129E43948834C0C643DDE78C")));
			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedFVDAndSensorData("TrafficSpeed200109359")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedFVDAndSensorData("TravelTimeData200109359")));
			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedSensorOnlyData("TrafficFlow200109359")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedSensorOnlyData("TrafficConcentration200109359")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedSensorOnlyData("TrafficHeadway200109359")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedSensorOnlyData("TrafficSpeed200109359")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.fusedSensorOnlyData("TravelTimeData200109359")));
			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.eventData("UF-15-04-28-000100")));			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.anprData("1430297819000ANPR_Measurement_Site_30071390")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.vmsData("D25095020A9C7952E0433CC411ACA994")));		
			
			// Network model data
			
			// VMS & Matrix Signal
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.vmsStaticData("F1CED9A9D71616DCE0438DC611AC6AA4")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.matrixSignalStaticData("D25095020D4F7952E0433CC411ACA994")));
			
			// Measurement Sites
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.tameStaticData("C6ED3C0233073F7DE0433CC411AC7306")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.midasStaticData("8E08E9D3D31C4BFC99B1D008B83F8C15")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.anprStaticData("ANPR_Measurement_Site_30071670")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.tmuStaticData("C6E971CAD36B789BE0433CC411ACCCEA")));
			
			// Predefined Locations
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.linkShapeStaticData("108041601_0")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.nwkLinkStaticData("108041601")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.anprRouteStaticData("NTIS_ANPR_Route_30071670_0")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.hatrisSectionStaticData("HS50000001_0")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.nwkNodeStaticData("1100291")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.alternateRouteStaticData("8200001_0")));
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
