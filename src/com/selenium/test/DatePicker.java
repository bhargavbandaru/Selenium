package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
    

	public static String baseUrl1;
	public static String baseUrl2;
	public static String baseUrl3;
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		WebElement nextButton;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseUrl1 = "http://www.expedia.com/";
		baseUrl2 = "http://www.southwest.com";
		baseUrl3 = "http://www.airbnbcom/";
		driver.get(baseUrl1);
		Thread.sleep(2000);
		driver.findElement(By.id("tab-flight-tab")).click();
		WebElement text = driver.findElement(By.id("flight-departing"));
		text.click();
		String expectedMonthText = driver.findElement(By.xpath("//table[@class='datepicker-cal-weeks']//caption[contains(text(),'Jan 2018')]")).getText();
		
		if(expectedMonthText.contains("Jan 2018"))
		{
			
			WebElement cal = driver.findElement(By.xpath("//div[@class='cal']//section[1]//ul[@class='cal-dates']"));
			
			
		}		
		while (!expectedMonthText.contains("Jan 2018") ) {
		nextButton = driver.findElement(By.xpath("//*[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']"));
		nextButton.click();
		
	}


	}

}
