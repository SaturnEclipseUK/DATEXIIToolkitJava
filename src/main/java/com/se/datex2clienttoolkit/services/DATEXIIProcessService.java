package com.se.datex2clienttoolkit.services;

import com.se.datex2.schema.D2LogicalModel;

public abstract class DATEXIIProcessService {
	public abstract void processMessage(D2LogicalModel d2LogicalModel);
}
