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
public class TC_FrameHandling
{
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";	
	public static WebDriver driver;
	ExtentReports extent = new ExtentReports(extentReportFile, false);
	ExtentTest extentTest = extent.startTest("My First Test", "Frame Handling");
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
		driver.get("http://suvian.in/selenium/2.3frame.html");
		extentTest.log(LogStatus.INFO, "Browser Launched and navigated to the URL");
		// Code for frame  handling 
		
		 int framesSize = driver.findElements(By.xpath("//iframe")).size();

		  System.out.println(framesSize);

		  for(int i=0;i<framesSize;i++)
		  {

		   driver.switchTo().frame(i);

		   extentTest.log(LogStatus.INFO, "Shifted to web Frame");

		   String Expected=driver.findElement(By.xpath("//button[@onclick='myFunction()']")).getText();

		   System.out.println(Expected); 

		   if(Expected.contentEquals("Click Me"))
		   {

		    extentTest.log(LogStatus.INFO, "verified actual and expected text");
		    driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		    extentTest.log(LogStatus.INFO, " Sucessfully clicked button ");
		    Thread.sleep(5000);
		    driver.switchTo().alert().accept();
		    extentTest.log(LogStatus.INFO, " Accepted alert ");
		    System.out.println("clicked succesfully");
		    break;
		   }

		   else

		    System.out.println(" Not clicked succesfully");

		  }

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




