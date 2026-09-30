package com.ui.tests;


import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class InvalidLoginTest extends TestBase{
	
	
	
	Logger logger= LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS="waxopab51@kikaga.com";
	private static final String INVALID_PASSWORD="nEWjOB";
	

	@Test(description = "Verifies that user should not be able to login into application with invalid creds and display proper error message ",groups= {"e2e","sanity"})
	public void loginTest()
	{
		
		assertEquals(homePage.gotoLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}

	
	
}
