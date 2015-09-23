package com.se.datex2clienttoolkit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.se.datex2clienttoolkit.services.DATEXIINetworkModelUpdateService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Datex2ClientToolkitApplication.class)
public class DATEXIINetworkModelUpdateServiceTests {

	@Autowired
	DATEXIINetworkModelUpdateService datexIINetworkModelFTPService;
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void updateNetworkModel() {
		String url = "http://www.tih.org.uk/images/5/50/NTISModel-2015-07-10-v3.2.zip";
		datexIINetworkModelFTPService.updateNetworkModel(url);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
