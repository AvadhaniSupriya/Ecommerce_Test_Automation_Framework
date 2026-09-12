package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {
		
		WebDriver wd= new ChromeDriver();
		
		BrowserUtility browserUtility= new BrowserUtility(wd);
		browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
		browserUtility.maximizeWindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign in\")]");
		browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "waxopab591@kikaga.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator,"Newjob@1910");
		
		
		By submitLoginButtonBoxLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonBoxLocator);
	}

}
