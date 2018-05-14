package com.selenium.test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
public class ExelReadAndWrite {
	public WebDriver driver;
	public Selenium selenium;
	public String str;
	@Test
	public void ValidInvalidCredintials() throws Exception
	{
		FileInputStream fi=new FileInputStream("E:\\bhargav\\BATCH1\\Anusha.xls");// For Linux machine
		Workbook w=Workbook.getWorkbook(fi);
		Sheet s=w.getSheet(0);
		FileOutputStream fo=new FileOutputStream("E:\\bhargav\\BATCH1\\Anusha.xls "); // For Linux machine
		WritableWorkbook wb=Workbook.createWorkbook(fo);
		WritableSheet ws=wb.createSheet("Result", 0);
		for (int i = 1; i < s.getRows(); i++) {
			
			   driver.findElement(By.xpath("(//input[@name='userName'])")).sendKeys(s.getCell(0, i).getContents()); 
			  

			  driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys(s.getCell(1, i).getContents());
			 
			 
			WebElement submitbutton = driver.findElement(By.xpath("(//input[@name='login'])"));
			
			
			if(submitbutton.isDisplayed())
			{
				//driver.findElement(By.linkText("edit-logout")).click();
				selenium.waitForPageToLoad("5000");
				//driver.get("http://techlearn.in/user");
				str="Pass";
			}else{
				str="Fail";
				System.out.println("Invalid");
			}
			Label result=new Label(2,i,str);
			ws.addCell(result);
			for (int j = 0; j < s.getColumns(); j++) {
				System.out.println(s.getCell(j, i).getContents());     
				Label un=new Label(j, i, s.getCell(j, i).getContents());
				ws.addCell(un);
			}      }    
		Label un=new Label(1,1,"Username");
		Label pw=new Label(2,2,"Password");
		Label rs=new Label(2,3,"Result");
		ws.addCell(un);
		ws.addCell(pw);
		ws.addCell(rs);
		wb.write();
		wb.close();
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","E:\\bhargav\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS); //
		//selenium=new WebDriverBackedSelenium(driver, "http://newtours.demoaut.com/mercurysignon.php?osCsid=b8d36a319bf0fb57aff66b70b13109e1");
		driver.get("http://newtours.demoaut.com/mercurysignon.php?osCsid=b8d36a319bf0fb57aff66b70b13109e1");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}