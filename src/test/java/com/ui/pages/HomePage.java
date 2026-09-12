package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

//import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{

	Logger logger = LoggerUtility.getLogger(this.getClass());
	public HomePage(Browser browserName, boolean isHeadless) {
		
		
		super(browserName,isHeadless);
		logger.info("Launching Browser in Headless Mode");
		maximizeWindow();
		//goToWebsite(readProperty(QA,"URL"));//this from Properties file
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}


	


	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	
	
	public LoginPage gotoLoginPage()
	{
		
		
		LoginPage loginPage= new LoginPage(getDriver());
		logger.info("Click on Sign-In Button for Login");
		clickOn(SIGN_IN_LINK_LOCATOR);
		return loginPage;
				
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
