package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;
	
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	
	
	public BrowserUtility(Browser browserName)
	{
		
		if(browserName == Browser.CHROME)
		{
			
			System.out.println("Before set = " + driver.get());

			driver.set(new ChromeDriver());

			System.out.println("After set = " + driver.get());
			this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		}
		else if(browserName == Browser.EDGE)
		{
			
			driver.set(new EdgeDriver());
			this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
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
			this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
			}
			
			else
			{
				
				driver.set(new ChromeDriver());
				this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
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
			this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
			
			}
			else
			{
				
				driver.set(new EdgeDriver());
				this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
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
		logger.info("Click operation performed on the element");
	}
	
	public void clickusingWait(By locator)
	{
		
		
		WebElement element = waitforElement(locator);
		
		element.click();
		logger.info("Click operation performed on the element using Expilict Waits ");
	}
	
	public void clickOn(WebElement element)
	{
		
		
		
		
		element.click();
		logger.info("Click operation performed on the element");
	}
	
	public void enterText(By locator, String texttoEnter)
	{
		
		
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(texttoEnter);
		logger.info("Text entered");
	}
	
	public void clearText(By locator)
	{
		
		
		WebElement element = driver.get().findElement(locator);
		element.clear();
		logger.info("Text cleared");
	}
	
	
	public void enterSpecialKey(By locator, Keys keytoEnter)
	{
		
		
		WebElement element = driver.get().findElement(locator);
		
		element.sendKeys(keytoEnter);
		logger.info("Elements found and getting the text");
	}
	
	
	public String getVisibleText(By locator)
	{
		
		WebElement element = driver.get().findElement(locator);
		
		return element.getText();
		
	}
	public String getVisibleText(WebElement element)
	{
		
		
		return element.getText();
		
	}
	
	public List<String> getAllVisibleText(By locator)
	{
		
		List<WebElement> elementList = driver.get().findElements(locator);
		
		
		List<String> visibleTextList= new ArrayList<String>();
		for(WebElement ele: elementList)
		{
			
			
			System.out.println("printing the List of Elements:  "+getVisibleText(ele));
			visibleTextList.add(getVisibleText(ele));
		}
		
		return visibleTextList;
		
		
	}
	
	public List<WebElement> getAllElements(By locator)
	{
		
		List<WebElement> elementList = driver.get().findElements(locator);
		
		
		
		
		return elementList;
		
		
	}
	
	
	public void selectFromDropdown(By dropdownlocator, String texttoSelect)
	{
		
		WebElement stateDropdown =
		        driver.get().findElement(dropdownlocator);

		performAction(stateDropdown, texttoSelect);
		
		
		
	}
	public void selectFromDropdownSelect(By dropdownlocator, String option)
	{
		
		WebElement stateDropdown =
		        driver.get().findElement(dropdownlocator);

		Select select = new Select(stateDropdown);
		select.selectByVisibleText(option);
		
		
		
		
	}
	
	//Waits
	
	public WebElement waitforElement(By locator)
	{
		
		
		return wait.until(
	            ExpectedConditions.elementToBeClickable(locator));
		
		
	}
	
	//actions
	
	public void performAction(WebElement element,String texttoSelect)
	{
		
		
		new Actions(getDriver()).click(element).sendKeys(texttoSelect).sendKeys(Keys.ENTER).build().perform();
		
		
		
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
		
		logger.info("Closing the WebDriver sessions");
	    driver.get().quit();
	}
}
