package com.edureka.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CaptureScreenShot implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		for(Object param : result.getParameters())
		{
			System.out.println(param);
		}
		String fileName = result.getMethod().getMethodName();
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		
		try 
		{
			File src = event.getScreenshotAs(OutputType.FILE);
			File screenShot = new File(".//ScreenShots//"+fileName+".png");
			if(screenShot.exists())
				screenShot.delete();
			FileUtils.copyFile(src, screenShot);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		for(Object param : result.getParameters())
		{
			System.out.println(param);
		}
		String fileName = result.getMethod().getMethodName();
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		
		try 
		{
			File src = event.getScreenshotAs(OutputType.FILE);
			File screenShot = new File(".//ScreenShots//"+fileName+".png");
			if(screenShot.exists())
				screenShot.delete();
			FileUtils.copyFile(src, screenShot);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	
}
