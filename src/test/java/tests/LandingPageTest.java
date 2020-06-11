package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LandingPage;
import pages.SearchResultsPage;

public class LandingPageTest extends BaseTest{

	String searchTerm="Selenium Webdriver";
	int suggestionNumber = 4;
	
	@Test
	public void testLandingPage() {
		driver.get(cr.getBaseUrl());
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.enterSearchTerm(searchTerm);
		SearchResultsPage resultsPage = landingPage.clickSearch();
		
		// verify that you are not on the landing page
		Assert.assertNotEquals(driver.getCurrentUrl(), cr.getBaseUrl());
		// verify you are still on the google domain
		Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
		
		resultsPage.clickQueryBox();
		resultsPage.clickSuggestion(suggestionNumber);
		// verify you are still on the google domain
		Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
		
		resultsPage.clickVideosTab();
		log.info("Results stats: " + resultsPage.getResultText());
	}
}