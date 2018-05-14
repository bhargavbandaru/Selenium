package com.selenium.test;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class WindowsHandle 
{
	public static WebDriver driver;
	@Test
	public void acceptAlertmessage() throws InterruptedException
	{
		/*// Model 1 :
		driver = new FirefoxDriver();
		driver.get("http://suvian.in/selenium/2.2browserPopUp.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'Click Me')]")).click();
		Thread.sleep(3000);

		wf:for(String winHandle : driver.getWindowHandles())
		{

			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
			
			String sTtileName=driver.getTitle();
			
			System.out.println(sTtileName);
			driver.close();
			if(sTtileName.equals("")){
			
			
			}
			else
			{
			break wf;
			}

			System.out.println("switched to window");

			String expected=driver.getCurrentUrl();

			System.out.println(expected);

			String Actual = "http://suvian.in/selenium/2.2browserPopUp.html";
			if(Actual.contentEquals(Actual))
			{

				System.out.println("Test case passed");

			}

			Thread.sleep(5000);

			driver.switchTo().defaultContent();
			break;

		}
		//driver.close(); window will not close only instance will close
		driver.quit();
*/
		// model 2

		//!!!!!!!++++++++++++++++===============++++++++++++++++++++++++++++++++++++++++++++++++++!!!!!!!!

	    driver = new FirefoxDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		System.out.println(driver.findElement(By.partialLinkText("All Jobs")).getText());
		System.out.println(driver.findElement(By.partialLinkText("All Jobs")).getTagName());
		System.out.println(driver.findElement(By.partialLinkText("All Jobs")).getAttribute("title"));
		driver.findElement(By.xpath("//a[contains(@href, 'https://www.naukri.com/browse-jobs')]")).click();
		System.out.println("Clicked the Link");
		Thread.sleep(4000);
		String ParentWin = driver.getWindowHandle();
		
		//Set<String>s = driver.getWindowHandles();
		wf:for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
			String sTtileName=driver.getTitle();
			System.out.println(sTtileName);
			
		}
/*		System.out.println(s);
		Object Childwins[]=s.toArray();
		for(int i=0;i<s.size();i++)
		{

			driver.switchTo().window(Childwins[i].toString());
			
			System.out.println("Entered and switched the window");

			String Expected= driver.findElement(By.partialLinkText("All Jobs")).getText();
			
			System.out.println(Expected);

			if(ParentWin.contentEquals(Childwins[i].toString()))
			{

				if(Expected.contentEquals("All Jobs"))
				{

					System.out.println("Expected text is present");
					//driver.close();
					break;
                    
				}
			}

		}

		driver.switchTo().window(ParentWin);*/
		driver.quit();
	
}
}
