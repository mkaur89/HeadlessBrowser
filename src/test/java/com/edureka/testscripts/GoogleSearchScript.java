package com.edureka.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.edureka.common.BaseTest;
import com.edureka.pages.GoogleSearchPage;

public class GoogleSearchScript extends BaseTest 
{
	GoogleSearchPage searchPage = null;

	@Test
	public void tc_01_searchEdureka()
	{
		try
		{
			searchPage = new GoogleSearchPage(driver);

			searchPage.enterSearchData("edureka");
			//searchPage.clickGoogleSearch();
			searchPage.clickEdurekaURL();

			Thread.sleep(2000);
			String currentTitle = driver.getTitle();
			System.out.println(currentTitle);
			assertEquals("Instructor-Led Online Training with 24X7 Lifetime Support | Edureka", currentTitle);
			log.info("TC_01_login has been executed successfully");
		}
		catch(Exception e)
		{
			log.error("TC_01_login has failed " + e);	
		}
	}
}
