package com.selenium.test;

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

public class WinHandle {

	public  WebDriver driver;


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

		driver.findElement(By.xpath("//a[@id='opentab']")).click();

		String parentwindow = driver.getWindowHandle(); // getting parentwindow
		System.out.println("parent window :"+parentwindow);

		for(String windowshandle :driver.getWindowHandles())
		{

			System.out.println("child wind:"+windowshandle);
			driver.switchTo().window(windowshandle);
			if(!parentwindow.contentEquals(windowshandle))

			{

				String expectedTitle = driver.getTitle();
				System.out.println(expectedTitle);

				if(expectedTitle.contentEquals("Let's Kode It"))
				{
					System.out.println("verified text in child window");

				}
			}


		}

		driver.close();
		driver.switchTo().window(parentwindow);
		System.out.println("switched to parent window");
		//driver.close();


	}

	@AfterTest
	public void teardown()
	{
		driver.quit(); 

	}	

}
