package com.selenium.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AjaxControl

{
	public WebDriver driver;
	@BeforeTest()        

	public void Open()
	{
		//  System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=tKAGVZWXN6bM8gfrmIDIBA&gws_rd=ssl");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test()
	public void ajaxControl() throws InterruptedException
	{
		driver.findElement(By.id("sb_ifc0")).click();
		driver.findElement(By.id("sb_ifc0")).sendKeys("selenium");
		Thread.sleep(3000);
		String s= driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[2]/div/div[2]/div[2]/div")).getText();
		System.out.println(s);
		String s1 [] = s.split("\n");
		for(int i =0;i<s1.length;i++)
		{

			if(s1[i].contains("selenium webdriver"))
			{
				Thread.sleep(3000);
				System.out.println(s1[i]);
				//        driver.findElement(By.id("sb_ifc0")).clear();   
				driver.findElement(By.id("sb_ifc0")).sendKeys(s1[i]);  

			}
		}    
	}
	@AfterTest()
	public void Close()
	{

		driver.close();
		driver.quit();
	}

}