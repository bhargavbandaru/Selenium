package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class IsElementDisplayed {
     
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
      
		// launching in chrome driver 
	   // setting path of the chrome driver
		System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();  // creating instance of browser
		driver.manage().window().maximize(); // maxmazie the window 
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);// setting time to locate each object in a web page
		driver.get("https://letskodeit.teachable.com/p/practice"); // launching the browser
	   
		// to chk element is displayed or not 
		
		// get the size if zixe =0 then not displayed elase element displayed
		// is element displayed
		//  Assert
		
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		
		Thread.sleep(2000);
		
		WebElement elemdisplay = driver.findElement(By.xpath("//input[@id='displayed-text']"));
	
		
		
        if(elemdisplay.isDisplayed())  // t
        {
        	
        System.out.println("Displayed");	
        }
        else
        {
        System.out.println("Not displayed");	
        }
        
	
		driver.close();
		
		

	
		

	}

}
