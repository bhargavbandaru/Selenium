package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonExample {
    public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
					// launching in chrome driver 
				   // setting path of the chrome driver
					System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
					driver = new ChromeDriver();  // creating instance of browser
					driver.manage().window().maximize(); // maxmazie the window 
					driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);// setting time to locate each object in a web page
					driver.get("https://letskodeit.teachable.com/p/practice"); // launching the browser
				
				    // click on radio button 
				    driver.findElement(By.id("benzradio")).click();
				    
				    System.out.println("clicked radio button sucessfully");
				    
				  
	}

}
