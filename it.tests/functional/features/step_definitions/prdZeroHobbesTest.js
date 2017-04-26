'use strict';

var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;

var myStepDefinitionsWrapper = function() {

    this.Given(/^I visit website with url "([^"]*)"$/, function(arg1,callback) {

        arg1 = "http://xjzxdea0030x.dta.kp.org:4502/editor.html/content/productzero/en/testnegativescenario.html";
        // arg1 = "http://localhost:4502/editor.html/content/productzero/en/testnegativescenario.html";
        browser.ignoreSynchronization = true;
        browser.manage().timeouts().pageLoadTimeout(50000);
        browser.get(arg1);
        // User Name
        browser.element(by.xpath(".//*[@id='username']")).sendKeys("i474917"); //i474917
        //Password
        browser.element(by.xpath(".//*[@id='password']")).sendKeys("Change3me"); //Change3me
        //Click on SignON
        browser.element(by.xpath(".//*[@id='submit-button']")).click().then(callback); 
    });

    this.When(/^I click on Developer Option icon$/, function(callback) {
        var EC = protractor.ExpectedConditions;
        browser.wait(EC.titleContains("testNegativeScenario"), 26000);
        browser.sleep(1000);
        browser.element(by.xpath(".//*[@id='Content']/div[1]/nav/div[3]/a/i")).click().then(callback);

        browser.sleep(2000);
    });


    this.When(/^I click on Tests icon$/, function() {
        // Write code here that turns the phrase above into concrete actions
        browser.element(by.xpath(".//*[@id='coral-122']/div/button[3]")).click(); //Dev
        browser.element(by.xpath(".//*[@id='developer-rail']/nav/a[2]/i")).click();
        browser.sleep(1000);
    });


    this.Then(/^I click on "([^"]*)" button$/, function(arg1, callback) {
        var testSuiteCssPath = ".coral-Icon.coral-Icon--playCircle.coral-Icon--sizeS.cq-DeveloperRail-actionTrigger.js-run-testsuite";
        browser.element(by.css(testSuiteCssPath)).click().then(function() {
              callback();
        });
    });

    this.Then(/^I see all the execution of test script$/, function(callback) {
        browser.sleep(5000);
        var cssPath = ".coral-Icon.coral-Icon--sizeXS.cq-TestCase-flag.coral-Icon--closeCircle.is-failed";
        expect(element(by.css(cssPath)).isPresent()).to.become(false).and.notify(callback);

    });

};
module.exports = myStepDefinitionsWrapper;