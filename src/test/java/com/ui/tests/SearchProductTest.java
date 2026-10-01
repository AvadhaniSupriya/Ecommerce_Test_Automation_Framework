package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase{
	
	Logger logger= LoggerUtility.getLogger(this.getClass());
	private static final String EMAIL_ADDRESS="waxopab51@kikaga.com";
	private static final String PASSWORD="Newjob@1910";
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	private MyAccountPage myaccountPage;
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setup()
	{
		
		myaccountPage=homePage.gotoLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD);
		
		
	}
	
	
	@Test(description="Verify if the logged in user is able to search for a product and correct products are displayed",groups= {"e2e","sanity","smoke"})
	
	
	public void verifyProductSearchTest()
	{
		
		boolean actuatlResult=myaccountPage.searchProduct(SEARCH_TERM).isSearchTermPresentinProductList(SEARCH_TERM);
		
		Assert.assertEquals(actuatlResult, true);
		
		
		
		
		
	}

}
