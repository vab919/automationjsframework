
new hobs.TestSuite("Product Zero helloworld Tests", {path:"/apps/productzero/tests/hobbesTest.js", register: true})

    .addTestCase(new hobs.TestCase("Navigate to mytest Page")
        .navigateTo("/content/productzero/en/mytest.html")
        .asserts.location("/content/productzero/en/mytest.html", true)
      )

    .addTestCase(new hobs.TestCase("Validate if helloworld component exists")
        .asserts.visible(".helloworld", true)
        .asserts.exists(".helloworld", true)
      )

    .addTestCase(new hobs.TestCase("Validate if fflService component exists")
        .asserts.visible(".fflService", true)
        .asserts.exists(".fflService", true)
        // .asserts.hasCssClass(".cq-Overlay cq-Overlay--component",true)
    )

    .addTestCase(new hobs.TestCase("Test Negative Scenario - fflService component doesn't exists")
        .navigateTo("/content/productzero/en/testnegativescenario.html")
        .asserts.location("/content/productzero/en/testnegativescenario.html", true)
        .asserts.visible(".helloworld", true)
        .asserts.visible(".fflService", false)
    );
