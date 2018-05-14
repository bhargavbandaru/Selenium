package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeExample {
	public static  WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// launching in chrome driver 
		// setting path of the chrome driver
		System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();  // creating instance of browser
		driver.manage().window().maximize(); // maxmazie the window 
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);// setting time to locate each object in a web page
		driver.get("https://letskodeit.teachable.com/p/practice"); // launching the browser

		// identifying frame and switching in to that frame 

		
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
		driver.switchTo().frame(iframe);
		
	
		System.out.println("successfullyswitched to i frame");

		Thread.sleep(3000);
        // scroll doen to particual expected element 
		
		WebElement scroll = driver.findElement(By.xpath("//div[contains(text(),'Rest API Automation With Rest Assured')]"));
		// intiating java script executor for scrolling in to that element 
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",scroll);
		System.out.println("scrolled");
		
		String expectedtext = driver.findElement(By.xpath("//div[contains(text(),'Rest API Automation With Rest Assured')]")).getText();

		if(expectedtext.contentEquals("Rest API Automation With Rest Assured"))
		{

			System.out.println("verified text");

		}

		driver.close();
	}

	

}
