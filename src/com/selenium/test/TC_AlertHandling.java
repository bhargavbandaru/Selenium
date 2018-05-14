package com.selenium.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_AlertHandling
{
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";	
	public static WebDriver driver;
	ExtentReports extent = new ExtentReports(extentReportFile, false);
	ExtentTest extentTest = extent.startTest("My First Test", "Alert handling");
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
		driver.get("http://suvian.in/selenium/2.1alert.html");
		extentTest.log(LogStatus.INFO, "Browser Launched and navigated to the URL");
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Thread.sleep(2000);
		// code for alert handling 
		
		driver.switchTo().alert().accept();
		extentTest.log(LogStatus.INFO, " Accepted alert ");
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



