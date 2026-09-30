package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String EMAIL_ADDRESS="mokiv14566@fidhost.com";
	
	private static final String PASSWORD="Newjob@1910";
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="Valid user is logged into the Application and searches for a product")
	public void setup()
	{
		
		searchResultPage=homePage.gotoLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD).searchProduct(SEARCH_TERM);
		
		
	}
	
	
	@Test(description="Verify if the user logged in able to place the order",groups= {"e2e","smoke","sanity"})
	public void checkoutTest()
	{
		
		
		String result=searchResultPage.clickontheProduct(1).changeSize(L).addtoCart().proceedtoCheckOut().goToConfirmAddressPage().gotoShipmentPage().goToPaymentPage().confirmCartProduct();
		System.out.println(result);

	}
	
}
