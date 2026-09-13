package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(Browser browserName)
	{
		
		if(browserName == Browser.CHROME)
		{
			
			System.out.println("Before set = " + driver.get());

			driver.set(new ChromeDriver());

			System.out.println("After set = " + driver.get());
		}
		else if(browserName == Browser.EDGE)
		{
			
			driver.set(new EdgeDriver());
		}
		else
		{
			
			System.err.println("Invalid browser Name, please enter valid Browser : Chrome/Edge!!");
			
		}
		
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless)
	{
		
		if(browserName == Browser.CHROME)
		{
			if(isHeadless)
			{
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--headless=old");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			}
			
			else
			{
				
				driver.set(new ChromeDriver());
			}
		}
		else if(browserName == Browser.EDGE)
		{
			if(isHeadless)
			{
			
			EdgeOptions options= new EdgeOptions();
			options.addArguments("--headless=old");
			options.addArguments("disabled-gpu");
			driver.set(new EdgeDriver(options));
			
			}
			else
			{
				
				driver.set(new EdgeDriver());
			}
		}
		else
		{
			
			System.err.println("Invalid browser Name, please enter valid Browser : Chrome/Edge!!");
			
		}
		
	}
	
	
	public void goToWebsite(String url)
	{
		
		driver.get().get(url);
	}

	public void maximizeWindow()
	{
		
		System.out.println("Inside maximizeWindow = " + driver.get());
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		
		
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String texttoEnter)
	{
		
		
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(texttoEnter);
	}
	
	public String getVisibleText(By locator)
	{
		
		WebElement element = driver.get().findElement(locator);
		return element.getText();
		
	}
	
	public String takeScreenshot(String name)
	{
		
		Date date = new Date();
		SimpleDateFormat timeformat= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = timeformat.format(date);
		String path= "./screenshots/"+name+" - "+ timestamp +".png";
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		File screenshotFile= new File(path);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
		
	}
	
	public void quit() {
	    driver.get().quit();
	}
}
