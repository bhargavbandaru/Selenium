package com.selenium.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileuploadUsingRobotClass {
	
	
		public static void main(String args[]) throws AWTException {
			Robot robot = new Robot();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://demo.automationtesting.in/Register.html");
			driver.findElement(By.id("imagesrc")).click();
			robot.setAutoDelay(3000);
			StringSelection stringSelection = new StringSelection("C:\\Users\\Bhargav\\Desktop\\FileUpload.txt");
			// Object owner;
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			robot.setAutoDelay(3000);			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}

}
