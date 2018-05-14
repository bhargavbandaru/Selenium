package com.selenium.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_AlertHandle {
	public static WebDriver driver;


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
	public void tescase() throws IOException
	{

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Switch To Alert Example')]")));
		

		// verify text
		
		

		String expected = "Switch To Alert Example";
		String actual  = driver.findElement(By.xpath("//*[contains(text(),'Switch To Alert Example')]")).getText();
		Assert.assertEquals(expected, actual);
		System.out.println("verified");

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.apache.commons.io.FileUtils.copyFile(srcFile, new File("C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\temp.png "));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*Alert handling

			driver.findElement(By.id("confirmbtn")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();*/

	}
	@AfterTest
	public void teardown()
	{
		driver.quit(); 

	}




}
