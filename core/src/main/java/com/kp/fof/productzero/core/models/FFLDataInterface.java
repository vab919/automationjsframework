package com.kp.fof.productzero.core.models;

import java.util.List;

import com.kp.fof.productzero.core.fflxmlhelper.FacilityType;

public interface FFLDataInterface {
	
	public List<FacilityType> getFacilityDetails(String zipCode, String regionId);

}
