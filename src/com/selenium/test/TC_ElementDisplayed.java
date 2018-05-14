package com.selenium.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_ElementDisplayed 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException

	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		
		System.out.println("clicking hide button");
		
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//input[@id='displayed-text']")).isDisplayed())
		{

			System.out.println("element is present");

		}
		else
		{
			System.out.println("element is not present");	

		}
		
		driver.quit();

	}



}

