package com.se.datex2clienttoolkit.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.se.datex2.common.UnZipUtils;

/**
 * 
 * This service retrieves the latest network model and forwards it to 
 * the DATEX II Update Service for processing.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class DATEXIINetworkModelUpdateService {

	final Logger log = LoggerFactory.getLogger(DATEXIINetworkModelUpdateService.class);
		
	@Autowired
	DATEXIIUpdateService datexIIUpdateService;
	
	String NWK_MODEL_PATH = "nwk_model.zip";
	String NWK_MODEL_DIRECTORY = "nwk_model";
    	
	public void updateNetworkModel(String url, String username, String password){
		
		this.removeExistingNetworkModel();
		
		if (url.startsWith("file:///")){
			copyNetworkModel(url);
		} else {
			this.fetchNetworkModel(url, username, password);
		}
	    
	    this.unzipNetworkModel();
		 
		this.parseNetworkModelXMLFiles();
	}
	
	private void removeExistingNetworkModel(){
		log.info("Removing existing network model");
		try {
			FileUtils.deleteDirectory(new File(NWK_MODEL_DIRECTORY));
			new File(NWK_MODEL_PATH).delete();
		} catch (IOException e) {
			log.error("Error removing directory: "+e.toString(),e);
			return;
		}
	}
	
	private void copyNetworkModel(String path){
		path = path.replace("file:///", "");
		log.info("Copying network model: "+path);
		try {
			Files.copy(new File(path).toPath(), new File(NWK_MODEL_PATH).toPath());
		} catch (IOException e) {
			log.error("Error copying file: "+path, e);
		}
	}
	
	private void fetchNetworkModel(String url, String username, String password){
		// Create an instance of HttpClient.
	    HttpClient client = new HttpClient();
	
	    // Create a method instance.
	    GetMethod method = new GetMethod(url);
	    
	    // Set credentials
	    String auth = username + ":" + password;
	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
	    String authHeader = "Basic " + new String(encodedAuth);
	    method.setRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);
	    
	    // Provide custom retry handler is necessary
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));
	
	    try {
	      log.info("Downloading network model.");
		  // Execute the method.
		  int statusCode = client.executeMethod(method);
		
		  if (statusCode != HttpStatus.SC_OK) {
		    log.error("Download of network model failed: " + method.getStatusLine());
		    return;
		  }
		
		  // Read the response body.
		  InputStream inputStream = method.getResponseBodyAsStream();
		
		  FileOutputStream fos = new FileOutputStream(NWK_MODEL_PATH);
		  IOUtils.copy(inputStream, fos);
		  fos.close();	
	    } catch (HttpException e) {
	      log.error("Fatal protocol violation: " + e.getMessage(), e);	      
	    } catch (IOException e) {
	      log.error("Fatal transport error: " + e.getMessage(), e);	      
	    } finally {
	      // Release the connection.
	      method.releaseConnection();
	    }
	}
	
	private void unzipNetworkModel(){
		log.info("Unzipping network model.");
		UnZipUtils.unZipFile(NWK_MODEL_PATH, NWK_MODEL_DIRECTORY);
	}
	
	private void parseNetworkModelXMLFiles(){
		File folder = new File(NWK_MODEL_DIRECTORY);
		File[] listOfFiles = folder.listFiles();
		  
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String filename = listOfFiles[i].getName();	
				try {
					byte[] encoded = Files.readAllBytes(Paths.get(listOfFiles[i].getPath()));	  
					datexIIUpdateService.addToMessageQueue(new String(encoded, StandardCharsets.UTF_8));
					log.info("Added file to process queue: "+filename);
				} catch (IOException e ){
					log.error("Failed to read file: "+filename, e);
				}
		    } 
		}
	}
}
