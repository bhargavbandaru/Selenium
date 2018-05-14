/**
 * 
 */
package com.selenium.test;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author bhargav
 *
 */
public class Log4j 
  
{

	public static WebDriver driver;

	//public static WebDriver driver;

	@Test()


	public static void test() 

	{
		// Here we need to create logger instance so we need to pass Class name for
		//which  we want to create log file in my case Google is classname
		Logger logger=Logger.getLogger("Google");// Logger.getLogger(Google.class)
		// configure log4j properties file
		PropertyConfigurator.configure("Log4j.properties");
		// Open browser

		driver = new FirefoxDriver();
		
		logger.info("Browser Opened");
	    
		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Implicit wait given");
		// Load application
		driver.get("https://www.google.co.in/");

		logger.info("Url opened");

		driver.get("http://bhargavbandaru.blogspot.in/");

		logger.info("Blog spot opened");

		driver.quit();
	
		
		//driver.close();	
		// type Selenium
		/*driver.findElement(By.name("q")).sendKeys("Selenium");
		logger.info("keyword type");  */

	}

}
