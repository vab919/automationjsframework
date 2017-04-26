package com.kp.fof.productzero.core.models;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kp.fof.productzero.core.fflxmlhelper.FacilityDataType;
import com.kp.fof.productzero.core.fflxmlhelper.FacilityType;
import com.kp.fof.productzero.core.fflxmlhelper.RegionType;

@Component(immediate = true, metatype = true, label = "FFL Data Service")
@Service(value = FFLDataInterface.class)
public class FFLDataService implements FFLDataInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(FFLDataService.class);
	
	@Property(label = "Path", description = "FFL DataService API URL", value = "https://service-bus-qa.kp.org:2008/service/hlth_plan_admin/mbrshp_admin/v1/KPORG/FacilityDirectoryDataRESTSvc/regions/region/facilities?ESB-ENVLBL=HQA")
	public static final String FFLDataService_URL = "FFLDataServiceApiUrl";	
	private static String FFLDataServiceApiUrl="";
	
	public List<FacilityType> getFacilityData(String zipCode, String region) {

		return getFacilityDetails(zipCode, region);
	}
	
	protected void activate(ComponentContext componentContext){
		configure(componentContext.getProperties());
		LOGGER.info("FFL Data Service is activated");
	}
	
	protected void configure(Dictionary<?, ?> properties) {
		FFLDataServiceApiUrl = (String.valueOf(properties.get(FFLDataService_URL)) != null)?String.valueOf(properties.get(FFLDataService_URL)):null;
		LOGGER.info("configure: FFL Data Service API URL='{}''"+ FFLDataServiceApiUrl);
	}
	
	public String getDataUrl(String regionId, String endPointUrl) {
		return Pattern.compile("region/+").matcher(endPointUrl).replaceAll(regionId+"/");
	}
	
	public List<FacilityType> matchZip(String zipCode, FacilityDataType facilityData, String regionId) {
		List<FacilityType> facilityResults = new ArrayList<FacilityType>();
		int requestZip = 0;
		
		if ((zipCode != null && zipCode != "") && (regionId != null && regionId != "")) {
			requestZip = Integer.parseInt(zipCode);
		}
		
		for (RegionType region : facilityData.getRegions()) {
			if (region.getRegionId().equalsIgnoreCase(regionId)) {
				for (FacilityType facility : region.getFacilities()) {
					int facilityZip = facility.getAddress().getZip();
					String relatedZipCode = ((facility.getRelatedZipcodes() != null) ? facility.getRelatedZipcodes()
							: "");
					if ((facilityZip == requestZip) || relatedZipCode.contains(zipCode)) {
						facilityResults.add(facility);
					}
				}
			}
		}
		
		return facilityResults;
	}
	
	public List<FacilityType> getFacilityDetails(String zipCode, String regionId) {
		String ffdlService = getDataUrl(regionId, FFLDataServiceApiUrl);
		// TODO: add behavior for invalid URL
		List<FacilityType> facilityResults = new ArrayList<FacilityType>();
		
		// TODO: Implement common configurator instead of keeping property annotations in service class
		// This is service virtualization end point
		// String ffdlService="http://xjzxdis0110x.dta.kp.org:10151/data/regions/region/facilities?v=3&ESB-ENVLBL=Hint2";
		
		JAXBContext jaxbContext;
		
		try {
			jaxbContext = JAXBContext.newInstance(FacilityDataType.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FacilityDataType facilityData = (FacilityDataType) jaxbUnmarshaller.unmarshal(new URL(ffdlService));
			// TODO: add behavior if the unmarshaller fails
			facilityResults = matchZip(zipCode, facilityData, regionId);
		} catch (JAXBException e) {
			LOGGER.debug(e.getMessage());
		} catch (MalformedURLException e) {
			LOGGER.debug(e.getMessage());
		}
		return facilityResults;
	}
}