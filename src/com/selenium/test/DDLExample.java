package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDLExample {
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
	    
		// identifying  web element pck list 
		WebElement selectClassDDlist = driver.findElement(By.xpath("//select[@id='carselect']"));
		
		// handling drop down list 
		
		Select selectClassDDl = new Select(selectClassDDlist);  // select or identify the element 
		
		selectClassDDl.selectByIndex(0);
		
		System.out.println("Selecting ddl ");
		selectClassDDl.selectByValue("benz");    
		selectClassDDl.selectByVisibleText("Honda");
			
		Thread.sleep(3000);
		driver.close();
		
		

	}

}
