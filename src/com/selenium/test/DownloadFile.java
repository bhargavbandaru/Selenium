package com.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFile {

	
	
	public WebDriver driver;
	 @Test
	 public void testBing() throws Exception {
	 
	  driver.get("http://the-internet.herokuapp.com/");
	  driver.findElement(By.linkText("File Download")).click();
	  driver.findElement(By.linkText("avatar.jpg")).click();
	  Thread.sleep(5000);
	 
	 }
	 
	 
	 @BeforeClass
	 public void beforeClass() throws IOException
	{
	  //Create object of FirefoxProfile in built class to access Its properties.
	 // System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	  FirefoxProfile fprofile = new FirefoxProfile();
	 

			/*System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargav\\Desktop\\Course Material\\Softwares\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS); //	
		    */
	  //Set Location to store files after downloading.
	 
	  fprofile.setPreference("browser.download.dir", "C://Users//Bhargav//Downloads");
	 
	  // 2 tells it to use a custom download path whereas a 1 is the browser's default path and a 0 is the Desktop
	 
	  fprofile.setPreference("browser.download.folderList", 2);
	 
	  //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
	  //Full lsit of MIME types "http://www.webmaster-toolkit.com/mime-types.shtml"
	 
	  fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg");
	 
	  fprofile.setPreference( "browser.download.manager.showWhenStarting", false );
	 
	  //if usign PDFs then use it
	  fprofile.setPreference( "pdfjs.disabled", true );
	 
	  //Pass firefox profile parameter In webdriver to use preferences to download file.
	 
	  driver = new FirefoxDriver(fprofile);
	 
	  //maximize browser
	  driver.manage().window().maximize();
	 
	  //global declaration of wait
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	 }
	 
	 @AfterClass
	 public void afterClass() {
	  driver.quit();
	 }

}
