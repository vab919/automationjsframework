var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);

exports.config = {

    // localhost
    // seleniumAddress: 'http://127.0.0.1:4445/wd/hub',
    //PQE Grid
    // seleniumAddress: 'http://xlzvbta0094x.lvdc.kp.org:4445/wd/hub',

    seleniumAddress: 'http://cskpcloudxp1501.cloud.kp.org:4444/wd/hub', // New Grid

    framework: 'custom',

    // path relative to the current config file
    frameworkPath: require.resolve('protractor-cucumber-framework'),
    // multiCapabilities: [{
    //     'browserName': 'chrome'
    // }, {
    //     'browserName': 'firefox'
    // }],
    ignoreUncaughtExceptions: true,

    capabilities: {
        'browserName': 'chrome'
    },
    useAllAngular2AppRoots: true,



    // Spec patterns are relative to this directory.
    specs: [
        '../features/*.feature'
    ],
    resultJsonOutputFile: './reports/report.json',

    cucumberOpts: {
        require: [
            '../features/step_definitions/*.js',
             '../features/support/*.js',
            '../features/support/env.js' //remove the 5000 milliseconds
        ],

        tags: '@functional,@regression,@smoke',
        format: 'pretty',
        profile: false,
        keepAlive: false,
        'no-source': true
    }
};
