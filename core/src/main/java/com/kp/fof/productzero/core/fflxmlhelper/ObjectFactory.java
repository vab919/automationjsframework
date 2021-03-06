//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.12 at 03:35:18 PM PST 
//


package com.kp.fof.productzero.core.fflxmlhelper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kp.fof.productzero.core.models.ffdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FacilityData_QNAME = new QName("", "facility_data");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kp.fof.productzero.core.models.ffdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FacilityDataType }
     * 
     */
    public FacilityDataType createFacilityDataType() {
        return new FacilityDataType();
    }

    /**
     * Create an instance of {@link PhoneType }
     * 
     */
    public PhoneType createPhoneType() {
        return new PhoneType();
    }



    /**
     * Create an instance of {@link PhoneNumbersType }
     * 
     */
    public PhoneNumbersType createPhoneNumbersType() {
        return new PhoneNumbersType();
    }

    /**
     * Create an instance of {@link RegionType }
     * 
     */
    public RegionType createRegionType() {
        return new RegionType();
    }

    /**
     * Create an instance of {@link FacilityType }
     * 
     */
    public FacilityType createFacilityType() {
        return new FacilityType();
    }


    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link CpmFacilitiesType }
     * 
     */
    public CpmFacilitiesType createCpmFacilitiesType() {
        return new CpmFacilitiesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilityDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "facility_data")
    public JAXBElement<FacilityDataType> createFacilityData(FacilityDataType value) {
        return new JAXBElement<FacilityDataType>(_FacilityData_QNAME, FacilityDataType.class, null, value);
    }

}
