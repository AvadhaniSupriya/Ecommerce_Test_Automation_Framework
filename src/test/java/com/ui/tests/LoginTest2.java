package com.ui.tests;

 
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;


public class LoginTest2 {

	@Test
	public void loginTest() {
		
		
		
		HomePage homePage = new HomePage(Browser.CHROME);
		LoginPage loginPage=homePage.gotoLoginPage();
		loginPage.doLoginWith("waxopab591@kikaga.com", "Newjob@1910");
	}

}
