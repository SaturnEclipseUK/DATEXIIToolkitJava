package com.se.datex2clienttoolkit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.se.datex2clienttoolkit.services.DATEXIIUpdateService;

/**
 * 
 * A DATEX II HTTP controller to receive raw XML strings and add to the update service queue.
 * 
 * @author Saturn Eclipse Limited
 *
 */
@RestController
@RequestMapping("/subscriber")
public class DATEXIIClientController {
	final Logger logger = LoggerFactory.getLogger(DATEXIIClientController.class);

	@Autowired
	DATEXIIUpdateService datexIIUpdateService;
	 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody String xml) {
		if(logger.isDebugEnabled()){
			logger.debug("DATEXII Update Message Received");
			if(logger.isTraceEnabled()){
				logger.trace("DATEXII Update Message Received(Message Length = " + new Integer(xml.length()).toString() + ")");
			}
		}
		
		datexIIUpdateService.addToMessageQueue(xml);
        return;
    }
}
