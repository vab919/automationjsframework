package com.kp.fof.productzero.core.models;

import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * This class holds all of the unit tests for the PrdZeroButton class.
 */
public class TestPrdZeroButton {
	
	@Inject
	private PrdZeroButton prdZeroButton;
	
	@Before
    public void setup() {
        prdZeroButton = new PrdZeroButton();
        prdZeroButton.init();
    }
	
	@Test
	public void testTitle() {
		String expectedTitle = "GO";
		String actualTitle = prdZeroButton.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testLink() {
		String expectedLink = "https://www.google.com";
		String actualLink = prdZeroButton.getLink();
		assertEquals(expectedLink, actualLink);
	}
	
}