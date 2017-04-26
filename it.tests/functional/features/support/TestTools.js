var TestTools = {

  clickDropdownOptionWithGivenValue: function (
    selectId, optionValue) {
    element(by.css('#' + selectId)).click();
    return element(
      by.xpath(
        '//select[@id="' + selectId +
        '"]/option[text()="' + optionValue  + '"]')
    ).click();
  }
};


module.exports.clickDropdownOptionWithGivenValue = TestTools.clickDropdownOptionWithGivenValue;
