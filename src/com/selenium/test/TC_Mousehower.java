package com.selenium.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_Mousehower

{
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";	
	public static WebDriver driver;
	ExtentReports extent = new ExtentReports(extentReportFile, false);
	ExtentTest extentTest = extent.startTest("My First Test", "Mouse hower");
	@BeforeTest
	public void browserLaunching()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public  void testCase() throws InterruptedException
	{
		System.out.println(extentReportFile);
		System.out.println(extentReportImage);
		driver.get("http://suvian.in/selenium/2.4mouseHover.html");
		extentTest.log(LogStatus.INFO, "Browser Launched and navigated to the URL");
		extentTest.log(LogStatus.INFO, "Select gender from DDl");
       
		// Code To mouse hower 
		
		WebElement wb = driver.findElement(By.xpath("//a[contains(text(),'This link has tooltip. Copy it and paste into below text field')]"));
		
		Actions a =  new Actions(driver);
		a.moveToElement(wb).build().perform();
		String expectedText  =  wb.getText();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(expectedText);
		
        extentTest.log(LogStatus.INFO, "Selectd gender from DDl");
		extentTest.log(LogStatus.INFO, "Browser closed");
	}		    

	@AfterTest
	public void afterClass()
	{

		extentTest.log(LogStatus.INFO, "Browser closed");
		// close report.
		extent.endTest(extentTest);
		// writing everything to document.
		extent.flush();
		driver.close();
		driver.quit();
		// Close application.
	}
}




