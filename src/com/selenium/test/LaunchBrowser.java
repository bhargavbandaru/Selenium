package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static WebDriver driver ;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	/*// ff chrome ie safari 
		
	// To launch FF browser
		
		driver = new FirefoxDriver();
		
		System.out.println("launched browser");
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		System.out.println("launching fb url ");*/
		
	// launching in chrome driver 
	
		System.setProperty("webdriver.chrome.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.NANOSECONDS);
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=2.35/");
		// imlicit wait and explict waits 
		
		//Thread.sleep(3000);
		
		
		driver.quit();
		driver.close();
		
		
		// chrome driver Ie safri   .exe 
	}

}
