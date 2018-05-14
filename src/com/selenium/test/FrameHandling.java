package com.selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class FrameHandling 
{
	public static WebDriver driver;

	@Test
	public void handleFrame() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.get("http://suvian.in/selenium/2.3frame.html");
		driver.manage().window().maximize();
		int framesSize = driver.findElements(By.xpath("//iframe")).size();

		System.out.println(framesSize);

		for(int i=0;i<framesSize;i++)
		{

			driver.switchTo().frame(i);

			System.out.println("Shifted to webframe");

			String Expected=driver.findElement(By.xpath("//button[@onclick='myFunction()']")).getText();

			System.out.println(Expected); 

			if(Expected.contentEquals("Click Me"))
			{

				driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
				Thread.sleep(5000);
				driver.switchTo().alert().accept();
				System.out.println("Alert handled");
				System.out.println("clicked succesfully");
				break;
			}

			else

				System.out.println(" Not clicked succesfully");

		}

		driver.quit();

	}
}

