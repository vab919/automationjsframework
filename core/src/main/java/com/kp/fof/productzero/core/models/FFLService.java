package com.kp.fof.productzero.core.models;

import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Reference;

import com.kp.fof.productzero.core.fflxmlhelper.FacilityType;

@Component(immediate = true, metatype = false, label = "FFL Service")
@Service(value=FFLServiceInterface.class)
public class FFLService implements FFLServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(FFLService.class);
	
	@Reference
	private FFLDataInterface FFLdataInterface;
	//TODO:SCR annotations is not injecting automatically, investigate
	// Temp solution as constructor
	
	public FFLService(){
		this.FFLdataInterface = new FFLDataService();
		LOGGER.debug("FFLDataService instance is created");
	}
	
	public List<FacilityType> getFacilityDetails(String zipCode, String regionId) {
		return FFLdataInterface.getFacilityDetails(zipCode, regionId);
	}

}
