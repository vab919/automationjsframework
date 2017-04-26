module.exports = function(grunt) {

var webURL ="http://xjzxdep0218x.slsjc.kp.org:4503"; // URL for Dev20
process.env.ENVIRONMENT = (grunt.option("environment")||webURL);
console.log("This is webURL: "+process.env.ENVIRONMENT);

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        jshint: {
            files: ['Gruntfile.js', 'specs/*.js'],
            options: {
                // options here to override JSHint defaults
                globals: {
                    jQuery: true,
                    console: true,
                    module: true,
                    document: true
                }
            }
        },
        protractor: {
            options: {
                keepAlive: true,
                configFile: "config/config.js"
            },
            singlerun: {},
            auto: {
                keepAlive: true,
                options: {
                    args: {
                        seleniumPort: 4444
                    }
                }
            }
        },
        shell: {
            options: {
                stdout: true
            },
            protractor_install: {
                command: 'node ./node_modules/protractor/bin/webdriver-manager update'
            },
            npm_install: {
                command: 'npm install'
            }
        }

    });


    grunt.loadNpmTasks('grunt-protractor-runner');

    grunt.loadNpmTasks('grunt-contrib-jshint');

    grunt.loadNpmTasks('grunt-shell-spawn');

    grunt.registerTask('install', ['shell:npm_install', 'shell:protractor_install']);

    grunt.registerTask('default', ['jshint', 'protractor:singlerun']);

};
