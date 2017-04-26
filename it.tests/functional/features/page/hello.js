var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;

module.exports = function(driver) {

    var selectors = {
        header: by.xpath('html/body/div[1]/div[1]/div/h1'),
        body: by.xpath('html/body/div[1]/div[2]')

    };

    function visibleHeaderTitle(callback) {
        var headerTitle = driver.element(selectors.header);
        expect(headerTitle.isDisplayed()).to.eventually.equal(true).and.notify(callback);
    }

    function verifyHeaderTitle(arg1, callback) {
        var headerTitle = driver.element(selectors.header);
        expect(headerTitle.getText()).to.eventually.contains(arg1).and.notify(callback);
    }


    function visibleBody(callback) {
        var contentValue = driver.element(selectors.body);
        expect(contentValue.isDisplayed()).to.eventually.equal(true).and.notify(callback);
    }

    function verifyBody(arg1, callback) {
        var contentValue = driver.element(selectors.body);
        expect(contentValue.getText()).to.eventually.contains(arg1).and.notify(callback);
    }

    return {
        visibleHeaderTitle: visibleHeaderTitle,
        verifyHeaderTitle: verifyHeaderTitle,
        visibleBody: visibleBody,
        verifyBody: verifyBody

    };
};