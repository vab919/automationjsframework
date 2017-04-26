new hobs.TestSuite("Product Zero Button Comp Tests", {path:"/apps/productzero/tests/prdzerobutton.js", register: true})

      .addTestCase(new hobs.TestCase("Check Button Text")
        .navigateTo("/content/productzero/prdzerobutton.html")
        .asserts.location("/content/productzero/prdzerobutton.html", true)
        .asserts.visible(".prodzerobutton", true)
        .asserts.isTrue(function() {
        	return hobs.find("button[id='prdZeroButton']").text().trim() === "GO";
        })
      )

        .addTestCase(new hobs.TestCase("Check Button Link")
            .navigateTo("/content/productzero/prdzerobutton.html")
        	.asserts.location("/content/productzero/prdzerobutton.html", true)
        	.asserts.visible(".prodzerobutton", true)
        	.asserts.isTrue(function() {
                var res = $(hobs.find("button[id='prdZeroButton'][data-selector='https://www.google.com']"))
				if(res.length > 0) {
                    return true
                } else {
                    return false
                }
            })
        );