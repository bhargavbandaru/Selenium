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
public class TC_ClickAndSelect
{
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";	
	public static WebDriver driver;
	ExtentReports extent = new ExtentReports(extentReportFile, false);
	ExtentTest extentTest = extent.startTest("My First Test", "Check radio Button");
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
		driver.get("http://suvian.in/selenium/1.10selectElementFromDD.html");
		extentTest.log(LogStatus.INFO, "Browser Launched and navigated to the URL");
		driver.findElement(By.xpath("//*[@class='dropbtn']")).click();
		System.out.println("clicked button");
		Thread.sleep(2000);
		extentTest.log(LogStatus.INFO, "Click me to open a menu");
		driver.findElement(By.xpath("//div[@class='dropdown']//following::div//a[text()='Option 2']")).click();
		extentTest.log(LogStatus.INFO, "selected required option and switching to tab");
		/*driver.switchTo().window("http://suvian.in/selenium/1.10option2.html");*/
		extentTest.log(LogStatus.INFO, "switching to tab");
		// windows handling
		String ParentWin = driver.getWindowHandle();
		wf:for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
			String sTtileName=driver.getTitle();
			System.out.println(sTtileName);
			if(sTtileName.contains("Congratulations"))
			{
				System.out.println("verified text"); 

			}
			driver.switchTo().defaultContent();

		}
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
