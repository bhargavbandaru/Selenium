package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchIeBrowser
{
    public static WebDriver driver;
	public static void main(String[] args) 
	{
    // TODO Auto-generated method stub
	System.setProperty("webdriver.ie.driver","D:\\Manaul and Automation Training\\Course Material\\Softwares\\IEDriverServer.exe");	
	driver = new InternetExplorerDriver();
	driver.get("http://www.seleniumhq.org/download/");

	}

}
