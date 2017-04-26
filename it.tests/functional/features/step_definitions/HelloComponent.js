'use strict';


var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
var hellopage = require('../page/hello.js');
chai.use(chaiAsPromised);
var expect = chai.expect;

var myStepDefinitionsWrapper = function() {
    var helloPage;
    this.Given(/^I visit AEM webpage "([^"]*)"$/, function(arg1) {
        arg1 = process.env.ENVIRONMENT + arg1;
        // to run locally or using dev URL 
        // arg1 = "http://xjzxdep0031x.dta.kp.org:4503/content/productzero/comp-automation-page.html";
        console.log("Page Open: " + arg1);
        browser.ignoreSynchronization = true;
        browser.manage().timeouts().pageLoadTimeout(50000);
        browser.get(arg1);
        helloPage = hellopage(browser);
    });

    this.When(/^I search for  "([^"]*)"$/, function(arg1, callback) {
        helloPage.visibleHeaderTitle(callback);
    });

    this.Then(/^I validate the "([^"]*)"$/, function(arg1, callback) {
        helloPage.verifyHeaderTitle(arg1, callback);
    });

    this.When(/^I search for body content "([^"]*)"$/, function(arg1, callback) {
       helloPage.visibleBody(callback);
    });

    this.Then(/^I validate the body content "([^"]*)"$/, function(arg1, callback) {
         helloPage.verifyBody(arg1, callback);
    });


};
module.exports = myStepDefinitionsWrapper;
