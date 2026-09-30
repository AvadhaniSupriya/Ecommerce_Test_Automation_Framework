package com.ui.tests;



import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase{
	
	protected HomePage homePage;
	
	private boolean isLambda;
	
	
	@Parameters({"browser","isLambda","isHeadless"})
	@BeforeMethod(description = "Launch the HomePage of the Website")
	public void setup(@Optional("chrome")String browser,@Optional("false")boolean isLambda, @Optional("false")boolean isHeadless,ITestResult result)
	{
		
		this.isLambda=isLambda;
		
		WebDriver lambdaDriver = null;
		if(isLambda)
		{
			
			lambdaDriver=LambdaTestUtility.initlizeLambdaTest(result.getMethod().getMethodName(),browser);
			homePage = new HomePage(lambdaDriver);
			
		}
		else
			
		{
		
		//run into local machine
		 homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
		
	}
	
	public BrowserUtility getInstance()
	{
		
		
		return homePage;
	}

	
	/@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		
		if(isLambda)
		{
			
			LambdaTestUtility.quitSession();
		}
		
		else
		{
			
			homePage.quit();
		}
		
		
	}
}
