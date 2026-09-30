package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	
	private static final By CONFIRM_CART_PRODUCT_MESSAGE_LOCATOR=By.cssSelector("span.heading-counter");

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String confirmCartProduct()
	{
		
		return getVisibleText(CONFIRM_CART_PRODUCT_MESSAGE_LOCATOR);
	}
}
