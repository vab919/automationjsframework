'use strict';

var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
var TestTools = require('../support/TestTools.js');
var hellopage = require('../page/hello.js');
chai.use(chaiAsPromised);
var expect = chai.expect;
var facilityZipCodeXpathValue = ".//*[@id='facilityZipCode']";
var findFacilityByLocationXpathValue = ".//*[@id='findFacilityByLocation']";
var count = 0;
var FFL_zipCode = require('../page/FFL_ZipCode.js');
var listOfFacilitiesXpathValue = "html/body/div/div[2]/div[3]"

var myStepDefinitionsWrapper = function() {
    var FFL_ZipCode;

    this.Given(/^I go to the website with url "([^"]*)"$/, function(arg1, callback) {
        arg1 = process.env.ENVIRONMENT + arg1;
        // arg1 = "http://localhost:4502/content/productzero-foundation/testpagekp.html";
        //  arg1="http://xjzxdep0031x.dta.kp.org:4503/content/productzero/dec10morning.html"
        console.log("Page Open: " + arg1);
        FFL_ZipCode = FFL_zipCode(browser);
        if (count == 0) {
            browser.ignoreSynchronization = true;
            browser.manage().timeouts().pageLoadTimeout(50000);
            browser.get(arg1);
            count++;
            callback();
        } else {
            callback();
        }
    });

    this.Then(/^I validate the Zipcode Textbox$/, function(callback) {
        FFL_ZipCode.visibleFacilityZipCode(callback);
    });
    this.Then(/^I validate the SEARCH Button$/, function(callback) {
        FFL_ZipCode.visibleFacilityByLocation(callback);
    });
    this.When(/^I enter "([^"]*)" in the textbox$/, function(arg1, callback) {
        var textboxValue = browser.findElement(by.xpath(facilityZipCodeXpathValue));
        textboxValue.clear();
        textboxValue.sendKeys(arg1).then(callback);
    });

    this.When(/^I click SEARCH button$/, function(callback) {
        FFL_ZipCode.clickFacilityByLocation(callback);
    });
    this.Then(/^I can see the list of facilities with "([^"]*)" and Address as "([^"]*)" in the first row$/, function(arg1, arg2, callback) {
        var listOfFacilities1 = browser.element(by.xpath(listOfFacilitiesXpathValue));
        var listOfFacilities = browser.element(by.xpath("html/body/div[1]/div[2]/div[3]/font[1]"));
        expect(listOfFacilities.isDisplayed()).to.eventually.equal(true);
        expect(listOfFacilities.getText()).to.eventually.contains(arg1);
        expect(listOfFacilities1.getText()).to.eventually.contains(arg2).and.notify(callback);
    });

    this.When(/^I enter valid Zipcode with "([^"]*)" in the textbox$/, function(arg1, callback) {
        var textboxValue = browser.findElement(by.xpath(facilityZipCodeXpathValue));
        textboxValue.clear();
        textboxValue.sendKeys(arg1).then(callback);
    });

    this.When(/^I select Region as "([^"]*)"$/, function(arg1, callback) {
        TestTools.clickDropdownOptionWithGivenValue('facilityRegionCode', arg1).then(callback);
    });

    this.When(/^I enter invalid Zipcode with "([^"]*)" in the textbox$/, function(arg1, callback) {
        var textboxValue = browser.findElement(by.xpath(facilityZipCodeXpathValue));
        textboxValue.clear();
        textboxValue.sendKeys(arg1).then(callback);
    });
    this.Then(/^I do not see the list of facilities$/, function(callback) {
        var listOfFacilities = browser.element(by.xpath(".//*[@id='displayLocation']"));
        expect(listOfFacilities.getText()).to.eventually.contains("No Results found").and.notify(callback);
    });

};
module.exports = myStepDefinitionsWrapper;
