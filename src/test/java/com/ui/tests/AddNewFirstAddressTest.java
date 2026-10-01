package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Addresses;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{

	private static final String EMAIL_ADDRESS="mokiv14566@fidhost.com";
		
	private static final String PASSWORD="Newjob@1910";
	
	private MyAccountPage myaccountPage;
	
	private Addresses address;
	
	@BeforeMethod(description="Valid Only First Time user logs into the application")
	public void setup()
	{
		
		myaccountPage=homePage.gotoLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD);
		 address = FakeAddressUtility.getFakeAddress();
		
		
	}
	
	
	@Test(description="Add new Address",groups= {"e2e","sanity","smoke"})
	public void addAddress()
	{
		
		
	String addressText=myaccountPage.goToAddressPage().saveAddress(address);
	System.out.println(addressText);
	System.out.println(address.getAddressAlias());
	Assert.assertEquals(addressText,address.getAddressAlias().toUpperCase());
		
		
	}
}
