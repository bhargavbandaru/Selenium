package com.selenium.test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();  // creating instance of browser
		driver.manage().window().maximize(); // maxmazie the window 
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);// setting time to locate each object in a web page
		driver.get("https://letskodeit.teachable.com/p/practice"); // launching the browser
		//program to handle windows 
		
		// clicking on button\\
		
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		
		// switch to window and handle the window
		
		String parentwindow = driver.getWindowHandle(); //   getting parent window reference
		
		Set<String> win = driver.getWindowHandles();
		
		for(String windowshandle :driver.getWindowHandles())
		{

			System.out.println("child wind:"+windowshandle);
			driver.switchTo().window(windowshandle);
			if(!parentwindow.contentEquals(windowshandle))

			{

				String expectedTitle = driver.getTitle();
				System.out.println(expectedTitle);

				if(expectedTitle.contentEquals("Let's Kode It"))
				{
					System.out.println("verified text in child window");

				}
			}


		}

		driver.close();
		driver.switchTo().window(parentwindow);
		System.out.println("switched to parent window");
       //driver.switchTo().window(parentwindow);
       
       
       driver.quit();
	}

}
