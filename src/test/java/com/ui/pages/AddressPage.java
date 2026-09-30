package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.Addresses;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{

		private static final By COMPANY_TEXT_BOX_LOCATOR=By.id("company");
		private static final By ADDRESS1_TEXT_BOX_LOCATOR=By.id("address1");
		private static final By ADDRESS2_TEXT_BOX_LOCATOR=By.id("address2");
		private static final By CITY_TEXT_BOX_LOCATOR=By.id("city");
		private static final By POSTAL_CODE_BOX_LOCATOR=By.id("postcode");
		private static final By HOME_PHONE_BOX_LOCATOR=By.id("phone");
		private static final By MOBILE_PHONE_BOX_LOCATOR=By.id("phone_mobile");
		private static final By ADDITIONAL_INFO_BOX_LOCATOR=By.id("other");
		private static final By ADDRESS_TITLE_BOX_LOCATOR=By.cssSelector("//input[value=\"My address\"]");
		private static final By STATE_DROPDOWN_LOCATOR=By.id("uniform-id_state");
		private static final By SAVE_ADDRESS_LOCATOR=By.id("submitAddress");
		private static final By ADDRESS_ALIAS_LOCATOR=By.id("alias");
		private static final By SUBMIT_ADDRESS_LOCATOR=By.id("submitAddress");
		private static final By ADDRESS_HEADING_LOCATOR=By.tagName("h3");
	
	
	public AddressPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String saveAddress(Addresses address)
	{
		
		
		enterText(COMPANY_TEXT_BOX_LOCATOR, address.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, address.getAddressLine1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, address.getAddressLine2());
		enterText(CITY_TEXT_BOX_LOCATOR, address.getCity());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, address.getState());
		enterText(POSTAL_CODE_BOX_LOCATOR, address.getPostalCode());
		enterText(HOME_PHONE_BOX_LOCATOR, address.getHomePhoneNumber());
		enterText(MOBILE_PHONE_BOX_LOCATOR, address.getMobilePhoneNumber());
		enterText(ADDITIONAL_INFO_BOX_LOCATOR, "NA");
		enterText(SAVE_ADDRESS_LOCATOR, address.getOtherInformation());
		clearText(ADDRESS_ALIAS_LOCATOR);
		enterText(ADDRESS_ALIAS_LOCATOR, address.getAddressAlias());
		clickOn(SUBMIT_ADDRESS_LOCATOR);
		 return getVisibleText(ADDRESS_HEADING_LOCATOR);
		
		
		
		
		
		
		
	
	}
	
	
	

}
