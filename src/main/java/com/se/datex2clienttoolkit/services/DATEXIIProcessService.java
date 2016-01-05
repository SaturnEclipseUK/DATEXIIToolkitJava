package com.se.datex2clienttoolkit.services;

import com.se.datex2.schema.D2LogicalModel;

/**
 * 
 * Abstract class for all process services.
 * 
 * @author Saturn Eclipse Limited
 *
 */
public abstract class DATEXIIProcessService {
	public abstract void processMessage(D2LogicalModel d2LogicalModel);
}
