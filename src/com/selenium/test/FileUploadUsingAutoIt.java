package com.selenium.test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadUsingAutoIt {				
	public static void main(String[] args) throws IOException, InterruptedException {								
		WebDriver driver=new FirefoxDriver();			
		driver.get("http://demo.guru99.com/selenium/autoit.html");			
		//driver.findElement(By.id("postjob")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='postjob']")).click();
		Thread.sleep(3000);

		/*driver.findElement(By.id("input_3")).sendKeys("Gaurav");                                 					
		driver.findElement(By.id("input_4")).sendKeys("test.test@gmail.com");	*/ 				
		//driver.findElement(By.id("input_5")).click();
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='JotFormIFrame-72320244964454']"));
		driver.switchTo().frame(iframe);
		System.out.println("switched To Iframe");
		
		driver.findElement(By.xpath("//input[@id='input_5']")).click();
		
		
		
		// below line execute the AutoIT script .
		Runtime.getRuntime().exec("D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\FileUpload.exe");
		System.out.println("File Uploaded");
		Thread.sleep(5000);
		/*driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");					
		//driver.findElement(By.id("submit")).click();
		driver.close();
		*/
	}
}

