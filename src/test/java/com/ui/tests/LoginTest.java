package com.ui.tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pojo.User;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{
	
	//HomePage homePage;
	
	
	

	@Test(description = "Verifies with the valid user is able to login into application",groups= {"e2e","sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void loginTest(User user)
	{
		
		assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Supriya Gorivale");
	}

	
	@Test(description = "Verifies with the valid user is able to login into application",groups= {"e2e","sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginCSVTest(User user)
	{
		
		assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Supriya Gorivale");
	}
	
	
	@Test(description = "Verifies with the valid user is able to login into application",groups= {"e2e","sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider")
	public void loginExcelTest(User user)
	{
		
		
		
		assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Supriya Gorivale");
		
	}
}
