'use strict';

    var open = function (arg1) {

        this.element = browser.findElement(by.linkText(arg1));

    }

    module.exports=open;
