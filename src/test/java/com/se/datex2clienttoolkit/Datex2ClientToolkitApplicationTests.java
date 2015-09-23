package com.se.datex2clienttoolkit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.datex2clienttoolkit.controllers.DATEXIIClientController;
import com.se.datex2clienttoolkit.controllers.DataObjectController;
import com.se.datex2clienttoolkit.datastores.data.VMSData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Datex2ClientToolkitApplication.class)
@WebAppConfiguration
public class Datex2ClientToolkitApplicationTests {
	
	@Autowired
	DataObjectController dataObjectController;
	
	@Autowired
	DATEXIIClientController datexIIClientController;
	
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
		
		try {
			Thread.sleep(10000);
			System.out.println("ANPR Data Size = " + dataObjectController.anprDataAll().size());
			System.out.println("Event Data Size = " +dataObjectController.eventDataAll().size());
			System.out.println("VMS Data Size = " + dataObjectController.vmsDataAll().size());
			System.out.println("TMU Data Size = " + dataObjectController.tmuDataAll().size());
			System.out.println("MIDAS Data Size = " + dataObjectController.midasDataAll().size());
			System.out.println("Fused Sensor Only Data Size = " + dataObjectController.fusedSensorOnlyDataAll().size());
			System.out.println("Fused FVD and Sensor Data Size = " + dataObjectController.fusedFVDAndSensorDataAll().size());
			
			
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
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.anprData("ANPR_Measurement_Site_30070608")));
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObjectController.vmsData("D25095020A9C7952E0433CC411ACA994")));
			Thread.sleep(3000);
		} catch (InterruptedException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
