package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHower {
 
	public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// launching in chrome driver 
		   // setting path of the chrome driver
			System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
			driver = new ChromeDriver();  // creating instance of browser
			driver.manage().window().maximize(); // maxmazie the window 
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);// setting time to locate each object in a web page
			driver.get("https://letskodeit.teachable.com/p/practice"); // launching the browser
		  WebElement mousehower=  driver.findElement(By.xpath("//button[@id='mousehover']"));
		// actions commands 
		  
		  Actions ac = new Actions(driver);
		 	
		  ac.moveToElement(mousehower).perform();
		 // ac.build().perform();
		  Thread.sleep(3000);
		  System.out.println(" successfully mouse hower on element mousehower example");
		
		  driver.close();

	}

}
