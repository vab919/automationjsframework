var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;
var facilityZipCodeXpathValue = ".//*[@id='facilityZipCode']";
var findFacilityByLocationXpathValue = ".//*[@id='findFacilityByLocation']";


module.exports = function(driver) {

    var selectors = {
        facilityZipCode: by.xpath(facilityZipCodeXpathValue),
        findFacilityByLocation: by.xpath(findFacilityByLocationXpathValue)
    };

    function visibleFacilityZipCode(callback) {
        var Zipcode = driver.element(selectors.facilityZipCode);
        expect(Zipcode.isDisplayed()).to.eventually.equal(true).and.notify(callback);
    }

    function visibleFacilityByLocation(callback) {
        var FacilityByLocation = driver.element(selectors.findFacilityByLocation);
        expect(FacilityByLocation.isDisplayed()).to.eventually.equal(true).and.notify(callback);
    }

    function clickFacilityByLocation(callback) {
        var ClickFacilityByLocation = driver.element(selectors.findFacilityByLocation);
        ClickFacilityByLocation.click().then(callback);
    }
    return {
        visibleFacilityZipCode: visibleFacilityZipCode,
        visibleFacilityByLocation: visibleFacilityByLocation,
        clickFacilityByLocation: clickFacilityByLocation
    };
};
