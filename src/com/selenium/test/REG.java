package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class REG {
    public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.name("name")).sendKeys("Test");
		driver.findElement(By.name("phone")).sendKeys("4827595277");
		driver.findElement(By.name("email")).sendKeys("bhargav.softwaretester@gmail.com");
		
		Select country = new Select(driver.findElement(By.name("country")));
		/*country.selectByIndex(1);
		country.selectByValue("Albania");*/
		country.selectByVisibleText("Albania");
		
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("hyd");
		
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("Testing");
		
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("(//input[@class='button'])[2]")).click();
		
		System.out.println("Registered");

	}

}
