package com.selenium.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KeyEvents {

	static WebDriver driver;
	@Test
	public void minimizethewindow() throws AWTException, InterruptedException

	{ 
		//System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.chrome.driver","\\C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_SPACE);
		//release opposite order
		robot.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_N);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_N); 
		
	}



}
