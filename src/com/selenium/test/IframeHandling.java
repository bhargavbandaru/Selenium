package com.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframeHandling {
	
	public WebDriver driver;
	@BeforeTest
	public void setUp()
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void tescase() throws IOException, InterruptedException
	{

		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
		driver.switchTo().frame(iframe);
		System.out.println("successfullyswitched to i frame");

	    Thread.sleep(3000);
	    
		WebElement scroll = driver.findElement(By.xpath("//div[contains(text(),'Rest API Automation With Rest Assured')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",scroll);
		System.out.println("scrolled");
		String expectedtext = driver.findElement(By.xpath("//div[contains(text(),'Rest API Automation With Rest Assured')]")).getText();

		if(expectedtext.contentEquals("Rest API Automation With Rest Assured"))
		{
			
			System.out.println("verified text");
			
		}

	}

	@AfterTest
	public void teardown()
	{
		driver.quit(); 

	}	
}
