package com.kp.fof.productzero.core.models;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kp.fof.productzero.core.fflxmlhelper.FacilityDataType;
import com.kp.fof.productzero.core.fflxmlhelper.FacilityType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * Simple JUnit test verifying the FFLDataService
 */
public class TestFFLDataService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FFLDataService.class);
	private static final String REGION_ID_GGA = "GGA";
	private static final String REGION_ID_NCA = "NCA";
	private static final String VALID_ZIP_CODE = "30606";
	private static final String INVALID_ZIP_CODE = "30000";
	private static final String EXPECTED_GGA_URL = "https://service-bus-qa.kp.org:2008/service/hlth_plan_admin/mbrshp_admin/v1/KPORG/FacilityDirectoryDataRESTSvc/regions/GGA/facilities?ESB-ENVLBL=HQA";
	private static final String EXPECTED_NCA_URL = "https://service-bus-qa.kp.org:2008/service/hlth_plan_admin/mbrshp_admin/v1/KPORG/FacilityDirectoryDataRESTSvc/regions/NCA/facilities?ESB-ENVLBL=HQA";
	private static final File TEST_FACILITY_DATA = new File("/productzero/core/src/test/TestFacilityData.xml");
	private FFLDataService fflDataService = new FFLDataService();
	
	@Test
	public void testDataUrlPositive() {
		String endpointUrl = "https://service-bus-qa.kp.org:2008/service/hlth_plan_admin/mbrshp_admin/v1/KPORG/FacilityDirectoryDataRESTSvc/regions/region/facilities?ESB-ENVLBL=HQA";
		String actualGGAURL = fflDataService.getDataUrl(REGION_ID_GGA, endpointUrl);
		String actualNCAURL = fflDataService.getDataUrl(REGION_ID_NCA, endpointUrl);
		assertEquals(EXPECTED_GGA_URL, actualGGAURL);
		assertEquals(EXPECTED_NCA_URL, actualNCAURL);
	}
	
	@Test
	public void testDataUrlNegative() {
		String invalidEndpointUrl = "https://healthy.kaiserpermanente.org/";
		String invalidGGAUrl = fflDataService.getDataUrl(REGION_ID_GGA, invalidEndpointUrl);
		String invalidNCAUrl = fflDataService.getDataUrl(REGION_ID_NCA, invalidEndpointUrl);
		assertFalse(EXPECTED_GGA_URL.equals(invalidGGAUrl));
		assertFalse(EXPECTED_NCA_URL.equals(invalidNCAUrl));
	}
	
	@Test
	public void testMatchZipPositive() {
		assertNull(getFacilities(VALID_ZIP_CODE, REGION_ID_GGA));
	}

	@Test
	public void testMatchZipNegative() {
		assertNull(getFacilities(INVALID_ZIP_CODE, REGION_ID_GGA));
	}
	
	@Test
	/* TODO: This test will return no data because the endpoint URL is only assigned when the bundle gets deployed.
	 * Potential test case for mocking 
	 */
	public void testFacilityDetailsNegative() {
		List<FacilityType> facData = fflDataService.getFacilityDetails(VALID_ZIP_CODE, REGION_ID_GGA);
		assertTrue(facData.isEmpty());
	}
	
	public List<FacilityType> getFacilities(String zipCode, String regionId) {
		JAXBContext jaxbContext;
		List<FacilityType> facilityResults = null;
		
		try {
			jaxbContext = JAXBContext.newInstance(FacilityDataType.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FacilityDataType facilityData = (FacilityDataType) jaxbUnmarshaller.unmarshal(TEST_FACILITY_DATA);
			facilityResults = fflDataService.matchZip(zipCode, facilityData, regionId);
		} catch (JAXBException e) {
			LOGGER.debug(e.getMessage());
		}
		return facilityResults;
	}
}
