package com.se.datex2clienttoolkit.services;


import org.springframework.stereotype.Service;

import com.se.datex2.schema.D2LogicalModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * A JAXB helper service.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@Service
public class JAXBService {
	JAXBContext jc;

	public JAXBService(){
		try {
			jc = JAXBContext.newInstance(D2LogicalModel.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
		
	public Unmarshaller createUnmarshaller()
	{
		synchronized(this){
			Unmarshaller unmarshaller=null;
			try {
				unmarshaller = jc.createUnmarshaller();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			return unmarshaller;
		}
	}
	
	public Marshaller createMarshaller(){
		synchronized(this){
			Marshaller marshaller = null;
			try {
				marshaller = jc.createMarshaller();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			return marshaller;
		}
	}
}
