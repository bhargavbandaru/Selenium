package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TC_Login_newtour
{

	public static WebDriver driver;
	@BeforeClass
	public void browserLaunching()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}
	@Test(description = "login to website, book a flight and verify the details")
	public void login() throws InterruptedException
	{
       driver.get("http://newtours.demoaut.com/mercurysignon.php");
       driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("pbunny");
       driver.findElement(By.xpath("//input[@name='password']")).sendKeys("padala");
       driver.findElement(By.name("login")).click();
       Thread.sleep(2000);
        if(driver.getPageSource().contains("SIGN-OFF"))
        	 
       {
    	   
    	  System.out.println(" Login test scenario validated");
    	  driver.findElement(By.partialLinkText("SIGN-OFF")).click();
    	   
       }
       
	}

	@AfterClass
	public void afterClass()
	{

		driver.close();
		//driver.quit();

	}

}
