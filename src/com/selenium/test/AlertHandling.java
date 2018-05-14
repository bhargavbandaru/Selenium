package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
    public static WebDriver driver;
	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// launching in chrome driver 
			   // setting path of the chrome driver
				System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
				driver = new ChromeDriver();  // creating instance of browser
				driver.manage().window().maximize(); // maxmazie the window 
				driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);// setting time to locate each object in a web page
				driver.get("https://letskodeit.teachable.com/p/practice"); // launching the browser
			    driver.findElement(By.id("name")).sendKeys("Bhargav"); // sending text to 	the text box Enter your Name
			    // click on alert button
			    driver.findElement(By.id("alertbtn")).click();
			    Thread.sleep(3000);
	            //Accept the  alert  
				driver.switchTo().alert().accept();  // okk	
			//	driver.switchTo().alert().dismiss(); cancel the alert
				Thread.sleep(3000);
				System.out.println("===  successfully accepted the alert ===== ");
				driver.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    // closing the browser and sessions 
				//driver.quit();
				
	
	}

}
