package com.edureka.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class GoogleSearchPage extends SharedActions 
{
	@FindBy(xpath = "//input[@class = 'gLFyf gsfi']")
	private WebElement INP_search;
	@FindBy(xpath = "//div[@class= 'FPdoLc tfB0Bf']//input[@class = 'gNO89b']")
	private WebElement BTN_googleSearch;
	@FindBy(xpath = "//a[@href='https://www.edureka.co/']")
	private WebElement LNK_edureka;

	public GoogleSearchPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterSearchData(String searchData)
	{
		try
		{
			verifyElementPresent(INP_search);
			INP_search.sendKeys(searchData);
			INP_search.sendKeys(Keys.ENTER);
			log.info("Entered data in "+INP_search);
		}
		catch(Exception e)
		{
			log.error("Unable to enter search value " + e.getStackTrace());
		}
	}
	public void clickGoogleSearch()
	{
		click(BTN_googleSearch);
	}
	public void clickEdurekaURL()
	{
		click(LNK_edureka);
	}
}
