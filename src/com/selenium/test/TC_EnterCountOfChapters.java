package com.selenium.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_EnterCountOfChapters {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
	
		// TODO Auto-generated method stub
		int count  =0;
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("http://suvian.in/selenium/2.6liCount.html");
		List<WebElement> myElements = driver.findElements(By.xpath("//li[contains(text() , 'Chapter')]"));
		System.out.println("Total chapters count in all books : " +myElements.size());
		int c = myElements.size();
		driver.findElement(By.id("chapall")).sendKeys(String.valueOf(c));
		String text = driver.findElement(By.xpath("//ul[@id='books']/li[2]")).getText();
	   // String text1 = driver.findElement(By.xpath("//div/div/div/ul/li[2] and contains(text(), 'Chapter ')")).getText();
		//int d = text1.length();
		Thread.sleep(3000);
		List<WebElement> myElements1 = driver.findElements(By.xpath("//ul[@id='books']/li[2]//*[contains(text(),'Chapter')]"));
		System.out.println(myElements1.size());
		int d  = myElements1.size();
		Thread.sleep(3000);
		driver.findElement(By.id("chapbook2")).sendKeys(String.valueOf(d));
		System.out.println("successfully entered");
     
		driver.quit();
		
	
	}

}
