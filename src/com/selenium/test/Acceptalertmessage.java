package com.selenium.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Acceptalertmessage

{
	public static WebDriver driver;

	@Test()
	public void acceptAlertmessage() throws InterruptedException
	{
		
		String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";

		System.out.println(extentReportFile);
		System.out.println(extentReportImage);


		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest extentTest = extent.startTest("My First Test", "Verify WebSite Title");
		driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		extentTest.log(LogStatus.INFO, "Browser Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		System.out.println("Alert Accepted");
		extentTest.log(LogStatus.INFO, "Alert verified");
		extentTest.log(LogStatus.INFO, "Browser closed");
		driver.quit();
		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
	}
}
