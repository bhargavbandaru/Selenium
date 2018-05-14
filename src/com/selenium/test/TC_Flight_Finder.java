package com.selenium.test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class TC_Flight_Finder 
{
	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";	
	public static WebDriver driver;
	
	@BeforeClass
	public void browserLaunching()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	@Test(description = "Validating flight finder details")
	public void loginValidateFlight_Finder() throws InterruptedException
	{

		String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		String extentReportImage = System.getProperty("user.dir")+ "\\extentReportImage.png";

		System.out.println(extentReportFile);
		System.out.println(extentReportImage);

		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest extentTest = extent.startTest("My First Test", "Verify WebSite Title");

		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		extentTest.log(LogStatus.INFO, "Browser Launched and navigated to the URL");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("pbunny");
		extentTest.log(LogStatus.INFO, "Entered required Username");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("padala");
		extentTest.log(LogStatus.INFO, "Entered required Password");
		driver.findElement(By.name("login")).click();
		extentTest.log(LogStatus.INFO, "Clicked Login button");
		Select passangers = new Select (driver.findElement(By.xpath("//select[@name='passCount']")));
		passangers.selectByVisibleText("2");
		extentTest.log(LogStatus.INFO, "Selected No of Passengers details");
		System.out.println("###### passenger value is selected ##########");
		String s= driver.findElement(By.xpath("//select[@name='fromPort']")).getText();

		String s1 [] = s.split("\n");
		System.out.println(s1);

		for(int i=1;i<s1.length;i++)

		{


			Select DepartingFrom = new Select (driver.findElement(By.xpath("//select[@name='fromPort']")));
			DepartingFrom.selectByVisibleText(s1[i]);
			extentTest.log(LogStatus.INFO, "Selected from destination");
			System.out.println(s1[i]);
			break;
		}

		Select On = new Select (driver.findElement(By.xpath("//select[@name='fromMonth']")));
		On.selectByVisibleText("February");

		extentTest.log(LogStatus.INFO, "Picked from Month");

		Select Arrivedate = new Select (driver.findElement(By.xpath("//select[@name='fromDay']")));
		Arrivedate.selectByVisibleText("21");

		extentTest.log(LogStatus.INFO, "Picked from Day");

		Select ArrivingIn = new Select (driver.findElement(By.xpath("//select[@name='toPort']")));
		ArrivingIn.selectByVisibleText("New York");

		extentTest.log(LogStatus.INFO, "Selected to Destination");

		Select Returning = new Select (driver.findElement(By.xpath("//select[@name='toMonth']")));
		Returning.selectByVisibleText("February");

		extentTest.log(LogStatus.INFO, "Selected to month");

		System.out.println("The value febuary is selected");

		Select Returndate = new Select (driver.findElement(By.xpath("//select[@name='toDay']")));
		Returndate.selectByVisibleText("23");

		extentTest.log(LogStatus.INFO, "Selected to Day");

		System.out.println("The value  Return  is selected");

		// driver.findElement(By.xpath("//input[@name='servClass'])[2]")).click();

		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();

		extentTest.log(LogStatus.INFO, "Selecting the bussiness class details");

		System.out.println("bussines class is selected");

		driver.findElement(By.xpath("//input[@name='findFlights']")).click();

		extentTest.log(LogStatus.INFO, "Clicking the find Flight button");

		// select the to and fro flights

		if (driver.getPageSource().contains("Blue Skies Airlines 360"))
		{

			extentTest.log(LogStatus.INFO, " Verifying the text Blue Skies Airlines 360");


			driver.findElement(By.xpath("//input[@name='outFlight']")).click();
			extentTest.log(LogStatus.INFO, " towards journey check box is checked");
			System.out.println("towards journey check box is checked");
			driver.findElement(By.xpath("//input[@name='inFlight']")).click();
			extentTest.log(LogStatus.INFO, " return journey check box is checked");
			System.out.println(" return journey check box is checked");
			driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
			System.out.println("clicked on continue button");
			extentTest.log(LogStatus.INFO, "Clicked continue button");

		}

		// book a flight

		// validate and book a flight

		if (driver.getPageSource().contains("Total Price")) 

		{

			extentTest.log(LogStatus.INFO, " Validating Total Price");

			System.out.println("page contains Frankfurt to Acapulco");
			driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("bunny");

			extentTest.log(LogStatus.INFO, " Entering the First name");

			System.out.println("enter the first name");

			driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("padala");
			extentTest.log(LogStatus.INFO, " Entering the Last  name");

			System.out.println("enter the last name name");

			driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
			extentTest.log(LogStatus.INFO, " Clicked the Buy Flight button");

		}


		// validating the flight confirmation

		if (driver.getPageSource().contains("Total Price"))
		{
			System.out.println("flight confirmation id # 2016-02-21085745 flight ticket is booked succesfully ");

			driver.findElement(By.xpath("//td[3]/a/img"));

			System.out.println(" booking scenario test case is passed");
			extentTest.log(LogStatus.INFO, " Ticket booked successfully");

			extentTest.log(LogStatus.INFO, "Browser closed");


			//driver.close();
			driver.quit();

			// close report.
			extent.endTest(extentTest);

			// writing everything to document.
			extent.flush();




		}		    

	}


/*	@AfterClass
	public void afterClass()
	{

		driver.close();
		driver.quit();

		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
	}*/


	}



