'use strict';

var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;

var protractor = require('protractor');

var productZeroButtonStepDefinitions = function() {

    this.Given(/^I visit the "([^"]*)" page$/, function(arg1, callback) {
        arg1 = process.env.ENVIRONMENT + arg1;
        // to run locally or using dev URL 
        // arg1 = "http://xjzxdep0031x.dta.kp.org:4503/content/productzero/prdzerobutton.html";
        browser.ignoreSynchronization = true;
        browser.get(arg1).then(function() {
            callback();
        });
    });

    this.When(/^I click on the "([^"]*)" in the page$/, function(arg1, callback) {
        var prdZeroButtonXpath = ".//*[@id='" + arg1 + "']";
        var productZeroButton = browser.element(by.xpath(prdZeroButtonXpath));
        productZeroButton.click().then(function() {
            callback();
        });

    });

    this.Then(/^"([^"]*)" should navigate to "([^"]*)" page$/, function(arg1, arg2, callback) {
        var currentTitlename;
        var EC = protractor.ExpectedConditions;
        browser.wait(EC.titleContains("Google"), 50000);
          currentTitlename = browser.getTitle().then(function(webpagetitle) {
            return webpagetitle;
        });
        expect(currentTitlename).to.eventually.equal(arg2).and.notify(callback);
    });

};
module.exports = productZeroButtonStepDefinitions;