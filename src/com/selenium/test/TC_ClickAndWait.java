package com.selenium.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_ClickAndWait

{
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
    String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";	
	public static WebDriver driver;
	ExtentReports extent = new ExtentReports(extentReportFile, false);
	ExtentTest extentTest = extent.startTest("My First Test", "Click And Wait");
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
/*
		String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";*/
		System.out.println(extentReportFile);
		System.out.println(extentReportImage);
        driver.get("http://suvian.in/selenium/1.7button.html");
        
		extentTest.log(LogStatus.INFO, "Browser Launched and navigated to the URL");
		driver.findElement(By.xpath("//a[text()='Click Me']")).click();
		extentTest.log(LogStatus.INFO, "Clicked text me button ");
		// waiting for element to present 
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn btn-danger btn-lg']")));
		
		driver.findElement(By.xpath("//a[@class='btn btn-danger btn-lg']")).click();
		extentTest.log(LogStatus.INFO, " waited and clicked navigate button is displayed ");
		Thread.sleep(2000);
		
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



