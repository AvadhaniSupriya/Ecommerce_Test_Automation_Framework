package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{
	
	private static final By SHOPPING_CART_BUTTON_LOCATOR= By.cssSelector("p.cart_navigation.clearfix a[title='Proceed to checkout']");

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ConfirmAddressPage goToConfirmAddressPage()
	{
		
		clickOn(SHOPPING_CART_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}

}
